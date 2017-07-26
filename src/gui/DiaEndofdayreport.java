/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.time.LocalDate;
import java.time.ZoneId;

/**
 *
 * @author DELL
 */
public class DiaEndofdayreport extends javax.swing.JDialog {

    /**
     * Creates new form DiaEndofdayreport
     */
    public DiaEndofdayreport(FrEmployeeWorkspace parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        this.setLocationRelativeTo(this.parent);
        this.setLocation(400, 200);
        this.setModal(true);
        
        initComponents();
        
        initDefaultSetting();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngStyle = new javax.swing.ButtonGroup();
        pnInput = new javax.swing.JPanel();
        pnControl = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBegincash = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbPrint = new javax.swing.JCheckBox();
        txtDayreport = new javax.swing.JTextField();
        cbTextfile = new javax.swing.JCheckBox();
        pnOption = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rdShortreport = new javax.swing.JRadioButton();
        rdLongreport = new javax.swing.JRadioButton();
        cbIncome = new javax.swing.JCheckBox();
        cbPurchase = new javax.swing.JCheckBox();
        cbCash = new javax.swing.JCheckBox();
        lbBegincashState = new javax.swing.JLabel();
        lbDayreportState = new javax.swing.JLabel();
        lbTextoutputState = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("End of Report");

        pnInput.setBackground(new java.awt.Color(204, 204, 204));

        pnControl.setBackground(new java.awt.Color(0, 0, 0));
        pnControl.setLayout(new java.awt.GridLayout());

        btnSave.setBackground(new java.awt.Color(0, 153, 0));
        btnSave.setText("SAVE");
        pnControl.add(btnSave);

        jButton1.setBackground(new java.awt.Color(153, 153, 0));
        jButton1.setText("RESET");
        pnControl.add(jButton1);

        btnClose.setBackground(new java.awt.Color(153, 0, 0));
        btnClose.setText("CLOSE");
        pnControl.add(btnClose);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Report");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Begin of day Cash (kVND):");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Day report:");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Text output:");

        cbPrint.setText("Print");

        cbTextfile.setText("Text file");

        pnOption.setBackground(new java.awt.Color(153, 153, 153));
        pnOption.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Option", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel5.setText("Style:");

        jLabel6.setText("Details:");

        btngStyle.add(rdShortreport);
        rdShortreport.setText("Short report");

        btngStyle.add(rdLongreport);
        rdLongreport.setText("Long report");

        cbIncome.setText("Income");

        cbPurchase.setText("purchase");

        cbCash.setText("cash");

        javax.swing.GroupLayout pnOptionLayout = new javax.swing.GroupLayout(pnOption);
        pnOption.setLayout(pnOptionLayout);
        pnOptionLayout.setHorizontalGroup(
            pnOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnOptionLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(34, 34, 34)
                .addGroup(pnOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnOptionLayout.createSequentialGroup()
                        .addComponent(cbIncome)
                        .addGap(18, 18, 18)
                        .addComponent(cbPurchase)
                        .addGap(18, 18, 18)
                        .addComponent(cbCash))
                    .addGroup(pnOptionLayout.createSequentialGroup()
                        .addComponent(rdShortreport)
                        .addGap(18, 18, 18)
                        .addComponent(rdLongreport)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnOptionLayout.setVerticalGroup(
            pnOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnOptionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rdShortreport)
                    .addComponent(rdLongreport))
                .addGap(20, 20, 20)
                .addGroup(pnOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbIncome)
                    .addComponent(cbPurchase)
                    .addComponent(cbCash))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        lbBegincashState.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbBegincashState.setForeground(new java.awt.Color(204, 0, 0));

        lbDayreportState.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbDayreportState.setForeground(new java.awt.Color(204, 0, 0));

        lbTextoutputState.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbTextoutputState.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout pnInputLayout = new javax.swing.GroupLayout(pnInput);
        pnInput.setLayout(pnInputLayout);
        pnInputLayout.setHorizontalGroup(
            pnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnInputLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(37, 37, 37)
                .addGroup(pnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnInputLayout.createSequentialGroup()
                        .addComponent(cbPrint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(cbTextfile))
                    .addComponent(txtDayreport)
                    .addComponent(txtBegincash))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbBegincashState, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbDayreportState, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTextoutputState, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(pnOption, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnInputLayout.createSequentialGroup()
                .addContainerGap(141, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141))
        );
        pnInputLayout.setVerticalGroup(
            pnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnInputLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBegincash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbBegincashState, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDayreport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDayreportState, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbPrint)
                    .addComponent(cbTextfile)
                    .addComponent(lbTextoutputState, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(pnInput, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(DiaEndofdayreport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiaEndofdayreport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiaEndofdayreport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiaEndofdayreport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DiaEndofdayreport dialog = new DiaEndofdayreport(new FrEmployeeWorkspace(null), true);
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
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup btngStyle;
    private javax.swing.JCheckBox cbCash;
    private javax.swing.JCheckBox cbIncome;
    private javax.swing.JCheckBox cbPrint;
    private javax.swing.JCheckBox cbPurchase;
    private javax.swing.JCheckBox cbTextfile;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbBegincashState;
    private javax.swing.JLabel lbDayreportState;
    private javax.swing.JLabel lbTextoutputState;
    private javax.swing.JPanel pnControl;
    private javax.swing.JPanel pnInput;
    private javax.swing.JPanel pnOption;
    private javax.swing.JRadioButton rdLongreport;
    private javax.swing.JRadioButton rdShortreport;
    private javax.swing.JTextField txtBegincash;
    private javax.swing.JTextField txtDayreport;
    // End of variables declaration//GEN-END:variables




// CUSTOM VARIABLE REPORT
    FrEmployeeWorkspace parent;
    
    
    // default setting info
    LocalDate dayreport = LocalDate.now( ZoneId.of( "Asia/Ho_Chi_Minh" ) );
    float begincash = 2000;
// END CUSTOM VARIABLE REPORT
    
    
    
// CUSTOM CODE
    private void initDefaultSetting() {
        this.txtBegincash.setText(String.valueOf(this.begincash));
        this.txtDayreport.setText(String.valueOf(this.dayreport));
        
        this.cbPrint.setSelected(true);
        this.cbTextfile.setSelected(false);
        
        this.rdLongreport.setSelected(true);
        this.cbCash.setSelected(true);
        this.cbIncome.setSelected(true);
        this.cbPurchase.setSelected(true);
    }
    
// END CUSTOM CODE
}