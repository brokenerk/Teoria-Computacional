#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <iostream>

using namespace std;

char *acadena=(char*)calloc(400, sizeof(char));
int avalido, acont;
char aedo;

void aD(int acontD){
	aedo='D';
	printf("%c - %c - %d\n", aedo, acadena[acontD-1], acontD-1);
	if(acontD<strlen(acadena)){
		 avalido=0;
		if(acadena[acontD]=='1'||acadena[acontD]=='0'){ aD(acontD+1);} 
	}
	else avalido=1;
}

void aC(int acontC){
	aedo='C';
	printf("%c - %c - %d\n", aedo, acadena[acontC-1], acontC-1);
	if(acontC<strlen(acadena)){
		if(acadena[acontC]=='1') aD(acontC+1);
	}
}

void aB(int acontB){
	aedo='B';
	printf("%c - %c - %d\n", aedo, acadena[acontB-1], acontB-1);
	if(acontB<strlen(acadena)){
		
		if(acadena[acontB]=='0') aD(acontB+1);
	}
}

void aA(int acontA){
	aedo='A';

	if(acontA<strlen(acadena)){
		if(acadena[acontA]=='0') {printf("%c - %c - %d\n", aedo, acadena[acontA], acontA); aB(acontA+1); aA(acontA+1);} 
		else if(acadena[acontA]=='1') {printf("%c - %c - %d\n", aedo, acadena[acontA], acontA); aC(acontA+1); aA(acontA+1);}
	}
}

void inicioAFNDa(char *s){
	acadena=s;
	avalido=0; acont=0;
	aA(acont);

	if(avalido==1) printf("\nAceptada");
	else printf("\nRechazada");
}