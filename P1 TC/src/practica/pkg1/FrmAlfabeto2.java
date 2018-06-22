
package practica.pkg1;

import javax.swing.JOptionPane;
import Atxy2k.CustomTextField.RestrictedTextField;

public class FrmAlfabeto2 extends javax.swing.JFrame {
   String alfab1="";
    public String eliminaRepetidos(String s){//Funcion para eliminar elementos repetidos de ambos alfabetos
        char c[]=s.toCharArray();//separa la cadena en caracteres
        String cad="";
        
        for(int i=0; i<s.length(); i++){//Recorre cadena
            c[i]=c[i];//va ingresando elems distintos
            for (int j=i+1; j<s.length(); j++){
                if (c[i]==c[j]){//Si son iguales, reemplaza el elem con un espacio vacio
                    c[j]=' ';
                }
            }
        }
        
        for (int i=0; i<s.length(); i++){
            if (c[i]!=' '){//Va concatenando los elems de c en cad, descartando los espacios vacios
                cad=cad+c[i];
            }
        }
        return cad;//Regresa los alfabetos sin elems repetidos y sin espacios
    }
    

     public void setAlfabeto1(String alfab1)
    {
        this.alfab1=alfab1;//Establecemos la cadena recuperada del form1 en alfab1
    }
    
