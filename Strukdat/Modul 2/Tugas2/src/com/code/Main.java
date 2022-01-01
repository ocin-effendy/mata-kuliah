package com.code;


class Node{
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
    }

}

class MyHash{
    Node[] table;
    int size;

    public MyHash(int size) {
        this.size = size;
        table = new Node[size];
    }
    public int hashFunction(int key){
        return key%size;
    }
    public void insert(int key){
        Node newNode = new Node(key);
        int row = hashFunction(key);
        if(table[row] == null){
            table[row] = newNode;
        }else{
            newNode.next = table[row];
            table[row].prev = newNode;
            table[row] = newNode;
        }
    }
    public void printAll(){
        for(int i=0; i<size; i++){
            System.out.print("Row "+i+" : ");
            Node current = table[i];
            while(current != null){
                System.out.print(current.data+" ");
                current = current.next;
            }
            System.out.println("");
        }

    }


    public void remove(int key){
        int row = hashFunction(key);
        if(table[row] == null){
            System.out.println("Data not found !!!");
        }else if(table[row].data == key){
            if(table[row].next == null){
                table[row] = null;
            }else{
                table[row] = table[row].next;
            }
        }else{
            Node current = table[row];
            while(current != null){
                if(current.data == key){
                    if(current.next == null){
                        current = current.prev;
                        current.next = null;
                    }else{
                        Node temp = current.next;
                        current = current.prev;
                        current.next = temp;
                        temp.prev = current;
                    }
                }
                current = current.next;
            }
        }
    }

    public void find(int key){
        int row = hashFunction(key);
        int index=0;
        boolean check = false;
        Node current = table[row];
        while(current != null){
            if(current.data == key){
                check = true;
                break;
            }
            current = current.next;
            index++;
        }

        if (check)System.out.println("Baris : "+ row + ", Index : " + index );
        else System.out.println("Data tidak ditemukan");
    }
}


public class Main {

    public static void main(String[] args) {
        MyHash dataku = new MyHash(10);
        dataku.insert(70);
        dataku.insert(80);
        dataku.insert(60);
        dataku.insert(50);
        dataku.insert(99);
        dataku.insert(86);
        dataku.insert(106);
        dataku.insert(119);

        dataku.find(90);
        dataku.printAll();
    }
}
