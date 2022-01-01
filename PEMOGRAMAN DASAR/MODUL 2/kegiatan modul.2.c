#include <stdio.h>

int main()
{

	float dolar, euro, ringgit;
	int rupiah_A = 10720;
	int rupiah_B = 7846;
	int rupiah_C = 8607758;
	

	
	dolar = rupiah_A / 14.684;
	euro = dolar / 1,177;
	ringgit = euro / 0,204;
	
	printf("konversi rupiah A adalah %d rupiah sama dengan : ", rupiah_A);
	printf("\n %.2f dolar \n %.2f euro \n %.2f ringgit\n", dolar, euro, ringgit);
	
//	dolar = rupiah_B / 14684;
///	euro = dolar / 1,177;
//	ringgit = euro / 0,206;
	
	printf("\nkonversi rupiah B adalah %d rupiah sama dengan : ", rupiah_B);
	printf("\n %.2f dolar \n %.2f euro \n %.2f ringgit\n", dolar, euro, ringgit);
	
//	dolar = rupiah_C/ 14684;
//	euro = dolar / 1,177;
//	ringgit = euro / 0,206;
	
	printf("\nkonversi rupiah C adalah %d rupiah sama dengan : ", rupiah_C);
	printf("\n %.2f dolar \n %.2f euro \n %.2f ringgit\n", dolar, euro, ringgit);

	return 0;
}
