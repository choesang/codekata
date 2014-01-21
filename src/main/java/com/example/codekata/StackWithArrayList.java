/**
 * 
 */
package com.example.codekata;

import java.util.ArrayList;

/**
 * @author choesang
 *
 */
public class StackWithArrayList<E> extends ArrayList<E>{
	
	public E push(E element) {
		add(element);
		return element;
	}
	
	public E pop() {
		E e = get(size() - 1);
		remove(size() - 1);
		return e;
	}
}
