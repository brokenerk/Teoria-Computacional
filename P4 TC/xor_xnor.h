#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <iostream>

using namespace std;

char *bits=(char*)calloc(400, sizeof(char));
int Xnor, Xor, count;
int edo;

void q2(int cont2);
void q1(int cont1);

void q4(int cont4){
	edo=4;
	if(cont4<strlen(bits)){
		if(bits[cont4]=='1') q2(cont4+1);
		else if(bits[cont4]=='0') q4(cont4+1); 
	} 
}

void q3(int cont3){
	edo=3; 
	if(cont3<strlen(bits)){
		if(bits[cont3]=='1') q3(cont3+1);
		else if(bits[cont3]=='0') q1(cont3+1); 
	}

}


void q2(int cont2){//unos pares
	edo=2; 
	if(cont2<strlen(bits)){
		if(bits[cont2]=='1') q4(cont2+1);
		else if(bits[cont2]=='0') q2(cont2+1);
	}
	else {Xor=0; Xnor=1;}

}

void q1(int cont1){//ceros pares
	edo=1; 
	if(cont1<strlen(bits)){
		if(bits[cont1]=='1') q1(cont1+1);
		else if(bits[cont1]=='0') q3(cont1+1);
	}

}

void q0(int cont0){
	edo=0; 
	q1(cont0);
	q2(cont0);


}

void iniciabits(char *s){
	bits=s;
	Xor=1; Xnor=0; count=0;
	q0(count);

	printf("XOR = %d \nXNOR = %d", Xor, Xnor);
}