package View;

import Control.ConsultaControl;
import Control.MedicoControl;
import Control.PacienteControl;
import static Util.Validacoes.validarDataDeConsulta;
import static Util.Validacoes.validarHorario;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import static Util.MensagensDestinadasAoUsuario.mensagemErro;
import static Util.MensagensDestinadasAoUsuario.mensagemSucesso;

public class TelaDeCadastroDeConsulta extends javax.swing.JFrame {

    private static final ConsultaControl CONSULTA_CONTROL = new ConsultaControl();
    private static final PacienteControl PACIENTE_CONTROL = new PacienteControl();
    private static final MedicoControl MEDICO_CONTROL = new MedicoControl();

    private ArrayList<String> idDosMedicosRelacionadosAoSeuIndiceNoComboBox;

    public TelaDeCadastroDeConsulta() {
        initComponents();
        this.inputDescricao.setLineWrap(true);
        this.inputDescricao.setWrapStyleWord(true);
        this.getContentPane().setBackground(Color.getColor("282A36"));
        URL imagem = this.getClass().getResource("/Assets/Assets.png");
        Image icone = Toolkit.getDefaultToolkit().getImage(imagem);
        this.setIconImage(icone);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox2 = new javax.swing.JComboBox<>();
        cancelar = new javax.swing.JButton();
        cadastrar = new javax.swing.JButton();
        limparDados = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboBoxSelecionarMedico = new javax.swing.JComboBox<>();
        try{
            comboBoxSelecionarMedico.setModel(new javax.swing.DefaultComboBoxModel<>(this.buscarMedicos()));
        }catch(Exception e){
            e.printStackTrace();
        }
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputDescricao = new javax.swing.JTextArea();
        inputData = new javax.swing.JFormattedTextField();
        try {
            inputData = new JFormattedTextField(new MaskFormatter("##/##/####"));
        } catch (ParseException ex) {
            Logger.getLogger(TelaDeCadastroDeMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        inputHorario = new javax.swing.JFormattedTextField();
        try {
            inputHorario = new JFormattedTextField(new MaskFormatter("##:##"));
        } catch (ParseException ex) {
            Logger.getLogger(TelaDeCadastroDeMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        inputCPF = new javax.swing.JFormattedTextField();
        try {
            inputCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
        } catch (ParseException ex) {
            Logger.getLogger(TelaDeCadastroDeMedico.class.getName()).log(Level.SEVERE, null, ex);
        }

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Medico 1", "Medico 2", "Medico 3", "Medico 4" }));

        setTitle("Cadastro");
        setBackground(new java.awt.Color(40, 42, 54));
        setFocusable(false);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        cancelar.setBackground(new java.awt.Color(94, 23, 203));
        cancelar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cancelar.setForeground(new java.awt.Color(245, 245, 245));
        cancelar.setText("Voltar");
        cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        cadastrar.setBackground(new java.awt.Color(94, 23, 203));
        cadastrar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cadastrar.setForeground(new java.awt.Color(245, 245, 245));
        cadastrar.setText("Cadastrar");
        cadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarActionPerformed(evt);
            }
        });

        limparDados.setBackground(new java.awt.Color(94, 23, 203));
        limparDados.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        limparDados.setForeground(new java.awt.Color(245, 245, 245));
        limparDados.setText("Limpar dados");
        limparDados.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        limparDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparDadosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(56, 182, 255));
        jLabel1.setText("CPF do paciente*:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(56, 182, 255));
        jLabel2.setText("Médico(a)*:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(56, 182, 255));
        jLabel4.setText("Data*:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(245, 245, 245));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText(" Cadastramento de Consulta");

        comboBoxSelecionarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxSelecionarMedicoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(56, 182, 255));
        jLabel5.setText(" Horário*:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(56, 182, 255));
        jLabel7.setText("Descrição da consulta*:");

        inputDescricao.setColumns(1);
        inputDescricao.setRows(20);
        inputDescricao.setAutoscrolls(true);
        inputDescricao.setPreferredSize(new java.awt.Dimension(12, 28));
        jScrollPane1.setViewportView(inputDescricao);

        inputCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCPFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)
                        .addComponent(limparDados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                        .addComponent(cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(118, 118, 118)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)))
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputData, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(comboBoxSelecionarMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(134, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inputCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboBoxSelecionarMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(inputData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(inputHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar)
                    .addComponent(cadastrar)
                    .addComponent(limparDados))
                .addGap(15, 15, 15))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.limparDados();
        this.setVisible(false);
    }//GEN-LAST:event_cancelarActionPerformed
    private void limparDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparDadosActionPerformed
        this.limparDados();
    }//GEN-LAST:event_limparDadosActionPerformed
    private void comboBoxSelecionarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSelecionarMedicoActionPerformed
    }//GEN-LAST:event_comboBoxSelecionarMedicoActionPerformed
    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed
        try {
            String cpfDoPaciente = this.inputCPF.getText().substring(0, 3) + this.inputCPF.getText().substring(4, 7)
                    + this.inputCPF.getText().substring(8, 11) + this.inputCPF.getText().substring(12, 14);
            Long idMedico = this.obterIdDoMedico();
            String[] dataInformada = this.inputData.getText().split("/");
            LocalDate dataDaConsulta = LocalDate.parse(dataInformada[2] + "-" + dataInformada[1] + "-" + dataInformada[0]);
            String horarioDoExame = this.inputHorario.getText();
            String descricao = this.inputDescricao.getText();

            if (cpfDoPaciente.isEmpty() || idMedico == null || descricao.isEmpty()) {
                mensagemErro("Todos os campos são obrigatórios!\nPor obséquio, preencha-os.", "Erro: Dados inválidos informados");
            } else if (validarDataDeConsulta(dataDaConsulta)) {
                mensagemErro("A data de consulta está inválida.", "Erro: Dados inválidos informados");
            } else if (!validarHorario(horarioDoExame, MEDICO_CONTROL.obterOHorarioDeAtendimentoDeUmMedico(idMedico))) {
                mensagemErro("O Horario está inválido.", "Erro: Dados inválidos informados");
            } else {

                System.out.println(PACIENTE_CONTROL.buscarPacientePorCPF(cpfDoPaciente));
                System.out.println(MEDICO_CONTROL.obterMedicoEspecificadoPeloId(idMedico));
                if (CONSULTA_CONTROL.cadastrar(PACIENTE_CONTROL.buscarPacientePorCPF(cpfDoPaciente),
                        MEDICO_CONTROL.obterMedicoEspecificadoPeloId(idMedico),
                        dataDaConsulta, horarioDoExame, descricao)) {
                    mensagemSucesso("Consulta agendada com sucesso!", "Sucesso!");
                    this.limparDados();
                } else {
                    mensagemErro("Esse horário já  está reservado.");
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            mensagemErro("Ocorreu um Erro.");

        }
    }//GEN-LAST:event_cadastrarActionPerformed
    private void inputCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCPFActionPerformed
    }//GEN-LAST:event_inputCPFActionPerformed
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            comboBoxSelecionarMedico.setModel(new javax.swing.DefaultComboBoxModel<>(this.buscarMedicos()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_formWindowActivated

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDeCadastroDeConsulta().setVisible(true);
            }
        });
    }

    private void limparDados() {
        this.inputCPF.setText("");
        this.inputHorario.setText("");
        this.inputData.setText("");
        this.inputDescricao.setText("");
        this.comboBoxSelecionarMedico.setSelectedIndex(0);

    }

    public String[] buscarMedicos() throws SQLException {

        ArrayList<String[]> list = CONSULTA_CONTROL.buscarMedicos();
        String[] converterLista = {"Não há médicos(as)."};
        if (!list.isEmpty()) {
            converterLista = new String[list.size() + 1];
            idDosMedicosRelacionadosAoSeuIndiceNoComboBox = new ArrayList<>();
            converterLista[0] = "Selecione o(a) Médico(a)";
            idDosMedicosRelacionadosAoSeuIndiceNoComboBox.add(null);
            for (int i = 0; i < list.size(); i++) {
                converterLista[i + 1] = list.get(i)[0];
                idDosMedicosRelacionadosAoSeuIndiceNoComboBox.add(list.get(i)[1]);
            }

            if (converterLista[1] == null) {
                converterLista = new String[1];
                converterLista[0] = "Não há médicos(as).";
            }

        }
        return converterLista;
    }

    private Long obterIdDoMedico() {
        String indexDoMedico = this.comboBoxSelecionarMedico.getSelectedIndex() + "";
        for (int i = 0; i < idDosMedicosRelacionadosAoSeuIndiceNoComboBox.size() - 1; i++) {
            if (((i + 1) + "").equals(indexDoMedico)) {
                return Long.parseLong(idDosMedicosRelacionadosAoSeuIndiceNoComboBox.get(i + 1));
            }
        }
        return null;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrar;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox<String> comboBoxSelecionarMedico;
    private javax.swing.JFormattedTextField inputCPF;
    private javax.swing.JFormattedTextField inputData;
    private javax.swing.JTextArea inputDescricao;
    private javax.swing.JFormattedTextField inputHorario;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limparDados;
    // End of variables declaration//GEN-END:variables
}
