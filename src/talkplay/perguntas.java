/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talkplay;

import classes.banco;
import classes.tabela;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.ColorUIResource;
import static talkplay.frmusuario.statususer;
/**
 *
 * @author danie
 */
public class perguntas extends javax.swing.JFrame {
login login = new login();
banco banco = new banco();
public String email = login.user;
public String senha = login.senha;
    /**
     * Creates new form perguntas
     */
    public perguntas() {
        initComponents();
        banco.conexao();
        try{
        String consulta = "select * from admin where email = '" + this.email.toString()+ "' and senha = '"+this.senha.toString()+"' and status = 'ativo'";            
                PreparedStatement pst1 = banco.con.prepareStatement(consulta);
                 banco.rs = pst1.executeQuery(consulta); 
                 if(!banco.rs.next()){
                     JOptionPane.showMessageDialog(null,"Perfil desativado");
                     System.exit(0);
                 }
        }catch(SQLException ex){
            
        }
        btaceitar.setVisible(false);
        btrecusar.setVisible(false);
        jButton2.setVisible(false);
        jLabel1.setText("Bem-vindo "+login.user);
        setLocationRelativeTo(null);
        preenchertabela("select * from adminperguntas where status = 'Não vista'");
    }
public void preenchertabela(String banco1) {
        //variavel do tipo arratlist
        ArrayList dados = new ArrayList();
        //nomeando as colunas da tabela, usando vetor
        String[] colunas = new String[]{"Nick","Pergunta","Categoria"};
        //comando para buscar dados da tabela
        banco.executaSQL(banco1);
        try {
            //volta para a primeira coluna
            banco.rs.first();
            //pode fazer  com o if
            //realizando busca de dados, caso tenha algum
            //o nome é igual ao nome do campo no bd
            do {
                dados.add(new Object[]{
                    banco.rs.getString("nick"),
                    banco.rs.getString("pergunta"),
                    banco.rs.getString("categoria")});
            } while (banco.rs.next());
        } catch (SQLException ex) {
        }
        tabela table = new tabela(dados, colunas);
        tabela1.setModel(table);
        //preenchendo as tabelas, no caso apenas algumas preferencias
        //no caso defini apenas o tamanho e se ela poderia ser redimensionada
        tabela1.getColumnModel().getColumn(0).setPreferredWidth(120);
        tabela1.getColumnModel().getColumn(0).setResizable(false);
        tabela1.getColumnModel().getColumn(1).setPreferredWidth(120);
        tabela1.getColumnModel().getColumn(1).setResizable(false);
        tabela1.getColumnModel().getColumn(2).setPreferredWidth(120);
        tabela1.getColumnModel().getColumn(2).setResizable(false);
        tabela1.getTableHeader().setReorderingAllowed(false);
        /*opcional*/
        //a tabela não pode ser redimensioanda
        tabela1.setAutoResizeMode(tabela1.AUTO_RESIZE_OFF);
        //seleção única
        tabela1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela1 = new javax.swing.JTable();
        btaceitar = new javax.swing.JButton();
        btrecusar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(667, 402));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(143, 188, 143));
        jButton1.setText("Voltar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/teste.png"))); // NOI18N

        tabela1.setModel(new javax.swing.table.DefaultTableModel(
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
        tabela1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela1);

        btaceitar.setBackground(new java.awt.Color(255, 255, 255));
        btaceitar.setForeground(new java.awt.Color(143, 188, 143));
        btaceitar.setText("Aceitar");
        btaceitar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btaceitarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btaceitarMouseExited(evt);
            }
        });
        btaceitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btaceitarActionPerformed(evt);
            }
        });

        btrecusar.setBackground(new java.awt.Color(255, 255, 255));
        btrecusar.setForeground(new java.awt.Color(143, 188, 143));
        btrecusar.setText("Recusar");
        btrecusar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btrecusarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btrecusarMouseExited(evt);
            }
        });
        btrecusar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btrecusarActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setForeground(new java.awt.Color(143, 188, 143));
        jButton2.setText("Mais informações");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 539, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(53, 53, 53))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btaceitar)
                                        .addGap(85, 85, 85)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(78, 78, 78)
                                        .addComponent(btrecusar)))
                                .addGap(101, 101, 101))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btaceitar)
                    .addComponent(btrecusar)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        frmgerenciar gere = new frmgerenciar();
        gere.setTitle("Gerenciamento Talkplay");
        this.setVisible(false);
        gere.setVisible(true);
        gere.setResizable(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabela1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela1MouseClicked
        // TODO add your handling code here:
        btaceitar.setVisible(true);
        btrecusar.setVisible(true);
        jButton2.setVisible(true);
    }//GEN-LAST:event_tabela1MouseClicked

    private void btaceitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btaceitarActionPerformed
        // TODO add your handling code here:
        int linha = tabela1.getSelectedRow();
        String codigo = String.valueOf(tabela1.getValueAt(linha, 0));
        String codigoa = String.valueOf(tabela1.getValueAt(linha, 1));
        String codigob = String.valueOf(tabela1.getValueAt(linha, 2));
        try{
          PreparedStatement pst = banco.con.prepareStatement("select * from adminperguntas where nick = '"+codigo.toString()+"' and pergunta = '"+codigoa.toString()+"' and categoria = '"+codigob.toString()+"'");
          banco.rs = pst.executeQuery();
          if(banco.rs.next()){
              String alternativa1 = banco.rs.getString("alternativa1");
              String alternativa2 = banco.rs.getString("alternativa2");
              String alternativa3 = banco.rs.getString("alternativa3");
              String alternativa4 = banco.rs.getString("alternativa4");
              String alternativacerta = banco.rs.getString("alternativacerta");
              if(codigob.equals("logica")){
                  PreparedStatement pst1 = banco.con.prepareStatement("insert into logica values (null,'"+codigob.toString()+"','"+codigoa.toString()+"','"+alternativa1.toString()+"','"+alternativa2.toString()+"','"+alternativa3.toString()+"','"+alternativa4.toString()+"','"+alternativacerta.toString()+"')");
                    pst1.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Pergunta enviada com sucesso");
                   PreparedStatement pst2 = banco.con.prepareStatement("insert into notificacao values (null,'Talkplay','sistema.png','"+codigo.toString()+"','perguntaaceita','aceitacomsucesso','Lógica','Não vista')");
                    pst2.executeUpdate();
                    PreparedStatement pst3 = banco.con.prepareStatement("update adminperguntas set status = 'Vista' where pergunta = '"+codigoa.toString()+"'");
                    pst3.executeUpdate();
                    btaceitar.setVisible(false);
                     btrecusar.setVisible(false);
                         jButton2.setVisible(false);
                    preenchertabela("select * from adminperguntas where status = 'Não vista'");
              }else if(codigob.equals("conhecimentosgerais")){
               PreparedStatement pst1 = banco.con.prepareStatement("insert into conhecimentosgerais values (null,'"+codigob.toString()+"','"+codigoa.toString()+"','"+alternativa1.toString()+"','"+alternativa2.toString()+"','"+alternativa3.toString()+"','"+alternativa4.toString()+"','"+alternativacerta.toString()+"')");
                    pst1.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Pergunta enviada com sucesso");
                    PreparedStatement pst2 = banco.con.prepareStatement("insert into notificacao values (null,'Talkplay','sistema.png','"+codigo.toString()+"','perguntaaceita','aceitacomsucesso','Conhecimentos gerais','Não vista')");
                    pst2.executeUpdate();
                    PreparedStatement pst3 = banco.con.prepareStatement("update adminperguntas set status = 'Vista' where pergunta = '"+codigoa.toString()+"'");
                    pst3.executeUpdate();
                    btaceitar.setVisible(false);
                    btrecusar.setVisible(false);
                    jButton2.setVisible(false);
                    preenchertabela("select * from adminperguntas where status = 'Não vista'");
              }
          }
        } catch (SQLException ex) {
       
    }
            
    }//GEN-LAST:event_btaceitarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int linha = tabela1.getSelectedRow();
        String codigo = String.valueOf(tabela1.getValueAt(linha, 0));
        String codigoa = String.valueOf(tabela1.getValueAt(linha, 1));
        String codigob = String.valueOf(tabela1.getValueAt(linha, 2));
        try{
            PreparedStatement pst = banco.con.prepareStatement("select * from adminperguntas where nick = '"+codigo.toString()+"' and pergunta = '"+codigoa.toString()+"' and categoria = '"+codigob.toString()+"'");
            banco.rs = pst.executeQuery();
            if(banco.rs.next()){
             String alternativa1 = banco.rs.getString("alternativa1");
              String alternativa2 = banco.rs.getString("alternativa2");
              String alternativa3 = banco.rs.getString("alternativa3");
              String alternativa4 = banco.rs.getString("alternativa4");
              String alternativacerta = banco.rs.getString("alternativacerta");
              JOptionPane.showMessageDialog(null,"Alternativa 1: "+alternativa1+"\nAlternativa 2: "+alternativa2+"\nAlternativa 3: "+alternativa3+"\nAlternativa 4: "+alternativa4+"\nAlternativa certa: "+alternativacerta);
            }
        }catch(SQLException ex){
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btrecusarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btrecusarActionPerformed
        // TODO add your handling code here:
         int linha = tabela1.getSelectedRow();
        String codigo = String.valueOf(tabela1.getValueAt(linha, 0));
        String codigoa = String.valueOf(tabela1.getValueAt(linha, 1));
        String codigob = String.valueOf(tabela1.getValueAt(linha, 2));
        try{
            if(codigob.equals("logica")){
            PreparedStatement pst = banco.con.prepareStatement("update adminperguntas set status = 'Recusada' where pergunta = '"+codigoa+"'");
            pst.executeUpdate();
            PreparedStatement pst2 = banco.con.prepareStatement("insert into notificacao values (null,'Talkplay','sistema.png','"+codigo.toString()+"','perguntarecusada','recusadacomsucesso','Lógica','Não vista')");
                    pst2.executeUpdate();
             preenchertabela("select * from adminperguntas where status = 'Não vista'");
             btaceitar.setVisible(false);
                btrecusar.setVisible(false);
                jButton2.setVisible(false);
             JOptionPane.showMessageDialog(null, "Recusada com sucesso");
             preenchertabela("select * from adminperguntas where status = 'Não vista'");
             
            }else if(codigob.equals("conhecimentosgerais")){
               PreparedStatement pst = banco.con.prepareStatement("update adminperguntas set status = 'Recusada' where pergunta = '"+codigoa+"'");   
               pst.executeUpdate();
               PreparedStatement pst2 = banco.con.prepareStatement("insert into notificacao values (null,'Talkplay','sistema.png','"+codigo.toString()+"','perguntarecusada','recusadacomsucesso','Conhecimentos gerais','Não vista')");
                    pst2.executeUpdate();
             preenchertabela("select * from adminperguntas where status = 'Não vista'");
             btaceitar.setVisible(false);
                btrecusar.setVisible(false);
                jButton2.setVisible(false);
             JOptionPane.showMessageDialog(null, "Recusada com sucesso");
             preenchertabela("select * from adminperguntas where status = 'Não vista'");
            }
        }catch(SQLException ex){
            
        }
    }//GEN-LAST:event_btrecusarActionPerformed

    private void btaceitarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btaceitarMouseEntered
        // TODO add your handling code here:
        btaceitar.setBackground(ColorUIResource.decode("#8FBC8F"));
        btaceitar.setForeground(ColorUIResource.WHITE);
    }//GEN-LAST:event_btaceitarMouseEntered

    private void btaceitarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btaceitarMouseExited
        // TODO add your handling code here:
         btaceitar.setBackground(ColorUIResource.WHITE);
       btaceitar.setForeground(ColorUIResource.decode("#8FBC8F"));
    }//GEN-LAST:event_btaceitarMouseExited

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
        jButton2.setBackground(ColorUIResource.decode("#8FBC8F"));
        jButton2.setForeground(ColorUIResource.WHITE);
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        // TODO add your handling code here:
         jButton2.setBackground(ColorUIResource.WHITE);
        jButton2.setForeground(ColorUIResource.decode("#8FBC8F"));
    }//GEN-LAST:event_jButton2MouseExited

    private void btrecusarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btrecusarMouseEntered
        // TODO add your handling code here:
        btrecusar.setBackground(ColorUIResource.decode("#8FBC8F"));
        btrecusar.setForeground(ColorUIResource.WHITE);
    }//GEN-LAST:event_btrecusarMouseEntered

    private void btrecusarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btrecusarMouseExited
        // TODO add your handling code here:
        btrecusar.setBackground(ColorUIResource.WHITE);
        btrecusar.setForeground(ColorUIResource.decode("#8FBC8F"));
    }//GEN-LAST:event_btrecusarMouseExited

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
        jButton1.setBackground(ColorUIResource.decode("#8FBC8F"));
        jButton1.setForeground(ColorUIResource.WHITE);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
         jButton1.setBackground(ColorUIResource.WHITE);
        jButton1.setForeground(ColorUIResource.decode("#8FBC8F"));
    }//GEN-LAST:event_jButton1MouseExited

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
            java.util.logging.Logger.getLogger(perguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(perguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(perguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(perguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new perguntas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btaceitar;
    private javax.swing.JButton btrecusar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela1;
    // End of variables declaration//GEN-END:variables
}
