import java.util.Stack;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class AutomataL3{
	public int cont; 
	public char cadena[];
	public String s="", edo, msje="";
	public boolean aceptado;
	public Stack<String> pila01, pila02;

	public AutomataL3(){
		pila01 = new Stack<String>(); 
		pila02 = new Stack<String>(); 
		aceptado=false;
		pila01.push("Z0");
		pila02.push("Z0");
	}

	public void inicio(String s){
		
		this.s=s;
		cadena=s.toCharArray();
		cont=0; edo="0";

		q0(cont);

		if (aceptado==true){
			msje="La cadena '"+s+"'' ha sido ACEPTADA por el automata L3.  Se alcanzo el Estado: 8";
			JOptionPane.showMessageDialog(null, msje, "Cadena Valida", 1);
			System.out.println("Aceptado");
		}
		else{
			if(edo.equals("Muerto")){
				msje="La cadena ''"+s+"'' ha sido NO ACEPTADA por el automata L3.  Estado: Muerto";
				JOptionPane.showMessageDialog(null, msje,"Cadena Invalida", JOptionPane.ERROR_MESSAGE);
			}
			else{
				msje="La cadena ''"+s+"'' ha sido NO ACEPTADA por el automata L3.  Estado: "+edo;
				JOptionPane.showMessageDialog(null, msje,"Cadena Invalida", JOptionPane.ERROR_MESSAGE);
				System.out.println("Invalido");		
			}
		}
		s="";

	}

	public void qMuerto(){edo="Muerto";}

	public void q0(int cont0){
		edo="0"; 
		System.out.println("");
		System.out.println("Estado: "+edo+" | Tope Pila: "+pila01.peek());
	
		if (cont0<cadena.length){

			if(cadena[cont0]=='a' && pila01.peek()=="Z0"){
				pila01.push("A"); 

				q1(cont0+1, pila01);
				pila01=null;
				
				pila02.push("A");

				q5(cont0+1, pila02);	
				pila02=null;
			}
			else qMuerto();

		}
	}

	public void q1(int cont1, Stack<String> pila1){
		edo="1"; 
		System.out.println("Estado: "+edo+" | Tope Pila: "+pila1.peek()+" | Caracter: "+cadena[cont1-1]);
		if (cont1<cadena.length){

			if(cadena[cont1]=='a' && pila1.peek()=="A"){
				pila1.push("A");
				q1(cont1+1, pila1);
			}
			else if(cadena[cont1]=='b' && pila1.peek()=="A"){
				pila1.push("B");
				q2(cont1+1, pila1);
			}
			else qMuerto();

		}
	}

	public void q2(int cont2, Stack<String> pila2){
		edo="2"; 
		System.out.println("Estado: "+edo+" | Tope Pila: "+pila2.peek()+" | Caracter: "+cadena[cont2-1]);
		if (cont2<cadena.length){

			if(cadena[cont2]=='b' && pila2.peek()=="B"){
				pila2.push("B");
				q2(cont2+1, pila2);
			}
			else if(cadena[cont2]=='c' && pila2.peek()=="B"){
				pila2.pop();
				q3(cont2+1, pila2);
			}
			else qMuerto();
			
		}

	}

	public void q3(int cont3, Stack<String> pila3){
		edo="3"; 
		System.out.println("Estado: "+edo+" | Tope Pila: "+pila3.peek()+" | Caracter: "+cadena[cont3-1]);
		if (cont3<cadena.length){

			if(cadena[cont3]=='c' && pila3.peek()=="B"){
				pila3.pop();
				q3(cont3+1,pila3);
			}
			else if(cadena[cont3]=='c' && pila3.peek()=="A"){
				pila3.pop();
				q4(cont3+1, pila3);
			}
			else qMuerto();
		}
	}

	public void q4(int cont4, Stack<String> pila4){
		edo="4"; 
		if (cont4<cadena.length){
			System.out.println("Estado: "+edo+" | Tope Pila: "+pila4.peek()+" | Caracter: "+cadena[cont4-1]);
			if(cadena[cont4]=='c' && pila4.peek()=="A"){
				pila4.pop();
				q4(cont4+1, pila4);
			}
			else qMuerto();
		}
		else{
			if(pila4.peek()=="Z0"){
				q8(cont4,pila4);
			} 
		}
	}

	public void q5(int cont5, Stack<String> pila5){
		edo="5"; 
		System.out.println("Estado: "+edo+" | Tope Pila: "+pila5.peek()+" | Caracter: "+cadena[cont5-1]);
		if (cont5<cadena.length){

			if(cadena[cont5]=='a' && pila5.peek()=="A"){
				q6(cont5+1, pila5);
			}
		
			else qMuerto();
		}
	}

	public void q6(int cont6, Stack<String> pila6){
		edo="6"; 
		System.out.println("Estado: "+edo+" | Tope Pila: "+pila6.peek()+" | Caracter: "+cadena[cont6-1]);
		if (cont6<cadena.length){

			if(cadena[cont6]=='a' && pila6.peek()=="A"){
				pila6.push("A");
				q5(cont6+1, pila6);
			}
			else if(cadena[cont6]=='b' && pila6.peek()=="A"){
				pila6.pop();
				q7(cont6+1, pila6);
			}
			else qMuerto();
		}
	}

	public void q7(int cont7, Stack<String> pila7){
		edo="7"; 
		System.out.println("Estado: "+edo+" | Tope Pila: "+pila7.peek()+" | Caracter: "+cadena[cont7-1]);
		if (cont7<cadena.length){
			if(cadena[cont7]=='b' && pila7.peek()=="A"){
				pila7.pop();
				q7(cont7+1, pila7);
			}
			else qMuerto();
		}
		else{
			if(pila7.peek()=="Z0") {
				q8(cont7,pila7);
			}
		}

	}

	public void q8(int cont8, Stack<String> pila8){
		aceptado=true;
		edo="8";
		System.out.println("Estado: "+edo+" | Tope Pila: "+pila8.peek()+" | Caracter: "+cadena[cont8-1]);
		
	}
}