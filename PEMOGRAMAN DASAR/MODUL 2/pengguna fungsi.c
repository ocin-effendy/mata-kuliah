#include <stdio.h>

int hitung_luas(int panjang, int lebar){
	int luas;
	luas = panjang * lebar;
	return luas;
		
}

 int main(){
	 int panjang = 8;
	 int lebar = 9;
	 int luas;
	 
	 luas = hitung_luas(panjang, lebar);
	 printf("%d \n", luas);
	 return 0;
 }