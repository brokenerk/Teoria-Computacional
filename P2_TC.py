
import sys
import tkMessageBox
import os
import Tkinter
from Tkinter import *
import random

#Inicializacion de la interfaz

top = Tkinter.Tk ()

top.title ("Practica 2: Operaciones en lenguajes")
top.geometry ("780x550")
top.configure (background = 'dimgrey')


#FUNCIONES A EJECUTAR EN LOS BOTONES

def read(var1):
	global a,c
	os.system('clear')
	a = E1.get().replace(',','')
	c = list(E1.get().split(","))
	
	print "Alfabeto: "+str(c)
	print "Longitud: "+str(len(c)) 
	
def read2(var1):
	global a,b,c
	os.system('clear')
	c = []
	b = E1.get().replace('-','')
	b = str(b)
	a = ""
	for x in range (ord(b[0]), ord(b[1]) + 1):
		c.append(chr(x))
	for x in range (0, len(c)):
		a = a + c[x]
	
	print "Alfabeto: "+str(c)
	print "Longitud: "+str(len(c)) 
	
def callback():
	read(E1)

def callback2():
	read2(E1)

def Lenguajes():
	os.system('clear')
	print "Alfabeto: "+str(c)
	print "Longitud: "+str(len(c)) 
	print ("")
	print ("")
	print("Lenguajes:")
	global lenguaje1, lenguaje2
	lenguaje1 = []
	lenguaje2 = []

	if ((int(E3.get())>(int(len(a))**int(E31.get()))) | (int(E33.get())>(int(len(a))**int(E4.get())))):
			print ("Se ha superado el limite de palabras que el alfabeto puede formar")
	else:
		for x in range (0, int(E3.get())):
			s1=''
			for y in range(0, int(E31.get())):
				s1 = s1 + (random.SystemRandom()).choice(a)
			lenguaje1.append(s1)

		for i in range (0, int(E33.get())):
			s2=''
			for j in range(0, int(E4.get())):
				s2 = s2 + (random.SystemRandom()).choice(a)
			lenguaje2.append(s2)
		
		lenguaje1=list(set(lenguaje1))
		lenguaje2=list(set(lenguaje2))
	
		while (int(len(lenguaje1))<int(E3.get())):
			s1=''
			for y in range(0, int(E31.get())):
				s1 = s1 + (random.SystemRandom()).choice(a)
			lenguaje1.append(s1)
			lenguaje1=list(set(lenguaje1))
		
		
		while (int(len(lenguaje2))<int(E33.get())):
			s2=''
			for j in range(0, int(E4.get())):
				s2 = s2 + (random.SystemRandom()).choice(a)
			lenguaje2.append(s2)
			lenguaje2=list(set(lenguaje2))
		
		print "L1 = "+str(lenguaje1);
		print "L2 = "+str(lenguaje2)


def Union():
	print ("")
	print ("")
	uni=[]

	esta=False

	for i in range(0, len(lenguaje2)):
		uni.append(lenguaje2[i])

	for x in range(0, len(lenguaje1)):
		esta = False
		for y in range(0, len(lenguaje2)):
			if (lenguaje1[x] == lenguaje2[y]):
				esta = True
		if(esta == False):
			uni.append(lenguaje1[x])

	print "Union L1U12 = "+str(uni)
	print "Longitud: "+str(len(uni))

def Concatenar():
	print ("")
	print ("")
	Concatenacion = []

	for x in range(0, len(lenguaje1)):
		for y in range(0, len(lenguaje2)):
			Concatenacion.append(lenguaje1[x] + lenguaje2[y])

	print "Concatenacion L1L2: "
	print str(Concatenacion)
	print "Longitud: "+str(len(Concatenacion))

def Diferencias():
	print ("")
	print ("")
	flag1=False
	flag2=False
	LD1 = []
	LD2 = []


	for x in range(0, len(lenguaje1)):
		flag1 = False
		for y in range(0, len(lenguaje2)):
			if (lenguaje1[x] == lenguaje2[y]):
				flag1 = True
		if(flag1 == False):
			LD1.append(lenguaje1[x])

	for k in range(0, len(lenguaje2)):
		flag2 = False
		for l in range(0, len(lenguaje1)):
			if (lenguaje2[k]==lenguaje1[l]):
				flag2 = True
		if(flag2 == False):
			LD2.append(lenguaje2[k])

	print "Diferencia L1-L2 = "+str(LD1)
	print "Diferencia L2-L1 = "+str(LD2)

