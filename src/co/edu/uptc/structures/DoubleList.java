package co.edu.uptc.structures;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
		Node <T> newNode = new Node<T>(element);
        if(index< 0 || index > size){
            throw new IndexOutOfBoundsException();  
        }
        
        if(element == null){
            throw  new NullPointerException();
        }
        //SI ESTA VACIO
        if(size == 0 ){
            head = newNode;
            tail = newNode;
        }
        //INSERTAR AL PRINCIPIO
        if(index  == 0){
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode; 
            
            //INSERTAR AL FINAL
        }else if(index ==  size){
            newNode.setPrevious(tail);
            tail.setNext(newNode);
            tail = newNode;
            //INSERTAR EN MEDIO
        }else {
            Node <T> currentNode = head;
            for(int i = 0 ; i < index ; i++){
                currentNode= currentNode.getNext();
            }
            Node <T> previusNode =currentNode.getPrevious();
            previusNode.setNext(newNode);
            newNode.setPrevious(previusNode);
            newNode.setNext(currentNode);
            currentNode.setPrevious(newNode);
        }
        size++;
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
		// TODO Auto-generated method stub
		return null;
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
