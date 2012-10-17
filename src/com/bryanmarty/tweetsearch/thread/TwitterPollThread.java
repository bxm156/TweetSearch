package com.bryanmarty.tweetsearch.thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class TwitterPollThread extends Thread {
	
	private static long SLEEP_TIME = 5000L;
	
	private Handler handler_;

	public TwitterPollThread(Handler handler) {
		handler_ = handler;
	}
	
	@Override
	public void run() {
	
		while(!Thread.currentThread().isInterrupted()) {
			Bundle b = new Bundle();
			b.putString("tweet", "HelloWorld");
			Message msg = new Message();
			msg.setData(b);
			handler_.sendMessage(msg);
			
			try {
				Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				
			}
		}
	}
}
