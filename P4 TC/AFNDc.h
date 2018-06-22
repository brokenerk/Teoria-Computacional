#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <iostream>

using namespace std;

char *ccadena=(char*)calloc(400, sizeof(char));
int cvalido, ccont;
char cedo;

void cD(int ccontD);
void cC(int ccontC);
void cB(int ccontB);

void cF(int ccontF){
	cedo='F';
	printf("%c - %c - %d\n", cedo, ccadena[ccontF-1], ccontF-1);
	if(ccontF<strlen(ccadena)){
		cvalido=0; //hay caracteres
	} 
	else cvalido=1; //fin de la cadena
}

void cE(int ccontE){
	cedo='E';
	printf("%c - %c - %d\n", cedo, ccadena[ccontE-1], ccontE-1);
	if(ccontE<strlen(ccadena)){
		if(ccadena[ccontE]=='0') {cF(ccontE+1); cD(ccontE+1); } 
		else if (ccadena[ccontE]=='1') cC(ccontE+1);
	}
}

void cD(int ccontD){
	cedo='D'; 
	printf("%c - %c - %d\n", cedo, ccadena[ccontD-1], ccontD-1);
	if(ccontD<strlen(ccadena)){
		if(ccadena[ccontD]=='0') {cF(ccontD+1); cE(ccontD+1);} 
	}
}

void cC(int ccontC){
	cedo='C';
	printf("%c - %c - %d\n", cedo, ccadena[ccontC-1], ccontC-1);
	if(ccontC<strlen(ccadena)){
		if(ccadena[ccontC]=='1') {cF(ccontC+1); cD(ccontC+1); } 
		else if(ccadena[ccontC]=='0') cB(ccontC+1);
	}
}

void cB(int ccontB){
	cedo='B';
	printf("%c - %c - %d\n", cedo, ccadena[ccontB-1], ccontB-1);

	if(ccontB<strlen(ccadena)){
		if(ccadena[ccontB]=='0') cB(ccontB+1);
		else if(ccadena[ccontB]=='1') cC(ccontB+1);
	}
}

void cA(int ccontA){
	cedo='A';
	if(ccontA<strlen(ccadena)){
		if(ccadena[ccontA]=='0') {printf("%c - %c - %d\n", cedo, ccadena[ccontA], ccontA); cB(ccontA+1);} 
		else if(ccadena[ccontA]=='1') {printf("%c - %c - %d\n", cedo, ccadena[ccontA], ccontA); cA(ccontA+1);}
	}
}

void inicioAFNDc(char *s){
	ccadena=s;
	cvalido=0; ccont=0;
	cA(ccont);

	if(cvalido==1) printf("\nAceptada");
	else printf("\nRechazada");
}