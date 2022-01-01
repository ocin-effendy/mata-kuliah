#include <stdio.h>

int fungsiare (int hektare)
{
	int are;
	are = hektare * 100;
	return are;
}

int fungsim_persegi (int are)
{
	int m_persegi;
	m_persegi = are * 100;
	return m_persegi;
	}

int fungsicm_persegi (m_persegi)
{
	int cm_persegi;
	cm_persegi = m_persegi * 10000;
	return cm_persegi;
}

int main()
{
	int hektare, are, m_persegi, cm_persegi;
	printf("masukkan datuan luas dalam satuan hektare : ");
	scanf("%d", &hektare);
	
	are = fungsiare(hektare);
	m_persegi = fungsim_persegi(are);
	cm_persegi = fungsicm_persegi(m_persegi);
	
	printf("konversi satuan luas adalah %d hektare sama dengan : ", hektare);
	printf("\n %d are \n %d meter persegi \n %d centimeter persegi\n", are, m_persegi, cm_persegi);
	
	return 0;
}