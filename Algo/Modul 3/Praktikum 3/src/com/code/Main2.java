package com.code;

import java.util.ArrayList;
import java.util.Arrays;

public class Main2 {

    public static ArrayList<String> permute(String s) {

        ArrayList<String> perms = new ArrayList<>();
        int arrLength = s.length();
        if (arrLength > 0) {
            perms.add(Character.toString(s.charAt(0)));

            for (int i = 1; i < arrLength; i++) {
                char c = s.charAt(i);

                int size = perms.size();
                System.out.println("ini size :" + size);

                for (int j = 0; j < size; ++j) {

                    String p = perms.remove(0);
                    int plen = p.length();
                    System.out.println("isi perms : " + perms);
                    System.out.println("p : " + p);
                    System.out.println("panjang p : " + plen);

                    for (int k = 0; k <= plen; k++) {
                        perms.add(p.substring(0, k) + c + p.substring(k));
                        System.out.println("perm di loop akhir : " + perms);
                    }
                }
            }
        }
        return perms;
    }
    public static void main(String[] args) {

        String ourword = "abc";

        System.out.println("====== hasil =========");

        for (int i=0; i < permute(ourword).size(); i++){
            System.out.println(permute(ourword).get(i));
            System.out.println();
        }



//         permutation(ourword);




//        String nama = "abc";
//        String[] t = {"a","b","c"};
//        int faktorial = 1;
//        for (int i = 1; i <= nama.length(); i++){
//            faktorial = faktorial* i;
//        }
//        System.out.println("faktorial : "+ faktorial);
//
//        for (int i = 0; i < t.length; i++){
//            permutasi(t,i,t[i]);
//        }


//        permutation("abc");

//        String str = "abc";
//        StringBuffer strBuf = new StringBuffer(str);
//        doPerm(strBuf,str.length());


//        String[] arr = { "a", "b"};
//        int faktorial = 1;
//        for (int i = 1; i <= arr.length; i++) faktorial = faktorial* i;
//        String[][] arrHasil = new String[faktorial][arr.length];
//
//
//        for (int i = 0; i < arr.length; i++){
//            if (i == arr.length -1){
//                tambahData(arr,arr[i], arr[arr.length-1],arrHasil, faktorial);
//                break;
//            }else{
//                tambahData(arr,arr[i], arr[i+1], arrHasil, faktorial);
//            }
//        }
//
//        show(faktorial,arrHasil);

//        String[] arr = { "a", "b","c"};
//        String[] arrTemp = Arrays.copyOf(arr,arr.length);
//        for (int i = 0; i < arr.length; i++){
//
//
//            for (int j = 0; j < arr.length; j++){
//
//            }
//        }


    }
    public static void permutation(String str) {
        permutation1("", str);
    }

    private static void permutation1(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation1(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }



    public static void tambahData(String[] arr, String huruf1, String huruf2, String[][] arrHasil, int faktorial) {

        boolean check = true;
        String checkHuruf = "";
        for (int i = 0; i < faktorial; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arrHasil[i][j] == null && !checkHuruf.equals(huruf1)) {
                    arrHasil[i][j] = huruf1;
                    checkHuruf = huruf1;
                } else if (arrHasil[i][j] == null && !checkHuruf.equals(huruf2)) {
                    arrHasil[i][j] = huruf2;
                    checkHuruf = huruf2;
                }
            }
        }


    }

    public static void show(int faktorial, String[][] arrHasil) {
        for (int i = 0; i < faktorial; i++) {
            System.out.println(Arrays.toString(arrHasil[i]));
        }
    }









}
