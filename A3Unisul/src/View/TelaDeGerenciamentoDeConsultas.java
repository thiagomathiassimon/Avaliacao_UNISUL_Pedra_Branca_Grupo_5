package View;

import Control.ConsultaControl;
import Control.MedicoControl;
import Model.Consulta;
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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import static Util.MensagensDestinadasAoUsuario.mensagemAlerta;
import static Util.MensagensDestinadasAoUsuario.mensagemConfirmacao;
import static Util.MensagensDestinadasAoUsuario.mensagemErro;
import static Util.MensagensDestinadasAoUsuario.mensagemSucesso;

public class TelaDeGerenciamentoDeConsultas extends javax.swing.JFrame {

    private static final ConsultaControl CONSULTA_CONTROL = new ConsultaControl();
    private static final MedicoControl MEDICO_CONTROL = new MedicoControl();
    private static final Integer VALOR_DE_RETORNO_QUANDO_NAO_HOUVER_LINHA_SELECIONADA_NA_JTABLE = -1;
    private static final Integer RETORNO_DE_CONFIRMACAO_DO_JOPTIONPANE_SHOW_CONFIRM_DIALOG = 0;
    private ArrayList<String> idDosMedicosRelacionadosAoSeuIndiceNoComboBox;

    public TelaDeGerenciamentoDeConsultas() {
        initComponents();
        this.carregarConsultas();
        this.inputDescricao.setLineWrap(true);
        this.inputDescricao.setWrapStyleWord(true);
        this.getContentPane().setBackground(Color.getColor("282A36"));
        URL imagem = this.getClass().getResource("/Assets/Assets.png");
        Image icone = Toolkit.getDefaultToolkit().getImage(imagem);
        this.setIconImage(icone);

        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();

        centralizado.setHorizontalAlignment(SwingConstants.CENTER);

        Integer numeoDeColunasDaTabela = this.tabelaConsulta.getColumnCount() - 1;
        for (int i = 0; i <= numeoDeColunasDaTabela; i++) {
            this.tabelaConsulta.getColumnModel().getColumn(i).setCellRenderer(centralizado);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaConsulta = new javax.swing.JTable();
        comboBoxSelecionarMedico = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cancelar = new javax.swing.JButton();
        try{
            inputHorario = new javax.swing.JFormattedTextField(new MaskFormatter("##:##"));
            atualizar = new javax.swing.JButton();
            jLabel7 = new javax.swing.JLabel();
            limparDados = new javax.swing.JButton();
            jScrollPane1 = new javax.swing.JScrollPane();
            inputDescricao = new javax.swing.JTextArea();
            inputPaciente = new javax.swing.JTextField();
            jLabel1 = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            inputData = new javax.swing.JFormattedTextField();
            try {
                inputData = new JFormattedTextField(new MaskFormatter("##/##/####"));
            } catch (ParseException ex) {
                Logger.getLogger(TelaDeCadastroDeMedico.class.getName()).log(Level.SEVERE, null, ex);
            }
            excluir = new javax.swing.JButton();
            label97 = new javax.swing.JLabel();
            try{
                inputCPF = new javax.swing.JFormattedTextField(new MaskFormatter("###.###.###-##"));

                setTitle("Gerenciamento");
                setBackground(new java.awt.Color(40, 42, 54));
                setResizable(false);
                addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowActivated(java.awt.event.WindowEvent evt) {
                        formWindowActivated(evt);
                    }
                });

                jLabel6.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
                jLabel6.setForeground(new java.awt.Color(245, 245, 245));
                jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel6.setText("Gerenciamento de Consultas");

                tabelaConsulta.setBackground(new java.awt.Color(40, 42, 54));
                tabelaConsulta.setForeground(new java.awt.Color(245, 245, 245));
                tabelaConsulta.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {

                    },
                    new String [] {
                        "ID", "Paciente", "CPF", "Médico(a)", "Data", "Horários", "Descrição"
                    }
                ) {
                    boolean[] canEdit = new boolean [] {
                        false, false, false, false, false, false, false
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                    }
                });
                tabelaConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        tabelaConsultaMouseClicked(evt);
                    }
                });
                jScrollPane2.setViewportView(tabelaConsulta);
                if (tabelaConsulta.getColumnModel().getColumnCount() > 0) {
                    tabelaConsulta.getColumnModel().getColumn(0).setPreferredWidth(20);
                }

                comboBoxSelecionarMedico.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        comboBoxSelecionarMedicoActionPerformed(evt);
                    }
                });

                jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
                jLabel5.setForeground(new java.awt.Color(56, 182, 255));
                jLabel5.setText("Horário*:");

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

            }catch(Exception e){e.printStackTrace();}
            inputHorario.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    inputHorarioActionPerformed(evt);
                }
            });

            atualizar.setBackground(new java.awt.Color(94, 23, 203));
            atualizar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
            atualizar.setForeground(new java.awt.Color(245, 245, 245));
            atualizar.setText("Atualizar");
            atualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            atualizar.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    atualizarMouseClicked(evt);
                }
            });
            atualizar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    atualizarActionPerformed(evt);
                }
            });

            jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
            jLabel7.setForeground(new java.awt.Color(56, 182, 255));
            jLabel7.setText("Descrição da consulta*:");

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

            inputDescricao.setColumns(1);
            inputDescricao.setRows(20);
            inputDescricao.setAutoscrolls(true);
            jScrollPane1.setViewportView(inputDescricao);

            inputPaciente.setEditable(false);
            inputPaciente.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    inputPacienteActionPerformed(evt);
                }
            });

            jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(56, 182, 255));
            jLabel1.setText("Paciente*:");

            jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
            jLabel2.setForeground(new java.awt.Color(56, 182, 255));
            jLabel2.setText("Médico(a)*:");

            jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
            jLabel4.setForeground(new java.awt.Color(56, 182, 255));
            jLabel4.setText("Data*:");

            excluir.setBackground(new java.awt.Color(94, 23, 203));
            excluir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
            excluir.setForeground(new java.awt.Color(245, 245, 245));
            excluir.setText("Excluir");
            excluir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            excluir.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    excluirActionPerformed(evt);
                }
            });

            label97.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
            label97.setForeground(new java.awt.Color(56, 182, 255));
            label97.setText("CPF*:");

        }catch(Exception e){e.printStackTrace();}
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(label97)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(inputHorario, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(303, 303, 303))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(inputCPF, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputPaciente, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboBoxSelecionarMedico, javax.swing.GroupLayout.Alignment.LEADING, 0, 287, Short.MAX_VALUE)
                                    .addComponent(inputData))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 994, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(106, 106, 106)
                                .addComponent(limparDados)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label97))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxSelecionarMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(atualizar)
                    .addComponent(excluir)
                    .addComponent(limparDados)
                    .addComponent(cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void inputHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputHorarioActionPerformed
    }//GEN-LAST:event_inputHorarioActionPerformed
    private void inputPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPacienteActionPerformed
    }//GEN-LAST:event_inputPacienteActionPerformed
    private void limparDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparDadosActionPerformed
        this.limparDados();
    }//GEN-LAST:event_limparDadosActionPerformed
    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.limparDados();
        this.setVisible(false);
    }//GEN-LAST:event_cancelarActionPerformed
    private void comboBoxSelecionarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSelecionarMedicoActionPerformed
    }//GEN-LAST:event_comboBoxSelecionarMedicoActionPerformed
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        this.carregarConsultas();
        try {
            comboBoxSelecionarMedico.setModel(new javax.swing.DefaultComboBoxModel<>(this.buscarMedicos()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_formWindowActivated
    private void tabelaConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaConsultaMouseClicked
        int selectedRow = this.tabelaConsulta.getSelectedRow();
        if (selectedRow != VALOR_DE_RETORNO_QUANDO_NAO_HOUVER_LINHA_SELECIONADA_NA_JTABLE) {
            this.inputPaciente.setText(this.tabelaConsulta.getValueAt(this.tabelaConsulta.getSelectedRow(), 1).toString());
            this.inputCPF.setText(this.tabelaConsulta.getValueAt(this.tabelaConsulta.getSelectedRow(), 2).toString());
            this.comboBoxSelecionarMedico.setSelectedItem(this.tabelaConsulta.getValueAt(this.tabelaConsulta.getSelectedRow(), 3));
            this.inputData.setText(this.tabelaConsulta.getValueAt(this.tabelaConsulta.getSelectedRow(), 4).toString());
            this.inputHorario.setText(this.tabelaConsulta.getValueAt(this.tabelaConsulta.getSelectedRow(), 5).toString());
            this.inputDescricao.setText(this.tabelaConsulta.getValueAt(this.tabelaConsulta.getSelectedRow(), 6).toString());
        }
    }//GEN-LAST:event_tabelaConsultaMouseClicked
    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        try {
            int escolhaDoUsuario = mensagemConfirmacao("Deseja, realmente, excluir esta consulta? \nEssa ação não poderá ser desfeita!");
            if (escolhaDoUsuario == RETORNO_DE_CONFIRMACAO_DO_JOPTIONPANE_SHOW_CONFIRM_DIALOG) {
                CONSULTA_CONTROL.excluir(this.obterIdConsulta());
                mensagemSucesso("A consulta foi removida com sucesso!");
                this.carregarConsultas();
                this.limparDados();
            } else {
                mensagemSucesso("A consulta será mantida!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_excluirActionPerformed
    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed

        try {
            Long id = obterIdConsulta();
            Long idMedico = this.obterIdDoMedico();

            String cpf = this.inputCPF.getText().substring(0, 3) + this.inputCPF.getText().substring(4, 7)
                    + this.inputCPF.getText().substring(8, 11) + this.inputCPF.getText().substring(12, 14);

            String[] dataInformada = this.inputData.getText().split("/");
            LocalDate data = LocalDate.parse(dataInformada[2] + "-" + dataInformada[1] + "-" + dataInformada[0]);
            String horario = this.inputHorario.getText();
            String descricao = this.inputDescricao.getText();

            if (cpf.isEmpty() || idMedico == null || descricao.isEmpty()) {
                mensagemAlerta("Todo os campos são obrigatórios!\nPor obséquio, preencha-os.");
            } else if (validarDataDeConsulta(data)
                    || !validarHorario(horario, MEDICO_CONTROL.obterOHorarioDeAtendimentoDeUmMedico(idMedico))) {
                mensagemAlerta("Alguns dados estão inválidos, por favor, verifique os campos.");
            } else if (CONSULTA_CONTROL.editar(id, cpf, idMedico, data, horario, descricao)) {
                mensagemSucesso("Consulta atualizada com sucesso!");
                this.limparDados();
                this.carregarConsultas();
            } else {
                mensagemErro("Alguns dados estão inválidos, por favor, verifique os campos.");
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_atualizarActionPerformed
    private void inputCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCPFActionPerformed
    }//GEN-LAST:event_inputCPFActionPerformed
    private void atualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atualizarMouseClicked
    }//GEN-LAST:event_atualizarMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDeGerenciamentoDeConsultas().setVisible(true);
            }
        });
    }

    private void limparDados() {
        this.inputPaciente.setText("");
        this.inputHorario.setText("");
        this.inputData.setText("");
        this.inputDescricao.setText("");
        this.comboBoxSelecionarMedico.setSelectedIndex(0);
        Integer numeroDeLinhasNaColuna = this.tabelaConsulta.getRowCount() - 1;
        if (numeroDeLinhasNaColuna != -1) {
            this.tabelaConsulta.removeRowSelectionInterval(0, numeroDeLinhasNaColuna);
        }
        this.inputCPF.setText("");
    }

    private void carregarConsultas() {
        DefaultTableModel tabela = (DefaultTableModel) this.tabelaConsulta.getModel();
        tabela.setNumRows(0);

        ArrayList<Consulta> lista = CONSULTA_CONTROL.buscar();

        if (lista != null) {

            lista.forEach(consulta -> {
                String[] dataDaConsulta = consulta.getDataDoExame().toString().split("-");
                tabela.addRow(new Object[]{
                    consulta.getIdConsulta(),
                    consulta.getPaciente().getNome(),
                    consulta.getPaciente().getCpf(),
                    consulta.getMedico().getNome(),
                    String.format("%s/%s/%s", dataDaConsulta[2], dataDaConsulta[1], dataDaConsulta[0]),
                    consulta.getHorarioDeExame(),
                    consulta.getDescricao()
                });
            });
        }
    }

    public String[] buscarMedicos() throws SQLException {

        ArrayList<String[]> list = CONSULTA_CONTROL.buscarMedicos();
        String[] converterLista = {"Não há médicos."};
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
                converterLista[0] = "Não há médicos.";
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

    private Long obterIdConsulta() {

        int selectedRow = this.tabelaConsulta.getSelectedRow();
        if (selectedRow != VALOR_DE_RETORNO_QUANDO_NAO_HOUVER_LINHA_SELECIONADA_NA_JTABLE) {
            return Long.parseLong(this.tabelaConsulta.getValueAt(selectedRow, 0).toString());
        } else {
            String mensagem = "Nenhuma linha selecionada. Selecione uma linha para alterar seus dados";
            mensagemAlerta(mensagem);
            throw new RuntimeException(mensagem);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizar;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox<String> comboBoxSelecionarMedico;
    private javax.swing.JButton excluir;
    private javax.swing.JTextField inputCPF;
    private javax.swing.JFormattedTextField inputData;
    private javax.swing.JTextArea inputDescricao;
    private javax.swing.JTextField inputHorario;
    private javax.swing.JTextField inputPaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label97;
    private javax.swing.JButton limparDados;
    private javax.swing.JTable tabelaConsulta;
    // End of variables declaration//GEN-END:variables
}
