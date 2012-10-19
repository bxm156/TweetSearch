package com.bryanmarty.tweetsearch.data;

import java.util.LinkedList;
import java.util.Observable;

public class ObservableLinkedList<T> extends Observable {
	
	private LinkedList<T> list_;
	
	public ObservableLinkedList() {
		list_ = new LinkedList<T>();
	}
	
	public ObservableLinkedList(LinkedList<T> list) {
		list_ = list;
	}

	public boolean add(T item) {
		list_.add(item);
		setChanged();
		notifyObservers();
		return true;
	}
	
	public boolean remove(T item) {
		if(list_.remove(item)) {
			setChanged();
			notifyObservers();
			return true;
		}
		return false;
	}

	public int size() {
		return list_.size();
	}

	public T get(int position) {
		return list_.get(position);
	}

}
