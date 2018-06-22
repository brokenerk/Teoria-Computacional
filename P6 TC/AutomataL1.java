import java.util.Stack;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class AutomataL1{
	public int cont; 
	public char cadena[];
	public String s="", edo, msje="";
	public boolean aceptado;
	public Stack<String> pila;

	public AutomataL1(){
		pila = new Stack<String>(); 
		aceptado=false;
		pila.push("Z0");
	}

	public boolean inicio(String s){
		
		this.s=s;
		cadena=s.toCharArray();
		cont=-1; edo="0";

		q0();

		if (edo.equals("2")){
			msje="La cadena '"+s+"'' ha sido ACEPTADA por el automata L1.  Estado: "+edo;
			JOptionPane.showMessageDialog(null, msje, "Cadena Valida", 1);
			System.out.println("Aceptado");
		}
		else{
			if(edo.equals("Muerto")){
				msje="La cadena ''"+s+"'' ha sido NO ACEPTADA por el automata L1.  Estado: Muerto";
				JOptionPane.showMessageDialog(null, msje,"Cadena Invalida", JOptionPane.ERROR_MESSAGE);
			}
			else{
				msje="La cadena ''"+s+"'' ha sido NO ACEPTADA por el automata L1.  Estado: "+edo;
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
		System.out.println("");
		System.out.println("Estado: "+edo+" | Tope Pila: "+pila.peek()); cont++;
	
		if (cont<cadena.length){
			if(cadena[cont]=='a' && (pila.peek()=="Z0"||pila.peek()=="A")){
				pila.push("A");
				q0();
			}
			else if(cadena[cont]=='b' && pila.peek()=="A"){
				q1();
			}
			else qMuerto();

		}
	}

	public void q1(){
	edo="1"; 
	System.out.println("Estado: "+edo+" | Tope Pila: "+pila.peek()+" | Caracter: "+cadena[cont]);
	cont++;
	
		if (cont<cadena.length){
			if(cadena[cont]=='c' && pila.peek()=="A"){
				pila.pop();
				q1();
			}
			else if(cadena[cont]=='c' && pila.peek()=="Z0"){
				q2();
			}

			else qMuerto();

		}
	}

	public void q2(){
			edo="2"; 
			System.out.println("Estado: "+edo+" | Tope Pila: "+pila.peek()+" | Caracter: "+cadena[cont]); cont++;
	
		if (cont<cadena.length){
			if(cadena[cont]=='c' && pila.peek()=="Z0") q2();
			else qMuerto();

		}

	}
}