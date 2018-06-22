
package practica.pkg1;
import javax.swing.*;
import Atxy2k.CustomTextField.RestrictedTextField;

public class FrmAlfabeto1 extends javax.swing.JFrame {
    
    public String eliminaRepetidos(String s){
        char c[]=s.toCharArray();                                                   //separa la cadena en caracteres
        int resp=1;
        String cad="";
        
        for(int i=0; i<s.length(); i++){                                            //Recorre cadena
            c[i]=c[i];                                                              //va ingresando elems distintos
            for (int j=i+1; j<s.length(); j++){
                if (c[i]==c[j]){                                                    //Si son iguales, reemplaza el elem con un espacio vacio
                    c[j]=' ';
                }
            }
        }
        
        for (int i=0; i<s.length(); i++){
            if (c[i]!=' '){                                                         //Va concatenando los elems de c en cad, descartando los espacios vacios
                cad=cad+c[i];
            }
        }
        
        return cad;
    }
    public FrmAlfabeto1() {
        initComponents();
        this.setLocationRelativeTo(null);
        TxtManual1.setEnabled(true);                                                //Habilita el txtfield manual
        TxtPrimer1.setEnabled(false);                                               //Bloquea los txtfields de los rangos
        TxtUlt1.setEnabled(false);
        RestrictedTextField primer1 = new RestrictedTextField(TxtPrimer1);
        RestrictedTextField ult1 = new RestrictedTextField(TxtUlt1);
       
        primer1.setLimit(1);
        ult1.setLimit(1);
    }
    
    private int limite  = 8;
 


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jSlider1 = new javax.swing.JSlider();
        jMenu1 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jSeparator1 = new javax.swing.JSeparator();
        RdBtnManual1 = new javax.swing.JRadioButton();
        RdBtnRango1 = new javax.swing.JRadioButton();
        TxtManual1 = new javax.swing.JTextField();
        TxtPrimer1 = new javax.swing.JTextField();
        TxtUlt1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        BtnAceptar1 = new javax.swing.JButton();
        BtnSalir1 = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        jScrollPane1.setViewportView(jTree1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Alfabeto 1");
        setLocation(new java.awt.Point(0, 0));
        setPreferredSize(new java.awt.Dimension(350, 267));
        setResizable(false);

        buttonGroup1.add(RdBtnManual1);
        RdBtnManual1.setSelected(true);
        RdBtnManual1.setText("<html>Ingrese los elementos del Σ1 uno a uno <br>(deben ser al menos 3 elementos):</html>");
        RdBtnManual1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RdBtnManual1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(RdBtnRango1);
        RdBtnRango1.setText("O ingrese un rango para definir a Σ1 (Ej: 0 - 9):");
        RdBtnRango1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RdBtnRango1ActionPerformed(evt);
            }
        });

        jLabel1.setText("a");

        BtnAceptar1.setText("Aceptar");
        BtnAceptar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAceptar1ActionPerformed(evt);
            }
        });

        BtnSalir1.setText("Salir");
        BtnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalir1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TxtPrimer1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(TxtUlt1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(BtnSalir1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnAceptar1))
                        .addComponent(RdBtnRango1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(RdBtnManual1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(TxtManual1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(RdBtnManual1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtManual1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RdBtnRango1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtPrimer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtUlt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnSalir1)
                    .addComponent(BtnAceptar1))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RdBtnManual1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RdBtnManual1ActionPerformed
        TxtManual1.setEnabled(true);//Habilita el txtfield manual
        TxtPrimer1.setEnabled(false);//Bloquea los txtfields de los rangos
        TxtUlt1.setEnabled(false);
    }//GEN-LAST:event_RdBtnManual1ActionPerformed

    private void RdBtnRango1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RdBtnRango1ActionPerformed
        TxtManual1.setEnabled(false);//Deshabilita txtfielda manual
        TxtPrimer1.setEnabled(true);//Habilita txtfield rangos
        TxtUlt1.setEnabled(true);
    }//GEN-LAST:event_RdBtnRango1ActionPerformed

    private void BtnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalir1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BtnSalir1ActionPerformed
  
    private void BtnAceptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAceptar1ActionPerformed
       String alfabeto1="";
       int i;
     
     
       
       if (RdBtnManual1.isSelected()){
           alfabeto1 = TxtManual1.getText();//Guarda alfabeto 1
       }
       else if (RdBtnRango1.isSelected()){
           if ((TxtPrimer1.getText()).length()==0 || (TxtUlt1.getText()).length()==0){//Verifica que el alfabeto no este vacio
                    JOptionPane.showMessageDialog(null, "Error al establecer los rangos", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else  if ((TxtPrimer1.getText().length())>1 || (TxtUlt1.getText().length())>1){//Verifica que no se ingrese más de un caracter en los rangos
                        JOptionPane.showMessageDialog(null, "No se puede agregar más de un caracter en los campos de los rangos", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        for(i=(int)(TxtPrimer1.getText()).charAt(0); i<=(int)(TxtUlt1.getText()).charAt(0); i++){
                            alfabeto1 = alfabeto1 + (char)i;//Recorre el rango en ASCII y va agregando cada caracter a alfabeto 1
                        }
                    }
       }
       if (eliminaRepetidos(alfabeto1).length()<3){//Verifica que el alfabeto contenga al menos 3 elementos (que no este vacio)
           JOptionPane.showMessageDialog(null, "El alfabeto debe tener al menos 3 caracteres distintos", "Error", JOptionPane.ERROR_MESSAGE);
       }
       else 
       {
       int resp = JOptionPane.showConfirmDialog(null, "¿Es correcto el alfabeto ingresado?\n"+"Σ1 = "+alfabeto1, 
        "Aviso", JOptionPane.YES_NO_OPTION);//MsgBox pra verificar alfabeto ingresado
     
       if (resp==0){
           FrmAlfabeto2 form2 = new FrmAlfabeto2();//Crear y pasar al formulario 2
           form2.setAlfabeto1(alfabeto1);
           form2.setVisible(true);
           this.setVisible(false);
       }
       }
    }//GEN-LAST:event_BtnAceptar1ActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmAlfabeto1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAlfabeto1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAlfabeto1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAlfabeto1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAlfabeto1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAceptar1;
    private javax.swing.JButton BtnSalir1;
    private javax.swing.JRadioButton RdBtnManual1;
    private javax.swing.JRadioButton RdBtnRango1;
    private javax.swing.JTextField TxtManual1;
    private javax.swing.JTextField TxtPrimer1;
    private javax.swing.JTextField TxtUlt1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
