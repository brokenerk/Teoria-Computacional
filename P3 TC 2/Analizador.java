import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.applet.*; 
import javax.swing.filechooser.FileNameExtensionFilter; 

public class Analizador extends JApplet implements ActionListener{
    JPanel contentPane;
    String cadena, resultado, archivo;
    int noLinea=1;
    boolean errores=false;
    Automata a;
    JButton banalizar;
    JLabel limg, l, l1;
    FileReader f;
    BufferedReader b;

    public Analizador(){}
    public void init (String archivo){
        setLayout(new FlowLayout());
        this.archivo=archivo;
        a = new Automata(); 
        resultado="";
        banalizar = new JButton("Analizar archivo Numeros.java");
        limg= new JLabel(new ImageIcon("automata.gif"));
        l=new JLabel("<html><body> AFD = ( Σ, Q, q0, F) <BR>β = Cualquier símbolo fuera del alfabeto<br>b= Espacio en blanco <br>Σ = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F, x, ;, b, +, -, .}<BR>F = { C0, C1, C2, C3, C4, C5, q0 }<br>*******************************************************************************************************************************************************************************</body></html>");
        limg.setAlignmentX(Component.CENTER_ALIGNMENT);
        l.setAlignmentX(Component.CENTER_ALIGNMENT);
        banalizar.setAlignmentX(Component.CENTER_ALIGNMENT);
        //l1.setVisible(false);
        add(l);
        add(banalizar);
        add(limg);
        banalizar.addActionListener(this);
    }

    public void analiza() throws FileNotFoundException, IOException{
        f = new FileReader(archivo);
        b = new BufferedReader(f);
        while((cadena = b.readLine())!=null){
            if(a.inicio(cadena)==false){
                resultado=resultado+"Error en linea "+noLinea+"\n";
                errores=true;
            } 
            noLinea++;
            cadena="";
        }
        b.close();
        if(errores==false) resultado=("No hay errores de analisis lexico en las constantes numericas del archivo Numeros.java");
        JOptionPane.showMessageDialog(null, resultado);
        
        noLinea=1;
        cadena="";
        resultado="";
        errores=false;
    }

     public void actionPerformed(ActionEvent e){
        JButton b=(JButton)e.getSource();
        if(b==banalizar){
            try{ analiza(); }
            catch(IOException ex) { System.out.println(ex.getMessage()); } 
        }
    }

    public static void main(String[] args){
        Analizador analiza=new Analizador();
        analiza.init("Numeros.java"); analiza.start();
        JFrame ventana=new JFrame("Practica 3: Automatas Finitos Deterministas PARTE II");
        ventana.add(analiza);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(1165,625);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }
}

