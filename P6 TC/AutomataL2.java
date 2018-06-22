import java.util.Stack;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class AutomataL2{
	public int cont; 
	public char cadena[];
	public String s="", edo, msje="";
	public boolean aceptado;
	public Stack<String> pila;

	public AutomataL2(){
		pila = new Stack<String>(); 
		aceptado=false;
		pila.push("Z0");
	}

	public boolean inicio(String s){
		
		this.s=s;
		cadena=s.toCharArray();
		cont=-1; edo="0";

		q0();

		if (edo.equals("4")){
			msje="La cadena '"+s+"'' ha sido ACEPTADA por el automata L2.  Estado: "+edo;
			JOptionPane.showMessageDialog(null, msje, "Cadena Valida", 1);
			System.out.println("Aceptado");
		}
		else{
			if(edo.equals("Muerto")){
				msje="La cadena ''"+s+"'' ha sido NO ACEPTADA por el automata L2.  Estado: Muerto";
				JOptionPane.showMessageDialog(null, msje,"Cadena Invalida", JOptionPane.ERROR_MESSAGE);
			}
			else{
				msje="La cadena ''"+s+"'' ha sido NO ACEPTADA por el automata L2.  Estado: "+edo;
				JOptionPane.showMessageDialog(null, msje,"Cadena Invalida", JOptionPane.ERROR_MESSAGE);
				System.out.println("Invalido");		
			}
		}
		s="";
		return aceptado;

	}

	public void qMuerto(){edo="Muerto";}

	public void q0(){
		edo="0";
		System.out.println("Estado: "+edo+" | Tope Pila: "+pila.peek()); cont++;
	
		if (cont<cadena.length){
			if(cadena[cont]=='0' && (pila.peek()=="Z0"||pila.peek()=="A")){
				pila.push("A");
				q0();
			}
			else if(cadena[cont]=='1' && pila.peek()=="A"){
				pila.pop();
				q1();
			}
			else if(cadena[cont]=='1' && pila.peek()=="Z0"){
				pila.push("B");
				q2();
			}
			else if(cadena[cont]=='3' && pila.peek()=="Z0"){
				q4();
			}
			else qMuerto();

		}
	}

	public void q1(){
	edo="1"; 
	System.out.println("Estado: "+edo+" | Tope Pila: "+pila.peek()+" | Caracter: "+cadena[cont]);
	cont++;
	
		if (cont<cadena.length){
			if(cadena[cont]=='1' && pila.peek()=="A"){
				pila.pop();
				q1();
			}
			else if(cadena[cont]=='3' && pila.peek()=="Z0"){
				q4();
			}
			else if(cadena[cont]=='1' && pila.peek()=="Z0"){
				pila.push("B");
				q2();
			}
			else qMuerto();

		}
	}

	public void q2(){
		edo="2";
		System.out.println("Estado: "+edo+" | Tope Pila: "+pila.peek()+" | Caracter: "+cadena[cont]); cont++;
		
		if (cont<cadena.length){

			if(cadena[cont]=='1' && pila.peek()=="B"){
				pila.push("B");
				q2();
			}
			else if(cadena[cont]=='2' && pila.peek()=="B"){
				pila.pop();
				q3();
			}
			else qMuerto();
			
		}

	}

	public void q3(){
		edo="3";
		System.out.println("Estado: "+edo+" | Tope Pila: "+pila.peek()+" | Caracter: "+cadena[cont]); cont++;
	
		if (cont<cadena.length){

			if(cadena[cont]=='2' && pila.peek()=="B"){
				pila.pop();
				q3();
			}
			else if(cadena[cont]=='3' && pila.peek()=="Z0"){
				q4();
			}
			else qMuerto();
		}
	}

	public void q4(){
		edo="4";
		System.out.println("Estado: "+edo+" | Tope Pila: "+pila.peek()+" | Caracter: "+cadena[cont]); cont++;
	
		if (cont<cadena.length){
			if(cadena[cont]=='3' && pila.peek()=="Z0"){
				q4();
			}
			else qMuerto();
		}
	}
}