package com.bryanmarty.tweetsearch;

import com.bryanmarty.tweetsearch.fragments.SearchTermDetailFragment;
import com.bryanmarty.tweetsearch.fragments.SearchTermListFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;

public class SearchTermListActivity extends FragmentActivity
        implements SearchTermListFragment.Callbacks {

    private boolean mTwoPane;

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
    }

    @Override
    public void onItemSelected(String id) {
        if (mTwoPane) {
            Bundle arguments = new Bundle();
            arguments.putString(SearchTermDetailFragment.ARG_ITEM_ID, id);
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
}
