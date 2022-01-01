package com.code;

class LinkedList{

    Node first, last;
    int size = 0;
    static class Node {
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
        } // Constructor
    }

    public void addFirst(int value){
        Node newNode = new Node(value);
        if(first == null){
            first = newNode;//first menunjuk ke newNode
            last = newNode;// last menunjuk ke newNode
        }else{
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
        size++;
    }

    public void addLast(int value){
        Node newNode = new Node(value);
        if(first == null){
            first = newNode;
        }else{
            last.next = newNode;
            newNode.prev = last;
            last = newNode;

        }

    }


    public void printAll(){
        Node current = first;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public int getDataFirst(){
        return first.data;
    }

    public int getDataLast(){
        return last.data;
    }

    public void removeFirst(){
        first = first.next;
        size--;
    }

    public void addData(int index, int value){
        Node newNode = new Node(value);
        int i = 0;
        Node current = first;
        while(current != null);
    }

    public void replaceData(int index, int value){
        int i = 0;
        Node current = first;
        while(current != null){
            if(index == i) current.data = value;
            i++;
            current = current.next;
        }
    }

    public int getIndex(int value){
        int index=0;
        Node current = first;
        while(current != null){
            if(current.data == value)break;
            index++;
            current = current.next;
        }
        return index;
    }

    public int indexOf(int index){
        int i=0;
        Node current = first;
        while(current != null){
            if(index == i) break;
            i++;
            current = current.next;
        }
        return current != null ? current.data : 0;
    }

    public void addBefore(int value, int newValue){
        Node newNode = new Node(newValue);
        Node current = first;
        Node temp;
        while(current != null){
            if(value == first.data){
                newNode.next = first;
                first.prev = newNode;
                first = newNode;
            }else if (value == current.data){
                temp = current.prev;
                newNode.next = current;
                newNode.prev = current.prev;
                temp.next = newNode;
                current.prev = newNode;
            }
            current = current.next;
        }

    }

    public void addIndex(int index , int newValue){
        Node newNode = new Node(newValue);
        Node current = first;
        Node temp;
        int i =0;
        while(current != null){
            if (index == 0){
                newNode.next = first;
                first.prev = newNode;
                first = newNode;
                break;
            }
            else if (index == i){
                temp = current.prev;
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev = newNode;
                temp.next = newNode;

            }
            current = current.next;
            i++;
        }
    }
}

public class Main {

    public static void main(String[] args) {
        LinkedList daftarNilai = new LinkedList();
        daftarNilai.addFirst(100);
        daftarNilai.addFirst(90);
        daftarNilai.addLast(110);
        daftarNilai.addBefore(110, 105);
        daftarNilai.addIndex(0, 70 );
        daftarNilai.addIndex(1, 75 );
        daftarNilai.addIndex(3, 95 );




//        System.out.print("full data : ");daftarNilai.printAll();
//        daftarNilai.addData(0,50);

//        System.out.println("\nini indek inputan : " + daftarNilai.getIndex(10));
//        System.out.println("ini value inputan  : " + daftarNilai.indexOf(1));

//        daftarNilai.replaceData(3, 900);
//        System.out.println("fist : " + daftarNilai.getDataFirst());
//        System.out.println("last : " + daftarNilai.getDataLast());
        System.out.print("\nfull data : ");daftarNilai.printAll();

//        daftarNilai.removeFirst();
//        System.out.print("\nresult removeFirst : " );daftarNilai.printAll();


    }
}
