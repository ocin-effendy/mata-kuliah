#include <stdio.h>
#include <string.h>
#include <windows.h>

int main()
{
	char arrKode[15];
	arrKode[4] = '1';
	arrKode[5] = '0';
	arrKode[6] = '3';
	arrKode[7] = '7';
	arrKode[8] = '0';
	arrKode[9] = '3';
	arrKode[10] = '1';
	arrKode[11] = '1';
	char arrNim[15];
	
	awal:
	system("cls");
	printf("Inputkan NIM : ");
	fflush(stdin);
	gets(arrNim);
	
	try{
		if(strlen(arrNim) < 15){
			throw arrNim;
		}else if(strlen(arrNim) > 15){
			throw 1;
		}else{
			for(int i=4; i < 12; i++){
				if(arrKode[i] != arrNim[i]){
					throw 'b';
				}
            }	
		}
	}catch(char* e){
		printf("Nim Kurang dari 15 Digit\n");
		getchar();
		goto awal;
	}catch(int e){
		printf("Nim lebih dari 15 Digit\n");
		getchar();
		goto awal;
	}catch(char b){
		printf("Nim Bukan Informatika\n");
		getchar();
		goto awal;
	}
	
	printf("\nNIM anda : ");
	for(int i =0; i < 16; i++){
		printf("%c", arrNim[i]);
	}
	
	
	/*
	try{
		
		system("cls");
		printf("Inputkan NIM : ");
	   	gets(arrNim);
	   	
		
	}catch(char* e){
		printf("nim lebih");
		
		
	}
	
	
	try{
		for(int i=1; i < 4; i++){
			if(arrKode[i] != arrNim[i]){
				throw arrNim;
			}
		}
	}catch(char* e){
		printf("nim tidak informatika");
		goto awal;
	}
	
	*/
	
	return 0;
}