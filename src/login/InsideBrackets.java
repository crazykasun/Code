/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package login;


/**
 *
 * @author iTEC
 */
public class InsideBrackets {
    private String s;

    public InsideBrackets(String input) {

        this.s = input;
    }

    public String getRound() {

        Stack stack = new Stack(s.length());
        Stack stack1 = new Stack(s.length());

        String output = " ";
        char get = ' ';

        char[] toChar = s.toCharArray();

        for (int i = 0; i < s.length(); ++i) {

            if (toChar[i] == '(') {
                stack.push(toChar[i]);
            } else if (toChar[i] == ')') {
                get = stack.pop();
            }

            if (!stack.isEmpty()) {
                stack1.push(toChar[i]);
            }
            if (stack.isEmpty() && get == '(') {
                break;
            }
        }

        while (!stack1.isEmpty()) {
            output = output + stack1.pop();
        }

        output = new StringBuilder(output).reverse().toString();

        return output;
    }

    public String getCurly() {

        Stack stack = new Stack(s.length());
        Stack stack1 = new Stack(s.length());

        String output = " ";
        char get = ' ';

        char[] toChar = s.toCharArray();

        for (int i = 0; i < s.length(); ++i) {

            if (toChar[i] == '{') {
                stack.push(toChar[i]);
            } else if (toChar[i] == '}') {
                get = stack.pop();
            }

            if (!stack.isEmpty()) {
                stack1.push(toChar[i]);
            }
            if (stack.isEmpty() && get == '{') {
                break;
            }
        }

        while (!stack1.isEmpty()) {
            output = output + stack1.pop();
        }

        output = new StringBuilder(output).reverse().toString();

        return output;
    }
}
