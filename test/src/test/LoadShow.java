/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.sun.prism.impl.PrismSettings;
import java.awt.Color;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author u55369
 */
public class LoadShow {

    private JDialog dialog;
    private JPanel panel;
    private JLabel label;

    public LoadShow() {
        dialog = new JDialog();
        label = new JLabel();
        panel = new JPanel();
    }

    private void show() {
        dialog.setSize(300, 300);
        dialog.setResizable(false);
        panel.setBackground(new Color(51, 51, 51));

        label.setForeground(Color.WHITE);
        label.setText("Loading");

        panel.add(label);
        dialog.add(panel);

        dialog.setVisible(true);
    }

    private void close() {
        dialog.dispose();
    }

    public static void main(String[] args) throws InterruptedException {
        LoadShow loadShow = new LoadShow();
        loadShow.show();
        // Thread.sleep(5000);
        //loadShow.close();
    }

}
