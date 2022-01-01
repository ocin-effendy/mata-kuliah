package com.code;

public class Assassin extends Character implements CriticalDamage {

    public Assassin(int level){
        this.level = level;

    }

    public void setHealtPoint(double healtPoint){
        this.healtPoint = this.level * 80 + healtPoint;
    }


    public void setDefense(double defense){
        this.defense = this.level * 10 + defense;
    }


    public void setAttackDamage(double attackDamage){
        this.attackDamage = doubleDamage(this.level * 25 + attackDamage);
    }

    @Override
    public double doubleDamage(double attackDamage) {
        double plusDamage = 0.2D;
        return plusDamage * attackDamage + attackDamage;
    }

    @Override
    public void spawnIntro() {
        System.out.println("\t * " + this.name + " Move *");
        System.out.println("'Saya Lapar Akan Perhatianmu'");
    }

}
