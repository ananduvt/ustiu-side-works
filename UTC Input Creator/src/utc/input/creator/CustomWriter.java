/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utc.input.creator;

import java.util.Set;
import org.pmw.tinylog.Configuration;
import org.pmw.tinylog.LogEntry;
import org.pmw.tinylog.writers.LogEntryValue;

/**
 *
 * @author u55369
 */
public class CustomWriter implements org.pmw.tinylog.writers.Writer{

    private javax.swing.JTextArea textArea;
    
    public CustomWriter(javax.swing.JTextArea textArea) {
        
        this.textArea = textArea;
    }

    @Override
    public Set<LogEntryValue> getRequiredLogEntryValues() {
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void init(Configuration c) throws Exception {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void write(LogEntry le) throws Exception {
        
       textArea.append(le.getLevel()+" : "+le.getMessage()+"\n");
        //System.out.println("log : " + le.getLevel());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void flush() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
