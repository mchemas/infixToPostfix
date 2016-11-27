/**
 * Created by itslehcim on 11/23/2016.
 */
public class DynamicArrayStack<AnyType> implements Stack<AnyType> {
    public static final int DEFAULT_CAPACITY = 256;
    AnyType[] data;
    int topOfStack;

    public DynamicArrayStack() { this(DEFAULT_CAPACITY); }

    public DynamicArrayStack(int capacity){
        topOfStack = -1;
        data = (AnyType[]) new Object[capacity];
    }

    public int size(){
        return topOfStack+1;
    }

    public boolean isEmpty(){
        return(topOfStack == -1);
    }

    public void push(AnyType newValue){
        if (size()==data.length){
            resize(2*data.length);
        }

        data[++topOfStack] = newValue;
    }

    public AnyType top() {
        if (isEmpty()) {
            return null;
        }
        return data[topOfStack];
    }

    public AnyType pop(){
        if (isEmpty()) {
            return null;
        }

        if ((size() > 0) && (size() == data.length / 4)){
            resize(data.length / 2);
        }

        AnyType oldValue = data[topOfStack];
        topOfStack--;
        return oldValue;
    }

    protected void resize(int newCapacity){
        int n = size();

        AnyType[] temp = (AnyType[]) new Object[newCapacity];
        for (int i=0; i < n; i++)
            temp[i] = data[i];
        data = temp;
    }
}
