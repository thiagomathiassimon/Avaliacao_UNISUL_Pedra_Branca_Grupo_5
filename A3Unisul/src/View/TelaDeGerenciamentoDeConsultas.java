package View;

import Control.ConsultaControl;
import Control.MedicoControl;
import Model.Consulta;
import static Util.Validacoes.validarDataDeConsulta;
import static Util.Validacoes.validarHorario;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class TelaDeGerenciamentoDeConsultas extends javax.swing.JFrame {

    private static final ConsultaControl CONSULTA_CONTROL = new ConsultaControl();
    private static final MedicoControl MEDICO_CONTROL = new MedicoControl();
    private static final Integer VALOR_DE_RETORNO_QUANDO_NAO_HOUVER_LINHA_SELECIONADA_NA_JTABLE = -1;
    private static final Integer RETORNO_DE_CONFIRMACAO_DO_JOPTIONPANE_SHOW_CONFIRM_DIALOG = 0;
    private ArrayList<String> idDosMedicosRelacionadosAoSeuIndiceNoComboBox;

    public TelaDeGerenciamentoDeConsultas() {
        initComponents();
        this.carregarConsultas();
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
            InputDescricao = new javax.swing.JTextArea();
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
                addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowActivated(java.awt.event.WindowEvent evt) {
                        formWindowActivated(evt);
                    }
                });

                jLabel6.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
                jLabel6.setText("Gerenciamento de Consultas");

                tabelaConsulta.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {

                    },
                    new String [] {
                        "ID", "Paciente", "CPF", "Médico", "Data", "Horários", "Descrição"
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
                jLabel5.setText("Horário:");

                cancelar.setText("Cancelar");
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

            atualizar.setText("Atualizar");
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
            jLabel7.setText("Descrição da consulta:");

            limparDados.setText("Limpar dados");
            limparDados.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    limparDadosActionPerformed(evt);
                }
            });

            InputDescricao.setColumns(20);
            InputDescricao.setRows(5);
            InputDescricao.setAutoscrolls(false);
            jScrollPane1.setViewportView(InputDescricao);

            inputPaciente.setEditable(false);
            inputPaciente.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    inputPacienteActionPerformed(evt);
                }
            });

            jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
            jLabel1.setText("Paciente:");

            jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
            jLabel2.setText("Médico:");

            jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
            jLabel4.setText("Data:");

            excluir.setText("Excluir");
            excluir.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    excluirActionPerformed(evt);
                }
            });

            label97.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
            label97.setText("CPF:");

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
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(54, 54, 54))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(limparDados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(excluir)
                        .addGap(83, 83, 83)
                        .addComponent(cancelar)
                        .addGap(100, 100, 100)
                        .addComponent(atualizar))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(inputData, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputHorario)
                                    .addComponent(comboBoxSelecionarMedico, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(34, 34, 34)
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(inputPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(label97)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(inputCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel7)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inputPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label97, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboBoxSelecionarMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar)
                    .addComponent(limparDados)
                    .addComponent(atualizar)
                    .addComponent(excluir))
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
            this.InputDescricao.setText(this.tabelaConsulta.getValueAt(this.tabelaConsulta.getSelectedRow(), 6).toString());
        }
    }//GEN-LAST:event_tabelaConsultaMouseClicked
    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        try {
            int escolhaDoUsuario = JOptionPane.showConfirmDialog(null, "Deseja, realmente, excluir esta consulta? \nEssa ação não poderá ser desfeita!");
            if (escolhaDoUsuario == RETORNO_DE_CONFIRMACAO_DO_JOPTIONPANE_SHOW_CONFIRM_DIALOG) {
                CONSULTA_CONTROL.excluir(this.obterIdConsulta());
                JOptionPane.showMessageDialog(null, "A consulta foi removida com sucesso!");
                this.carregarConsultas();
                this.limparDados();
            } else {
                JOptionPane.showMessageDialog(null, "A consulta será mantida!");
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
            String descricao = this.InputDescricao.getText();

            if (cpf.isEmpty() || idMedico == null || descricao.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todo os campos são obrigatórios!\nPor obséquio, preencha-os.");
            } else if (validarDataDeConsulta(data)
                    || !validarHorario(horario, MEDICO_CONTROL.obterOHorarioDeAtendimentoDeUmMedico(idMedico))) {
                JOptionPane.showMessageDialog(null, "Alguns dados estão inválidos, por favor, verifique os campos.");
            } else {
                CONSULTA_CONTROL.editar(id, cpf, idMedico, data, horario, descricao);
                JOptionPane.showMessageDialog(null, "Consulta atualizado com sucesso!");
                this.limparDados();
                this.carregarConsultas();
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
        this.InputDescricao.setText("");
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
            converterLista[0] = "Selecione o Médico";
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
            JOptionPane.showMessageDialog(null, mensagem);
            throw new RuntimeException(mensagem);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea InputDescricao;
    private javax.swing.JButton atualizar;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox<String> comboBoxSelecionarMedico;
    private javax.swing.JButton excluir;
    private javax.swing.JTextField inputCPF;
    private javax.swing.JFormattedTextField inputData;
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
