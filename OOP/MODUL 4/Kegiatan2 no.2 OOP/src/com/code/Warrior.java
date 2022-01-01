package com.code;

public class Warrior extends Character{

    public Warrior(int level){
        this.level = level;
    }

    public void setHealtPoint(double healtPoint){
        this.healtPoint = this.level * 100 + healtPoint;
    }


    public void setDefense(double defense){
        this.defense = this.level * 10 + defense;
    }


    public void setAttackDamage(double attackDamage){
        this.attackDamage = this.level * 15 + attackDamage;
    }

    @Override
    public void spawnIntro() {
        System.out.println("\t * " + this.name + " Move *");
        System.out.println("'Jangan Banyak Bicara Anda!!'");
    }

}
