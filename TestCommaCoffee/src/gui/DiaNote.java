/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author DELL
 */
public class DiaNote extends javax.swing.JDialog {

    /**
     * Creates new form DiaNote
     */
    public DiaNote(FrEmployeeWorkspace parent, boolean modal) {
        super(parent, modal);
        
        this.parent = parent;
        
        this.setLocationRelativeTo(this.parent);
        this.setLocation(500, 260);
        this.setModal(true);
        this.initComponents();
        
        // khởi tạo note nếu nó có sẵn
        int choosen_note = this.parent.getSelectRowxofTable()/2;
        String existnote = this.parent.getNoteofTable(this.parent.cur_table).getValue().get(choosen_note);
        String[] wordlist = existnote.split("[\\s]");
        for(int i = 0 ; i < wordlist.length; i++){
            if(wordlist[i].equals("<other>:")){
                existnote = "";
                for(int j = i+1; j < wordlist.length; j++){
                    existnote += wordlist[j];
                    existnote += " ";
                }
                break;
            }
        }
        this.txtNote.setText(existnote);
        this.txtNote.requestFocus();
        this.txtNote.select(0, this.txtNote.getText().length());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgStyle = new javax.swing.ButtonGroup();
        btgSweet = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        rdHot = new javax.swing.JRadioButton();
        rdMoreIce = new javax.swing.JRadioButton();
        rdNormalIce = new javax.swing.JRadioButton();
        rdLessIce = new javax.swing.JRadioButton();
        rdMoreSweet = new javax.swing.JRadioButton();
        rdNormalSweet = new javax.swing.JRadioButton();
        rdLessSweet = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNote = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        btnOK = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Order Note");
        setPreferredSize(new java.awt.Dimension(400, 310));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "default style", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 153))); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(0, 140));

        btgStyle.add(rdHot);
        rdHot.setText("Hot");
        rdHot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdHotActionPerformed(evt);
            }
        });

        btgStyle.add(rdMoreIce);
        rdMoreIce.setText("More Ice");
        rdMoreIce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdMoreIceActionPerformed(evt);
            }
        });

        btgStyle.add(rdNormalIce);
        rdNormalIce.setText("Normal Ice");
        rdNormalIce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdNormalIceActionPerformed(evt);
            }
        });

        btgStyle.add(rdLessIce);
        rdLessIce.setText("Less Ice");
        rdLessIce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdLessIceActionPerformed(evt);
            }
        });

        btgSweet.add(rdMoreSweet);
        rdMoreSweet.setText("More Sugar");
        rdMoreSweet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdMoreSweetActionPerformed(evt);
            }
        });

        btgSweet.add(rdNormalSweet);
        rdNormalSweet.setText("Normal Sugar");
        rdNormalSweet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdNormalSweetActionPerformed(evt);
            }
        });

        btgSweet.add(rdLessSweet);
        rdLessSweet.setText("Less Sugar");
        rdLessSweet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdLessSweetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdHot)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rdMoreIce)
                        .addGap(18, 18, 18)
                        .addComponent(rdNormalIce)
                        .addGap(18, 18, 18)
                        .addComponent(rdLessIce))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rdMoreSweet)
                        .addGap(18, 18, 18)
                        .addComponent(rdNormalSweet)
                        .addGap(18, 18, 18)
                        .addComponent(rdLessSweet)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdHot)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdMoreIce)
                    .addComponent(rdNormalIce)
                    .addComponent(rdLessIce))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdMoreSweet)
                    .addComponent(rdNormalSweet)
                    .addComponent(rdLessSweet))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "other", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 153))); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(0, 130));
        jPanel3.setLayout(new java.awt.BorderLayout());

        txtNote.setColumns(20);
        txtNote.setRows(5);
        jScrollPane1.setViewportView(txtNote);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 50));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });
        jPanel1.add(btnOK);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdHotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdHotActionPerformed
        
    }//GEN-LAST:event_rdHotActionPerformed

    private void rdMoreIceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdMoreIceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdMoreIceActionPerformed

    private void rdNormalIceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdNormalIceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdNormalIceActionPerformed

    private void rdLessIceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdLessIceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdLessIceActionPerformed

    private void rdMoreSweetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdMoreSweetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdMoreSweetActionPerformed

    private void rdNormalSweetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdNormalSweetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdNormalSweetActionPerformed

    private void rdLessSweetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdLessSweetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdLessSweetActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        // TODO add your handling code here:
        String defaultnote = "<style>: ";
        if(this.rdHot.isSelected()){
            defaultnote += "hot";
        }
        if(this.rdMoreIce.isSelected()){
            defaultnote += "more ice";
        }
        if(this.rdNormalIce.isSelected()){
            defaultnote += "normal ice";
        }
        if(this.rdLessIce.isSelected()){
            defaultnote += "less ice";
        }
        if(this.rdMoreSweet.isSelected()){
            defaultnote += ", more sugar";
        }
        if(this.rdNormalSweet.isSelected()){
            defaultnote += ", normal sugar";
        }
        if(this.rdLessSweet.isSelected()){
            defaultnote += ", less sugar";
        }
        
        defaultnote += "   \n<other>: ";
        defaultnote += this.txtNote.getText();
        int choosen_note = this.parent.getSelectRowxofTable()/2;
        this.parent.getNoteofTable(this.parent.cur_table).getValue().set(choosen_note, defaultnote);
        
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(DiaNote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiaNote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiaNote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiaNote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DiaNote dialog = new DiaNote(new FrEmployeeWorkspace(null), true);
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
    private javax.swing.ButtonGroup btgStyle;
    private javax.swing.ButtonGroup btgSweet;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOK;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdHot;
    private javax.swing.JRadioButton rdLessIce;
    private javax.swing.JRadioButton rdLessSweet;
    private javax.swing.JRadioButton rdMoreIce;
    private javax.swing.JRadioButton rdMoreSweet;
    private javax.swing.JRadioButton rdNormalIce;
    private javax.swing.JRadioButton rdNormalSweet;
    private javax.swing.JTextArea txtNote;
    // End of variables declaration//GEN-END:variables

    
    FrEmployeeWorkspace parent;
}
