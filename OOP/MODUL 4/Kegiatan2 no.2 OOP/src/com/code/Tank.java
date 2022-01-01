package com.code;

public class Tank extends Character{

    public Tank(int level){
        this.level = level;
    }

    public void setHealtPoint(double healtPoint){
        this.healtPoint = this.level * 150 + healtPoint;
    }


    public void setDefense(double defense){
        this.defense = this.level * 15 + defense;
    }


    public void setAttackDamage(double attackDamage){
        this.attackDamage = this.level * 10 + attackDamage;
    }

    @Override
    public void spawnIntro() {
        System.out.println("\t * " + this.name + " Move *");
        System.out.println("'Kau Takkan Bisa Menyentuhku'");
    }


}
