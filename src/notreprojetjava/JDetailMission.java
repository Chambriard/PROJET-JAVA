/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notreprojetjava;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACHAMBRI
 */
public class JDetailMission extends javax.swing.JFrame {

    /**
     * Creates new form JDetailMission
     */
    static Mission maMission ;
    static ArrayList<Employe> lesEmployes ;
    static ArrayList<Competence> jtableEnsembleComp ;
    public JDetailMission(Mission uneMission,ArrayList<Employe> lesEmployes,ArrayList<Competence> lesComp) {
        initComponents();
        
//        //init competences
//        CSVFileListeCompetences maListComp = null;
//        try {
//            maListComp = new CSVFileListeCompetences();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        maListComp.recupCompetence();
//        
//        //init employes
//        CSVFileListePersonnel maListPerso = null;
//        try {
//            maListPerso = new CSVFileListePersonnel();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            maListPerso.recupEmployes();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ParseException ex) {
//            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        //instancie compétence 
//        CSVFileCompetencesPersonnel maListCompPerso = null;
//        try {
//            maListCompPerso = new CSVFileCompetencesPersonnel();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        maListCompPerso.recupCompetencesPersonnel(maListComp.getList(), maListPerso.getList());
        this.lesEmployes = lesEmployes;
        this.jtableEnsembleComp = lesComp;
        this.maMission = uneMission;
        
        id.setText(uneMission.getId());
        id.setEditable(false);
        
        //DATE :
        SimpleDateFormat formatterJ = new SimpleDateFormat("dd");
        SimpleDateFormat formatterM = new SimpleDateFormat("MM");
        SimpleDateFormat formatterA = new SimpleDateFormat("yyyy");
        dateDebJ.setText(formatterJ.format(maMission.getDateDeb()));
        dateDebM.setText(formatterM.format(maMission.getDateDeb()));
        dateDebA.setText(formatterA.format(maMission.getDateDeb()));
        dateFinJ.setText(formatterJ.format(maMission.getDateFin()));
        dateFinM.setText(formatterM.format(maMission.getDateFin()));
        dateFinA.setText(formatterA.format(maMission.getDateFin()));
        
        
        
        DefaultTableModel modelEmp = new DefaultTableModel();
        modelEmp.addColumn("id");
        modelEmp.addColumn("Nom");
        modelEmp.addColumn("Prenom");
        for(Employe monEmpDuCSVFile : lesEmployes){
            boolean missione = false ;
            Iterator<Employe>  monEmpDeLaMission  = maMission.equipeMission.iterator();
            while(monEmpDeLaMission.hasNext() && !missione){
                if(monEmpDuCSVFile.getId().equals(monEmpDeLaMission.next().getId())){
                    missione = true;
                }
            }
            if(!missione){
                modelEmp.addRow(new String[]{monEmpDuCSVFile.getId(), monEmpDuCSVFile.getNom(),monEmpDuCSVFile.getPrenom()});
            }
        }
        lesEmp.setModel(modelEmp);
        
        DefaultTableModel modelEmpMiss = new DefaultTableModel();
        modelEmpMiss.addColumn("id");
        modelEmpMiss.addColumn("Nom");
        modelEmpMiss.addColumn("Prenom");
        for(Employe monEmp : maMission.equipeMission){
            modelEmpMiss.addRow(new String[]{monEmp.getId(), monEmp.getNom(),monEmp.getPrenom()});
        }
        
        lesEmpDeLaMiss.setModel(modelEmpMiss);
        
        DefaultTableModel modelCompMission = new DefaultTableModel();
        modelCompMission.addColumn("id");
        modelCompMission.addColumn("libelle");
        modelCompMission.addColumn("Requis");
        for(HashMap.Entry<Competence,Integer> entry : maMission.CompReq.entrySet()){
            Competence key = entry.getKey();
            Integer value = entry.getValue();
            for(Employe monEmp : maMission.equipeMission){
                if(monEmp.getCompetences().contains(key)){
                    value = value - 1 ;
                }
            }
            if(value < 1){
                value = 0 ;
            }
            modelCompMission.addRow(new String[]{key.getId(), key.getNomFra(),value.toString()});
            
        }
        compMission.setModel(modelCompMission);
        
        DefaultTableModel modelLesComp = new DefaultTableModel();
        modelLesComp.addColumn("id");
        modelLesComp.addColumn("libelle");
        modelLesComp.addColumn("Requis");
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lesEmpDeLaMiss = new javax.swing.JTable(){
            public boolean isCellEditable(int d, int c){
                return false;
            }
        };
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lesEmp = new javax.swing.JTable(){
            public boolean isCellEditable(int d, int c){
                return false;
            }
        };
        ajoutEmp = new javax.swing.JButton();
        id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dateDebJ = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dateDebM = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dateDebA = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        dateFinJ = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        dateFinM = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        dateFinA = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        compMission = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Les Employes de la mission :");

        lesEmpDeLaMiss.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(lesEmpDeLaMiss);

        jLabel2.setText("Les employes :");

        lesEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(lesEmp);

        ajoutEmp.setText("Ajouter");
        ajoutEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutEmpActionPerformed(evt);
            }
        });

        jLabel3.setText("ID :");

        jLabel4.setText("Date début :");

        jLabel5.setText("/");

        jLabel6.setText("/");

        jLabel7.setText("Date Fin :");

        jLabel8.setText("/");

        jLabel9.setText("/");

        compMission.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(compMission);

        jLabel10.setText("Les Competences de la mission :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ajoutEmp))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(37, 37, 37)
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(dateFinM, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(dateDebM, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel6)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(dateDebA, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel9)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(dateFinA, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(dateDebJ, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                                                .addComponent(dateFinJ))
                                            .addGap(88, 88, 88))))))))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dateDebJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(dateDebM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(dateDebA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(dateFinJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateFinM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(dateFinA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addComponent(ajoutEmp))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        id.getAccessibleContext().setAccessibleName("id");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ajoutEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutEmpActionPerformed
        // TODO add your handling code here:
       
        //Ajoute l'employé dans la Jtable lesEmpDeLaMiss
        int ligne = lesEmp.getSelectedRow();
        int colonneId = 0 ;
        int colonneNom = 1;
        int colonnePrenom = 2 ;
        String id = (String) lesEmp.getValueAt(ligne, colonneId);
        String nom = (String) lesEmp.getValueAt(ligne, colonneNom);
        String prenom = (String) lesEmp.getValueAt(ligne, colonnePrenom);
 
        DefaultTableModel modelLesEmpDeLaMission =(DefaultTableModel)  lesEmpDeLaMiss.getModel();
        modelLesEmpDeLaMission.addRow(new Object[]{id,nom,prenom});
        lesEmpDeLaMiss.setModel(modelLesEmpDeLaMission);
        //Enlève l'employé das Jtable lesEmp
        DefaultTableModel modelLesEmp =(DefaultTableModel)  lesEmp.getModel();
        modelLesEmp.removeRow(ligne);
        lesEmp.setModel(modelLesEmp);
        
        //Ajoute l'employé dans la liste d'employé de la mission et réduir le requis de jtable compMission
        DefaultTableModel modelComMission =(DefaultTableModel)  compMission.getModel();
        for(Employe unEmp : lesEmployes ){
            if(unEmp.getId().equals(id)){
                maMission.equipeMission.add(unEmp);
                for(int i=0; i<compMission.getRowCount();i++){
                    String idCom = (String) compMission.getValueAt(i, 0);
                    String libelle = (String) compMission.getValueAt(i, 1);
                    String nbRequisS = (String) compMission.getValueAt(i, 2);
                    Integer nbRequisI = Integer.parseInt(nbRequisS);
                    for(Competence uneComp : unEmp.getCompetences()){
                        if(uneComp.getId().equals(idCom)){
                            nbRequisI = nbRequisI - 1 ;
                            modelComMission.removeRow(i);
                            modelComMission.addRow(new Object[]{idCom,libelle,nbRequisI});
                            compMission.setModel(modelComMission);
                            
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_ajoutEmpActionPerformed

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
            java.util.logging.Logger.getLogger(JDetailMission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDetailMission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDetailMission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDetailMission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            /*
            public void run() {
                new JDetailMission().setVisible(true);
            }*/
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajoutEmp;
    private javax.swing.JTable compMission;
    private javax.swing.JTextField dateDebA;
    private javax.swing.JTextField dateDebJ;
    private javax.swing.JTextField dateDebM;
    private javax.swing.JTextField dateFinA;
    private javax.swing.JTextField dateFinJ;
    private javax.swing.JTextField dateFinM;
    private javax.swing.JTextField id;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable lesEmp;
    private javax.swing.JTable lesEmpDeLaMiss;
    // End of variables declaration//GEN-END:variables
}
