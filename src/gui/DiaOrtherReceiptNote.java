/*
 * Tạo ra cửa sổ cho phép người dùng nhập một loại hoá đơn khác (orther receiptnote)
 * Loại hoá đơn thường nhập chỉ dành cho các loại chỉ trả vật chất thường ngày
 * Loại hoá đơn này dành cho loại các chi trả tuỳ biến (tập trung vào chi phí và lý do chi trả thay vì loại sản phẩm cần chi trả)
 */
package gui;

import entities.Employee;
import entities.FoodMaterial;
import entities.ReceiptNote;
import entities.ReceiptNoteDetails;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.swing.JOptionPane;
import model.ReceiptNoteDAO;
import supportclass.Pair;

/**
 *
 * @author DELL
 */
public class DiaOrtherReceiptNote extends javax.swing.JDialog {

    /**
     * Creates new form DiaOrtherReceiptNote
     */
    public DiaOrtherReceiptNote(FrEmployeeWorkspace parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        
        this.setLocationRelativeTo(this.parent);
        this.setLocation(400, 200);
        this.setModal(true);
        
        initComponents();
        
        this.initbeginingdata();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnInput = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cboEmployee = new javax.swing.JComboBox<>();
        txtItemname = new javax.swing.JTextField();
        txtQuan = new javax.swing.JTextField();
        txtTotalAmount = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNote = new javax.swing.JTextArea();
        pnControl = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lbWarning = new javax.swing.JLabel();
        btnminus = new javax.swing.JButton();
        btnplus = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Other Style ReceiptNote");

        pnInput.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Employee:");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Item:");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Quan:");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Total Amount:");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Note:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("RECEIPT NOTE");

        txtItemname.setEditable(false);

        txtQuan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQuanFocusLost(evt);
            }
        });
        txtQuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuanActionPerformed(evt);
            }
        });

        txtTotalAmount.setEditable(false);

        txtNote.setColumns(20);
        txtNote.setRows(5);
        jScrollPane1.setViewportView(txtNote);

        pnControl.setBackground(new java.awt.Color(102, 102, 102));
        pnControl.setLayout(new java.awt.GridLayout());

        btnSave.setBackground(new java.awt.Color(0, 153, 0));
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        pnControl.add(btnSave);

        btnReset.setBackground(new java.awt.Color(204, 204, 0));
        btnReset.setText("RESET");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        pnControl.add(btnReset);

        btnCancel.setBackground(new java.awt.Color(204, 0, 0));
        btnCancel.setText("CANCEL");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        pnControl.add(btnCancel);

        lbWarning.setForeground(new java.awt.Color(204, 0, 0));
        lbWarning.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbWarning.setText("Please remember to specify the note for this Receipt ");

        btnminus.setText("-");
        btnminus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnminusActionPerformed(evt);
            }
        });

        btnplus.setText("+");
        btnplus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnplusActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Price:");

        txtPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPriceFocusLost(evt);
            }
        });
        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnInputLayout = new javax.swing.GroupLayout(pnInput);
        pnInput.setLayout(pnInputLayout);
        pnInputLayout.setHorizontalGroup(
            pnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnInputLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnInputLayout.createSequentialGroup()
                        .addComponent(lbWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(32, Short.MAX_VALUE))
                    .addGroup(pnInputLayout.createSequentialGroup()
                        .addGroup(pnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7))
                        .addGap(20, 20, 20)
                        .addGroup(pnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnInputLayout.createSequentialGroup()
                                .addGroup(pnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnInputLayout.createSequentialGroup()
                                .addGroup(pnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtPrice, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTotalAmount, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtQuan, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtItemname, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboEmployee, javax.swing.GroupLayout.Alignment.LEADING, 0, 143, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(btnplus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnminus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        pnInputLayout.setVerticalGroup(
            pnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInputLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtItemname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(pnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnminus)
                    .addComponent(btnplus))
                .addGap(18, 18, 18)
                .addGroup(pnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbWarning)
                .addGap(18, 18, 18)
                .addComponent(pnControl, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(pnInput, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if(this.txtNote.getText().isEmpty() || this.txtNote.getText().length() > 300){
            JOptionPane.showMessageDialog(null, "Note is not correct", "INPUT WARNING", JOptionPane.WARNING_MESSAGE);
            this.txtNote.requestFocus();
            return;
        }
        
        
        // nhập dữ liệu vào database
        ReceiptNote new_rn = null;
        for(Employee iter : this.parent.working_emp){
            if(iter.getName().equals( this.cboEmployee.getSelectedItem())){
                new_rn = new ReceiptNote("", iter.getEm_id(), java.sql.Date.valueOf(this.parent.today), Float.parseFloat(this.txtTotalAmount.getText()));
                break;
            }
        }
        ReceiptNoteDetails new_rndetails = new ReceiptNoteDetails("", "FM00000000", Integer.valueOf(this.txtQuan.getText()), Float.valueOf(this.txtPrice.getText()), this.txtNote.getText());
        
        ArrayList<ReceiptNoteDetails> new_details = new ArrayList<>();
        new_details.add(new_rndetails);
        Pair<ReceiptNote, ArrayList<ReceiptNoteDetails>> new_receipt = new Pair<>(new_rn, new_details);
        ReceiptNoteDAO.insert(new_receipt);
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        this.initbeginingdata();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnplusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnplusActionPerformed
        // TODO add your handling code here:
        int quan = Integer.parseInt(this.txtQuan.getText());
        quan++;
        this.txtQuan.setText(String.valueOf(quan));
        
        float price = Float.parseFloat(this.txtPrice.getText());
        float tamount = quan * price;
        this.txtTotalAmount.setText(String.valueOf(tamount));
    }//GEN-LAST:event_btnplusActionPerformed

    private void btnminusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnminusActionPerformed
        // TODO add your handling code here:
        int quan = Integer.parseInt(this.txtQuan.getText());
                
        if(quan <= 0){
            return;
        }else{
            quan--;
            this.txtQuan.setText(String.valueOf(quan));
            
            float price = Float.parseFloat(this.txtPrice.getText());
            float tamount = quan * price;
            this.txtTotalAmount.setText(String.valueOf(tamount));
        }
    }//GEN-LAST:event_btnminusActionPerformed

    private void txtQuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuanActionPerformed
        // TODO add your handling code here:
        int quan;
        try{
            quan = Integer.parseInt(this.txtQuan.getText());
            
            if(quan < 0){
                JOptionPane.showMessageDialog(null, "Quantity is not correct", "INPUT WARNING", JOptionPane.WARNING_MESSAGE);
                this.txtQuan.requestFocus();
                return;
            }
        }catch(NumberFormatException ex){
            ex.getStackTrace();
            JOptionPane.showMessageDialog(null, "Quantity is not correct", "INPUT WARNING", JOptionPane.WARNING_MESSAGE);
            this.txtQuan.requestFocus();
            return;
        }
        float price = Float.parseFloat(this.txtPrice.getText());
        
        
        float tamount = quan * price;
        this.txtTotalAmount.setText(String.valueOf(tamount));
    }//GEN-LAST:event_txtQuanActionPerformed

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
        int quan = Integer.parseInt(this.txtQuan.getText());
        float price;
        try{
            price = Float.parseFloat(this.txtPrice.getText());
            
            if(price < 0){
                JOptionPane.showMessageDialog(null, "Price is not correct", "INPUT WARNING", JOptionPane.WARNING_MESSAGE);
                this.txtPrice.requestFocus();
                return;
            }
        }catch(NumberFormatException ex){
            ex.getStackTrace();
            JOptionPane.showMessageDialog(null, "Price is not correct", "INPUT WARNING", JOptionPane.WARNING_MESSAGE);
            this.txtPrice.requestFocus();
            return;
        }
        
        float tamount = quan * price;
        this.txtTotalAmount.setText(String.valueOf(tamount));
    }//GEN-LAST:event_txtPriceActionPerformed

    private void txtPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPriceFocusLost
        // TODO add your handling code here:
        int quan = Integer.parseInt(this.txtQuan.getText());
        
        float price;
        try{
            price = Float.parseFloat(this.txtPrice.getText());
            
            if(price < 0){
                JOptionPane.showMessageDialog(null, "Price is not correct", "INPUT WARNING", JOptionPane.WARNING_MESSAGE);
                this.txtPrice.requestFocus();
                return;
            }
        }catch(NumberFormatException ex){
            ex.getStackTrace();
            JOptionPane.showMessageDialog(null, "Price is not correct", "INPUT WARNING", JOptionPane.WARNING_MESSAGE);
            this.txtPrice.requestFocus();
            return;
        }
        
        float tamount = quan * price;
        this.txtTotalAmount.setText(String.valueOf(tamount));
    }//GEN-LAST:event_txtPriceFocusLost

    private void txtQuanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuanFocusLost
        // TODO add your handling code here:
        int quan;
        try{
            quan = Integer.parseInt(this.txtQuan.getText());
            
            if(quan < 0){
                JOptionPane.showMessageDialog(null, "Quantity is not correct", "INPUT WARNING", JOptionPane.WARNING_MESSAGE);
                this.txtQuan.requestFocus();
                return;
            }
        }catch(NumberFormatException ex){
            ex.getStackTrace();
            JOptionPane.showMessageDialog(null, "Quantity is not correct", "INPUT WARNING", JOptionPane.WARNING_MESSAGE);
            this.txtQuan.requestFocus();
            return;
        }
        
        float price;
        try{
            price = Float.parseFloat(this.txtPrice.getText());
        }catch(NumberFormatException ex){
            ex.getStackTrace();
            JOptionPane.showMessageDialog(null, "Price is not correct", "INPUT WARNING", JOptionPane.WARNING_MESSAGE);
            this.txtPrice.requestFocus();
            return;
        }
        float tamount = quan * price;
        this.txtTotalAmount.setText(String.valueOf(tamount));
    }//GEN-LAST:event_txtQuanFocusLost

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
            java.util.logging.Logger.getLogger(DiaOrtherReceiptNote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiaOrtherReceiptNote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiaOrtherReceiptNote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiaOrtherReceiptNote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DiaOrtherReceiptNote dialog = new DiaOrtherReceiptNote(new FrEmployeeWorkspace(null), true);
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
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnminus;
    private javax.swing.JButton btnplus;
    private javax.swing.JComboBox<String> cboEmployee;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbWarning;
    private javax.swing.JPanel pnControl;
    private javax.swing.JPanel pnInput;
    private javax.swing.JTextField txtItemname;
    private javax.swing.JTextArea txtNote;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuan;
    private javax.swing.JTextField txtTotalAmount;
    // End of variables declaration//GEN-END:variables



// CUSTOM VARIABLE DECLARATION
    FrEmployeeWorkspace parent;
// END CUSTOM VARIABLE DECLARATION

    
    
    
    
// CUSTOM CODE
    private void initbeginingdata() {
        try{
            // khởi tạo danh sách các nhân viên đang làm việc
            String[] empname = new String[this.parent.working_emp.size()];
            for(int i = 0; i < empname.length; i++){
                empname[i] = this.parent.working_emp.get(i).getName();
            }
            this.cboEmployee.setModel(new javax.swing.DefaultComboBoxModel<>(empname));
            this.cboEmployee.setSelectedIndex(0);

            // khởi tạo thông tin hoá đơn
            for(FoodMaterial item : this.parent.menumaterial_list){
                if(item.getFm_id().equals("FM00000000")){
                    int quan = 1;
                    float tamount = quan * item.getStandard_price();

                    this.txtItemname.setText(item.getName());
                    this.txtItemname.setEditable(false);
                    this.txtPrice.setText(String.valueOf(item.getStandard_price()));
                    this.txtQuan.setText(String.valueOf(quan));
                    this.txtTotalAmount.setText(String.valueOf(tamount));
                    break;
                }
            }
            this.txtNote.setText("");
        }catch(NumberFormatException ex){
            ex.printStackTrace();
        }
    }
// END CUSTOM CODE
}