def Potencia():
	global lista1, exp, listafinal
	print ("")
	print ("")
	print ("Potencia L^n:")
	exp = int(E40.get())
	lista1 = []
	listafinal = []
	if (max(Lb1.curselection()) == 0):
		if (exp < 0):
			for x in range(0,len(lenguaje1)):
				lista1.append(lenguaje1[x][::-1])
			for x in range(0,len(lenguaje1)):
				lenguaje1[x] = lenguaje1[x][::-1]
			exp = abs(exp)
		else:
			for x in range(0,len(lenguaje1)):
				lista1.append(lenguaje1[x])
		for z in range(1,exp):
			for x in range(0,len(lista1)):
				for y in range(0,len(lenguaje1)):
					lista1.append(lista1[x] + lenguaje1[y])
		for x in range ((len (lista1)) - (len(lenguaje1) ** exp),len(lista1)):
			listafinal.append(lista1[x])
		print str(listafinal) 
		print len(listafinal)
	else:
		if (exp < 0):
			for x in range(0,len(lenguaje2)):
				lista1.append(lenguaje2[x][::-1])
			for x in range(0,len(lenguaje2)):
				lenguaje2[x] = lenguaje2[x][::-1]
			exp = abs(exp)
		else:
			for x in range(0,len(lenguaje2)):
				lista1.append(lenguaje2[x])
		for z in range(1,exp):
			for x in range(0,len(lista1)):
				for y in range(0,len(lenguaje2)):
					lista1.append(lista1[x] + lenguaje2[y])
		for x in range ((len (lista1)) - (len(lenguaje2) ** exp),len(lista1)):
			listafinal.append(lista1[x])
		print str(listafinal)
		print len(listafinal)

def Curp():
	global Apellidos,Nombres,Estados
	Apellidos = ["Arenas", "Anleu", "Tinoco", "Barron", "Ingles", "Villalobos", "Alarcon", "Ramos", "Diaz", "Fuentes", "Solo", "Garcia", "Nava",
	"Jimenez", "Andrade", "Rojas", "Monson", "Xochihua", "Ramirez", "Torres", "Bodet", "Ojeda", "Sangreal", "Navarro", "Franco", "Casados", "Manriquez", "Maldonado"]

	Nombres = {}

	Nombres["Hombres"] = ["Carlos","Felix","Angel","Omar","Miguel","Josh","Lester","Daniel","Alfredo","Manuel","Charlie","Oscar","Alexis","Ismael","Uriel",
	"Jorge","Kevin","Ruben","Eduardo","Martin","Enrique","Edgar"]

	Nombres["Mujeres"] = ["Ana","Maria","Evelyn","Alejandra","Patricia","Carmen","Atziri","Deyanira","Monse","Esmeralda","Eva","Ailyn",
	"Jocelyn","Yamili","Grace","Alice","Ivonne","Noelia","Yolanda","Anabel","Victoria","Natalia"]

	Estados = {'Aguascalientes' : 'AS', 'Baja California' : 'BC', 'Baja California Sur' : 'BS', 'Campeche' : 'CC', 'Chiapas' : 'CS',
	'Chihuahua' : 'CH', 'Coahuila' : 'CL', 'Colima' : 'CM', 'Ciudad De Mexico' : 'DF', 'Durango' : 'DG', 'Guanajuato' : 'GT',
	'Guerrero' : 'GR', 'Hidalgo' : 'HG', 'Jalisco' : 'JC', 'Estado De Mexico'	: 'MC', 'Michoacan' : 'MN', 'Morelos' : 'MS', 'Nayarit' : 'NT',
	'Nuevo Leon' : 'NL', 'Oaxaca' : 'OC', 'Puebla' : 'PL', 'Queretaro' : 'QT', 'Quintana Roo' : 'QR', 'San Luis Potosi' : 'SP', 'Sinaloa' : 'SL',
	'Sonora' : 'SR', 'Tabasco' : 'TC', 'Tamaulipas' : 'TS', 'Tlaxcala' : 'TL', 'Veracruz' : 'VZ', 'Yucatan' : 'YN', 'Zacatecas' : 'ZS', 'Nacido en el extranjero' : 'NE'}

	Meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"]
	
	Ap = random.choice(Apellidos)
	Am = random.choice(Apellidos)

	r1 = random.randint(0,1)
	if (r1 == 0):
		r1 = "Hombres"
		Sexo = "H"
	else:
		r1 = "Mujeres"
		Sexo = "M"
	r2 = random.randint(0,21)
	Nombre = Nombres[r1][r2]

	vocales = ('a', 'e', 'i' , 'o', 'u')
	ApAux = ''.join([letra for letra in Ap if letra not in vocales])
	AmAux = ''.join([letra for letra in Am if letra not in vocales])
	NombreAux = ''.join([letra for letra in Nombre if letra not in vocales])

	#Suponemos que ya cumplieron anhos
	Edad = random.randint(1,80)
	EdadAux = Edad
	if (Edad > 17):
		Edad = 117 - Edad
		penult_car = random.randint(0,9)
	else:
		Edad = 17 - Edad
		penult_car = chr(random.randint(65,90))
		if (Edad < 10):
			Edad = "0" + str(Edad)

	Mes = random.randint(0,11)
	MesAux = Mes
	Mes = Mes + 1
	if (Mes < 10):
		Mes = "0" + str(Mes)

	Entidad = random.choice(Estados.keys())

	ult_car = random.randint(0,9)


	if(MesAux == 0 | MesAux == 2 | MesAux == 4 | MesAux == 6 | MesAux == 7 | MesAux == 9 | MesAux == 11):
		Dia = random.randint(1,31)
	elif (MesAux == 1):
		if ((2017-int(Edad))%4==0):
			Dia = random.randint(1,29)
		else:
			Dia = random.randint(1,28)
	else:
		Dia = random.randint(1,30)
	if (Dia < 10):
		Dia  = "0" + str(Dia)

	#CURP
	Clave = Ap[0] + Ap[1].upper() + Am[0] + Nombre[0] + str(Edad) + str(Mes) + str(Dia) + Sexo + Estados[Entidad] + ApAux[1].upper() + AmAux[1].upper() + NombreAux[1].upper() + str(penult_car) + str(ult_car)
	os.system('clear')
	print Ap + " " + Am + " " + Nombre
	print "Edad: " + str(EdadAux) + " anhos"
	print "Dia: " + str(Dia)+ "   " +" Mes: " + str(Mes) + "-" + Meses[MesAux] + "   " + "Anho:" + str(Edad)
	print "Entidad: " + Entidad  
	print "\n" + "CURP: " + Clave + "\n\n"
	
