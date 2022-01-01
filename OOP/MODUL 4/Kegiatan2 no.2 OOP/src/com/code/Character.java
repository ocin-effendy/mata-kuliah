package com.code;

public abstract class Character {

    String name;
    double healtPoint;
    double attackDamage;
    double defense;
    int level;
    boolean lifeStatus;
    double realDamage;


    public void attack(Character target){

        if(this.healtPoint != 0){
            reviewDamage(target.defense);
            target.healtPoint -= this.realDamage;

            if (target.healtPoint <= 0){
                target.healtPoint = 0;
                target.lifeStatus = false;
            }
        }

        System.out.println(target.name + " Remaining HP : " + target.healtPoint);

    }

    public void reviewDamage(double defense){
        this.realDamage = this.attackDamage - defense;
    }

    public void checkStatus(){

        System.out.println("\n ================= " + this.name + " =================");
        System.out.println("level : " + this.level);
        System.out.println("HealtPoint\t\t: " + this.healtPoint + "\t Defense\t: " + this.defense);
        System.out.println("AttactDamage\t: " + this.attackDamage + "\t\t LifeStatus\t: " + this.lifeStatus);

    }

    public abstract void spawnIntro();






}
