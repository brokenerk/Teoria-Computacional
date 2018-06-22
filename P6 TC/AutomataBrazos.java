import java.util.Stack;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class AutomataBrazos{
	public int cont; 
	public char cadena[];
	public String s="", edo, msje="";
	public boolean aceptado;
	public Stack<String> pila;

	public AutomataBrazos(){
		pila = new Stack<String>(); 
		aceptado=false;
		pila.push("Z");
	}

	public boolean inicio(String s){
		
		this.s=s;
		cadena=s.toCharArray();
		cont=-1; edo="0";

		q0();

		if (edo.equals("3")){
			msje="El personaje tiene brazos equilibrados, teniendo una anatomia normal.";
			JOptionPane.showMessageDialog(null, msje, "Anatomia normal", 1);
			System.out.println("Aceptado");
		}
		else{
				msje="El personaje tiene brazos desbalanceados, nacio deforme...";
				JOptionPane.showMessageDialog(null, msje,"Malformacion encontrada", JOptionPane.ERROR_MESSAGE);
				System.out.println("Invalido");		
			
		}
		s="";
		return aceptado;

	}

	public void qMuerto(){edo="Muerto";}

	public void q0(){
		edo="0";
		System.out.println("Estado: "+edo+" | Tope Pila: "+pila.peek()); cont++;
	
		if (cont<cadena.length){
			if((cadena[cont]=='O'||cadena[cont]=='o') && pila.peek()=="Z"){
				q1();
			}

		}
	}

	//O-----------------T-----------------O

	public void q1(){
	edo="1"; 
	System.out.println("Estado: "+edo+" | Tope Pila: "+pila.peek()+" | Caracter: "+cadena[cont]);
	cont++;
	
		if (cont<cadena.length){
			if(cadena[cont]=='-' && pila.peek()=="Z"){
				pila.push("Y");
				q1();
			}
			else if(cadena[cont]=='-' && pila.peek()=="Y"){
				pila.push("Y");
				q1();
			}
			else if(cadena[cont]=='T' && pila.peek()=="Y"){
				q2();
			}

		}
	}

	public void q2(){
		edo="2";
		System.out.println("Estado: "+edo+" | Tope Pila: "+pila.peek()+" | Caracter: "+cadena[cont]); cont++;
		
		if (cont<cadena.length){

			if(cadena[cont]=='-' && pila.peek()=="Y"){
				pila.pop();
				q2();
			}
			else if((cadena[cont]=='O'||cadena[cont]=='o') && pila.peek()=="Z"){
				q3();
			}
			
		}

	}

	public void q3(){
		edo="3";
		System.out.println("Estado: "+edo+" | Tope Pila: "+pila.peek()+" | Caracter: "+cadena[cont]); cont++;
	}


}