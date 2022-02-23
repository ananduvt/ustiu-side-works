/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ust.credman;

import POJO.AppProps;
import POJO.Credential;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author u55369
 */
public class MainUi extends javax.swing.JFrame {

    /**
     * Creates new form MainUi
     */
    private AppProps appProps;
    private String APP_PASSWORD;

    public MainUi() {
        initComponents();
        mainUIInit();

    }

    private void mainUIInit() {
        setIconImage(getIcon().getImage());
        this.setVisible(false);

        if (Util.isFirst()) {
            initDialog.setVisible(true);
        } else {
            lockDialog.setVisible(true);
            appProps = Util.loadConfigFile(Global.CONFIG_FILE);
            APP_PASSWORD = appProps.getProperties().getProperty(Global.APP_PASSWORD);
        }

    }

    private ImageIcon getIcon() {
        ImageIcon imageIcon = new ImageIcon("res/icon.png");
        return imageIcon;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lockDialog = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        lockPassword = new javax.swing.JPasswordField();
        lockDg_Enter = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        initDialog = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        initPass = new javax.swing.JPasswordField();
        initPassConfirm = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        initCryptKey = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        initCryptKeyConfirm = new javax.swing.JPasswordField();
        initSave = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        passOk = new javax.swing.JLabel();
        keyOk = new javax.swing.JLabel();
        addCredDialog = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Key = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        MainPanel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        credentialsPanel = new javax.swing.JPanel();
        linksPanel = new javax.swing.JPanel();
        propertiesPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        addLink = new javax.swing.JMenu();
        addCredMenu = new javax.swing.JMenuItem();
        addLinkMenu = new javax.swing.JMenuItem();
        lockMenu = new javax.swing.JMenu();

        lockDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        lockDialog.setTitle("Credential Manager");
        lockDialog.setAlwaysOnTop(true);
        lockDialog.setIconImage(getIcon().getImage());
        lockDialog.setMinimumSize(new java.awt.Dimension(400, 300));
        lockDialog.setName("Lock"); // NOI18N
        lockDialog.setResizable(false);
        lockDialog.setType(java.awt.Window.Type.UTILITY);
        lockDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                lockDialogWindowClosed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        lockPassword.setBackground(new java.awt.Color(51, 51, 51));
        lockPassword.setForeground(new java.awt.Color(255, 255, 255));
        lockPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lockPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lockPasswordActionPerformed(evt);
            }
        });

        lockDg_Enter.setText("Enter");
        lockDg_Enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lockDg_EnterActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Enter the Password");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(lockPassword, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lockDg_Enter))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lockPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lockDg_Enter)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout lockDialogLayout = new javax.swing.GroupLayout(lockDialog.getContentPane());
        lockDialog.getContentPane().setLayout(lockDialogLayout);
        lockDialogLayout.setHorizontalGroup(
            lockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        lockDialogLayout.setVerticalGroup(
            lockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        initDialog.setMinimumSize(new java.awt.Dimension(400, 300));
        initDialog.setType(java.awt.Window.Type.UTILITY);
        initDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                initDialogWindowClosing(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        initPass.setBackground(new java.awt.Color(51, 51, 51));
        initPass.setForeground(new java.awt.Color(255, 255, 255));
        initPass.setCaretColor(new java.awt.Color(255, 255, 255));
        initPass.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                initPassCaretUpdate(evt);
            }
        });
        initPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initPassActionPerformed(evt);
            }
        });

        initPassConfirm.setBackground(new java.awt.Color(51, 51, 51));
        initPassConfirm.setForeground(new java.awt.Color(255, 255, 255));
        initPassConfirm.setCaretColor(new java.awt.Color(255, 255, 255));
        initPassConfirm.setEnabled(false);
        initPassConfirm.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                initPassConfirmCaretUpdate(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enter Password :");

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Confirm Password :");

        initCryptKey.setBackground(new java.awt.Color(51, 51, 51));
        initCryptKey.setForeground(new java.awt.Color(255, 255, 255));
        initCryptKey.setCaretColor(new java.awt.Color(255, 255, 255));
        initCryptKey.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                initCryptKeyCaretUpdate(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Enter Encryption Key :");

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Confirm Encryption Key :");

        initCryptKeyConfirm.setBackground(new java.awt.Color(51, 51, 51));
        initCryptKeyConfirm.setForeground(new java.awt.Color(255, 255, 255));
        initCryptKeyConfirm.setCaretColor(new java.awt.Color(255, 255, 255));
        initCryptKeyConfirm.setEnabled(false);
        initCryptKeyConfirm.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                initCryptKeyConfirmCaretUpdate(evt);
            }
        });

        initSave.setText("Save");
        initSave.setEnabled(false);
        initSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initSaveActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(51, 51, 51));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Initializing Credential Manager");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(initSave)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(initCryptKey, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(initCryptKeyConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(initPass, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(initPassConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passOk, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                            .addComponent(keyOk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(38, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(110, 110, 110))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(initPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(initPassConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(passOk, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(initCryptKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(initCryptKeyConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(keyOk, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(initSave)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout initDialogLayout = new javax.swing.GroupLayout(initDialog.getContentPane());
        initDialog.getContentPane().setLayout(initDialogLayout);
        initDialogLayout.setHorizontalGroup(
            initDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        initDialogLayout.setVerticalGroup(
            initDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("User Name : ");

        jLabel8.setText("Next Key : ");

        jLabel9.setText("Password : ");

        Key.setText("Next Key : ");

        jButton1.setText("Add Credential");

        jLabel10.setText("Credential Name : ");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Key, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Key)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout addCredDialogLayout = new javax.swing.GroupLayout(addCredDialog.getContentPane());
        addCredDialog.getContentPane().setLayout(addCredDialogLayout);
        addCredDialogLayout.setHorizontalGroup(
            addCredDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addCredDialogLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 53, Short.MAX_VALUE))
        );
        addCredDialogLayout.setVerticalGroup(
            addCredDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Credential Manager");
        setAlwaysOnTop(true);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });

        MainPanel.setBackground(new java.awt.Color(51, 51, 51));

        credentialsPanel.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout credentialsPanelLayout = new javax.swing.GroupLayout(credentialsPanel);
        credentialsPanel.setLayout(credentialsPanelLayout);
        credentialsPanelLayout.setHorizontalGroup(
            credentialsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        credentialsPanelLayout.setVerticalGroup(
            credentialsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Credentials ", credentialsPanel);

        linksPanel.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout linksPanelLayout = new javax.swing.GroupLayout(linksPanel);
        linksPanel.setLayout(linksPanelLayout);
        linksPanelLayout.setHorizontalGroup(
            linksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        linksPanelLayout.setVerticalGroup(
            linksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Links ", linksPanel);

        propertiesPanel.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout propertiesPanelLayout = new javax.swing.GroupLayout(propertiesPanel);
        propertiesPanel.setLayout(propertiesPanelLayout);
        propertiesPanelLayout.setHorizontalGroup(
            propertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        propertiesPanelLayout.setVerticalGroup(
            propertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Properties", propertiesPanel);

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        jMenuBar1.setBackground(new java.awt.Color(51, 51, 51));
        jMenuBar1.setForeground(new java.awt.Color(51, 51, 51));

        addLink.setText("New");
        addLink.setToolTipText("Create New Credential");
        addLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLinkActionPerformed(evt);
            }
        });

        addCredMenu.setText("Credential");
        addCredMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCredMenuActionPerformed(evt);
            }
        });
        addLink.add(addCredMenu);

        addLinkMenu.setText("Link");
        addLinkMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLinkMenuActionPerformed(evt);
            }
        });
        addLink.add(addLinkMenu);

        jMenuBar1.add(addLink);

        lockMenu.setText("Lock App");
        lockMenu.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                lockMenuMenuSelected(evt);
            }
        });
        jMenuBar1.add(lockMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLinkActionPerformed

    }//GEN-LAST:event_addLinkActionPerformed

    private void lockDialogWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_lockDialogWindowClosed
        // TODO add your handling code here:
        System.out.println("Window Closed");
        this.dispose();
    }//GEN-LAST:event_lockDialogWindowClosed

    private void lockDg_EnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lockDg_EnterActionPerformed
        unlockApp();
    }//GEN-LAST:event_lockDg_EnterActionPerformed

    private void lockPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lockPasswordActionPerformed
        unlockApp();
    }//GEN-LAST:event_lockPasswordActionPerformed

    private void unlockApp() {

      //  System.out.println(String.valueOf(lockPassword.getPassword()) + " : " + APP_PASSWORD);
        
      if (String.valueOf(lockPassword.getPassword()).equals(APP_PASSWORD)) {
            lockDialog.setVisible(false);
            this.setVisible(true);

        } else {
            System.out.println("Invalid Password");
        }

    }

    private void initPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_initPassActionPerformed

    private void initSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initSaveActionPerformed
        // TODO add your handling code here:     
        initDialog.dispose();
        Properties prop = new Properties();
        prop.put(Global.APP_PASSWORD, String.valueOf(initPass.getPassword()));
        prop.put(Global.APP_CRYPT_KEY, String.valueOf(initCryptKey.getPassword()));

        appProps = new AppProps();
        appProps.setProperties(prop);
        appProps.setCredList(new ArrayList<Credential>());

        Util.createConfigFile(Global.CONFIG_FILE, appProps);
        this.setVisible(true);
    }//GEN-LAST:event_initSaveActionPerformed

    private void initPassConfirmCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_initPassConfirmCaretUpdate

        if (!String.valueOf(initPass.getPassword()).equals("")) {
            if (String.valueOf(initPass.getPassword()).equals(String.valueOf(initPassConfirm.getPassword()))) {
                passOk.setText("✔");
                if (keyOk.getText().equals("✔")) {
                    initSave.setEnabled(true);
                }
            } else {
                passOk.setText("✘");
                initSave.setEnabled(false);
            }
        }
    }//GEN-LAST:event_initPassConfirmCaretUpdate

    private void initPassCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_initPassCaretUpdate

        initPassConfirmCaretUpdate(evt);

        if (!String.valueOf(initPass.getPassword()).equals("")) {
            initPassConfirm.setEnabled(true);
        } else {
            initPassConfirm.setEnabled(false);
            initPassConfirm.setText("");
            passOk.setText("");
        }
    }//GEN-LAST:event_initPassCaretUpdate

    private void initCryptKeyConfirmCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_initCryptKeyConfirmCaretUpdate
        if (!String.valueOf(initCryptKey.getPassword()).equals("")) {
            if (String.valueOf(initCryptKey.getPassword()).equals(String.valueOf(initCryptKeyConfirm.getPassword()))) {
                keyOk.setText("✔");
                if (passOk.getText().equals("✔")) {
                    initSave.setEnabled(true);
                }
            } else {
                keyOk.setText("✘");
                initSave.setEnabled(false);
            }
        }
    }//GEN-LAST:event_initCryptKeyConfirmCaretUpdate

    private void initCryptKeyCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_initCryptKeyCaretUpdate

        initCryptKeyConfirmCaretUpdate(evt);

        if (!String.valueOf(initCryptKey.getPassword()).equals("")) {
            initCryptKeyConfirm.setEnabled(true);
        } else {
            initCryptKeyConfirm.setEnabled(false);
            initCryptKeyConfirm.setText("");
            passOk.setText("");
        }

    }//GEN-LAST:event_initCryptKeyCaretUpdate

    private void initDialogWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_initDialogWindowClosing

        initDialog.dispose();
        this.dispose();
    }//GEN-LAST:event_initDialogWindowClosing

    private void lockMenuMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_lockMenuMenuSelected
        lockApp();
    }//GEN-LAST:event_lockMenuMenuSelected

    private void addLinkMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLinkMenuActionPerformed


    }//GEN-LAST:event_addLinkMenuActionPerformed

    private void addCredMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCredMenuActionPerformed

        Credential cred = new Credential();
        cred.setCredentialName("Test cred");
        cred.setId("test Pass");

        appProps.getCredList().add(cred);
        Util.createConfigFile(Global.CONFIG_FILE, appProps);
    }//GEN-LAST:event_addCredMenuActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        System.out.println("Window Focus Lost");
        startLockMonitor();
    }//GEN-LAST:event_formWindowLostFocus

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        System.out.println("Window Focus Gained");
        stopLockMonitor();
    }//GEN-LAST:event_formWindowGainedFocus

    private void lockApp() {
        System.out.println("App Locked");
        lockPassword.setText("");
        this.setVisible(false);
        lockDialog.setVisible(true);
    }

    private Thread monitorThread;

    private void startLockMonitor() {
        if (monitorThread != null) {
            monitorThread.stop();
        }
        monitorThread = new Thread() {
            @Override
            public void run() {
                long start = new Date().getTime();
                long now = new Date().getTime();

                while ((now - start) < Global.LOCK_TIME) {

                    try {
                        Thread.sleep(50);
                        now = new Date().getTime();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MainUi.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                lockApp();
            }
        };
        monitorThread.start();
    }

    private void stopLockMonitor() {
       if (monitorThread != null) {
            monitorThread.stop();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUi().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Key;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JDialog addCredDialog;
    private javax.swing.JMenuItem addCredMenu;
    private javax.swing.JMenu addLink;
    private javax.swing.JMenuItem addLinkMenu;
    private javax.swing.JPanel credentialsPanel;
    private javax.swing.JPasswordField initCryptKey;
    private javax.swing.JPasswordField initCryptKeyConfirm;
    private javax.swing.JDialog initDialog;
    private javax.swing.JPasswordField initPass;
    private javax.swing.JPasswordField initPassConfirm;
    private javax.swing.JButton initSave;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel keyOk;
    private javax.swing.JPanel linksPanel;
    private javax.swing.JButton lockDg_Enter;
    private javax.swing.JDialog lockDialog;
    private javax.swing.JMenu lockMenu;
    private javax.swing.JPasswordField lockPassword;
    private javax.swing.JLabel passOk;
    private javax.swing.JPanel propertiesPanel;
    // End of variables declaration//GEN-END:variables
}