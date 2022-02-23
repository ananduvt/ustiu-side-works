/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utc.creator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pojo.Claim;
import pojo.Line;
import pojo.Member;
import pojo.Subscription;

/**
 *
 * @author U55369
 */
public class processor {

    public static void main(String[] args) {

        ArrayList<Subscription> list = inputProc(new File("d:\\test\\input2.csv"));
        // System.out.println("Input Processing completed");
        //view(list);
        listWriter(outputClaimGen(list), new File("d:\\test\\output2.csv"));
        //System.out.println("claim write complete");
        //listWriter(outputMemGen(list), new File("d:\\test\\members2.csv"));
        // System.out.println("mem write complete");
    }

    public static ArrayList<String> outputMemGen(ArrayList<Subscription> list) {
        ArrayList<String> output = new ArrayList<>();
        int key = 1;

        String header = "SUBSCRIPTION_KEY,RELATION_TO_SUBSCRIBER,GENDER,DATE_OF_BIRTH,EFFECTIVE_START_DATE,BENEFIT_NETWORKS,PCP_KEY,UDT";
        output.add(header);

        for (Subscription s : list) {
            String head = String.valueOf(key);
            key++;
            output.add(head + blanks(8));
//            if (containsSelf(s)) {
            for (Member m : s.getMemberList()) {
                String cont = ",";

                if (m.getrCode().equals("01")) {
                    cont += "Self" + ",";
                } else if (m.getrCode().equals("18")) {
                    cont += "Spouse" + ",";
                } else if (m.getrCode().equals("19")) {
                    cont += "Child" + ",";
                } else {
                    cont += "Unknown" + ",";
                }

                cont += m.getGender() + ",";
                cont += m.getDob() + ",";
                cont += "1/1/16" + ",";
                cont += ",";
                cont += "1" + ",";
                cont += ",";

                output.add(cont);
            }
//            }
//            else
//            {
//                
//                
//            }
        }

        return output;
    }

    private static boolean containsSelf(Subscription subs) {
        for (Member memb : subs.getMemberList()) {
            if (memb.getrCode().equals("01")) {
                return true;
            }
        }

        return false;
    }

