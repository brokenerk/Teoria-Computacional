public class Automata{

	public int cont; 
	public char cadena[];
	public String s="", edo;
	public boolean aceptado;

	public Automata(){
		aceptado=true;
	}

	public boolean inicio(String s){
		this.s=s;
		cadena=s.toCharArray();
		cont=-1; edo="0";

		q0();
		if (edo.equals("c0")||edo.equals("c1")||edo.equals("c2")||edo.equals("c3")||edo.equals("c4")||edo.equals("0")) aceptado=true;
		else aceptado=false;
		s="";
		return aceptado;
	}

	public void qMuerto(){edo="Muerto";}

	public void q0(){
		//System.out.print("\033[H\033[2J"); System.out.flush();
		edo="0"; cont++;
	
		if (cont<cadena.length){
			if (cadena[cont]=='-') q1();
			else if (cadena[cont]=='+') q8();
			else if (cadena[cont]==' ') q0();
			else if (cadena[cont]=='0') q2();
			else if (cadena[cont]>=49 && cadena[cont]<=57) q3();
			else q0();
		}
	}

	public void q1(){
		edo="1"; cont++;
		if (cont<cadena.length){
			if(cadena[cont]=='0') q2();
			else if (cadena[cont]==' ') q1();
			else if(cadena[cont]>=48 && cadena[cont]<=57) q3();
			else if(cadena[cont]=='-') q0();
			else qMuerto();
		}
	}

	public void q2(){
		edo="2"; cont++;
		if (cont<cadena.length){
			if(cadena[cont]=='x') q5();
			else if (cadena[cont]>=48 && cadena[cont]<=55) c2();
			else if(cadena[cont]=='.') q4();
			else if (cadena[cont]==';') c0();
			else if((cadena[cont]>=56 && cadena[cont]<=57)||(cadena[cont]>=65 && cadena[cont]<=70)||(cadena[cont]=='E')||(cadena[cont]=='-')||(cadena[cont]=='+')||(cadena[cont]==' ')) qMuerto();
			else q0();
		}
	}

	public void q3(){
		edo="3"; cont++;
		if (cont<cadena.length){
			if(cadena[cont]>=48 && cadena[cont]<=57) q3();
			else if (cadena[cont]==';') c0();
			else if (cadena[cont]=='.') q4();
			else if (cadena[cont]=='E') q6();
			else if(cadena[cont]>=65 && cadena[cont]<=70||cadena[cont]=='-'||cadena[cont]=='+'||cadena[cont]==' '||cadena[cont]=='x') qMuerto();
			else q0();
		}
	}

	public void q4(){
		edo="4"; cont++;
		if (cont<cadena.length){
			if(cadena[cont]>=48 && cadena[cont]<=57) c3();
			else qMuerto();
		}
	}

	public void c0(){
		edo="c0"; cont++;
		if (cont<cadena.length){
			if((cadena[cont]>=48 && cadena[cont]<=57)||(cadena[cont]=='-')||(cadena[cont]=='+')||(cadena[cont]=='.')) qMuerto();
			else q0();
		}
	}

	public void c1(){
		edo="c1"; cont++;
		if (cont<cadena.length){
			if ((cadena[cont]>=48 && cadena[cont]<=57)||(cadena[cont]>=65 && cadena[cont]<=70)) c1();
			else if(cadena[cont]>=65 && cadena[cont]<=70||cadena[cont]=='-'||cadena[cont]=='+'||cadena[cont]=='x'||cadena[cont]=='E'||cadena[cont]=='.') qMuerto();
			else q0();
		}
	}

	public void c2(){
		edo="c2"; cont++;
		if (cont<cadena.length){
			if (cadena[cont]>=48 && cadena[cont]<=55) c2();
			else if(cadena[cont]>=56 && cadena[cont]<=57||cadena[cont]>=65 && cadena[cont]<=70||cadena[cont]=='-'||cadena[cont]=='+'||cadena[cont]=='x'||cadena[cont]=='E'||cadena[cont]=='.') qMuerto();
			else q0();
		}
	}

	public void q5(){
		edo="5"; cont++;
		if (cont<cadena.length){
			if ((cadena[cont]>=48 && cadena[cont]<=57)||(cadena[cont]>=65 && cadena[cont]<=70)) c1();
			else qMuerto();
		}
	}

	public void c3(){
		edo="c3"; cont++;
		if (cont<cadena.length){
			if(cadena[cont]>=48 && cadena[cont]<=57) c3();
			else if (cadena[cont]=='E') q6();
			else if(cadena[cont]>=65 && cadena[cont]<=70||cadena[cont]=='-'||cadena[cont]=='+'||cadena[cont]=='x'||cadena[cont]=='.') qMuerto();
			else q0();
		}
	}

	public void q6(){
		edo="6"; cont++;
		if (cont<cadena.length){
			if(cadena[cont]=='-'||cadena[cont]=='+') q7();
			else if(cadena[cont]>=48 && cadena[cont]<=57) c4();
			else qMuerto();
		}
	}

	public void q7(){
		edo="6"; cont++;
		if (cont<cadena.length){
			if(cadena[cont]>=48 && cadena[cont]<=57) c4();
			else qMuerto();
		}
	}

	public void c4(){
		edo="c4"; cont++;
		if (cont<cadena.length){
			if(cadena[cont]>=48 && cadena[cont]<=57) c4();
			else if(cadena[cont]>=65 && cadena[cont]<=70||cadena[cont]=='-'||cadena[cont]=='+'||cadena[cont]=='x'||cadena[cont]=='.'||cadena[cont]=='E') qMuerto();
			else q0();
		}
	}

	public void q8(){
		edo="8"; cont++;
		if (cont<cadena.length){
			if(cadena[cont]=='0') q2();
			else if(cadena[cont]>=48 && cadena[cont]<=57) q3();
			else q0();
		}
	}

	
}