#include <stdio.h>
#define a 3
#define b 0.04

int main()
{
   	int nilai1,nilai2,nilai3;
    int ratarata;
    float nilaiakhir;
	
	printf("masukkan nilai 1 : ");
	scanf("%d", &nilai1);
	printf("masukkan nilai 2 : ");
	scanf("%d", &nilai2);
	printf("masukkan nilai 3 : ");
	scanf("%d", &nilai3);
	
	ratarata = (nilai1+nilai2+nilai3)/a;
    printf("\nrata rata nilai yang kamu peroleh adalah : %d", ratarata);
    
    nilaiakhir = ratarata * b;
    printf("\nnilai akhir yang kamu peroleh : %.2f", nilaiakhir);
	

    
	return 0;
}