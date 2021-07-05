package View;

import Control.MedicoControl;
import Util.Validacoes;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class TelaDeCadastroDeMedico extends javax.swing.JFrame {

    private final MedicoControl MEDICO_CONTROL;
    private final int NUMERO_MAXIMO_DE_MEDICOS_POR_PERIODO_DE_ATENDIMENTO = 2;

    public TelaDeCadastroDeMedico() {
        initComponents();
        this.getContentPane().setBackground(Color.getColor("282A36"));
        URL imagem = this.getClass().getResource("/Assets/Assets.png");
        Image icone = Toolkit.getDefaultToolkit().getImage(imagem);
        this.setIconImage(icone);
        MEDICO_CONTROL = new MedicoControl();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputNome3 = new javax.swing.JTextField();
        cancelar = new javax.swing.JButton();
        cadastrar = new javax.swing.JButton();
        limparDados = new javax.swing.JButton();
        inputNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        inputEspecialidade = new javax.swing.JTextField();
        inputCRM = new javax.swing.JTextField();
        comboBoxPeriodoDeAtendimento = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        inputTelefone = new javax.swing.JFormattedTextField();
        try {             inputTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));         } catch (Exception e) {          }

        inputNome3.setText("jTextField1");
        inputNome3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNome3ActionPerformed(evt);
            }
        });

        setTitle("Cadastro");
        setBackground(new java.awt.Color(40, 42, 54));
        setResizable(false);

        cancelar.setBackground(new java.awt.Color(94, 23, 203));
        cancelar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cancelar.setForeground(new java.awt.Color(245, 245, 245));
        cancelar.setText("Voltar");
        cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        cadastrar.setBackground(new java.awt.Color(94, 23, 203));
        cadastrar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cadastrar.setForeground(new java.awt.Color(245, 245, 245));
        cadastrar.setText("Cadastrar");
        cadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarActionPerformed(evt);
            }
        });

        limparDados.setBackground(new java.awt.Color(94, 23, 203));
        limparDados.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        limparDados.setForeground(new java.awt.Color(245, 245, 245));
        limparDados.setText("Limpar dados");
        limparDados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        limparDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparDadosActionPerformed(evt);
            }
        });

        inputNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNomeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(56, 182, 255));
        jLabel1.setText("Nome*:");

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(56, 182, 255));
        jLabel2.setText("Telefone*:");

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(56, 182, 255));
        jLabel3.setText("Especialidade*:");

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(56, 182, 255));
        jLabel4.setText("CRM*:");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(56, 182, 255));
        jLabel5.setText("Período de Atendimento*:");

        inputEspecialidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEspecialidadeActionPerformed(evt);
            }
        });

        inputCRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCRMActionPerformed(evt);
            }
        });

        comboBoxPeriodoDeAtendimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Horário", "Matutino", "Vespertino" }));
        comboBoxPeriodoDeAtendimento.setToolTipText("");
        comboBoxPeriodoDeAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxPeriodoDeAtendimentoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(245, 245, 245));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText(" Cadastramento de Médico");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputCRM)
                            .addComponent(inputEspecialidade)
                            .addComponent(inputTelefone)
                            .addComponent(inputNome)
                            .addComponent(comboBoxPeriodoDeAtendimento, 0, 224, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(limparDados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(inputTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(inputEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputCRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxPeriodoDeAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limparDados)
                    .addComponent(cadastrar)
                    .addComponent(cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void inputNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNomeActionPerformed
    }//GEN-LAST:event_inputNomeActionPerformed
    private void inputEspecialidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputEspecialidadeActionPerformed
    }//GEN-LAST:event_inputEspecialidadeActionPerformed
    private void inputNome3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNome3ActionPerformed
    }//GEN-LAST:event_inputNome3ActionPerformed
    private void inputCRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCRMActionPerformed
    }//GEN-LAST:event_inputCRMActionPerformed
    private void comboBoxPeriodoDeAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxPeriodoDeAtendimentoActionPerformed
    }//GEN-LAST:event_comboBoxPeriodoDeAtendimentoActionPerformed
    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.limparDados();
        this.setVisible(false);
    }//GEN-LAST:event_cancelarActionPerformed
    private void limparDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparDadosActionPerformed
        this.limparDados();
    }//GEN-LAST:event_limparDadosActionPerformed
    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed

        String crm = this.inputCRM.getText();
        String especialidade = this.inputEspecialidade.getText();
        String nome = this.inputNome.getText();
        String telefone = this.inputTelefone.getText();
        String periodoDeAtendimento = this.comboBoxPeriodoDeAtendimento.getItemAt(this.comboBoxPeriodoDeAtendimento.getSelectedIndex());
        try {
            if ((Validacoes.validarNome(nome)) && (this.comboBoxPeriodoDeAtendimento.getSelectedIndex() != 0)
                    && ((periodoDeAtendimento.equalsIgnoreCase("matutino"))
                    ? (MEDICO_CONTROL.buscarQuantidadeDeMedicosNoPeriodoMatutino() < NUMERO_MAXIMO_DE_MEDICOS_POR_PERIODO_DE_ATENDIMENTO)
                    : (MEDICO_CONTROL.buscarQuantidadeDeMedicosNoPeriodoVespertino() < NUMERO_MAXIMO_DE_MEDICOS_POR_PERIODO_DE_ATENDIMENTO))) {
                MEDICO_CONTROL.cadastrar(crm, especialidade, periodoDeAtendimento, nome, telefone);
                JOptionPane.showMessageDialog(null, "Médico cadastrado com sucesso!");
                this.limparDados();
            } else {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro. \nVerifique os valores informados e tente novamente!");
            }
        } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Não foi possível concluir o cadastro.", "Erro", JOptionPane.ERROR);
        }

    }//GEN-LAST:event_cadastrarActionPerformed

    private void limparDados() {
        this.inputCRM.setText("");
        this.inputEspecialidade.setText("");
        this.inputNome.setText("");
        this.inputTelefone.setText("");
        this.comboBoxPeriodoDeAtendimento.setSelectedIndex(0);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDeCadastroDeMedico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrar;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox<String> comboBoxPeriodoDeAtendimento;
    private javax.swing.JTextField inputCRM;
    private javax.swing.JTextField inputEspecialidade;
    private javax.swing.JTextField inputNome;
    private javax.swing.JTextField inputNome3;
    private javax.swing.JFormattedTextField inputTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton limparDados;
    // End of variables declaration//GEN-END:variables
}
