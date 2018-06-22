import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.applet.*;			
 
public class AFD extends JApplet implements ActionListener{
	private JButton bcomprobara, bcomprobarb, bcomprobard, b2, b5, b10, breiniciar, bverificar;
	public JTextField tcadenaa, tcadenab, tcadenad;
	private JLabel la, lb, ld, limga, limgb, lc, limgc, limgd, lsaldo, lcosto;
	public AutomataA automataA;
	public AutomataB automataB;
	public AutomataD automataD;
	public AutomataSandwich sandwich=new AutomataSandwich();;

    public AFD(){}
    public void init(){
        Container c=getContentPane();
        JTabbedPane pestanias=new JTabbedPane();  //Creamos el conjunto de pestanias
        
        //Creamos el panel y lo añadimos a las pestanias
        JPanel panel1=new JPanel();
        panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
        //Componentes del panel1
        la= new JLabel("<html><body>a) AFD Numeros Reales <br><br>Expresion Regular: <br><br>digito -> [ 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 ]<br>( digito<sup>+</sup> )[ . | E( - | + | ^ ) | .digito<sup>+</sup>E( - | + | ^ ) ].digito<sup>+</sup><br><br>Ingrese una cadena para que el AFD la verifique:<br></center></body></html>");
        tcadenaa=new JTextField(20);
        bcomprobara= new JButton("Verificar");
        limga= new JLabel(new ImageIcon("incisoa.png"));
        limga.setAlignmentX(Component.CENTER_ALIGNMENT);
        la.setAlignmentX(Component.CENTER_ALIGNMENT);
        bcomprobara.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel1.add(la); panel1.add(tcadenaa); 
        panel1.add(bcomprobara); panel1.add(limga);
        //Añadimos un nombre de la pestania y el panel
        pestanias.addTab("a) Numeros Reales", panel1);
 
        //Realizamos lo mismo con el resto
        JPanel panel2=new JPanel();
        panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
        //Componentes del panel2
        lb= new JLabel("<html><body>b) Expresion Regular I: <br><br>a + ac(a + b)<sup>*</sup> + c(a + b + c)<sup>*</sup> <br><br>Ingrese una cadena para que el AFD la verifique:<br></body></html>");
        tcadenab=new JTextField(20);
        bcomprobarb= new JButton("Verificar");
        limgb= new JLabel(new ImageIcon("incisob.gif"));
        limgb.setAlignmentX(Component.CENTER_ALIGNMENT);
        lb.setAlignmentX(Component.CENTER_ALIGNMENT);
        bcomprobarb.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(lb);  panel2.add(tcadenab); 
        panel2.add(bcomprobarb);  panel2.add(limgb);
        //Añadimos un nombre de la pestania y el panel
        pestanias.addTab("b) Expresion Regular I", panel2);

        JPanel panel3=new JPanel();
        //Componentes del panel3
        lc= new JLabel("c) Maquina de Sandwichs");
        lcosto=new JLabel("Costo unitario: $12.00");
        b2= new JButton("$2"); b5= new JButton("$5"); b10= new JButton("$10");
       	bverificar= new JButton("Verificar");
        breiniciar= new JButton("Reiniciar");
        limgc= new JLabel(new ImageIcon("sandwich.gif"));
        lsaldo=new JLabel("Su saldo es de: $0.00. Esperando monedas...");
        panel3.add(lc);  panel3.add(lcosto);
        panel3.add(b2); panel3.add(b5);
        panel3.add(b10);  panel3.add(lsaldo); panel3.add(bverificar);
        panel3.add(breiniciar); panel3.add(limgc);
        pestanias.addTab("Maquina de Sandwichs", panel3);

        JPanel panel4=new JPanel();
        panel4.setLayout(new BoxLayout(panel4,BoxLayout.Y_AXIS));
        //Componentes del panel2
        ld= new JLabel("<html><body>d) Expresion Regular II: <br><br>( c(a + b) + a + b )<sup>*</sup>cc( a + b + (a + b)c )<sup>*</sup> <br><br>Ingrese una cadena para que el AFD la verifique:<br></body></html>");
        tcadenad=new JTextField(20);
        bcomprobard= new JButton("Verificar");
        limgd= new JLabel(new ImageIcon("incisod.gif"));
        limgd.setAlignmentX(Component.CENTER_ALIGNMENT);
        ld.setAlignmentX(Component.CENTER_ALIGNMENT);
        bcomprobard.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel4.add(ld);  panel4.add(tcadenad); 
        panel4.add(bcomprobard);  panel4.add(limgd);
        //Añadimos un nombre de la pestania y el panel
        pestanias.addTab("d) Expresion Regular II", panel4);

 
        c.add(pestanias);
        b2.addActionListener(this);
    	b5.addActionListener(this);
    	b10.addActionListener(this);
        bcomprobara.addActionListener(this);
        bcomprobarb.addActionListener(this);
        bcomprobard.addActionListener(this);
        bverificar.addActionListener(this);
        breiniciar.addActionListener(this);
    }	

    public void actionPerformed(ActionEvent e){
    	JButton b=(JButton)e.getSource();
    	automataA=new AutomataA(tcadenaa.getText());
    	automataB=new AutomataB(tcadenab.getText());
    	automataD=new AutomataD(tcadenad.getText());
    	if (b==bcomprobara) automataA.inicio();
    	if (b==bcomprobarb) automataB.inicio();
    	if (b==bcomprobard) automataD.inicio();
    	if (b==b5) lsaldo.setText(sandwich.inicio(5));
    	if (b==b10) lsaldo.setText(sandwich.inicio(10));
    	if (b==b2) lsaldo.setText(sandwich.inicio(2));
    	if (b==bverificar) {lsaldo.setText((lsaldo.getText())+sandwich.verificar()); bverificar.setEnabled(false);}
    	if (b==breiniciar) {bverificar.setEnabled(true); lsaldo.setText(sandwich.reinicio());}
    }

    public static void main(String[] args) {
        AFD afd=new AFD();
        afd.init(); afd.start();
        JFrame ventana=new JFrame("Practica 3: Automatas Finitos Deterministas PARTE I");
        ventana.add(afd);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(1050,650);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }
}