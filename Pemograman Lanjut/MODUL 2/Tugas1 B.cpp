#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <conio.h>


void cekName(char *name);
void cekFrom(char *from);
void cekDate(int date);
void list();

char book[10][100] = {{"A book, Malang. 2021"}};
char place[][10] = {{"Malang"}, {"Batu"}, {"Surabaya"}};

int main()
{
	char inName[20], inFrom[10], name[50];
	int inDate;
	system("cls");
	printf("\nWellcome\nInput Buku \n");
	printf("Nama : ");
	fflush(stdin);
	scanf("%[^\n]", &inName);
	cekName(inName);
	printf("From : ");
	fflush(stdin);
	scanf("%s", &inFrom);
	cekFrom(inFrom);
	printf("Date : ");
	fflush(stdin);
	scanf("%d", &inDate);
	cekDate(inDate);
	sprintf(name, "%s, %s. %d", inName, inFrom, inDate);
	strcpy(book[1], name);
	printf("\nMenambahkan Buku Sukses\n");
	list();
	exit(1);
	
	return 0;
}

void cekDate(int date){
	if(date <= 2018 || date >= 2021){
		printf("Harus Buku Keluaran 2019-2020");
		getch();
		main();
		
	}
}

void cekFrom(char from[]){
	for(int i =0; place[i][0] != '\0'; i++){
		if(strcmp(from, place[i]) == 0){
			printf("Data Tempat Sudah Ada");
			getch();
			main();
		}
	}
}

void cekName(char *name){
 	for(int i=0; book[i][0] != '\0'; i++){
		 if(strcmp(name,book[i]) == 0){
			 printf("Data Nama Sudah Ada");
			 getch();
			 main();
		 }
	 }
}

void list(){
	printf("\n== List Buku == ");
	for(int i=0; book[i][0] != '\0'; i++){
		printf("\n%s", book[i]);
	}
	
	printf("\n");
	
}


 
