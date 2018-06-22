#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <iostream>

using namespace std;

char *cadena=(char*)calloc(400, sizeof(char));
int valido, cont;
char edo;

void D(int contD){
	edo='D'; valido=1;
	printf("%c - %c\n", edo, cadena[contD]);
	if(contD<strlen(cadena)){
		
		if(cadena[contD]=='1'||cadena[contD]=='0') D(contD+1);
	}
}

void C(int contC){
	edo='C';
	printf("%c - %c\n", edo, cadena[contC]);
	if(contC<strlen(cadena)){
		
		if(cadena[contC]=='1') D(contC+1);
	}
}

void B(int contB){
	edo='B';
	printf("%c - %c\n", edo, cadena[contB]);
	if(contB<strlen(cadena)){
		
		if(cadena[contB]=='0') D(contB+1);
	}
}

void A(int contA){
	edo='A';
	printf("%c - %c\n", edo, cadena[contA]);
	if(contA<strlen(cadena)){
		
		if(cadena[contA]=='0') {A(contA+1);B(contA+1);} 
		else if(cadena[contA]=='1') {A(contA+1); C(contA+1);}
	}
}

void inicio(char *s){
	cadena=s;
	valido=0; cont=0;
	A(cont);

	if(valido==1) printf("Aceptada");
	else printf("Rechazada");
}