    public static ArrayList<String> outputClaimGen(ArrayList<Subscription> list) {
        int claimKey = 1;

        ArrayList<String> output = new ArrayList<>();

        String heading;

//        heading = "CLAIM_KEY,CLAIM_TYPE,SUPPLIER_HCC_ID,PRACTITIONER_HCC_ID,SUBSCRIPTION_KEY,"
//                + "MEMBER_KEY,ADMISSION_DATE,STATEMENT_START_DATE,STATEMENT_END_DATE,ADMIT_DIAGNOSIS_CODE,"
//                + "DIAGNOSIS_CODES,TOB,DISCHARGE_STATUS,LINE_KEY,POS,MODIFIERS,REVENUE_CODE,SERVICE_CODE,"
//                + "DIAGNOSIS_INDICIES,START_DATE,END_DATE,UNITS,FEE,CREATE_INPATIENT_AUTH,CREATE_OUTPATIENT_AUTH,COMMENT,";
        heading = "CLAIM_KEY,CLAIM_TYPE,TYPE_OF_TRANSACTION,SUPPLIER_KEY,LOCATION_KEY,SUPPLIER_HCC_ID,PRACTITIONER_KEY,"
                + "PRACTITIONER_HCC_ID,SUBSCRIPTION_KEY,MEMBER_KEY,GENDER,DATE_OF_BIRTH,EFFECTIVE_START_DATE,ADMISSION_DATE,"
                + "STATEMENT_START_DATE,STATEMENT_END_DATE,ADMIT_DIAGNOSIS_CODE,DIAGNOSIS_CODES,DRG_CODE,PROCEDURE_CODES,"
                + "CONDITION_CODES,TOB,DISCHARGE_STATUS,PLACE_OF_TREATMENT,EOB_CLAIM_ID,EOB_DATE,LINE_KEY,POS,MODIFIERS,"
                + "ORAL_CAVITY,TOOTH_SYSTEM,TOOTH_NUMBERS,TOOTH_SURFACES,PROCEDURE_DATE,REVENUE_CODE,SERVICE_CODE,"
                + "DIAGNOSIS_INDICIES,START_DATE,END_DATE,UNITS,FEE,EOB_ALLOWED_AMOUNT,EOB_NET_PAID_AMOUNT,REPRICER_NAME,"
                + "REPRICER_DECISION,REPRICER_AMOUNT,REPRICER_BENEFIT_NETWORK,CREATE_INPATIENT_AUTH,CREATE_OUTPATIENT_AUTH,COMMENT";

        output.add(heading);

        int subKey = 0;
        int membKey = 0;

        for (Subscription s : list) {

            subKey++;
            membKey = 0;

            for (Member m : s.getMemberList()) {

                membKey++;
                
                 ArrayList<String> authList = new ArrayList<>();

                for (Claim c : m.getClaimList()) {

                    String header = "";
                    header += String.valueOf(claimKey) + ",";
                    claimKey++;

                    if (c.getType().equals("HCFA")) {
                        header += c.getType() + ",";

                        header += blanks(3);

                        header += c.getFacTin() + ",";

                        header += blanks(1);

                        if (c.getRefProNPI().equals("Null")) {
                            header += ",";
                        } else {
                            header += c.getRefProNPI() + ",";
                        }
                        header += String.valueOf(subKey) + ",";
                        header += String.valueOf(membKey) + ",";

                        header += blanks(3);

                        header += blanks(4);
                        header += c.getPrimDiag() + ",";
                        header += blanks(32);

                        output.add(header);

                    } else if (c.getType().equals("UB")) {

                        header += c.getType() + ",";

                        header += blanks(3);

                        header += c.getFacTin() + ",";

                        header += blanks(1);

                        header += ",";

                        header += String.valueOf(subKey) + ",";
                        header += String.valueOf(membKey) + ",";

                        header += blanks(3);

                        header += c.getAddDate() + ",";
                        header += c.getAddDate() + ",";

                        header += c.getDisDate()+ ",";

                        header += c.getPrimDiag() + ",";
                        header += c.getPrimDiag() + ",";

                        header += blanks(3);

                        header += c.getBillType() + ",";
                        header += c.getDisStatus() + ",";

                        header += blanks(3);

                        output.add(header);
                    } else {

                        System.err.println("Unknown claim type");
                    }            

                    for (Line l : c.getLineList()) {

                        StringBuffer line = new StringBuffer();
                        line.append(blanks(26));

                        if (c.getType().equals("HCFA")) {

                            line.append(l.getLineNumber() + ",");
                            line.append(c.getPos() + ",");

                            if (l.getCpt4Modifier().equals("Null")) {
                                line.append(",");
                            } else {
                                line.append(l.getCpt4Modifier() + ",");
                            }

                            line.append(blanks(5));

                            line.append(",");

                            if (l.getCpt4Code().equals("Null")) {
                                line.append("," + ",");
                            } else {
                                line.append(l.getCpt4Code() + ",");
                            }

                            line.append("1" + ",");
                            line.append(l.getServFromDate() + ",");
                            line.append(l.getServToDate() + ",");
                            line.append(l.getUnits() + ",");
                            line.append(l.getSubAmount() + ",");

                            line.append(blanks(6));

                            line.append(blanks(2));
                            line.append(c.getNumber());

                            output.add(line.toString());

                        } else if (c.getType().equals("UB")) {

                            line.append(l.getLineNumber() + ",");
                            line.append(",");

                            if (l.getCpt4Modifier().equals("Null")) {
                                line.append(",");
                            } else {
                                line.append(l.getCpt4Modifier() + ",");
                            }

                            line.append(blanks(5));

                            line.append(l.getRevCode() + ",");

                            if (l.getCpt4Code().equals("Null")) {
                                line.append(",");
                            } else {
                                line.append(l.getCpt4Code() + ",");
                            }

                            line.append("1" + ",");
                            line.append(l.getServFromDate() + ",");
                            line.append(l.getServToDate() + ",");
                            line.append(l.getUnits() + ",");
                            line.append(l.getSubAmount() + ",");

                            line.append(blanks(6));

                            // inpatient 
                            if (c.getBillType().startsWith("11") || c.getBillType().startsWith("2") || c.getBillType().startsWith("12")) {

                                if (!authList.contains(l.getRevCode()  )) {

                                    line.append("Y" + ",");
                                } else {
                                    line.append(",");
                                }
                            } else {
                                line.append(",");
                            }

                            // outpatient 
                            if (!l.getAuthNumber().equals("Null")) {

                                if (c.getBillType().startsWith("11") || c.getBillType().startsWith("2") || c.getBillType().startsWith("12")) {

                                    line.append(",");
                                } else {

                                    if (!authList.contains(l.getRevCode() )) {

                                        line.append("Y" + ",");

                                    } else {
                                        line.append(",");
                                    }
                                }
                            } else {
                                line.append(",");
                            }

                            line.append(c.getNumber());

                            output.add(line.toString());
                        } else {
                            System.err.println("Unknown claim type");
                        }

                        authList.add(l.getRevCode() );

                    }
                }
            }
        }

        return output;

    }

