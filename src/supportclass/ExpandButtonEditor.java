/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supportclass;

import gui.employee.DiaEditReceiptNoteDetails;
import gui.employee.FrEmployeeWorkspace;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author DELL
 */
public class ExpandButtonEditor extends DefaultCellEditor {
  protected JButton button;
  private String label;
  private boolean isPushed;
  
  private FrEmployeeWorkspace parent;
  private int selectedrow;
  
  public ExpandButtonEditor(FrEmployeeWorkspace parent, JCheckBox checkBox) {
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
    this.selectedrow = row;
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
    
    new DiaEditReceiptNoteDetails(this.parent, this.selectedrow, true).setVisible(true);
  }
}