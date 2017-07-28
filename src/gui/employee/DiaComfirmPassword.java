/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.employee;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author DELL
 */
public class DiaComfirmPassword extends javax.swing.JDialog {

    /**
     * Creates new form DiaComfirmPassword
     */
    public DiaComfirmPassword(FrEmployeeWorkspace parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        this.setLocationRelativeTo(this.parent);
        this.setLocation(300, 150);
        this.setModal(true);
        
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

        lbMessage = new javax.swing.JLabel();
        txtConfirmpass = new javax.swing.JPasswordField();
        lbIcon = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Confirm your password");
        setBackground(new java.awt.Color(102, 102, 102));

        lbMessage.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbMessage.setForeground(new java.awt.Color(0, 153, 0));
        lbMessage.setText("Please retype your password:");

        txtConfirmpass.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtConfirmpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfirmpassActionPerformed(evt);
            }
        });

        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        btnOk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnOkKeyPressed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtConfirmpass, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtConfirmpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnCancel))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        ImageIcon icon = null;
        try{
            Image scaled = ImageIO.read(new File("src/image/confirmpass_icon.png")).getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaled);
        }catch(IOException io_ex){
            io_ex.printStackTrace();
        }
        this.lbIcon.setIcon(icon);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        // TODO add your handling code here:
        this.parent.checkpassword = new String(this.txtConfirmpass.getPassword());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.parent.checkpassword = "";
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtConfirmpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfirmpassActionPerformed
        // TODO add your handling code here:
        this.btnOk.requestFocus();
    }//GEN-LAST:event_txtConfirmpassActionPerformed

    private void btnOkKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnOkKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.parent.checkpassword = new String(this.txtConfirmpass.getPassword());
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.dispose();
        }
    }//GEN-LAST:event_btnOkKeyPressed

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
            java.util.logging.Logger.getLogger(DiaComfirmPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiaComfirmPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiaComfirmPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiaComfirmPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DiaComfirmPassword dialog = new DiaComfirmPassword(new FrEmployeeWorkspace(null), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbMessage;
    private javax.swing.JPasswordField txtConfirmpass;
    // End of variables declaration//GEN-END:variables

    
    
    
// CUSTOM VARIABLE DECLARATION
    FrEmployeeWorkspace parent;
    
// END CUSTOM VARIABLE DECLARATION
    
    
    
// CUSTOM CODE
    
    
// END CUSTOM CODE
}