    public static String blanks(int n) {

        String word = "";

        for (int i = 0; i < n; i++) {
            word = word + ",";

        }
        return word;
    }

    public static void listWriter(ArrayList<String> list, File output) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output)));

            for (String line : list) {
                bw.append(line);
                bw.newLine();
            }

            bw.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Please close the "
                    + output
                    + " -  output file and Try Again ", " Output File Already Open  !!! ", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(processor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<Subscription> inputProc(File input) {
        ArrayList<Subscription> subsList = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(input)));
            String line = br.readLine();

            line = br.readLine();
            while (line != null) {

                String subid = line.split(",")[0];
                Subscription subs = new Subscription();
                subs.setId(subid);

                ArrayList<Member> membList = new ArrayList<>();

                String memid = "";

                while (line != null && line.split(",")[0].equals(subid)) {

                    System.out.println("line : "+  line );
                    if (memid.equals(line.split(",")[1])) {
                        line = br.readLine();
                    } else {
                        memid = line.split(",")[1];
                        Member memb = new Member();
                        memb.setId(memid);
                        memb.setDob(line.split(",")[2]);
                        memb.setGender(line.split(",")[3]);
                        memb.setrCode(line.split(",")[4]);

                        ArrayList<Claim> claimList = new ArrayList<>();
                        String claimno = "";

                        while (line != null && line.split(",")[1].equals(memid)) {

                            if (claimno.equals(line.split(",")[5])) {
                                line = br.readLine();
                            } else {
                                claimno = line.split(",")[5];

                                Claim claim = new Claim();
                                claim.setNumber(claimno);
                                claim.setType(line.split(",")[6]);
                                claim.setPos(line.split(",")[7]);
                                claim.setAddDate(line.split(",")[8]);
                                claim.setDisDate(line.split(",")[9]);
                                claim.setPrimDiag(line.split(",")[10]);
                                claim.setDisStatus(line.split(",")[11]);
                                claim.setFacTin(line.split(",")[12]);
                                claim.setRefProNPI(line.split(",")[13]);
                                claim.setBillType(line.split(",")[14]);

                                ArrayList<Line> lineList = new ArrayList<>();
                                String lineno = "";

                                while (line != null && line.split(",")[5].equals(claimno)) {

                                    if (lineno.equals(line.split(",")[15])) {
                                        line = br.readLine();
                                    } else {
                                        lineno = line.split(",")[15];

                                        Line l = new Line();
                                        l.setLineNumber(lineno);
                                        l.setServFromDate(line.split(",")[16]);
                                        l.setServToDate(line.split(",")[17]);
                                        l.setRevCode(line.split(",")[18]);
                                        l.setCpt4Code(line.split(",")[19]);
                                        l.setCpt4Modifier(line.split(",")[20]);
                                        l.setUnits(line.split(",")[21]);
                                        l.setSubAmount(line.split(",")[22]);
                                        l.setAuthNumber(line.split(",")[23]);

                                        lineList.add(l);
                                    }
                                }

                                claim.setLineList(lineList);
                                //System.out.println(claim);
                                claimList.add(claim);
                            }

                        }
                        memb.setClaimList(claimList);
                        membList.add(memb);

                    }

                }
                subs.setMemberList(membList);

                subsList.add(subs);

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(processor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(processor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return subsList;
    }

    public static void view(ArrayList<Subscription> list) {
        for (Subscription s : list) {
            System.out.println(s);
            //System.out.println("Subs : " + s.getId());

            for (Member m : s.getMemberList()) {
                System.out.println(m);

                // System.out.println("memb : " + m.getId());
                for (Claim c : m.getClaimList()) {
                    System.out.println(c);

                    for (Line l : c.getLineList()) {
                        System.out.println(l);
                    }
                }
            }
        }
    }
}
