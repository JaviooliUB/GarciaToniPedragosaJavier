package vista;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import adaptador.Adaptador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author garci
 */
public class GestioComandes extends javax.swing.JFrame {

    Adaptador ad;
    AppMercatUB parent;
    AfegirComanda afCom;
    boolean urgent = false;
    /**
     * Creates new form GestioComandes
     */
    public GestioComandes() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAfegir = new javax.swing.JToggleButton();
        btnEsborra = new javax.swing.JToggleButton();
        btnToggle = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listComandes = new javax.swing.JList<>();
        btnTornar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestionar Comandes");

        btnAfegir.setText("Afegir Comanda");
        btnAfegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAfegirActionPerformed(evt);
            }
        });

        btnEsborra.setText("Esborrar Comanda");
        btnEsborra.setEnabled(false);
        btnEsborra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEsborraActionPerformed(evt);
            }
        });

        btnToggle.setText("Veure Urgents");
        btnToggle.setEnabled(false);
        btnToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToggleActionPerformed(evt);
            }
        });

        listComandes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                listComandesMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(listComandes);

        btnTornar.setText("Tornar");
        btnTornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTornarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(btnAfegir)
                        .addGap(113, 113, 113))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnToggle)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btnTornar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEsborra)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(108, Short.MAX_VALUE)
                .addComponent(btnAfegir)
                .addGap(87, 87, 87)
                .addComponent(btnToggle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEsborra)
                    .addComponent(btnTornar))
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTornarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        parent.setVisible(true);
    }//GEN-LAST:event_btnTornarActionPerformed

    private void btnAfegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAfegirActionPerformed
        // TODO add your handling code here:
        if (afCom == null){
            afCom = new AfegirComanda();
        }
        afCom.Show(this);
    }//GEN-LAST:event_btnAfegirActionPerformed

    private void listComandesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listComandesMouseReleased
        // TODO add your handling code here:
        if (listComandes.getSelectedIndex()!=-1) btnEsborra.setEnabled(true);
    }//GEN-LAST:event_listComandesMouseReleased

    private void btnEsborraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEsborraActionPerformed
        // TODO add your handling code here:
        if (listComandes.getSelectedIndex()==-1) 
            JOptionPane.showMessageDialog(null, "Afegeix una comanda o tria-la a la llista de la dreta.");
        else{
            try{
                ad.esborrarComanda(listComandes.getSelectedIndex());
                this.llistarComandes();
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btnEsborraActionPerformed

    private void btnToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToggleActionPerformed
        // TODO add your handling code here:
        urgent=!urgent;
        if(urgent){
            this.llistarComandes();
            btnToggle.setText("Veure totes");
        }
        else{
            this.llistarComandes();
            btnToggle.setText("Veure urgents");            
        }
        
    }//GEN-LAST:event_btnToggleActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(GestioComandes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestioComandes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestioComandes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestioComandes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestioComandes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAfegir;
    private javax.swing.JToggleButton btnEsborra;
    private javax.swing.JToggleButton btnToggle;
    private javax.swing.JButton btnTornar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listComandes;
    // End of variables declaration//GEN-END:variables

    void Show(AppMercatUB aThis) {
        parent=aThis;
        ad = aThis.ad;
        this.setVisible(true);
        aThis.setVisible(false);
    }
    void llistarComandes(){
        DefaultListModel<String> llista = new DefaultListModel<>();
        listComandes.setModel(llista);
        try{
            for (String Val : ad.printLlistaComandes(urgent)){
                llista.addElement(Val);            
            }
            listComandes.setModel(llista);
            btnToggle.setEnabled(!ad.printLlistaComandes(false).isEmpty());     
            
        }catch (Exception e){
        }
        btnEsborra.setEnabled(false);
    }

}
