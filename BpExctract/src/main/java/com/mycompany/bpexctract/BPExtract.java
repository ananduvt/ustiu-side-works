/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bpexctract;

import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author u55369
 */
public class BPExtract {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        processBP();
    }

    private static void processBP() {
        File inputFolder = new File("BP");
        List<BP> bpList = new ArrayList<>();

     
        for (File inputFile : inputFolder.listFiles()) {
            System.out.println("Processing : " + inputFile);
            bpList.add(extractData(inputFile));
        }

        try {
            CSVWriter cw = new CSVWriter(new FileWriter("Extract.csv"));
            String[] line = {"File Name", "BP", "Slotfor Preventive Care"};
            cw.writeNext(line);
               int i=0;
            for (BP bpObj : bpList) {

                System.out.println(++i + " : "+bpObj);
                line[0] = bpObj.getFileName();
                line[1] = bpObj.getBpName();
                line[2] = bpObj.getSlotgForPhysicianVisits();
                cw.writeNext(line);
            }
            cw.close();
        } catch (IOException ex) {
            Logger.getLogger(BPExtract.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static BP extractData(File inputFile) {

        BP bp = new BP();
        bp.setFileName(inputFile.getName());
        
        try {
            List fileContent = FileUtils.readLines(inputFile);
            for (Object obj : fileContent) {
                String line = (String) obj;

                if (line.contains("name")) {
                    bp.setBpName(line.split("name  ")[1].replaceAll("\"", ""));
                }

                if (line.contains("Slotfor Preventive Care")) {
                    int pos = fileContent.indexOf(line);
                    String bpc = "";
                    boolean found = true;
                    while (!bpc.contains("benefit plan component")) {

                        pos--;
                        if (pos == 0) {
                            found = false;
                            break;
                        }
                        bpc = (String) fileContent.get(pos);

                    }
                    if (found) {
                        bp.setSlotgForPhysicianVisits(bpc.split("benefit plan component ")[1].replaceAll("\"", ""));
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(BPExtract.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(bp);
        return bp;

    }

}
