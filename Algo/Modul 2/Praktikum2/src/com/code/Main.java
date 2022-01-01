package com.code;

public class Main {

    public static void main(String[] args) {

        String[] mobil1 = {"Lala", "Zahra", "Dede", "Bobo", "Boba"};
        String[] mobil2 = {"Jarvis", "Daniel", "Qibo", "Aldo", "Boca"};
        String[] daftarPenumpang = new String[mobil1.length + mobil2.length];
        int index = 0;
        for (int i = 0; i < daftarPenumpang.length; i++){
            if(i < daftarPenumpang.length/2){
                daftarPenumpang[i] = mobil1[i];
            }else {
                daftarPenumpang[i] = mobil2[index];
                index++;
            }
        }

        System.out.println("\n\n=============== BUBBLE SORT ===============");
        String[] arrString = {"culdy", "capi","vico", "budi","cuba","caa","cubdy", "bai", "cabi" };
        bubbleSort(daftarPenumpang);

        System.out.println("\n\n=============== SELECTION SORT ===============");
        String[] arrString2 = {"Zaldy" , "Angga", "Nico","Baba", "Bibi", "Aldo" ,"Bobo" };
        selectionSort(daftarPenumpang);



    }

    public static void bubbleSort(String[] array){
        boolean check;
        do {
            check = false;
            for (int i = 0; i < array.length-1; i++){
                if (array[i].codePointAt(0) > array[i+1].codePointAt(0)){
                    String temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    check= true;
                }else if (array[i].codePointAt(0) == array[i+1].codePointAt(0)){
                    int index = 1;
                    boolean c;
                    do {
                        c = false;
                        if (array[i].codePointAt(index) == array[i+1].codePointAt(index)){
                            c = true;
                        }else if (array[i].codePointAt(index) > array[i+1].codePointAt(index)){
                            String temp = array[i];
                            array[i] = array[i+1];
                            array[i+1] = temp;
                        }
                        index++;
                    }while(c);
                }
            }
        }while (check);
        for (String j : array) System.out.print(j + " ");

    }

    public static void selectionSort(String[] array){
        int min;
        for (int i = 0; i < array.length; i++){
            min = i;
            for (int j = i + 1; j < array.length  ; j++){
                if (array[j].codePointAt(0) < array[min].codePointAt(0)){
                    min = j;
                }else if(array[j].codePointAt(0) == array[min].codePointAt(0)){
                    int index1 = 1;
                    boolean b;
                    do {
                        b = false;
                        if (array[j].codePointAt(index1) == array[min].codePointAt(index1)){
                            b = true;
                        }else if (array[j].codePointAt(index1) < array[min].codePointAt(index1)){
                            min = j;
                        }
                        index1++;
                    }while(b);
                }
            }

            String temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }

        for (String j : array) System.out.print(j + " ");

    }


}
