package com.bryanmarty.tweetsearch;

import com.bryanmarty.tweetsearch.fragments.SearchTermDetailFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;

public class SearchTermDetailActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchterm_detail);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putString(SearchTermDetailFragment.ARG_ITEM_ID,
                    getIntent().getStringExtra(SearchTermDetailFragment.ARG_ITEM_ID));
            SearchTermDetailFragment fragment = new SearchTermDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.searchterm_detail_container, fragment)
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
