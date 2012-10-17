package com.bryanmarty.tweetsearch;
import com.bryanmarty.tweetsearch.R;
import com.bryanmarty.tweetsearch.fragments.SearchTermCreateFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;


public class SearchTermCreateActivity extends FragmentActivity {

	public SearchTermCreateActivity() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchterm_create);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            SearchTermCreateFragment fragment = new SearchTermCreateFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.searchterm_create_container, fragment)
                    .commit();
        }
    }
	

	 @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        if (item.getItemId() == android.R.id.home) {
	            NavUtils.navigateUpTo(this, new Intent(this, SearchTermListActivity.class));
	            return true;
	        }

	        return super.onOptionsItemSelected(item);
	    }
}
