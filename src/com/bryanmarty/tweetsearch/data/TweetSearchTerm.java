package com.bryanmarty.tweetsearch.data;

public class TweetSearchTerm {
	
	private Long id_ = -1L;
	private String displayName_ = "Undefined";
	private Integer unreadTweets_ = 0;

	public TweetSearchTerm(String displayName) {
		displayName_ = displayName;
	}
	
	public TweetSearchTerm(long id, String displayName) {
		id_ = id;
		displayName_ = displayName;
	}
	
	public Long getId() {
		return id_;
	}
	
	public void setDisplayName(String name) {
		displayName_ = name;
	}
	
	public String getDisplayName() {
		return displayName_;
	}
	
	public void setUnreadTweetCount(Integer unread) {
		unreadTweets_ = unread;
	}
	
	public Integer getUnreadTweetCount() {
		return unreadTweets_;
	}

}
