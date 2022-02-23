/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customStream;

import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 *
 * @author u55369
 */
public class CustomOutputStream extends OutputStream {

    private PrintStream defStream;
    private JTextPane jTextPane;
    private boolean isError;

    private String prefix = "-> ";
    private boolean first = true;
    private boolean newLine = false;

    private Color fgColor;
    private Color errorColor = Color.red;

    public CustomOutputStream(PrintStream defStream, JTextPane jTextPane, boolean isError) {

        this.defStream = defStream;
        this.jTextPane = jTextPane;
        this.isError = isError;
        this.fgColor = jTextPane.getForeground();
    }

    @Override
    public void write(int b) throws IOException {

        if (first || newLine) {
            defStream.print(prefix);
            if (isError) {
                appendToPane(jTextPane, String.valueOf((char) b), errorColor);
            } else {
                appendToPane(jTextPane, String.valueOf((char) b), fgColor);
            }
            newLine = false;
        }

        defStream.print((char) b);
        if (isError) {
            appendToPane(jTextPane, String.valueOf((char) b), errorColor);
        } else {
            appendToPane(jTextPane, String.valueOf((char) b), fgColor);
        }

        if (b == 10) {
            newLine = true;
        }
        first = false;
    }

    private void appendToPane(JTextPane tp, String msg, Color c) {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

        //aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        int len = tp.getDocument().getLength();
        tp.setCaretPosition(len);
        tp.setCharacterAttributes(aset, false);
        tp.replaceSelection(msg);
    }
}
