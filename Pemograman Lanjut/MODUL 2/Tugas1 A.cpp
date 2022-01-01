#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <conio.h>

char pulsa[][10] = {{"5000"},{"10000"},{"15000"},{"20000"},{"50000"}};
char noHp[5];
char pulsaInput[10];
int cekNomor=0, jumlahNo;



void login();
void cekNomorHp(char dataArray[]);
void cekPulsa(char pulsaInputan[]);
void berhasil();
void daftarPulsa ();


int main()
{
	login();
	return 0;
}

void login(){
	system("cls");
	printf("Masukkan Nomor Hp : ");
	gets(noHp);
	
	cekNomorHp(noHp);
	daftarPulsa();
	
	printf("Masukkan Pulsa : ");
	gets(pulsaInput);
	
	cekPulsa(pulsaInput);
	berhasil();
}

void cekNomorHp(char dataArray[]){
	char noCopy[4];
	char noHpResmi[13] = {'0','8','1','2','\0'};
    
    jumlahNo = strlen(dataArray);
    
    if(jumlahNo == 12){
		strncpy(noCopy,dataArray+0,4);
    	cekNomor = strcmp(noHpResmi,noCopy);
    	
    	if(cekNomor == 0){
			printf("Nomor Sama Dengan Kode Nomor");
		}else{
			printf("Nomor Beda Sama Kode Nomor");
			getch();
			login();
		}
		
	}else if(cekNomor < 12){
		printf("Maaf Nomor Kurang Dari 12 Digit");
		getch();
		login();
	}else if(cekNomor > 12){
		printf("Maaf Nomor Lebih Dari 12 Digit");
		getch();
		login();	
	}
	
}

void cekPulsa(char pulsaInputan[]){
	
	for(int i=0; pulsa[i][0] != '\0'; i++){
		if(strcmp(pulsaInputan,pulsa[1]) == 0){
			break;
			
		}else{
			printf("pulsa tidak tersedia");
			getch();
			login();
		}
			
	}
}

void berhasil(){
	printf("\nSelamat Trasaksi Berhasil");
	exit(EXIT_SUCCESS);
	
}

void daftarPulsa(){
	
	printf("\nDaftar Pulsa : \n");
	for(int i=0; pulsa[1][i] != '\0'; i++){
		printf("%d. %s\n", i+1, pulsa[i]);
	}
}

















