package com.sensepost.yeti.gui;

import javax.swing.JOptionPane;
import com.sensepost.yeti.common.ConfigSettings;
import com.sensepost.yeti.common.Globals;
import com.sensepost.yeti.common.UtilFunctions;
import com.sensepost.yeti.models.FootprintModel;
import com.sensepost.yeti.results.FootprintData;
import com.sensepost.yeti.persistence.DataStore;

/**
 *
 * @author willemmouton
 */
public class SelectFootprint extends BaseDlg {

    /**
     * Creates new form selectFootprint
     */
    public SelectFootprint() {
        initComponents();
        setLocationRelativeTo(null);
        setModalityType(ModalityType.APPLICATION_MODAL);
        FootprintModel model = new FootprintModel();
        tblFootprints.setModel(model);

        int dbType = ConfigSettings.getDBType();
        if (dbType != 0) {
            btnOpenDB.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFootprints = new javax.swing.JTable();
        btnClose = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnOpenDB = new javax.swing.JButton();

        setTitle("Select footprint"); // NOI18N
        setName("Form"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Availible footprints"));
        jPanel1.setName("jPanel1"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tblFootprints.setAutoCreateRowSorter(true);
        tblFootprints.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblFootprints.setName("tblFootprints"); // NOI18N
        tblFootprints.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblFootprints.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFootprintsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFootprints);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
        );

        btnClose.setText("Select"); // NOI18N
        btnClose.setName("btnClose"); // NOI18N
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnNew.setText("New"); // NOI18N
        btnNew.setName("btnNew"); // NOI18N
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnOpenDB.setText("Open database"); // NOI18N
        btnOpenDB.setName("btnOpenDB"); // NOI18N
        btnOpenDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenDBActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(btnOpenDB)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 90, Short.MAX_VALUE)
                .add(btnNew)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(btnClose)
                .addContainerGap())
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnClose)
                    .add(btnNew)
                    .add(btnOpenDB))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        String name = JOptionPane.showInputDialog(null, "Footprint name");
        if (name != null && !name.isEmpty()) {
            int footprintId = DataStore.addFootprint(name);
            if (footprintId != -1) {
                Globals.setCurrentFootprintId(footprintId);
                Globals.setCurrentFootprintName(name);
                ((FootprintModel) tblFootprints.getModel()).reload();
                new StartFootprintInit().setVisible(true);
            }
        }
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        if (tblFootprints.getSelectedRowCount() == 1) {
            FootprintData fpd = ((FootprintData) ((FootprintModel) this.tblFootprints.getModel()).valueAt(this.tblFootprints.getSelectedRow()));
            Globals.setCurrentFootprintId(fpd.getId());
            Globals.setCurrentFootprintName(fpd.getName());
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Please create or select a footprint.");
        }
    }//GEN-LAST:event_btnCloseActionPerformed

    private void tblFootprintsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFootprintsMouseClicked
        if (evt.getClickCount() == 2) {
            btnCloseActionPerformed(null);
        }
    }//GEN-LAST:event_tblFootprintsMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (Globals.getCurrentFootprintId() == -1) {
            JOptionPane.showMessageDialog(this, "No footprint selected, Yeti will now terminate.");
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnOpenDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenDBActionPerformed
        String filename;
        if (!(filename = UtilFunctions.openFile("*.db")).isEmpty()) {
            ((FootprintModel) tblFootprints.getModel()).reload();
            ConfigSettings.saveChanges();
        }

    }//GEN-LAST:event_btnOpenDBActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnOpenDB;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFootprints;
    // End of variables declaration//GEN-END:variables

}
