package com.company;

import java.util.Arrays;

public class BruteForce {
    private final char[] arrayChar;
    private char[] arrayPattern;

    public BruteForce(char[] characterSet, int guessLength){
        arrayChar = characterSet;
        arrayPattern = new char[guessLength];
        Arrays.fill(arrayPattern, arrayChar[0]);
    }

    public void increment() {
        int index = arrayPattern.length - 1;
        while(index >= 0) {
            if (arrayPattern[index] == arrayChar[arrayChar.length-1]) {
                if (index == 0){
                    arrayPattern = new char[arrayPattern.length+1];
                    Arrays.fill(arrayPattern, arrayChar[0]);
                    break;
                }else {
                    arrayPattern[index] = arrayChar[0];
                    index--;
                }
            }else{
                arrayPattern[index] = arrayChar[Arrays.binarySearch(arrayChar, arrayPattern[index]) + 1];
                break;

            }
        }
    }

    @Override
    public String toString() {
        return String.valueOf(arrayPattern);
    }

}