package co.edu.uptc.structures;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoubleList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    
    public DoubleList() {
    	head = null;
    	tail = null;
    	size = 0;
    }
    
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean add(T e) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean retainAll(Collection<?> c) {
		boolean hasChanged = false;
		Iterator<T> it = this.iterator();

		while (it.hasNext()) {
			T element = it.next();
			if (!c.contains(element)) {
				it.remove();
				hasChanged = true;
			}
		}

		return hasChanged;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public T set(int index, T element) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void add(int index, T element) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ListIterator<T> listIterator() {
	    return new ListIterator<T>() {
	        private Node<T> current = head;
	        private Node<T> lastReturned = null;
	        private int index = 0;

	        @Override
	        public boolean hasNext() {
	            return index < size;
	        }

	        @Override
	        public T next() {
	            if (!hasNext()) throw new NoSuchElementException();
	            lastReturned = current;
	            current = current.getNext();
	            index++;
	            return lastReturned.getValue();
	        }

	        @Override
	        public boolean hasPrevious() {
	            return index > 0;
	        }

	        @Override
	        public T previous() {
	            if (!hasPrevious()) throw new NoSuchElementException();
	            if (current == null) {
	                current = tail;
	            } else {
	                current = current.getPrevious();
	            }
	            lastReturned = current;
	            index--;
	            return lastReturned.getValue();
	        }

	        @Override
	        public int nextIndex() {
	            return index;
	        }

	        @Override
	        public int previousIndex() {
	            return index - 1;
	        }

	        @Override
	        public void remove() {
	            if (lastReturned == null) throw new IllegalStateException();
	            Node<T> prevNode = lastReturned.getPrevious();
	            Node<T> nextNode = lastReturned.getNext();
	            if (prevNode != null) {
	                prevNode.setNext(nextNode);
	            } else {
	                head = nextNode;
	            }
	            if (nextNode != null) {
	                nextNode.setPrevious(prevNode);
	            } else {
	                tail = prevNode;
	            }
	            if (lastReturned == current) {
	                current = nextNode;
	            } else {
	                index--;
	            }
	            size--;
	            lastReturned = null;
	        }

	        @Override
	        public void set(T t) {
	            if (lastReturned == null) throw new IllegalStateException();
	            lastReturned.setValue(t);
	        }

	        @Override
	        public void add(T t) {
	            Node<T> newNode = new Node<>(t);
	            if (current == null) {
	                if (tail != null) {
	                    tail.setNext(newNode);
	                    newNode.setPrevious(tail);
	                    tail = newNode;
	                } else {
	                    head = tail = newNode;
	                }
	            } else {
	                Node<T> prevNode = current.getPrevious();
	                newNode.setNext(current);
	                newNode.setPrevious(prevNode);
	                current.setPrevious(newNode);
	                if (prevNode != null) {
	                    prevNode.setNext(newNode);
	                } else {
	                    head = newNode;
	                }
	            }
	            size++;
	            index++;
	            lastReturned = null;
	        }
	    };
	}
	@Override
	public ListIterator<T> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

    
}
