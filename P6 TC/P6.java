import java.util.Scanner;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.applet.*;	


public class P6 extends JApplet implements ActionListener{
	public AutomataL1 automat1;
	public AutomataL2 automat2;
	public AutomataL3 automat3;
	public AutomataL4 automat4;
        public AutomataBrazos brazos;
	private JLabel l1, l2, l3, l4, l5, limag1, limag2, limag3, limag4, limag5;
	private JButton b1,b2,b3,b4,b5;
	private JTextField t1,t2,t3,t4,t5;



	public P6(){}
	public void init(){
		
		
		Container c=getContentPane();
        JTabbedPane pestanias=new JTabbedPane();  //Creamos el conjunto de pestanias
        
        //Creamos el panel y lo añadimos a las pestanias
        JPanel panel1=new JPanel();
        panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));

        l1 = new JLabel("<html><body><br>Lenguaje 1: L1 = { a^i b c^k | i, k >= 1 y i menor a k }<br><br></body></html>");
        t1=new JTextField(20);
        b1=new JButton("Comprobar cadena");
        limag1=new JLabel(new ImageIcon("L1.gif"));

        l1.setAlignmentX(Component.CENTER_ALIGNMENT);
        t1.setAlignmentX(Component.CENTER_ALIGNMENT);
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);
        limag1.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel1.add(l1); panel1.add(t1); panel1.add(b1); panel1.add(limag1);

        b1.addActionListener(this);

        pestanias.addTab("Automata de Pila L1", panel1);

        JPanel panel2=new JPanel();
        panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));

        l2 = new JLabel("<html><body><br>Lenguaje 2: L2 = { 0^i 1^(i+k) 2^k 3^(n+1) | i, k, n >= 0 }<br><br></body></html>");
        t2=new JTextField(20);
        b2=new JButton("Comprobar cadena");
        limag2=new JLabel(new ImageIcon("L2.gif"));

        l2.setAlignmentX(Component.CENTER_ALIGNMENT);
        t2.setAlignmentX(Component.CENTER_ALIGNMENT);
        b2.setAlignmentX(Component.CENTER_ALIGNMENT);
        limag2.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel2.add(l2); panel2.add(t2); panel2.add(b2); panel2.add(limag2);

        b2.addActionListener(this);
        pestanias.addTab("Automata de Pila L2", panel2);

        JPanel panel3=new JPanel();
        panel3.setLayout(new BoxLayout(panel3,BoxLayout.Y_AXIS));

        l3 = new JLabel("<html><body><br>Lenguaje 3: L3 = { a^m b^p c^(p+m) | m, p >= 1 } U { a^(2i) b^i | i >= 1 }<br><br></body></html>");
        t3=new JTextField(20);
        b3=new JButton("Comprobar cadena");
        limag3=new JLabel(new ImageIcon("L3.gif"));

        l3.setAlignmentX(Component.CENTER_ALIGNMENT);
        t3.setAlignmentX(Component.CENTER_ALIGNMENT);
        b3.setAlignmentX(Component.CENTER_ALIGNMENT);
        limag3.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel3.add(l3); panel3.add(t3); panel3.add(b3); panel3.add(limag3);

        b3.addActionListener(this);

        pestanias.addTab("AP NO determinista L3", panel3);

        JPanel panel4=new JPanel();
        panel4.setLayout(new BoxLayout(panel4,BoxLayout.Y_AXIS));

        l4 = new JLabel("<html><body><br>Lenguaje 4: L4 = { a^m b^p c^(p+m) | m, p >= 1} U { a^i b^(2i) | i >= 1 }<br><br></body></html>");
        t4=new JTextField(20);
        b4=new JButton("Comprobar cadena");
        limag4=new JLabel(new ImageIcon("L4.gif"));

        l4.setAlignmentX(Component.CENTER_ALIGNMENT);
        t4.setAlignmentX(Component.CENTER_ALIGNMENT);
        b4.setAlignmentX(Component.CENTER_ALIGNMENT);
        limag4.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel4.add(l4); panel4.add(t4); panel4.add(b4); panel4.add(limag4);

        b4.addActionListener(this);

        pestanias.addTab("AP NO determinista L4", panel4);

         JPanel panel5=new JPanel();
        panel5.setLayout(new BoxLayout(panel5,BoxLayout.Y_AXIS));

        l5 = new JLabel("<html><body><br>Lenguaje 5: Personaje con brazos normales (Balanceados)<br><br>Alfabeto Automata={O, o, -, T}<br> O, o = Manos   <br>  - = Porcion de Brazo  <br>  T = Torso<br>Alfabeto Pila={Z, Y}<br><br></body></html>");
        t5=new JTextField(20);
        b5=new JButton("Comprobar anatomia");
        limag5=new JLabel(new ImageIcon("brazos.gif"));

        l5.setAlignmentX(Component.CENTER_ALIGNMENT);
        t5.setAlignmentX(Component.CENTER_ALIGNMENT);
        b5.setAlignmentX(Component.CENTER_ALIGNMENT);
        limag5.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel5.add(l5); panel5.add(t5); panel5.add(b5); panel5.add(limag5);

        b5.addActionListener(this);

        pestanias.addTab("Personaje con Brazos", panel5);


        c.add(pestanias);
		

		
	}

	public void actionPerformed(ActionEvent e){
		JButton b=(JButton)e.getSource();
		automat1=new AutomataL1();
		automat2=new AutomataL2();
		automat3=new AutomataL3();
		automat4=new AutomataL4();
                brazos=new AutomataBrazos();

		if(b==b1) automat1.inicio(t1.getText());
		if(b==b2) automat2.inicio(t2.getText());
		if(b==b3) automat3.inicio(t3.getText());
		if(b==b4) automat4.inicio(t4.getText());
                if(b==b5) brazos.inicio(t5.getText());
	}


	public static void main(String args[]){
	
		P6 p6=new P6();
        p6.init(); p6.start();
        JFrame ventana=new JFrame("Practica 6: Automatas de Pila");
        ventana.add(p6);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(900,650);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
		
		
		
	}

}