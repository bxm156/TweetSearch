package com.bryanmarty.tweetsearch.fragments;

import com.bryanmarty.tweetsearch.R;
import com.bryanmarty.tweetsearch.TweetSearchApplication;
import com.bryanmarty.tweetsearch.data.TweetSearchTerm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SearchTermDetailFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";

	TweetSearchTerm mItem;

    public SearchTermDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(ARG_ITEM_ID)) {
        	
            mItem = TweetSearchApplication.getTweetSearchTermManager().getTweetSearchTerm(
        			getArguments().getLong(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_searchterm_detail, container, false);
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.searchterm_detail)).setText(mItem.getDisplayName());
        }
        return rootView;
    }
}
