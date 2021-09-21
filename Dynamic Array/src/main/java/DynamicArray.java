
/*
    @author: Jai Vora
    @description: List implementation, dynamically grows in size
 */

public class DynamicArray<T> {

    //static array
    private T[] arr;
    private int numOfElements; // num of elements in the list
    private int capacity; //capacity of the array

    public DynamicArray(int capacity){
        if(capacity <= 0) throw new IllegalArgumentException("Capacity should be greater than 0");
        this.capacity = capacity;
        numOfElements = 0;
        T[] arr = (T[]) new Object[capacity];
    }

    public DynamicArray(){
        this(16);
    }

    //returns the number of elements in the list
    public int size(){
        return numOfElements;
    }

    //returns true if list is empty, else false
    public boolean isEmpty(){
        return numOfElements == 0;
    }

    //append
    public void add(){

    }





}