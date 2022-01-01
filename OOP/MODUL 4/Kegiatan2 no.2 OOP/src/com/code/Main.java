package com.code;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        int input, input1, input2;
        int i = 1;

        System.out.println("======= Selamat Datang Di Pertandingan =========");
        System.out.println("1.Assassin VS Tank");
        System.out.println("2.Assassin VS Warrior");
        System.out.println("3.Warrior VS Tank");
        System.out.print("PIlih Karakter : ");
        input = userInput.nextInt();

        switch (input) {
            case 1 -> {
                System.out.print("Masukkan Level Assassin : ");
                input1 = userInput.nextInt();
                System.out.print("Masukkan Level Tank : ");
                input2 = userInput.nextInt();

                // Perkenalan Player 1
                Assassin assassin = new Assassin(input1);
                assassin.name = "Player 1";
                assassin.setHealtPoint(2500.D);
                assassin.setAttackDamage(750.D);
                assassin.setDefense(200.D);
                assassin.lifeStatus = true;
                assassin.checkStatus();

                // Perkenalan Player 2
                Tank tank = new Tank(input2);
                tank.name = "Player 2";
                tank.setHealtPoint(5000.D);
                tank.setAttackDamage(400.D);
                tank.setDefense(400.D);
                tank.lifeStatus = true;
                tank.checkStatus();


                // Perang
                while (assassin.lifeStatus && tank.lifeStatus) {
                    System.out.println("\n\n --------- Turn " + i + " ---------");
                    assassin.spawnIntro();
                    assassin.attack(tank);
                    tank.spawnIntro();
                    tank.attack(assassin);

                    i++;
                }

                if (assassin.lifeStatus) {
                    System.out.println("\n\n" + assassin.name + " Win");
                } else {
                    System.out.println("\n\n" + tank.name + " Win");
                }


            }
            case 2 -> {

                System.out.print("Masukkan Level Assassin : ");
                input1 = userInput.nextInt();
                System.out.print("Masukkan Level Warrior : ");
                input2 = userInput.nextInt();

                // Perkenalan Player 1
                Assassin assassin = new Assassin(input1);
                assassin.name = "Player 1";
                assassin.setHealtPoint(2500.D);
                assassin.setAttackDamage(750.D);
                assassin.setDefense(200.D);
                assassin.lifeStatus = true;
                assassin.checkStatus();

                // Perkenalan Player 2
                Warrior warrior = new Warrior(input2);
                warrior.name = "Player 2";
                warrior.setHealtPoint(3000.D);
                warrior.setAttackDamage(800.D);
                warrior.setDefense(250.D);
                warrior.lifeStatus = true;
                warrior.checkStatus();


                //Perang
                while (assassin.lifeStatus && warrior.lifeStatus) {
                    System.out.println("\n\n --------- Turn " + i + " ---------");
                    assassin.spawnIntro();
                    assassin.attack(warrior);
                    warrior.spawnIntro();
                    warrior.attack(assassin);

                    i++;
                }

                if (assassin.lifeStatus) {
                    System.out.println("\n\n" + assassin.name + " Win");
                } else {
                    System.out.println("\n\n" + warrior.name + " Win");
                }


            }
            case 3 -> {

                System.out.print("Masukkan Level Warrior : ");
                input1 = userInput.nextInt();
                System.out.print("Masukkan Level Tank : ");
                input2 = userInput.nextInt();

                // Perkenalan Player 1
                Warrior warrior = new Warrior(input1);
                warrior.name = "Player 1";
                warrior.setHealtPoint(3000.D);
                warrior.setAttackDamage(800.D);
                warrior.setDefense(250.D);
                warrior.lifeStatus = true;
                warrior.checkStatus();

                // Perkenalan Player 2
                Tank tank = new Tank(input2);
                tank.name = "Player 2";
                tank.setHealtPoint(5000.D);
                tank.setAttackDamage(400.D);
                tank.setDefense(400.D);
                tank.lifeStatus = true;
                tank.checkStatus();


                //Perang
                while (warrior.lifeStatus && tank.lifeStatus) {
                    System.out.println("\n\n --------- Turn " + i + " ---------");
                    warrior.spawnIntro();
                    warrior.attack(tank);
                    tank.spawnIntro();
                    tank.attack(warrior);

                    i++;
                }

                if (warrior.lifeStatus) {
                    System.out.println("\n\n ===== " + warrior.name + " Win =====");
                } else {
                    System.out.println("\n\n ====== " + tank.name + " Win ======");
                }


            }
            default -> System.out.println("Maaf Yang Anda Inputkan Tidak Sesuai");

        }












    }
}
