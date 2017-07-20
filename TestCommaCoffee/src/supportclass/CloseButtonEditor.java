/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supportclass;

import gui.FrEmployeeWorkspace;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author DELL
 */
public class CloseButtonEditor extends DefaultCellEditor {
  protected JButton button;
  private String label;
  private boolean isPushed;
  
  private FrEmployeeWorkspace parent;
  private JTable cur_table;
  private int cur_row;
  private int cur_col;

  public CloseButtonEditor(FrEmployeeWorkspace parent, JCheckBox checkBox) {
    super(checkBox);
    this.parent = parent;
    button = new JButton();
    button.setOpaque(true);
    button.addActionListener((ActionEvent e) -> {
        fireEditingStopped();
    });
  }

  @Override
  public Component getTableCellEditorComponent(JTable table, Object value,
      boolean isSelected, int row, int column) {
    if (isSelected) {
      button.setForeground(table.getSelectionForeground());
      button.setBackground(table.getSelectionBackground());
    } else {
      button.setForeground(table.getForeground());
      button.setBackground(table.getBackground());
    }
    label = (value == null) ? "" : value.toString();
    button.setText(label);
    this.cur_table = table;
    this.cur_col = column;
    this.cur_row = row;
    isPushed = true;
    return button;
  }

  @Override
  public Object getCellEditorValue() {
    if (isPushed) {
      // 
      // 
      //JOptionPane.showMessageDialog(button, label + ": Ouch!");
      
      // System.out.println(label + ": Ouch!");
    }
    isPushed = false;
    return new String(label);
  }

  @Override
  public boolean stopCellEditing() {
    isPushed = false;
    return super.stopCellEditing();
  }

  @Override
  protected void fireEditingStopped() {
    super.fireEditingStopped();
    if(this.cur_row % 2 == 0){
        this.parent.getOrderofTable(this.parent.cur_table).getValue().remove(this.cur_row/2);
        this.parent.getNoteofTable(this.parent.cur_table).getValue().remove((this.cur_row+1)/2);
        
        if(this.parent.getOrderofTable(this.parent.cur_table).getValue().isEmpty()){
            this.parent.setTableState(this.parent.cur_table, 0);
            this.parent.refreshTable();
        }
        this.parent.ShowCurrentOrderBill();
        this.parent.saveCurrentInfo(false);
    }else{
        JOptionPane.showMessageDialog(null, this.cur_table.getModel().getValueAt(this.cur_row, 0));
    }
    /*DefaultTableModel tbmodel = (DefaultTableModel) this.cur_table.getModel();
    tbmodel.removeRow(this.cur_row);*/
  }
}