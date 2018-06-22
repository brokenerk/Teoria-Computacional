import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class AutomataB{
	public int cont, edo; 
	public char cadena[];
	public String msje, s;

	public AutomataB(String s){
		this.s=s;
		cadena=s.toCharArray();
		msje="";
	}

	public void inicio(){
		cont=0; edo=0;

		q0();

		if(edo==1||edo==2||edo==3||edo==4||edo==5){
			msje="La cadena '"+s+"'' ha sido ACEPTADA por el automata B. Estado: "+edo;
			JOptionPane.showMessageDialog(null, msje, "Cadena Valida", 1);
			System.out.println("Aceptado");	
		}
		else{
			if(edo==6){
				msje="La cadena ''"+s+"'' ha sido NO ACEPTADA por el automata A. Estado: Muerto";
				JOptionPane.showMessageDialog(null, msje,"Cadena Invalida", JOptionPane.ERROR_MESSAGE);
			}
			else{
				msje="La cadena ''"+s+"'' ha sido NO ACEPTADA por el automata A. Estado: "+edo;
				JOptionPane.showMessageDialog(null, msje,"Cadena Invalida", JOptionPane.ERROR_MESSAGE);			
			}
			System.out.println("Invalido");
		}
	}

	public void q0(){
		System.out.print("\033[H\033[2J"); System.out.flush();
		edo=0;
		System.out.println("Inicio en estado q0");
		if (cont<cadena.length){
			if(cadena[cont]=='a') q1();
			else if (cadena[cont]=='b') qMuerto(); 
			else if (cadena[cont]=='c') q3(); 
			else qMuerto();
		}
	}

	public void q1(){
		edo=1;
		System.out.println(cadena[cont]+" en estado q1"); cont++;
		if (cont<cadena.length){
			if(cadena[cont]=='a' || cadena[cont]=='b') qMuerto();
			else if (cadena[cont]=='c') q2(); 
			else qMuerto();
		}
	}

	public void q2(){
		edo=2;
		System.out.println(cadena[cont]+" en estado q2"); cont++;
		if (cont<cadena.length){
			if(cadena[cont]=='a'||cadena[cont]=='b') q4();
			else if (cadena[cont]=='c') qMuerto(); 
			else qMuerto();
		}
	}

	public void q3(){
		edo=3;
		System.out.println(cadena[cont]+" en estado q3"); cont++;
		if (cont<cadena.length){
			if(cadena[cont]=='a'||cadena[cont]=='b'||cadena[cont]=='c') q5();
			else qMuerto();
		}
	}

	public void q4(){
		edo=4;
		System.out.println(cadena[cont]+" en estado q4"); cont++;
		if (cont<cadena.length){
			if(cadena[cont]=='c') qMuerto();
			else if (cadena[cont]=='b'||cadena[cont]=='a') q4(); 
			else qMuerto();
		}
	}

	public void q5(){
		edo=5;
		System.out.println(cadena[cont]+" en estado q5"); cont++;
		if (cont<cadena.length){
			if(cadena[cont]=='a'||cadena[cont]=='b'||cadena[cont]=='c') q5();
			else qMuerto();
		}
	}

	public void qMuerto(){ edo=6; System.out.println(cadena[cont]+" en estado muerto."); }
}
