/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.employee;

import entities.Employee;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import model.EmployeeDAO;

/**
 *
 * @author DELL
 */
public class DiaEmpChangeInfo extends javax.swing.JDialog {

    /**
     * Creates new form DiaEmpChangeInfo
     */
    public DiaEmpChangeInfo(FrEmployeeWorkspace parent, Employee cur_emp, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        this.cur_emp = cur_emp;
        this.setLocationRelativeTo(this.parent);
        this.setLocation(300, 150);
        this.setModal(true);
        
        initComponents();
        
        initOldData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtBirth = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtConfirmpass = new javax.swing.JPasswordField();
        txtPhone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        pnControl = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setForeground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Change Information");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("User Name:");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Password:");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Confirm password:");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Birth (yyyy-mm-dd):");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Phone:");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Email:");

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Address:");

        pnControl.setLayout(new java.awt.GridLayout());

        btnSave.setBackground(new java.awt.Color(0, 153, 0));
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        pnControl.add(btnSave);

        btnReset.setBackground(new java.awt.Color(153, 153, 0));
        btnReset.setText("RESET");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        pnControl.add(btnReset);

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jScrollPane1.setViewportView(txtAddress);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(102, 102, 102)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                        .addComponent(txtPassword)
                        .addComponent(txtConfirmpass)
                        .addComponent(txtBirth)
                        .addComponent(txtPhone)
                        .addComponent(txtEmail))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
            .addComponent(pnControl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtConfirmpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
        String newusername = this.txtUsername.getText();
        String newpass = new String(this.txtPassword.getPassword()), confirmpass = new String(this.txtConfirmpass.getPassword());
        String newbirth = this.txtBirth.getText();
        String newphone = this.txtPhone.getText();
        String newemail = this.txtEmail.getText();
        String newaddr = this.txtAddress.getText();
        
        // validation
        if(newusername.isEmpty() || newusername.length() > 50){
            JOptionPane.showMessageDialog(null, "Username do not be empty and characters less than 50", "INPUT WARNING", JOptionPane.WARNING_MESSAGE);
            this.txtUsername.requestFocus();
            return;
        }
        if(newpass.isEmpty() || newpass.length() > 50){
            JOptionPane.showMessageDialog(null, "Password do not be empty and characters less than 50", "INPUT WARNING", JOptionPane.WARNING_MESSAGE);
            this.txtPassword.requestFocus();
            return;
        }
        if(!confirmpass.equals(newpass)){
            JOptionPane.showMessageDialog(null, "Password and Confirm Password is not match", "INPUT WARNING", JOptionPane.WARNING_MESSAGE);
            this.txtConfirmpass.requestFocus();
            return;
        }
        if(newbirth.length() != 10){
            JOptionPane.showMessageDialog(null, "Birth day is not correct", "INPUT WARNING", JOptionPane.WARNING_MESSAGE);
            this.txtBirth.requestFocus();
            return;
        }
        LocalDate birthday;
        try{
            int year = Integer.parseInt(newbirth.substring(0, 4));
            int month = Integer.parseInt(newbirth.substring(5, 7));
            int day = Integer.parseInt(newbirth.substring(8, 10));
            birthday = LocalDate.of(year, month, day);
        }catch(DateTimeException | NumberFormatException ex){
            ex.getStackTrace();
            JOptionPane.showMessageDialog(null, "Birth day is not correct", "INPUT WARNING", JOptionPane.WARNING_MESSAGE);
            this.txtBirth.requestFocus();
            return;
        }
        if(newphone.length() > 20){
            JOptionPane.showMessageDialog(null, "Phone must has less than 20 degit", "INPUT WARNING", JOptionPane.WARNING_MESSAGE);
            this.txtPhone.requestFocus();
            return;
        }
        Pattern p = Pattern.compile("[\\w]+@[\\w]+[.][\\w]+");
        Matcher m = p.matcher(newemail);
        if(!m.matches() || newemail.length() > 50){
            JOptionPane.showMessageDialog(null, "Email must match the pattern and less than 50 characters", "INPUT WARNING", JOptionPane.WARNING_MESSAGE);
            this.txtEmail.requestFocus();
            return;
        }
        if(newaddr.length() > 200){
            JOptionPane.showMessageDialog(null, "Address must has less than 200 characters", "INPUT WARNING", JOptionPane.WARNING_MESSAGE);
            this.txtAddress.requestFocus();
            return;
        }
        
        // save new data to database
        int result = EmployeeDAO.selfupdate(cur_emp, newusername, newpass, java.sql.Date.valueOf(birthday), newphone, newemail, newaddr);
        if(result == 0){
            JOptionPane.showMessageDialog(null, "Some problems happen, can not update new employee data!", "DATABASE WARNING", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // set the current old employee data to new one
        this.cur_emp.setUsername(newusername);
        this.cur_emp.setPass(newpass);
        this.cur_emp.setBirth(java.sql.Date.valueOf(birthday));
        this.cur_emp.setPhone(newphone);
        this.cur_emp.setEmail(newemail);
        this.cur_emp.setAddr(newaddr);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        this.initOldData();
    }//GEN-LAST:event_btnResetActionPerformed

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
            java.util.logging.Logger.getLogger(DiaEmpChangeInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiaEmpChangeInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiaEmpChangeInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiaEmpChangeInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DiaEmpChangeInfo dialog = new DiaEmpChangeInfo(new FrEmployeeWorkspace(null), null, true);
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
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnControl;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtBirth;
    private javax.swing.JPasswordField txtConfirmpass;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

// CUSTOM VARIABLE DECLARATION
    FrEmployeeWorkspace parent;
    Employee cur_emp;
// END CUSTOM VARIABLE DECLARATION
    
    
    
    
// CUSTOM CODE
    private void initOldData() {
        this.txtUsername.setText(this.cur_emp.getUsername());
        this.txtPassword.setText(this.cur_emp.getPass());
        this.txtConfirmpass.setText(this.cur_emp.getPass());
        this.txtBirth.setText(this.cur_emp.getBirth().toString());
        this.txtPhone.setText(this.cur_emp.getPhone());
        this.txtEmail.setText(this.cur_emp.getEmail());
        this.txtAddress.setText(this.cur_emp.getAddr());
    }
    
// END CUSTOM CODE


}
