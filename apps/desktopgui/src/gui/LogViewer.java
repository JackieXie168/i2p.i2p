/*
 * LogViewer.java
 *
 * Created on 10 april 2009, 19:17
 */

package gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.WindowConstants;

/**
 *
 * @author  mathias
 */
public class LogViewer extends javax.swing.JFrame {

    /** Creates new form LogViewer */
    public LogViewer() {
        initComponents();
        readLogText();
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
    
    private void readLogText() {
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                String s = "";
                File f = new File(LOGLOCATION);
                if(f.exists()) {
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(f));
                        while(true) {
                            String line = br.readLine();
                            if(line != null)
                                s += JTEXTNEWLINE + line;
                            else
                                break;
                        }
                    }
                    catch(Exception e) {
                        s = "An error has occurred while loading the logfiles:" + JTEXTNEWLINE + e.getMessage();
                    }
                }
                logText.setText(s);
            }
            
        });
        t.start();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textScroll = new javax.swing.JScrollPane();
        logText = new javax.swing.JTextArea();
        explanationText = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N

        textScroll.setName("textScroll"); // NOI18N

        logText.setColumns(20);
        logText.setRows(5);
        logText.setName("logText"); // NOI18N
        textScroll.setViewportView(logText);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(desktopgui.Main.class).getContext().getResourceMap(LogViewer.class);
        explanationText.setText(resourceMap.getString("explanationText.text")); // NOI18N
        explanationText.setName("explanationText"); // NOI18N

        refreshButton.setText(resourceMap.getString("refreshButton.text")); // NOI18N
        refreshButton.setName("refreshButton"); // NOI18N
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        clearButton.setText(resourceMap.getString("clearButton.text")); // NOI18N
        clearButton.setName("clearButton"); // NOI18N
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(explanationText, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(textScroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(refreshButton)
                .addGap(18, 18, 18)
                .addComponent(clearButton)
                .addContainerGap(587, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(explanationText, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshButton)
                    .addComponent(clearButton))
                .addGap(14, 14, 14)
                .addComponent(textScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
    File f = new File(LOGLOCATION);
    f.delete();
    try {
        f.createNewFile();//GEN-LAST:event_clearButtonActionPerformed
    } catch (IOException ex) {
        Logger.getLogger(LogViewer.class.getName()).log(Level.SEVERE, null, ex);
    }
    readLogText();
}

private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
    readLogText();
}//GEN-LAST:event_refreshButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel explanationText;
    private javax.swing.JTextArea logText;
    private javax.swing.JButton refreshButton;
    private javax.swing.JScrollPane textScroll;
    // End of variables declaration//GEN-END:variables

    private static final String LOGLOCATION = "wrapper.log";
    private static final String JTEXTNEWLINE = "\n";
}
