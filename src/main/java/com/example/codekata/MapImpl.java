/**
 * 
 */
package com.example.codekata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author choesang
 * @param <K>
 * @param <V>
 *
 */
public class MapImpl<K, V> implements Map<K, V> {
	
	List< Entry<K,V> > list = new ArrayList< Entry<K,V> >();
	
	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return get(key) != null;
	}

	@Override
	public boolean containsValue(Object value) {
		for (Entry<K,V> entry : list) {
			if ( entry.getValue().equals(value) ) {
				return true;
			}
		}
		return false;
	}

	@Override
	public V get(Object key) {
		for (Entry<K,V> entry : list) {
			if ( entry.getKey().equals(key) ) {
				return entry.getValue();
			}
		}
		return null;
	}

	private Entry<K,V> getEntryByKey(K key) {
		for (Entry<K,V> entry : list) {
			if(entry.getKey().equals(key)) {
				return entry;
			}
		}
		return null;
	}
	
	@Override
	public V put(K key, V value) {
		Entry<K,V> oldEntry = getEntryByKey(key);
		V oldValue = null;
		if ( oldEntry != null ) {
			oldValue = oldEntry.getValue();
		    oldEntry.setValue(value);
		} else {
			list.add (new Entry<K, V>(key, value));
		}
		return oldValue;
	}

	@Override
	public V remove(Object key) {
		Iterator<Entry<K, V>> iterator = list.iterator();
		while (iterator.hasNext()) {
			V oldValue = iterator.next().getValue();
			if ( oldValue.equals(key) ) {
				iterator.remove();
				return oldValue;
			}
		}
		
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		for (java.util.Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
			put(entry.getKey(), entry.getValue());
		}
	}

	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public Set<K> keySet() {
		Set<K> listOfValues = new HashSet<K>();
		for ( Entry<K,V> entry : list ) {
			listOfValues.add(entry.getKey());
		}
		return listOfValues;
	}

	@Override
	public Collection<V> values() {
		Collection<V> listOfValues = new ArrayList<>();
		for ( Entry<K,V> entry : list ) {
			listOfValues.add(entry.getValue());
		}
		return listOfValues;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return null;
	}
	
	class Entry<K,V> implements Map.Entry<K,V> {
		final K key;
		V value;
		
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V newValue) {
			V oldValue = value;
			value = newValue;
			return oldValue;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((key == null) ? 0 : key.hashCode());
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Entry other = (Entry) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (key == null) {
				if (other.key != null)
					return false;
			} else if (!key.equals(other.key))
				return false;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}

		private MapImpl getOuterType() {
			return MapImpl.this;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Entry [key=" + key + ", value=" + value + "]";
		}
		
	}

}