    public String getAlfabeto1()
    {
        return alfab1;//Recupera el alfabeto 1 del form 1
    }
    public FrmAlfabeto2() {//Crea form
        initComponents();
        this.setLocationRelativeTo(null);
        TxtManual2.setEnabled(true);
        TxtPrimer2.setEnabled(false);
        TxtUlt2.setEnabled(false);
        RestrictedTextField primer2 = new RestrictedTextField(TxtPrimer2);
        RestrictedTextField ult2 = new RestrictedTextField(TxtUlt2);
       
        primer2.setLimit(1);
        ult2.setLimit(1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        BtnSalir2 = new javax.swing.JButton();
        RdBtnManual2 = new javax.swing.JRadioButton();
        RdBtnRango2 = new javax.swing.JRadioButton();
        TxtManual2 = new javax.swing.JTextField();
        TxtPrimer2 = new javax.swing.JTextField();
        TxtUlt2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        BtnAceptar2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Alfabeto 2");
        setPreferredSize(new java.awt.Dimension(350, 267));
        setResizable(false);

        BtnSalir2.setText("Salir");
        BtnSalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalir2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(RdBtnManual2);
        RdBtnManual2.setSelected(true);
        RdBtnManual2.setText("<html>Ingrese los elementos del Σ2 uno a uno <br>(deben ser al menos 3 elementos):</html>");
        RdBtnManual2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RdBtnManual2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(RdBtnRango2);
        RdBtnRango2.setText("O ingrese un rango para definir a Σ2 (Ej: 0 - 9):");
        RdBtnRango2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RdBtnRango2ActionPerformed(evt);
            }
        });

        jLabel1.setText("a");

        BtnAceptar2.setText("Aceptar");
        BtnAceptar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAceptar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TxtPrimer2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(TxtUlt2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(BtnSalir2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnAceptar2))
                        .addComponent(RdBtnRango2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(RdBtnManual2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(TxtManual2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(RdBtnManual2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtManual2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RdBtnRango2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtPrimer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtUlt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnSalir2)
                    .addComponent(BtnAceptar2))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalir2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BtnSalir2ActionPerformed

    private void RdBtnManual2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RdBtnManual2ActionPerformed
        TxtManual2.setEnabled(true);
        TxtPrimer2.setEnabled(false);
        TxtUlt2.setEnabled(false);
    }//GEN-LAST:event_RdBtnManual2ActionPerformed

    private void RdBtnRango2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RdBtnRango2ActionPerformed
        TxtManual2.setEnabled(false);
        TxtPrimer2.setEnabled(true);
        TxtUlt2.setEnabled(true);
    }//GEN-LAST:event_RdBtnRango2ActionPerformed

    private void BtnAceptar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAceptar2ActionPerformed
       String alfabeto2="";
       int i;
       
       //Funciones de form 1 para alfabeto 2
       if (RdBtnManual2.isSelected()){
           alfabeto2 = TxtManual2.getText();
       }
       else if (RdBtnRango2.isSelected()){
          if ((TxtPrimer2.getText()).length()==0 || (TxtUlt2.getText()).length()==0){//Verifica que el alfabeto no este vacio
                    JOptionPane.showMessageDialog(null, "Error al establecer los rangos", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else  if ((TxtPrimer2.getText().length())>1 || (TxtUlt2.getText().length())>1){//Verifica que no se ingrese más de un caracter en los rangos
                        JOptionPane.showMessageDialog(null, "No se puede agregar más de un caracter en los campos de los rangos", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        for(i=(int)(TxtPrimer2.getText()).charAt(0); i<=(int)(TxtUlt2.getText()).charAt(0); i++){
                            alfabeto2 = alfabeto2 + (char)i;//Recorre el rango en ASCII y va agregando cada caracter a alfabeto 1
                        }
                    }
       }
        if (eliminaRepetidos(alfabeto2).length()<3){
           JOptionPane.showMessageDialog(null, "El alfabeto debe tener al menos 3 caracteres distintos", "Error", JOptionPane.ERROR_MESSAGE);
       }
       else{
            int resp = JOptionPane.showConfirmDialog(null, "¿Es correcto el alfabeto ingresado?\n"+"Σ2 = "+alfabeto2, 
            "Aviso", JOptionPane.YES_NO_OPTION);
       
            if (resp==0){
                //Eliminamos repetidos con la funcion
                alfab1=eliminaRepetidos(alfab1);
                alfabeto2=eliminaRepetidos(alfabeto2);
     
                String Alfabeto1="{ ", Alfabeto2="{ ";//Colocamos corchetes para presentacion del alfabeto 1 como cadena
       
                for (int x = 0; x < alfab1.length(); x++){
                    if(x==alfab1.length()-1){//Si es el ult elem, no agrega coma
                        Alfabeto1 =Alfabeto1+alfab1.charAt(x)+" ";
                    }
                    else{
                        Alfabeto1 =Alfabeto1+alfab1.charAt(x)+", "; //Separa elems de la cadena con comas 
                    }
                }
                for (int j = 0; j < alfabeto2.length(); j++){//De manera similar para alfabeto 2
                    if(j==alfabeto2.length()-1){
                        Alfabeto2 =Alfabeto2+alfabeto2.charAt(j)+" ";
                    }
                    else{
                        Alfabeto2 = Alfabeto2+alfabeto2.charAt(j)+", ";
                    }
                }
       
                Alfabeto1=Alfabeto1+"}";//Al final agregamos corchete
                Alfabeto2=Alfabeto2+"}";
                
                Results results = new Results();//Crea y pasa al form Results
                Results.LblAlfabeto1.setText("Σ1 = "+Alfabeto1);//Lbl para tener los alfabetos disponibles como variables en form Results
                Results.LblAlfabeto2.setText("Σ2 = "+Alfabeto2);
                Results.LblAux1.setText(alfab1);//Imprimir alfabeto 1 (extraido del form 1)
                Results.LblAux2.setText(alfabeto2);//Imprimir alfabeto 2
                results.setVisible(true);
                this.setVisible(false);
            }
       }
    }//GEN-LAST:event_BtnAceptar2ActionPerformed
    
   

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
            java.util.logging.Logger.getLogger(FrmAlfabeto2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAlfabeto2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAlfabeto2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAlfabeto2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAlfabeto2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAceptar2;
    private javax.swing.JButton BtnSalir2;
    private javax.swing.JRadioButton RdBtnManual2;
    private javax.swing.JRadioButton RdBtnRango2;
    private javax.swing.JTextField TxtManual2;
    private javax.swing.JTextField TxtPrimer2;
    private javax.swing.JTextField TxtUlt2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
