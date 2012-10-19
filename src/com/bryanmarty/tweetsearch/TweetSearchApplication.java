package com.bryanmarty.tweetsearch;
import com.bryanmarty.tweetsearch.data.TweetSearchTermManager;

import android.app.Application;

public class TweetSearchApplication extends Application {

	private static TweetSearchTermManager tweetSearchTermManager_;
	
	public static TweetSearchTermManager getTweetSearchTermManager() {
		return tweetSearchTermManager_;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		tweetSearchTermManager_ = new TweetSearchTermManager();
	}
	

}
