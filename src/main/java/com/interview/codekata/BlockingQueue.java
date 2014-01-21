package com.interview.codekata;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author choesang
 *
 *	Implement a thread-safe Blocking queue
 */
public class BlockingQueue {

	  private List queue = new LinkedList();
	  private int  limit = 10;

	  public BlockingQueue(int limit){
	    this.limit = limit;
	  }


	  public synchronized void enqueue(Object item)
	  throws InterruptedException  {
	 
	    while(this.queue.size() == this.limit) {
	      wait();
	    }
	  //Notify all the threads that are waiting 
	    if(this.queue.size() == 0) {
	      notifyAll();
	    }
	    this.queue.add(item);
	  }


	  public synchronized Object dequeue()
	  throws InterruptedException{
	    while(this.queue.size() == 0){
	      wait();
	    }
	  
	    if(this.queue.size() == this.limit){
	      notifyAll();
	    }

	    return this.queue.remove(0);
	  }

	}