def Clear():
	os.system('clear')
	
def Close():
	sys.exit(0)

#ETIQUETAS Y ENTRADAS VENTANA PRINCIPAL

Titulo = Label (top, text = 'Practica 2', height = 3, width = 45, bg = "darkgoldenrod", fg = "black")
Titulo.place (x = 220, y = 10)
	
L1 = Label (top, text = "Introduce el alfabeto", height = 2, width = 20)
L1.place (x = 10, y = 100)
E1 = Entry (top, justify = LEFT, bd = 1, width = 50)
E1.place (x = 200, y = 100)
E1.focus_set ()

L10 = Label (top, text = "a) Leer el alfabeto", height = 2, width = 20)
L10.place (x = 10, y = 150)

L3 = Label (top, text = "Lenguaje 1", height = 2, width = 20)
L3.place (x = 10, y = 200)
L2 = Label (top, text = "# Palabras = ", height = 2, width = 10)
L2.place (x = 200, y = 200)
E3 = Entry (top, justify = LEFT, bd = 1, width = 5)
E3.place (x = 300, y = 200)
E3.focus_set ()
L21 = Label (top, text = "Longitud = ", height = 2, width = 10)
L21.place (x = 350, y = 200)
E31 = Entry (top, justify = LEFT, bd = 1, width = 5)
E31.place (x = 450, y = 200)
E31.focus_set ()

L4 = Label (top, text = "Lenguaje 2", height = 2, width = 20)
L4.place (x = 10, y = 250)
L25 = Label (top, text = "# Palabras = ", height = 2, width = 10)
L25.place (x = 200, y = 250)
E33 = Entry (top, justify = LEFT, bd = 1, width = 5)
E33.place (x = 300, y = 250)
E33.focus_set ()
L29 = Label (top, text = "Longitud = ", height = 2, width = 10)
L29.place (x = 350, y = 250)
E4 = Entry (top, justify = LEFT, bd = 1, width = 5)
E4.place (x = 450, y = 250)
E4.focus_set ()


E40 = Entry (top, justify = LEFT, bd = 1, width = 10)
E40.place (x = 375, y = 410)
E40.focus_set ()

#BOTONES VENTANA PRINCIPAL

b = Button (top, text = "Caracter por Caracter", width = 15, height = 2, command = callback)
b.place (x = 200, y = 140)

ba = Button (top, text = "Introduciendo un rango", width = 15, height = 2, command = callback2)
ba.place (x = 425, y = 140)

b1 = Button (top, text = "b) Formar lenguajes", width = 15, height = 3, command = Lenguajes)
b1.place (x = 625, y = 205)

b2 = Button (top, text = "c) Union de L1 con L2", width = 20, height = 2, command = Union)
b2.place (x = 10, y = 300)

b3 = Button (top, text = "d) Concatenacion de L1 con L2", width = 25, height = 2, command = Concatenar)
b3.place (x = 300, y = 300)

b7 = Button (top, text = "e) Diferencias", width = 15, height = 2, command = Diferencias)
b7.place (x = 625, y = 300)

b5 = Button (top, text = "f) Potenciar lenguaje", width = 15, height = 2, command = Potencia)
b5.place (x = 10, y = 400)

Lb1 = Listbox(top, height = 2)
Lb1.insert(1, "Lenguaje 1")
Lb1.insert(2, "Lenguaje 2")
Lb1.place(x = 175, y = 405)

b6 = Button (top, text = "Generar CURP", width = 15, height = 2, command = Curp)
b6.place (x = 625, y = 400)

b8 = Button (top, text = "Cerrar", width = 15, height = 2, command = Close)
b8.place (x = 400, y = 500)

top.mainloop()
