/**
 * Created by itslehcim on 11/23/2016.
 */
public interface Stack<AnyType> {
    int size();
    boolean isEmpty();
    void push(AnyType newValue);
    AnyType top();
    AnyType pop();
}
