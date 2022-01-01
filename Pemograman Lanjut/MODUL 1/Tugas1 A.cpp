#include <stdio.h>

int main(int argc, char** argv)
{
	int i =0;
	int sgenap[16], sganjil[16];
	int genap=0,ganjil=0,total=0;
	int arr[]={1,2,3,4,5,6,7,8,9};
	
	
	while(i < 9){
		if(arr[i]%2==0){
			genap +=arr[i];
			
			
		}else{
			ganjil += arr[i];
			
		}
		total += arr[i];
		i++;
		
	}

	
	printf("\njumlah bilangan genap adalah : %d", genap);
	printf("\njumlah bilangan ganjil adalah : %d", ganjil);
	printf("\nTotal adalah : %d", total);
	
	return 0;
}