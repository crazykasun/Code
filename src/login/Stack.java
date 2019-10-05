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
public class Stack {
    private int maxSize;
    private int top;
    private char[] stackArray;

    public Stack(int maxSize) {
        super();
        this.maxSize = maxSize;
        top = -1;
        stackArray = new char[maxSize];
    }

    public void push(char value) {

        if (top != maxSize - 1) {
            stackArray[++top] = value;
        } else {
            System.out.println("Full");
        }
    }

    public char pop() {

        if (top != -1) {
            return stackArray[top--];
        } else {
            return 'x';
        }
    }

    public boolean isEmpty() {

        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {

        if (top == maxSize - 1) {
            return true;
        } else {
            return false;
        }
    }
}
