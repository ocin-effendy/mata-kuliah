package com.tugas;

class Hewan {
     String name;
     String eat;
     int total;

     Hewan(String name){
         this.name = name;
     }

     Hewan(String name, String eat, int total){
        this.name = name;
        this.eat = eat;
        this.total = total;

     }

    void display(){
        System.out.println("Nama\t: " + this.name);
        System.out.println("Makanan\t: " + this.eat);
        System.out.println("Total\t: " + this.total);
        System.out.println("\n");
    }


}
