/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.employee;

import entities.Order;
import entities.OrderDetails;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Map.Entry;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

/**
 *
 * @author DELL
 */
public class DiaSwapTable extends javax.swing.JDialog {

    /**
     * Creates new form DiaSwapTable
     */
    public DiaSwapTable(FrEmployeeWorkspace parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        this.setLocationRelativeTo(this.parent);
        this.setLocation(300, 150);
        this.setModal(true);
        
        this.setTablePanelSize();
        initComponents();
        
        this.initOrderTable();
        this.refreshTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMain = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnTable = new javax.swing.JPanel();
        btnSwap = new javax.swing.JButton();
        btnMerge = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Swap Table");

        pnMain.setBackground(new java.awt.Color(204, 204, 255));

        pnTable.setBackground(new java.awt.Color(33, 30, 30));
        this.pnTable.setSize(this.Tablepn_width, this.Tablepn_height);
        pnTable.setLayout(new java.awt.GridLayout(0, 4, 10, 10));
        jScrollPane1.setViewportView(pnTable);

        btnSwap.setBackground(new java.awt.Color(0, 204, 0));
        btnSwap.setText("SWAP");
        btnSwap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSwapActionPerformed(evt);
            }
        });

        btnMerge.setBackground(new java.awt.Color(153, 153, 0));
        btnMerge.setText("Merge");
        btnMerge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMergeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnMainLayout = new javax.swing.GroupLayout(pnMain);
        pnMain.setLayout(pnMainLayout);
        pnMainLayout.setHorizontalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSwap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMerge, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnMainLayout.setVerticalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMainLayout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(btnSwap)
                .addGap(29, 29, 29)
                .addComponent(btnMerge)
                .addContainerGap(231, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );

        this.jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        this.jScrollPane1.getHorizontalScrollBar().setUnitIncrement(16);

        getContentPane().add(pnMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSwapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSwapActionPerformed
        // TODO add your handling code here:
        if(this.selectedtable_list.size() == 2){
            int table1 = Integer.parseInt(this.selectedtable_list.get(0).getText());
            int table2 = Integer.parseInt(this.selectedtable_list.get(1).getText());
            
            // dữ liệu bàn 1
            int table1_state = this.parent.getTableState(table1);
            SimpleEntry<Order, ArrayList<OrderDetails>> table1_order = new SimpleEntry<>(this.parent.getOrderofTable(table1));
            SimpleEntry<Integer, ArrayList<String>> table1_ordernote = new SimpleEntry<>(this.parent.getNoteofTable(table1));
            int table1_cusnumber = this.parent.getTableCustomerNumber(table1);
            // dữ liệu bàn 2
            int table2_state = this.parent.getTableState(table2);
            SimpleEntry<Order, ArrayList<OrderDetails>> table2_order = new SimpleEntry<>(this.parent.getOrderofTable(table2));
            SimpleEntry<Integer, ArrayList<String>> table2_ordernote = new SimpleEntry<>(this.parent.getNoteofTable(table2));
            int table2_cusnumber = this.parent.getTableCustomerNumber(table2);
            
            // swap
            int temp1_state;
            Entry<Order, ArrayList<OrderDetails>> temp1_order;
            Entry<Integer, ArrayList<String>> temp1_ordernote;
            int temp1_cusnumber;
            int temp2_state;
            Entry<Order, ArrayList<OrderDetails>> temp2_order;
            Entry<Integer, ArrayList<String>> temp2_ordernote;
            int temp2_cusnumber;
            temp1_state = table1_state;
            temp1_order = table1_order;
            temp1_ordernote = table1_ordernote;
            temp1_cusnumber = table1_cusnumber;
            temp2_state = table2_state;
            temp2_order = table2_order;
            temp2_ordernote = table2_ordernote;
            temp2_cusnumber = table2_cusnumber;
            
            this.parent.setTableState(table1, temp2_state);
            this.parent.setNoteofTable(table1, temp2_ordernote);
            this.parent.setOrderofTable(table1, temp2_order);
            this.parent.setTableCustomerNumber(table1, temp2_cusnumber);
            this.parent.setTableState(table2, temp1_state);
            this.parent.setNoteofTable(table2, temp1_ordernote);
            this.parent.setOrderofTable(table2, temp1_order);
            this.parent.setTableCustomerNumber(table2, temp1_cusnumber);
            
            // nếu đã print rồi thì chuyển trạng thái để yêu cầu print lại sau khi swap bàn
            if(temp1_state == 2){
                this.parent.setTableState(table1, 1);
            }
            if(temp2_state == 2){
                this.parent.setTableState(table2, 1);
            }
            
            
            // bản chất là bàn chưa print
            if(temp1_state != 2){
                ImageIcon icon = null;
                try{
                    Image scaled = ImageIO.read(new File("src/image/table_icon.png")).getScaledInstance(90, 50, Image.SCALE_SMOOTH);
                    icon = new ImageIcon(scaled);
                }catch(IOException io_ex){
                    io_ex.printStackTrace();
                }
                this.parent.tablebtn_list.get(table2-1).setIcon(icon);
            }
            if(temp2_state != 2){
                ImageIcon icon = null;
                try{
                    Image scaled = ImageIO.read(new File("src/image/table_icon.png")).getScaledInstance(90, 50, Image.SCALE_SMOOTH);
                    icon = new ImageIcon(scaled);
                }catch(IOException io_ex){
                    io_ex.printStackTrace();
                }
                this.parent.tablebtn_list.get(table1-1).setIcon(icon);
            }
            
            
            
            // buông 2 bàn đã swap
            this.selectedtable_list.get(0).setSelected(false);
            this.selectedtable_list.get(1).setSelected(false);
            this.selectedtable_list.remove(0);
            this.selectedtable_list.remove(0);
            
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.dispose();
        }
    }//GEN-LAST:event_btnSwapActionPerformed

    private void btnMergeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMergeActionPerformed
        // TODO add your handling code here:
        if(this.selectedtable_list.size() == 2){
            int table1 = Integer.parseInt(this.selectedtable_list.get(0).getText());
            int table2 = Integer.parseInt(this.selectedtable_list.get(1).getText());
            
            String result = JOptionPane.showInputDialog("Which table you want to merge to? (" + table1 + " or " + table2 +")");
            if(result.isEmpty()){
                return;
            }
            
            int mergetable = Integer.parseInt(result);
            if(mergetable == table1){
                
            }
            if(mergetable == table2){
                
            }
        }
        
    }//GEN-LAST:event_btnMergeActionPerformed

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
            java.util.logging.Logger.getLogger(DiaSwapTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiaSwapTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiaSwapTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiaSwapTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DiaSwapTable dialog = new DiaSwapTable(new FrEmployeeWorkspace(null), true);
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
    private javax.swing.JButton btnMerge;
    private javax.swing.JButton btnSwap;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPanel pnTable;
    // End of variables declaration//GEN-END:variables




// CUSTOM DECLARATION VARIABLE
    FrEmployeeWorkspace parent;
    
    
    int Tablepn_width;
    int Tablepn_height;
    ArrayList<JToggleButton> table_list = new ArrayList<>();
    ArrayList<JToggleButton> selectedtable_list = new ArrayList<>();
// END CUSTOM DECLARATION VARIABLE
    
    
    
    
// CUSTOM CODE
    private void setTablePanelSize(){
        int tablerow_number;
        int tablecol_number = 4;
        
        if(this.parent.tableitem_number % 3 != 0){
            tablerow_number = (this.parent.tableitem_number/3) + 1;
        }else{
            tablerow_number = this.parent.tableitem_number/3;
        }

        Tablepn_width = (tablecol_number * 100) + ((tablecol_number-1) * 10);
        Tablepn_height = (tablerow_number * 45) + ((tablerow_number-1) * 10);
    }
    
    private void initOrderTable() {
        for(int i = 1; i <= this.parent.tableitem_number; i++){
            JToggleButton b = new JToggleButton();
            b.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
            b.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            ImageIcon icon = null;
            ImageIcon slicon = null;
            try{
                Image scaled = ImageIO.read(new File("src/image/table_icon.png")).getScaledInstance(90, 50, Image.SCALE_SMOOTH);
                icon = new ImageIcon(scaled);
                
                scaled = ImageIO.read(new File("src/image/swaptable_icon.png")).getScaledInstance(90, 50, Image.SCALE_SMOOTH);
                slicon = new ImageIcon(scaled);
            }catch(IOException io_ex){
                io_ex.printStackTrace();
            }
            b.setIcon(icon);
            b.setSelectedIcon(slicon);
            
            
            b.addActionListener((ActionEvent e) -> {
                if(b.isSelected() == false){
                    this.selectedtable_list.remove(b);
                }else{
                    if(this.selectedtable_list.size() < 2){
                        this.selectedtable_list.add(b);
                    }else{
                        this.selectedtable_list.get(0).setSelected(false);
                        this.selectedtable_list.remove(0);
                        this.selectedtable_list.add(b);
                    }
                }
            });
            
            
            b.setText(String.valueOf(i));
            b.setFont(b.getFont().deriveFont(14f).deriveFont(Font.BOLD));
            b.setSize(100, 50);
            b.setBackground(new Color(104, 104, 104));
            b.setForeground(new Color(106, 158, 237));
            this.pnTable.add(b);
            this.table_list.add(b);
        }
    }
    
    
    
    public void refreshTable(){
        for(int i = 0; i < this.parent.tablestate_list.size(); i++){
            switch(this.parent.tablestate_list.get(i)){
                case 0:
                    this.table_list.get(i).setBackground(new Color(104, 104, 104));
                    break;
                case 1:
                    this.table_list.get(i).setBackground(new Color(56, 216, 28));
                    break;
                case 2:
                    this.table_list.get(i).setBackground(new Color(175, 17, 17));
                    ImageIcon icon = null;
                    try{
                        Image scaled = ImageIO.read(new File("src/image/reserved_icon.png")).getScaledInstance(90, 50, Image.SCALE_SMOOTH);
                        icon = new ImageIcon(scaled);
                    }catch(IOException io_ex){
                        io_ex.printStackTrace();
                    }
                    this.table_list.get(i).setIcon(icon);
            }
        }
    }
// CUSTOM CODE
}
