/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import pojo.Student;

/**
 *
 * @author u55369
 */
public class Main {

    public static void main(String[] args) {

    }

    public static void addDetail(JPanel destPanel, String title, String value) {

        JLabel label = new JLabel(value);
        label.setBorder(new TitledBorder(title));
        
        destPanel.add(label);
        destPanel.updateUI();
    }

}
