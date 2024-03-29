package com.bryanmarty.tweetsearch;

import com.bryanmarty.tweetsearch.fragments.SearchTermCreateFragment;
import com.bryanmarty.tweetsearch.fragments.SearchTermDetailFragment;
import com.bryanmarty.tweetsearch.fragments.SearchTermListFragment;
import com.bryanmarty.tweetsearch.services.TwitterService;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.support.v4.content.LocalBroadcastManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class SearchTermListActivity extends FragmentActivity
        implements SearchTermListFragment.Callbacks, SearchTermCreateFragment.Callbacks {

    private static final String NEW_TWEET_INTENT = "New-Tweet";
	private boolean mTwoPane;
    private LocalBroadcastManager broadcaster;

    private BroadcastReceiver receiveTweet = new BroadcastReceiver() {
    	
        @Override
        public void onReceive(final Context context, Intent intent) {
        	Bundle b = intent.getExtras();
        	final String msg = b.getString("msg");
        	runOnUiThread(new Runnable() {

				@Override
				public void run() {
					Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
				}
        		
        	});
        }
    };
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchterm_list);

        if (findViewById(R.id.searchterm_detail_container) != null) {
            mTwoPane = true;
            ((SearchTermListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.searchterm_list))
                    .setActivateOnItemClick(true);
        }
        broadcaster = LocalBroadcastManager.getInstance(this);
        broadcaster.registerReceiver(receiveTweet, new IntentFilter(NEW_TWEET_INTENT));
        
        //Service
        startService(new Intent(this,TwitterService.class));
    }

    @Override
    public void onItemSelected(Long id) {
        if (mTwoPane) {
            Bundle arguments = new Bundle();
            arguments.putLong(SearchTermDetailFragment.ARG_ITEM_ID, id);
            SearchTermDetailFragment fragment = new SearchTermDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.searchterm_detail_container, fragment)
                    .commit();

        } else {
            Intent detailIntent = new Intent(this, SearchTermDetailActivity.class);
            detailIntent.putExtra(SearchTermDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_search_term_list, menu);
        return true;
    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.new_filter:
				onCreateNewTweetFilter();
				return true;
			case R.id.menu_exit:
				onExit();
				return true;
		}
		return super.onOptionsItemSelected(item);
	}
	

	public void onCreateNewTweetFilter() {
		if (mTwoPane) {
            Bundle arguments = new Bundle();
            SearchTermCreateFragment fragment = new SearchTermCreateFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.searchterm_detail_container, fragment)
                    .commit();

        } else {
            Intent detailIntent = new Intent(this, SearchTermCreateActivity.class);
            startActivity(detailIntent);
        }
	}
	
	private void onExit() {
		 stopService(new Intent(this,TwitterService.class));
		 
	}

	@Override
	public void onSearchTermCreated() {
		return;
	}

    
}
