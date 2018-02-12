/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notreprojetjava;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACHAMBRI
 */
public class Accueil extends javax.swing.JFrame {

    /**
     * Creates new form Accueil
     */
    public Accueil() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GesionMission = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GesionMission.setText("Gestion Mission");
        GesionMission.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GesionMissionMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(330, Short.MAX_VALUE)
                .addComponent(GesionMission, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(197, Short.MAX_VALUE)
                .addComponent(GesionMission, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(169, 169, 169))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GesionMissionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GesionMissionMouseClicked
        // TODO add your handling code here:
        //REPRENDRE ICI RECUP DES INFO DANS L'ACCUEIL 
        //Instanciation des données présentent dans la doc CSV
        
        //Instanciation de CSVFileListeCompetences
        CSVFileListeCompetences maListComp = null;
        try {
            maListComp = new CSVFileListeCompetences();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
        }
        maListComp.recupCompetence();
        
        //Instanciation CSVFileListePersonnel
        CSVFileListePersonnel maListPerso = null;
        try {
            maListPerso = new CSVFileListePersonnel();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            maListPerso.recupEmployes();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Instanciation CSVFileCompetecesPersonnel
        CSVFileCompetencesPersonnel maListCompPerso = null;
        try {
            maListCompPerso = new CSVFileCompetencesPersonnel();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
        }
        maListCompPerso.recupCompetencesPersonnel(maListComp.getList(), maListPerso.getList());
        
        //Instanciation CSVFileListeMission
        CSVFileListeMission maListMission = null;
        try {
            maListMission = new CSVFileListeMission();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            maListMission.recupMission();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Instanciation CSVFileListeMissionPersonnel
        CSVFileListeMissionPersonnel maListMissionPerso = null;
        try {
            maListMissionPerso = new CSVFileListeMissionPersonnel();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
        }
        maListMissionPerso.recupPeronnel(maListMission.getList(),maListPerso.getList());
        
        //Instanciation CSVFileListeMissionCompetences
        CSVFileListeMissionCompetences maListMissionComp = null;
        try {
            maListMissionComp = new CSVFileListeMissionCompetences();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
        }
        maListMissionComp.RecupeCompRequise( maListMission.getList(), maListComp.getList());
       
        //Instanciation JFrame Mission 
        JMission frameMission = null;
        try {
            frameMission = new JMission(maListMission.getList());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
        }

        frameMission.setVisible(true);
        //problèmatique faire passer maListeMission dans JMission
       
    }//GEN-LAST:event_GesionMissionMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Accueil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GesionMission;
    // End of variables declaration//GEN-END:variables
}
