#include "AFNDa.h"
#include "AFNDb.h"
#include "AFNDc.h"
#include "xor_xnor.h"
#include "stdio.h"

using namespace std;

int main(){
	char *palabra=(char*)calloc(400, sizeof(char));
	int op, rep;

	do{
		system("/usr/bin/clear");
		printf("Practica 4.- AUTOMATAS FINITOS NO DETERMINISTAS\n\n");
		printf("*******MENU******\n");
		printf("1.- Inciso A) ER: (0|1)*(00|11)(0|1)*\n");
		printf("2.- Inciso B) ER: 1* | (0|1)*0\n");
		printf("3.- Inciso C)\n");
		printf("4.- Inciso D) Tema Libre: Compuertas XOR Y XNOR \n");
		printf("5.- Salir\n\n");
		printf("Digite una opcion: "); 
		scanf("%d", &op);

		


		switch(op){
			case 1:
				printf("\n\nIngrese la palabra a analizar: ");
				scanf("%s", palabra);
				printf("\nPalabra: %s\n\n", palabra);
				inicioAFNDa(palabra);
			break;
			case 2:
				printf("\n\nIngrese la palabra a analizar: ");
				scanf("%s", palabra);
				printf("\nPalabra: %s\n\n", palabra);
				inicioAFNDb(palabra);
			break;
			case 3:
				printf("\n\nIngrese la palabra a analizar: ");
				scanf("%s", palabra);
				printf("\nPalabra: %s\n\n", palabra);
				inicioAFNDc(palabra);
			break;
			case 4:
				printf("\n\nIngrese la entrada de bits: ");
				scanf("%s", palabra);
				printf("\nEntrada: %s\n\n", palabra);

				if(strlen(palabra)<=1) printf("Error. Las compuertas logicas necesitan al menos 2 bits para funcionar");
				else iniciabits(palabra);
			break;
			case 5:
				printf("Saliendo...");
				exit(-1);
			break;
			default:
				printf("Se ha ingresado una opcion invalida.\n");
		}
		
		
		printf("\n\n");
		printf("Volver al menu = 1 / Salir = Pulse cualquier otro numero \n");
		scanf("%d", &rep);
	}while(rep==1);
	return 0;
}
