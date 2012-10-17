package com.bryanmarty.tweetsearch.fragments;

import com.bryanmarty.tweetsearch.R;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SearchTermCreateFragment extends Fragment {

	public SearchTermCreateFragment() {
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_searchterm_detail, container, false);
        ((TextView) rootView.findViewById(R.id.searchterm_detail)).setText("New Filter");
        return rootView;
    }

}
