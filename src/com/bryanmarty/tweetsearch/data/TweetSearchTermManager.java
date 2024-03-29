package com.bryanmarty.tweetsearch.data;

import java.util.HashMap;

public class TweetSearchTermManager {
	
	private ObservableLinkedList<TweetSearchTerm> tweetList;
	private HashMap<Long,TweetSearchTerm> tweetMap;

	public TweetSearchTermManager() {
		//Load Terms From Database
		tweetList = new ObservableLinkedList<TweetSearchTerm>();
		tweetMap = new HashMap<Long,TweetSearchTerm>();
        addTweetSearchTerm(new TweetSearchTerm(0,"Tweet 0"));
        addTweetSearchTerm(new TweetSearchTerm(1,"Tweet 1"));
	}
	
	public synchronized void addTweetSearchTerm(TweetSearchTerm term) {
		tweetList.add(term);
		tweetMap.put(term.getId(), term);
	}
	
	public synchronized ObservableLinkedList<TweetSearchTerm> getTweetSearchTermList() {
		return tweetList;
	}
	
	public synchronized TweetSearchTerm getTweetSearchTerm(Long id) {
		return tweetMap.get(id);
	}
	
	

}
