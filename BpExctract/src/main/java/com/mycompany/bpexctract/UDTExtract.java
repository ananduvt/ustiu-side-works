/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bpexctract;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author u55369
 */
public class UDTExtract {

    public static void main(String[] args) {
        File inputDir = new File("udtbp");
        File output = new File("results.csv");
        List<String> results = new ArrayList<>();

        String header = "File Name,Cont1,Cont2,Cont3";
        results.add(header);

        for (File inputFile : inputDir.listFiles()) {
            System.out.println("Processing : " + inputFile.getName());
            results.add(extractUDT(inputFile));
        }
        try {
            Files.write(output.toPath(), results, Charset.defaultCharset());
        } catch (IOException ex) {
            Logger.getLogger(UDTExtract.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static String extractUDT(File inputFile) {
        String result = "";
        try {
            List<String> fileContent = Files.readAllLines(inputFile.toPath());

            for (String line : fileContent) {
                if (line.trim().contains("benefit plan user defined terms")) {
                    int linePosition = fileContent.indexOf(line);
                    result = inputFile.getName() + ","
                            + line.trim() + ","
                            + fileContent.get(++linePosition).trim() + ","
                            + fileContent.get(++linePosition).trim();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(UDTExtract.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
