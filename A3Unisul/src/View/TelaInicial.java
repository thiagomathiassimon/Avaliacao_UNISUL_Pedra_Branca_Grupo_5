package View;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class TelaInicial extends javax.swing.JFrame {

    TelaDeCadastroDePaciente telaCadastroPaciente;
    TelaDeGerenciamentoDePacientes telaDeGerenciamentoDePacientes;
    TelaDeCadastroDeMedico telaDeCadastroDeMedico;
    TelaDeGerenciamentoDeMedicos telaDeGerenciamentoDeMedicos;
    TelaDeCadastroDeConsulta telaDeCadastroDeConsulta;
    TelaDeGerenciamentoDeConsultas telaDeGerenciamentoDeConsultas;

    public TelaInicial() {
        telaCadastroPaciente = new TelaDeCadastroDePaciente();
        telaDeGerenciamentoDePacientes = new TelaDeGerenciamentoDePacientes();
        telaDeCadastroDeMedico = new TelaDeCadastroDeMedico();
        telaDeGerenciamentoDeMedicos = new TelaDeGerenciamentoDeMedicos();
        telaDeCadastroDeConsulta = new TelaDeCadastroDeConsulta();
        telaDeGerenciamentoDeConsultas = new TelaDeGerenciamentoDeConsultas();
        initComponents();       
        URL imagem = this.getClass().getResource("/Assets/Assets.png");
        Image icone = Toolkit.getDefaultToolkit().getImage(imagem);
        this.setIconImage(icone);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        cadastrarPaciente = new javax.swing.JMenuItem();
        gerenciarPaciente = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        cadastrarMedico = new javax.swing.JMenuItem();
        gerenciarMedico = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        cadastrarAgendamento = new javax.swing.JMenuItem();
        gerenciarAgendamento = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clínica Bonzina");
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Clínica BONZINA (10).png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jMenu1.setText("Paciente");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cadastrarPaciente.setText("Cadastrar");
        cadastrarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarPacienteActionPerformed(evt);
            }
        });
        jMenu1.add(cadastrarPaciente);

        gerenciarPaciente.setText("Gerenciar");
        gerenciarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerenciarPacienteActionPerformed(evt);
            }
        });
        jMenu1.add(gerenciarPaciente);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Médico");
        jMenu2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cadastrarMedico.setText("Cadastrar");
        cadastrarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarMedicoActionPerformed(evt);
            }
        });
        jMenu2.add(cadastrarMedico);

        gerenciarMedico.setText("Gerenciar");
        gerenciarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerenciarMedicoActionPerformed(evt);
            }
        });
        jMenu2.add(gerenciarMedico);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Consulta");
        jMenu4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cadastrarAgendamento.setText("Cadastrar");
        cadastrarAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarAgendamentoActionPerformed(evt);
            }
        });
        jMenu4.add(cadastrarAgendamento);

        gerenciarAgendamento.setText("Gerenciar");
        gerenciarAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerenciarAgendamentoActionPerformed(evt);
            }
        });
        jMenu4.add(gerenciarAgendamento);

        jMenuBar1.add(jMenu4);

        jMenu5.setEnabled(false);
        jMenu5.setMinimumSize(new java.awt.Dimension(300, 10));
        jMenu5.setPreferredSize(new java.awt.Dimension(270, 3));
        jMenuBar1.add(jMenu5);

        jMenu3.setText("Sair");
        jMenu3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarPacienteActionPerformed

        telaCadastroPaciente.setVisible(true);

    }//GEN-LAST:event_cadastrarPacienteActionPerformed
    private void gerenciarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerenciarPacienteActionPerformed
        telaDeGerenciamentoDePacientes.setVisible(true);
    }//GEN-LAST:event_gerenciarPacienteActionPerformed
    private void cadastrarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarMedicoActionPerformed
        telaDeCadastroDeMedico.setVisible(true);
    }//GEN-LAST:event_cadastrarMedicoActionPerformed
    private void gerenciarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerenciarMedicoActionPerformed
        telaDeGerenciamentoDeMedicos.setVisible(true);
    }//GEN-LAST:event_gerenciarMedicoActionPerformed
    private void cadastrarAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarAgendamentoActionPerformed
        telaDeCadastroDeConsulta.setVisible(true);
    }//GEN-LAST:event_cadastrarAgendamentoActionPerformed
    private void gerenciarAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerenciarAgendamentoActionPerformed
        telaDeGerenciamentoDeConsultas.setVisible(true);
    }//GEN-LAST:event_gerenciarAgendamentoActionPerformed
    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
    }//GEN-LAST:event_jMenu3ActionPerformed
    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
       System.exit(0);
    }//GEN-LAST:event_jMenu3MouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem cadastrarAgendamento;
    private javax.swing.JMenuItem cadastrarMedico;
    private javax.swing.JMenuItem cadastrarPaciente;
    private javax.swing.JMenuItem gerenciarAgendamento;
    private javax.swing.JMenuItem gerenciarMedico;
    private javax.swing.JMenuItem gerenciarPaciente;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
