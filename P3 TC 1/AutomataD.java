import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class AutomataD{
	public int cont, edo; 
	public char cadena[];
	public String msje, s;

	public AutomataD(String s){
		this.s=s;
		cadena=s.toCharArray();
		msje="";
	}

	public void inicio(){
		cont=0; edo=0;

		q0();

		if(edo==4||edo==5||edo==6||edo==7){
			msje="La cadena '"+s+"'' ha sido ACEPTADA por el automata D. Estado: "+edo;
			JOptionPane.showMessageDialog(null, msje, "Cadena Valida", 1);
			System.out.println("Aceptado");	
		}
		else{
			if(edo==8){
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
			if(cadena[cont]=='a'||cadena[cont]=='b') q3();
			else if (cadena[cont]=='c') q1(); 
			else qMuerto();
		}
	}

	public void q1(){
		edo=1;
		System.out.println(cadena[cont]+" en estado q1"); cont++;
		if (cont<cadena.length){
			if(cadena[cont]=='a' || cadena[cont]=='b') q2();
			else if (cadena[cont]=='c') q4(); 
			else qMuerto();
		}
	}

	public void q2(){
		edo=2;
		System.out.println(cadena[cont]+" en estado q2"); cont++;
		if (cont<cadena.length){
			if(cadena[cont]=='a'||cadena[cont]=='b') q2();
			else if (cadena[cont]=='c') q1(); 
			else qMuerto();
		}
	}

	public void q3(){
		edo=3;
		System.out.println(cadena[cont]+" en estado q3"); cont++;
		if (cont<cadena.length){
			if(cadena[cont]=='a'||cadena[cont]=='b') q3();
			else if(cadena[cont]=='c') q1();
			else qMuerto();
		}
	}

	public void q4(){
		edo=4;
		System.out.println(cadena[cont]+" en estado q4"); cont++;
		if (cont<cadena.length){
			if(cadena[cont]=='c') qMuerto();
			else if (cadena[cont]=='b'||cadena[cont]=='a') q5(); 
			else qMuerto();
		}
	}

	public void q5(){
		edo=5;
		System.out.println(cadena[cont]+" en estado q5"); cont++;
		if (cont<cadena.length){
			if(cadena[cont]=='a'||cadena[cont]=='b') q5();
			else if(cadena[cont]=='c') q6();
			else qMuerto();
		}
	}

	public void q6(){
		edo=6;
		System.out.println(cadena[cont]+" en estado q6"); cont++;
		if (cont<cadena.length){
			if(cadena[cont]=='a'||cadena[cont]=='b') q7();
			else if(cadena[cont]=='c') qMuerto();
			else qMuerto();
		}
	}

	public void q7(){
		edo=7;
		System.out.println(cadena[cont]+" en estado q7"); cont++;
		if (cont<cadena.length){
			if(cadena[cont]=='a'||cadena[cont]=='b') q7();
			else if(cadena[cont]=='c') q6();
			else qMuerto();
		}
	}

	public void qMuerto(){ edo=8; System.out.println(cadena[cont]+" en estado muerto."); }
}
