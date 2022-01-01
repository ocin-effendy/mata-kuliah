package com.code;

public class Tabung extends BangunRuang{
    double t = 10;
    double luasPermukaan;
    double volume;
    @Override
    void getLuasPermukaan(double input) {
        luasPermukaan = 2 * Math.PI * Math.pow(input,2) + 2 * Math.PI * input * t;
        System.out.println("Luas Permukaan Tabung adalah : " + luasPermukaan);
    }

    @Override
    void getVolume(double input) {
        volume = Math.PI * Math.pow(input,2) * t;
        System.out.println("Volume Tabung Adalah : " + volume);
    }
}
