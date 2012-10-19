package com.bryanmarty.tweetsearch.fragments;

import com.bryanmarty.tweetsearch.R;
import com.bryanmarty.tweetsearch.TweetSearchApplication;
import com.bryanmarty.tweetsearch.data.TweetSearchTerm;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SearchTermCreateFragment extends Fragment {

	private Callbacks mCallbacks = sDummyCallbacks;

    public interface Callbacks {

        public void onSearchTermCreated();
    }

    private static Callbacks sDummyCallbacks = new Callbacks() {
        @Override
        public void onSearchTermCreated() {
        	
        }
    };

	
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
		TweetSearchTerm tst = new TweetSearchTerm(4L,searchTerm);
		TweetSearchApplication.getTweetSearchTermManager().addTweetSearchTerm(tst);
		mCallbacks.onSearchTermCreated();
	}
	

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!(activity instanceof Callbacks)) {
            throw new IllegalStateException("Activity must implement fragment's callbacks.");
        }

        mCallbacks = (Callbacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = sDummyCallbacks;
    }

}
