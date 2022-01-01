package com.code;

class Link{
    String dDdata;
    Link next;
    public Link(String data){
        dDdata = data;
    }
    public void displayLink(){
        System.out.print(dDdata + " ");
    }
}

class FirstLastList{
    public Link first;
    public Link last;
    int size;

    public FirstLastList(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insert(String data){
        Link newLink = new Link(data);
        if (isEmpty()){
            first = newLink;
        }else{
            last.next = newLink;
        }
        last = newLink;
        size++;
    }

    public void delete(){
        if (first.next == null)  last = null;
        first = first.next;
        size--;
    }

    public void displayList(){
        Link current = first;
        while(current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }

    public String peek(){
        return first.dDdata;
    }

}


class LinkQueue{
    public FirstLastList theList;

    public LinkQueue(){
        theList = new FirstLastList();
    }

    public boolean isEmpty(){
        return theList.isEmpty();
    }

    public void enqueue(String data){
        theList.insert(data);
    }

    public void dequeue(){
        theList.delete();
    }

    public String peekQueue(){
        return theList.peek();
    }

    public void displayQueue(){
        System.out.println("QUEUE (Head -> Tail) : ");
        theList.displayList();
    }
    public int size(){
        return theList.size;
    }
}

public class Kegiatan2 {
    public static void main(String[] args) {
        LinkQueue queue = new LinkQueue();
        queue.enqueue("runtuh");
        queue.enqueue("waktu dan perhartian");
        queue.enqueue("bahaya");
        queue.displayQueue();

        queue.enqueue("");
        queue.enqueue("pesan terkahir");
        queue.dequeue();
        queue.displayQueue();
        System.out.println(queue.peekQueue());
        queue.enqueue("sisa waktu");
        System.out.println("size : " + queue.size());







    }
}
