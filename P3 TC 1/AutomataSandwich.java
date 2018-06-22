import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class AutomataSandwich{
	public char cadena[];
	public String msje, num, s;
	public int total, cont, edo;


	public AutomataSandwich(){
		msje=""; total=0; cont=0; s="";
	}

	public String inicio(int n){
		cont=0; cont=0;
		num=Integer.toString(n);
		if(n==10)s=s+"1"; 
		else s=s+num;
		cadena=s.toCharArray();
		total=total+n;
		q0();

		return ("Su saldo es de: $"+total+".00");
	}

	public String verificar(){
		if(edo==4||edo==10){
			JOptionPane.showMessageDialog(null, "Se ha entregado el sandwich por $"+total+"!", "Aviso", 1);
			msje=". Sandwich entregado!";
			System.out.println("Aceptado");	
		} 
		else {
			JOptionPane.showMessageDialog(null, "Saldo insuficiente. No se entregara el sandwich ni se regresaran sus monedas.","Error", JOptionPane.ERROR_MESSAGE);		
			System.out.println("Invalido");
			msje=". Saldo insuficente.";
		}
		return msje;
	}

	public String reinicio(){
		s=""; num=""; total=0; cont=0;
		edo=0;
		return "Su saldo es de: $0.00. Esperando monedas...";
	}

	public void q0(){
		System.out.print("\033[H\033[2J"); System.out.flush();
		edo=0;
		System.out.println("Inicio en estado q0");
		if(cont<cadena.length){
			if (cadena[cont]=='1') q1();
			else if (cadena[cont]=='5') q2();
			else if (cadena[cont]=='2') q3();
		}
	}

	public void q1(){
		edo=1;
		if (cadena[cont]=='1') System.out.println("10 en estado q1"); 
		else System.out.println(cadena[cont]+" en estado q1");
		cont++;
		if(cont<cadena.length){
			if (cadena[cont]=='1'||cadena[cont]=='5'||cadena[cont]=='2') q4();
		}
	}

	public void q2(){
		edo=2;
		if (cadena[cont]=='1') System.out.println("10 en estado q2"); 
		else System.out.println(cadena[cont]+" en estado q2");
		cont++;
		if(cont<cadena.length){
			if (cadena[cont]=='1') q4();
			else if (cadena[cont]=='5') q1();
			else if (cadena[cont]=='2') q5();
		}
	}

	public void q3(){
		edo=3;
		if (cadena[cont]=='1') System.out.println("10 en estado q3"); 
		else System.out.println(cadena[cont]+" en estado q3"); 
		cont++;
		if(cont<cadena.length){
			if (cadena[cont]=='1') q10();
			else if (cadena[cont]=='5') q5();
			else if (cadena[cont]=='2') q7();
		}
	}

	public void q4(){
		edo=4;
		if (cadena[cont]=='1') System.out.println("10 en estado q4"); 
		else System.out.println(cadena[cont]+" en estado q4"); 
		cont++;
		if(cont<cadena.length){
			if (cadena[cont]=='1'||cadena[cont]=='5'||cadena[cont]=='5') q4();
		}
	}

	public void q5(){
		edo=5;
		if (cadena[cont]=='1') System.out.println("10 en estado q5"); 
		else System.out.println(cadena[cont]+" en estado q5"); 
		cont++;
		if(cont<cadena.length){
			if (cadena[cont]=='1'||cadena[cont]=='5') q4();
			else if (cadena[cont]=='2') q6();
		}
	}

	public void q6(){
		edo=6;
		if (cadena[cont]=='1') System.out.println("10 en estado q6"); 
		else System.out.println(cadena[cont]+" en estado q6"); 
		cont++;
		if(cont<cadena.length){
			if (cadena[cont]=='1'||cadena[cont]=='5') q4();
			else if (cadena[cont]=='2') q1();
		}
	}

	public void q7(){
		edo=7;
		if (cadena[cont]=='1') System.out.println("10 en estado q7"); 
		else System.out.println(cadena[cont]+" en estado q7"); 
		cont++;
		if(cont<cadena.length){
			if (cadena[cont]=='1') q10();
			else if (cadena[cont]=='5') q6();
			else if (cadena[cont]=='2') q8();
		}
	}

	public void q8(){
		edo=8;
		if (cadena[cont]=='1') System.out.println("10 en estado q8"); 
		else System.out.println(cadena[cont]+" en estado q8");
		cont++;
		if(cont<cadena.length){
			if (cadena[cont]=='1') q10();
			else if (cadena[cont]=='5') q1();
			else if (cadena[cont]=='2') q9();
		}
	}

	public void q9(){
		edo=9;
		if (cadena[cont]=='1') System.out.println("10 en estado q9"); 
		else System.out.println(cadena[cont]+" en estado q9"); 
		cont++;
		if(cont<cadena.length){
			if (cadena[cont]=='1'||cadena[cont]=='5') q10();
			else if (cadena[cont]=='2') q1();
		}
	}

	public void q10(){
		edo=10;
		if (cadena[cont]=='1') System.out.println("10 en estado q10");
		else System.out.println(cadena[cont]+" en estado q10");
		cont++;
		if(cont<cadena.length){
			if (cadena[cont]=='1'||cadena[cont]=='5'||cadena[cont]=='5') q10();
		}
	}
}
