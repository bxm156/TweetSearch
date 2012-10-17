package com.bryanmarty.tweetsearch.services;

import java.lang.ref.WeakReference;
import java.util.LinkedList;

import com.bryanmarty.tweetsearch.thread.TwitterPollThread;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

public class TwitterService extends Service {
	
	private static LinkedList<Message> results = new LinkedList<Message>();
	private LocalBroadcastManager broadcaster;
	
	static class TwitterHandler extends Handler {
		private final WeakReference<TwitterService> mTarget;
		
		TwitterHandler(TwitterService target) {
	        mTarget = new WeakReference<TwitterService>(target);
	    }

		@Override
		public void handleMessage(Message msg) {
			TwitterService ts = mTarget.get();
			if(ts != null) {
				ts.broadcast(msg);
			}
		}
		
	}
	private final IBinder mBinder = new LocalBinder();
	private TwitterPollThread twThread_;
	private TwitterHandler twHandler_;
	
	

	@Override
	public void onCreate() {
		broadcaster = LocalBroadcastManager.getInstance(this);
		twHandler_ = new TwitterHandler(this);
		twThread_ = new TwitterPollThread(twHandler_);
		twThread_.start();
	}
	
	public void broadcast(Message msg) {
		Intent i = new Intent("New-Tweet");
		i.putExtra("msg", msg.getData().getString("tweet"));
		broadcaster.sendBroadcast(i);
	}
	
	
	 @Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Log.i("Service", "onStartCommnad");
		return Service.START_STICKY;
	}


	/**
     * Class used for the client Binder.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */
    public class LocalBinder extends Binder {
        TwitterService getService() {
            // Return this instance of LocalService so clients can call public methods
            return TwitterService.this;
        }
    }

	@Override
	public IBinder onBind(Intent arg0) {
		return mBinder;
	}
	

	@Override
	public boolean stopService(Intent name) {
		try {
			if(twThread_ != null) {
				twThread_.interrupt();
				twThread_.join();
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
		return super.stopService(name);
	}
	
	public LinkedList<Message> getMessages() {
		LinkedList<Message> values;
		synchronized(results) {
			values = results;
			results = new LinkedList<Message>();
		}
		return values;
	}

}
