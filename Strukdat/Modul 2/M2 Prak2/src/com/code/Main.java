package com.code;

class LinkedList{
    Node first, last;

    static class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
        }
    }

    public void addData(int value){
        Node newNode = new Node(value);
        if (first == null){
            first = last = newNode;
        }else{
            last.next = newNode;
            newNode.prev = last;
            last = newNode;

        }

        System.out.println("ini last : " + last.data);
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

    public void printSortList(){
        if (first == null){
            System.out.println("Linklist is Empty");
        }else{
            Node current = first;
            Node index;
            Node temp  = first;
            while (current != null){
                temp = current;
                System.out.println("ini temp : "+ temp.data);
                index = current.next;
                System.out.println("ini index : " + index.data);
                while (index != null){
                    if (index.data < temp.data) {
                        temp.data = index.data;
                        index.data = current.data;
                    }
                    index = index.next;
                }
                int haha = current.data;
                current.data = temp.data;
                index.data = haha;
                System.out.println(current.data);
                current = current.next;
            }
        }
    }

    public void remove(int index){
        Node current = first;
        int i=0;
        while(current != null){
            if (index == 0){
                first = first.next;
            }else if(index == i){
                Node tempB = current.prev;
                Node tempF = current.next;
                tempB.next = current.next;
                tempF.prev = current.prev;
            }
            i++;
            current = current.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
//
        list.addData(10);
        list.addData(8);
        list.addData(4);
        list.addData(2);
        list.addData(6);

//
//        list.addDataSort(15);
//        list.addDataSort(10);
//        list.addDataSort(7);
//        list.addDataSort(12);
//        list.addDataSort(10);
//        list.addDataSort(33);
//        list.addDataSort(11);


//        list.remove(0);
        System.out.println("Brefore : ");
        list.printList();
        System.out.println("\n=================");
//        list.sortData();
        System.out.println("After : ");
        list.printSortList();
        list.printList();


    }
}
