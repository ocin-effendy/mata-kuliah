package com.code;
import java.util.Scanner;
class Stack{
    int[] data;
    int top = -1;
    int size;

    public Stack(int size) {
        this.size = size;
        data = new int[size];
    }

    public void push(int newData) {data[++top] = newData;}
    public char pop(){ return (char) data[top--];}
}
public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Masukkan input : ");
        String string = userInput.nextLine();
        Stack s = new Stack(string.length());
        for (int i = 0; i < string.length(); i++) s.push(string.charAt(i));
        for (int i=0; i < string.length(); i++) System.out.print(s.pop() + " ");
    }

}
