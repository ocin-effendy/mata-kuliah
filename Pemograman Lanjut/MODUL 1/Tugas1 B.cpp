#include <stdio.h>

int find(int x, int arr[]){
	int i=0;
	while(i <= 10){
		if(arr[i] == x){
			x=-1;
        }
        i++;
		
	}
 return x;
}

int main(int argc, char** argv)
{
	int arr[] = {1,2,3,4,5,6,7,8,9};
	if(find(5, arr) == -1){
		printf("angka ada di array");
	}else{
		printf("anggka tidak ada di array");
	}
	return 0;
}