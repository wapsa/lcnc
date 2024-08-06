package com.lcnc.ds.linkedlist;

public interface List {

	public void addFirst(Integer data);

	public void addLast(Integer data);

	public void removeFirst();

	public void removeLast();

	public void remove(Integer data);

	public Integer getFirst();

	public Integer getLast();

	public Integer get(int index);

	public int size();

	public boolean isEmpty();

}
