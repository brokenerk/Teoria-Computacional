#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <iostream>

using namespace std;

char *bcadena=(char*)calloc(400, sizeof(char));
int bvalido, bcont;
char bedo;

void bD(int bcontD){
	bedo='D';
	printf("%c - %c - %d\n", bedo, bcadena[bcontD-1], bcontD-1);
	if(bcontD<strlen(bcadena)){
		bvalido=0; //hay caracteres
	} 
	else bvalido=1; //fin de la cadena
}

void bC(int bcontC){
	bedo='C'; 

	if(bcontC<strlen(bcadena)){
		printf("%c - %c - %d\n", bedo, bcadena[bcontC], bcontC);
		if(bcadena[bcontC]=='1') bC(bcontC+1);
		else if(bcadena[bcontC]=='0') { bD(bcontC+1); bC(bcontC+1);  }
	}
}

void bA(int bcontA){
	bedo='A'; bvalido=1;
	if(bcontA<strlen(bcadena)){
		printf("%c - %c - %d\n", bedo, bcadena[bcontA], bcontA);
		if(bcadena[bcontA]=='1') bA(bcontA+1);
	}
}

void bB(int bcontB){
	bedo='B'; 
	printf("%c - %c - %d\n", bedo, bcadena[bcontB], bcontB);
	bA(bcontB);
	bC(bcontB);
	
}

void inicioAFNDb(char *s){
	bcadena=s;
	bvalido=0; bcont=0;
	bB(bcont);

	if(bvalido==1) printf("\nAceptada");
	else printf("\nRechazada");
}