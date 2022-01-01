#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<stdbool.h>

char inputnim[15], nimcpy[9], IF[9]={'1','0','3','7','0','3','1','1','\0'};
int nimlen,cekkode=0,i=0,a;
bool run=true;

int main()
{
	while(run)
	{
		try{
			system("cls");
			printf("Input NIM anda : ");
			scanf("%s",inputnim);
			nimlen = strlen(inputnim);
				if(nimlen==15){
					strncpy(nimcpy,inputnim+4,8);
					cekkode = strcmp(IF,nimcpy);
					
						if(cekkode == 0){
				   		   	printf("\nSELAMAT! NIM ANDA BERHASIL DI INPUT\n");
				    	   	run=false;
					   	}else{
				   		   	short c=1;
				   	      	throw (c);
				   	   	}
				   	   	
			  	}else if(nimlen>15){
				   	throw 1;
				   	
				}else if(nimlen<15){
			  		throw 'b';
				}	

		}catch(int a){
			printf("\nNIM tidak boleh lebih dari 15 angka\nInput ulang!\n\n"); system("pause");
		}catch(char b){
			printf("\nNIM tidak boleh kurang dari 15 angka\nInput ulang!\n\n"); system("pause");
		}catch(short c){
			printf("Anda bukan mahasiswa informatika!\nHanya NIM mahasiswa informatika\n\n"); 
			system("pause");
		}
				
		i++;		
	}
	return 0;
}