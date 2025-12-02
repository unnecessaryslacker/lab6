package src;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedSet<T extends RailCar> implements Iterable<T> {

    private static class Node<T>{
        T value;
        Node<T> next, prev;
        Node(T v){value=v;}
    }

    private Node<T> head, tail;
    private int size;

    public MyLinkedSet(){}
    public MyLinkedSet(T obj){ add(obj); }
    public MyLinkedSet(Iterable<T> col){ for(T x: col) add(x); }

    public boolean add(T value){
        if(contains(value)) return false;
        Node<T> n=new Node<>(value);
        if(head==null){ head=tail=n; }
        else{
            tail.next=n;
            n.prev=tail;
            tail=n;
        }
        size++;
        return true;
    }

    public boolean contains(Object o){
        for(T x:this){
            if(x.equals(o)) return true;
        }
        return false;
    }

    public boolean remove(Object o){
        Node<T> cur=head;
        while(cur!=null){
            if(cur.value.equals(o)){
                if(cur.prev!=null) cur.prev.next=cur.next;
                else head=cur.next;
                if(cur.next!=null) cur.next.prev=cur.prev;
                else tail=cur.prev;
                size--;
                return true;
            }
            cur=cur.next;
        }
        return false;
    }

    public void clear(){ head=tail=null; size=0; }
    public int size(){ return size; }
    public boolean isEmpty(){ return size==0; }

    @Override
    public Iterator<T> iterator(){
        return new Iterator<T>(){
            Node<T> cur=head;
            public boolean hasNext(){ return cur!=null; }
            public T next(){
                if(cur==null) throw new NoSuchElementException();
                T v=cur.value;
                cur=cur.next;
                return v;
            }
        };
    }
}
