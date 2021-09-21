
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
        this.numOfElements = 0;
        this.arr = (T[]) new Object[capacity];
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

    //appends an element to the list
    public void add(T elem){
        ensureCapacity();
        arr[numOfElements++] = elem;
    }

    //ensures that sufficient space is available in the list
    private void ensureCapacity(){
        if(numOfElements >= capacity){
            capacity *= 2;
            T[] newArr = (T[])new Object[capacity];
            for(int i = 0; i < numOfElements; i++){
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
    }

    //add element to a particular index in the list
    public void addAtIndex(int index, T elem){
        if(index < 0 ) throw new IndexOutOfBoundsException();
        ensureCapacity(); //check if there is capacity to add this element
        T[] newArr = (T[]) new Object[capacity];
        for(int i = 0; i < numOfElements; i++){
            if(i >= index){
                newArr[i+1] = arr[i];
            }else{
                newArr[i] = arr[i];
            }
        }
        arr = newArr;
        arr[index] = elem;
        numOfElements++;
    }

    //Removes element at particular index
    public void removeAtIndex(int index){
        if(index >= numOfElements || index < 0) throw new IndexOutOfBoundsException();
        T[] newArr = (T[]) new Object[capacity];
        if(index == (numOfElements-1)){ //if last element
            for(int i = 0; i < numOfElements-1; i++){
                newArr[i] = arr[i];
            }
        }else{
            for(int i = 0; i < numOfElements-1; i++){
                if(index >= i) newArr[i] = arr[i+1];
            }
        }
        arr = newArr;
        numOfElements--;
    }

    //remove first occurrence of an element if found
    public void remove(T elem){
        for(int i = 0; i < numOfElements; i++){
            if(arr[i] == elem) removeAtIndex(i);
        }
    }

    public T get(int index){
        if(index < 0 || index >= numOfElements) throw new IndexOutOfBoundsException();
        return arr[index];
    }
}