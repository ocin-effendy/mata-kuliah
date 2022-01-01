package com.code;

public class Balok extends BangunRuang{

    double t = 10;
    double l = 5;
    double luasPermukaan;
    double volume;
    @Override
    void getLuasPermukaan(double input) {
        luasPermukaan = 2 * ((input * l) + (input * t) + (l * t));
        System.out.println("Luas Permukaan Balok adalah : " + luasPermukaan);
    }

    @Override
    void getVolume(double input) {
        volume = input * l * t;
        System.out.println("Volume Balok Adalah : " + volume);
    }

}
