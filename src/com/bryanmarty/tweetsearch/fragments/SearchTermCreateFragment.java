package com.bryanmarty.tweetsearch.fragments;

import com.bryanmarty.tweetsearch.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SearchTermCreateFragment extends Fragment {

	public SearchTermCreateFragment() {
		
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_searchterm_create, container, false);
        Button createButton = (Button) rootView.findViewById(R.id.fragment_searchterm_create_create_button);
        final TextView inputText = (TextView) rootView.findViewById(R.id.fragment_searchterm_create_search_term_input_text);
        createButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				onCreateFragment(inputText.getText().toString());
			}
        	
        });
        return rootView;
    }
	
	public void onCreateFragment(String searchTerm) {
		
	}

}
