import java.util.Stack;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class AutomataL4{
	public int cont; 
	public char cadena[];
	public String s="", edo, msje="";
	public boolean aceptado;
	public Stack<String> pila01, pila02;

	public AutomataL4(){
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
			msje="La cadena '"+s+"'' ha sido ACEPTADA por el automata L4.  Se alcanzo el Estado: 7";
			JOptionPane.showMessageDialog(null, msje, "Cadena Valida", 1);
			System.out.println("Aceptado");
		}
		else{
			if(edo.equals("Muerto")){
				msje="La cadena ''"+s+"'' ha sido NO ACEPTADA por el automata L4.  Estado: Muerto";
				JOptionPane.showMessageDialog(null, msje,"Cadena Invalida", JOptionPane.ERROR_MESSAGE);
			}
			else{
				msje="La cadena ''"+s+"'' ha sido NO ACEPTADA por el automata L4.  Estado: "+edo;
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
				pila02.push("A");
				q1(cont0+1, pila01, pila02);
			}
			else qMuerto();
			

		}
	}

	public void q1(int cont1, Stack<String> pila11, Stack<String> pila12){
		edo="1"; 

	

		System.out.println("Estado: "+edo+" | Tope Pila: "+pila11.peek()+" | Caracter: "+cadena[cont1-1]);
		
		if (cont1<cadena.length){
			
			if(cadena[cont1]=='a' && pila11.peek()=="A"){
				pila11.push("A");
				pila12.push("A");
				q1(cont1+1, pila11,pila12);
			}
			else if(cadena[cont1]=='b' && pila11.peek()=="A"){
				
				q5(cont1+1, pila11);

				pila12.push("B");
				q2(cont1+1, pila12);
				
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
				q3(cont2+1,pila2);
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
				q3(cont3+1, pila3);
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
		System.out.println("Estado: "+edo+" | Tope Pila: "+pila4.peek()+" | Caracter: "+cadena[cont4-1]);
		if (cont4<cadena.length){
			if(cadena[cont4]=='c' && pila4.peek()=="A"){
				pila4.pop();
				q4(cont4+1, pila4);
			}
			else qMuerto();
		}
		else{
			if(pila4.peek()=="Z0"){
				q7(cont4,pila4);
			} 
		}
	}

	public void q5(int cont5, Stack<String> pila5){
		edo="5"; 
		System.out.println("Estado: "+edo+" | Tope Pila: "+pila5.peek()+" | Caracter: "+cadena[cont5-1]);
		if (cont5<cadena.length){
			if(cadena[cont5]=='b' && pila5.peek()=="A"){
				pila5.pop();
				q6(cont5+1, pila5);
			}
			else qMuerto();
		}
	}

	public void q6(int cont6, Stack<String> pila6){
		edo="6"; 
		System.out.println("Estado: "+edo+" | Tope Pila: "+pila6.peek()+" | Caracter: "+cadena[cont6-1]);
		if (cont6<cadena.length){
			if(cadena[cont6]=='b' && pila6.peek()=="A"){
				q5(cont6+1, pila6);
			}
			
		}
		else{
			if(pila6.peek()=="Z0"){
				q7(cont6,pila6);
			} 
		}
	}

	public void q7(int cont7, Stack<String> pila7){
		aceptado=true;
		edo="7";
		System.out.println("Estado: "+edo+" | Tope Pila: "+pila7.peek()+" | Caracter: "+cadena[cont7-1]);
		

	}
}