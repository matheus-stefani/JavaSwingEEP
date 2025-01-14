/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package prova2;

import java.awt.Point;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JOptionPane;
import prova2.entities.Cadeira;
import prova2.exceptions.NonexistentEntityException;
/**
 *
 * @author aluno
 */
public class Cadastro extends javax.swing.JFrame {

    /**
     * Creates new form JFrameMain
     */
    EntityManagerFactory conn;
    CadeiraJpaController cadeiraC;
    public Cadastro() {
        initComponents();
       
        conn = Persistence.createEntityManagerFactory("prova2PU");
        cadeiraC = new CadeiraJpaController(conn);
        
        jTable1.getTableHeader().setReorderingAllowed(false);
        
        limparDadosEDarGet();
    }
    
    public void limparDadosEDarGet(){
         inputId.setText("");
            inputTipo.setText("");
            inputMaterial.setText("");
            inputPernas.setText("");
            inputUso.setText("");
        getDados();
        btnAlterar.setEnabled(false);
        btnRemover.setEnabled(false);
        btnInserir.setEnabled(true);
        btnLimpar.setEnabled(true);
    }
    
    public void getDados(){
        ((DefaultTableModel)jTable1.getModel()).setRowCount(0);
        
        List<Cadeira> cadeiras = cadeiraC.findCadeiraEntities();
        for(Cadeira cadeira: cadeiras){
            String row[] = {
            
            cadeira.getId().toString(),
            cadeira.getTipo(),
            cadeira.getMaterial(),
            String.valueOf(cadeira.getPernas()),
            cadeira.getUso(),
          
            };
            ((DefaultTableModel)jTable1.getModel()).addRow(row);
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

        inputMaterial = new javax.swing.JTextField();
        inputId = new javax.swing.JTextField();
        inputTipo = new javax.swing.JTextField();
        inputPernas = new javax.swing.JTextField();
        inputUso = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnLimpar = new javax.swing.JButton();
        btnInserir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inputId.setEnabled(false);

        jLabel1.setText("id:");

        jLabel2.setText("material:");

        jLabel3.setText("tipo:");

        jLabel5.setText("pernas:");

        jLabel6.setText("uso:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "tipo", "material", "pernas", "uso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnLimpar.setText("Limpar");
        btnLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimparMouseClicked(evt);
            }
        });
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnInserir.setText("Inserir");
        btnInserir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInserirMouseClicked(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlterarMouseClicked(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.setEnabled(false);
        btnRemover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemoverMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(inputUso))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(inputTipo))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(73, 73, 73)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(inputMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(83, 83, 83)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(inputPernas, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRemover))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(btnAlterar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnLimpar)
                                    .addComponent(btnInserir))))
                        .addGap(23, 23, 23)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(inputTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnInserir)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputPernas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar)
                        .addGap(31, 31, 31)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputUso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(btnRemover))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnLimparMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimparMouseClicked
        
        limparDadosEDarGet();
    }//GEN-LAST:event_btnLimparMouseClicked

    private void btnInserirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInserirMouseClicked
        
        try{
        if(inputTipo.getText().length() >0 &&
                inputMaterial.getText().length() >0 &&
                inputPernas.getText().length() >0 &&
                inputUso.getText().length() >0 ){
            
            Cadeira cadeira = new Cadeira(inputTipo.getText(),inputMaterial.getText(),
                    Integer.parseInt(inputPernas.getText()),inputUso.getText());
            cadeiraC.create(cadeira);
             limparDadosEDarGet();
            JOptionPane.showMessageDialog(this, "Cadeira inserida com sucesso!!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            throw new RuntimeException("Preencha todos os campos!!!");
        }    
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Coloque um numero inteiro em 'pernas'","Erro",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        catch(RuntimeException e){
             JOptionPane.showMessageDialog(this, e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_btnInserirMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
         
        Point point = evt.getPoint();
        
        int row = jTable1.rowAtPoint(point);
        if (evt.getClickCount() == 2 && jTable1.getSelectedRow() != -1) {
            
            inputId.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            inputTipo.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
            inputMaterial.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
            inputPernas.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
            inputUso.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
            btnAlterar.setEnabled(true);
            btnRemover.setEnabled(true);
            btnInserir.setEnabled(false);
            
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnAlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarMouseClicked
        
        try{
         if(inputTipo.getText().length() >0 &&
                inputMaterial.getText().length() >0 &&
                inputPernas.getText().length() >0 &&
                inputUso.getText().length() >0 ){
            Cadeira cadeira = new Cadeira(Integer.parseInt(inputId.getText()),inputTipo.getText(),inputMaterial.getText(),
                    Integer.parseInt(inputPernas.getText()),inputUso.getText());
            cadeiraC.edit(cadeira);
             limparDadosEDarGet();
            JOptionPane.showMessageDialog(this, "Cadeira alterada com sucesso!!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            throw new RuntimeException("Preencha todos os campos!!!");
        }
        }
         catch(NonexistentEntityException e){
             JOptionPane.showMessageDialog(this, "Coloque um numero inteiro em 'pernas'","Erro",JOptionPane.ERROR_MESSAGE);
             e.printStackTrace();
         }
         catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Coloque um numero inteiro em 'pernas'","Erro",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        catch(RuntimeException e){
             JOptionPane.showMessageDialog(this, e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Ocorreu algum erro","Erro",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAlterarMouseClicked

    private void btnRemoverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoverMouseClicked
         int resp = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja deletar essa cadeira",
                 "Aviso!!",
                 JOptionPane.YES_NO_OPTION);
         
         try{
         if(resp == JOptionPane.YES_OPTION){
         cadeiraC.destroy(Integer.parseInt(inputId.getText()));
          limparDadosEDarGet();
          JOptionPane.showMessageDialog(this, "Cadeira foi deletada com sucesso!!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
         }    
         }
         catch(NonexistentEntityException e){
             JOptionPane.showMessageDialog(this, "A cadeira que voce esta tentando deletar não existe","Erro",JOptionPane.ERROR_MESSAGE);
             e.printStackTrace();
         }
         
         
    }//GEN-LAST:event_btnRemoverMouseClicked

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
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JTextField inputId;
    private javax.swing.JTextField inputMaterial;
    private javax.swing.JTextField inputPernas;
    private javax.swing.JTextField inputTipo;
    private javax.swing.JTextField inputUso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
