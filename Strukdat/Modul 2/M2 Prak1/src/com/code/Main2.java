package com.code;

class Node{
    int data;
    Node next;
    Node prev;
    Node(int data){
        this.data = data;
    }
}

class LinkedList{
    Node first, last;



    public void addData(int value){
        Node newNode = new Node(value);
        if (first == null){
            first = last = newNode;
        }else{
            last.next = newNode;
            newNode.prev = last;
            last = newNode;

        }

    }

    public void sortData(){
        Node current = first;
        Node index;
        int temp;
        while (current != null){
            index = current.next;
            while (index != null){
                if (current.data > index.data){
                    temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    public void addDataSort(int value){
        Node newNode = new Node(value);
        if (first == null){
            first = last = newNode;
        }else if (value < first.data){
            newNode.next = first;
            first.prev = newNode;
            first = newNode;

        }else if (value >= last.data){
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }else{
            Node current = first;
            while(current != null){
                if (value <= current.data){
                    Node temp = current.prev;
                    newNode.next = current;
                    newNode.prev = current.prev;
                    current.prev = newNode;
                    temp.next = newNode;
                    break;
                }
                current = current.next;
            }
        }
    }

    public void printList(){
        if (first == null){
            System.out.println("Linklist is Empty");
        }else{
            Node current = first;
            while (current != null){
                System.out.print(current.data + " ");
                current = current.next;
            }
        }
    }




}
public class Main2 {
    public static void main(String[] args){

        LinkedList list = new LinkedList();
//
//        list.addData(10);
//        list.addData(8);
//        list.addData(4);
//        list.addData(2);
//        list.addData(6);


//        list.addDataSort(15);
//        list.addDataSort(10);
//        list.addDataSort(7);
//        list.addDataSort(12);
//        list.addDataSort(10);
//        list.addDataSort(33);
//        list.addDataSort(11);
//        list.printList();


//        System.out.println("Brefore : ");
//        list.printList();
//        System.out.println("\n=================");
//        list.sortData();
//        System.out.println("After : ");
//        list.printList();
    }
}
