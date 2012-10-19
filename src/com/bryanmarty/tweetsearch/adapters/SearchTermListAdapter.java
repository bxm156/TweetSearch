package com.bryanmarty.tweetsearch.adapters;

import java.util.List;

import com.bryanmarty.tweetsearch.R;
import com.bryanmarty.tweetsearch.TweetSearchApplication;
import com.bryanmarty.tweetsearch.data.TweetSearchTerm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SearchTermListAdapter extends BaseAdapter {
	
	private List<TweetSearchTerm> searchTermList_;
	private Context context_;

	public SearchTermListAdapter(List<TweetSearchTerm> searchTermList, Context context) {
		searchTermList_ = TweetSearchApplication.getTweetSearchTermManager().getTweetSearchTermList();
		context_ = context;
	}

	@Override
	public int getCount() {
		return searchTermList_.size();
	}

	@Override
	public Object getItem(int position) {
		return searchTermList_.get(position);
	}

	@Override
	public long getItemId(int position) {
		return searchTermList_.get(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LinearLayout itemLayout;
		TweetSearchTerm term = searchTermList_.get(position);
		itemLayout = (LinearLayout) LayoutInflater.from(context_).inflate(R.layout.searchterm_list_item, parent,false);
		TextView displayName = (TextView) itemLayout.findViewById(R.id.searchterm_list_item_display_name);
		displayName.setText(term.getDisplayName());
		TextView unreadCount = (TextView) itemLayout.findViewById(R.id.searchterm_list_item_unread_count);
		unreadCount.setText(term.getUnreadTweetCount().toString());
		
		return itemLayout;
	}

}
