package com.tugas;


public class Main {

    public static void main(String[] args) {

        Herbivora herbivora = new Herbivora("Herbivora");
        Herbivora hewan1 = new Herbivora("sapi","Rumput",5);
        System.out.println("Hewan " + herbivora.name);
        hewan1.display();

        Karnivora karnivora = new Karnivora("Karnivora");
        Karnivora hewan2 = new Karnivora("singa","Daging",3);
        System.out.println("Hewan " + karnivora.name);
        hewan2.display();

        Omnivora omnivora = new Omnivora("Omnivora");
        Omnivora hewan3 = new Omnivora("ayam","Jagung",15);
        System.out.println("Hewan " + omnivora.name);
        hewan3.display();








    }
}
