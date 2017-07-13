/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supportclass;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author DELL
 */
public class RollLabel extends JLabel{
    private Timer tm;
    
    private String str_labeltext;
    private final String str_space = "                       ";
    
    
    public RollLabel() {
        this.str_labeltext = "My rolling text label";
        super.setText(this.str_labeltext + this.str_space);
        this.setLabelTextRoll_performed();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setText(String text) {
        this.str_labeltext = text + str_space;
        super.setText(this.str_labeltext); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    // The Jlabel text roll action
    // Method set timer and add actionlistener
    private void setLabelTextRoll_performed() {
        this.tm = new Timer(100, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                TimerActionPerformed(e);
            }
        });
        this.tm.start();
    }

    private void TimerActionPerformed(ActionEvent e){
        String lost = String.copyValueOf(super.getText().toCharArray(), 0, 1);
        String current = String.copyValueOf(super.getText().toCharArray(), 1, super.getText().length()-1);
        super.setText(current + lost);
    }
}
