import java.io.IOException;

/**
 * Created by itslehcim on 11/23/2016.
 */
public class inToPost {

    private String print = "";

    DynamicArrayStack<Character> stack = new DynamicArrayStack<Character>();

    public inToPost(String line) throws IOException {
        fix(line);
        System.out.println(print + "\n");
    }

    public void fix(String line) {
        for (int j = 0; j < line.length(); j++) {
            char ch = line.charAt(j);

            if((ch == '+') || (ch == '-')){
                operator(ch, 1);
            } else if((ch == '*') || (ch == '/')){
                operator(ch, 2);
            } else if (ch == '('){
                stack.push(ch);
            } else if (ch == ')') {
                rightParen(ch);
            }else{
                print = print + ch;
            }
        }
        while (!stack.isEmpty()) {
            print = print + stack.pop();
        }
    }

    public void operator(char opThis, int prec1) {
        while (!stack.isEmpty()) {
            char opTop = stack.pop();
            if (opTop == '(') {
                stack.push(opTop);
                break;
            } else {
                int prec2;
                if (opTop == '+' || opTop == '-') {
                    prec2 = 1;
                } else {
                    prec2 = 2;
                }

                if (prec2 < prec1) {
                    stack.push(opTop);
                    break;
                } else {
                    print = print + opTop;
                }
            }
        }
        stack.push(opThis);
    }

    public void rightParen(char ch){
        while (!stack.isEmpty()) {
            char chx = stack.pop();
            if (chx == '('){
                break;
            } else {
                print = print + chx;
            }
        }
    }

}
