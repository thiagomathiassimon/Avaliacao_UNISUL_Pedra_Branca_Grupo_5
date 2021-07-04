package View;

import Control.MedicoControl;
import Model.Medico;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class TelaDeGerenciamentoDeMedicos extends javax.swing.JFrame {

    private static final MedicoControl MEDICO_CONTROL = new MedicoControl();
    private static final Integer NUMERO_MAXIMO_DE_MEDICOS_POR_PERIODO_DE_ATENDIMENTO = 2;
    private static final Integer VALOR_DE_RETORNO_QUANDO_NAO_HOUVER_LINHA_SELECIONADA_NA_JTABLE = -1;

    public TelaDeGerenciamentoDeMedicos() {
        initComponents();
        this.carregarMedicos();
        getContentPane().setBackground(Color.getColor("282A36"));
        URL imagem = this.getClass().getResource("/Assets/Assets.png");
        Image icone = Toolkit.getDefaultToolkit().getImage(imagem);
        
        this.setIconImage(icone);   DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();

        centralizado.setHorizontalAlignment(SwingConstants.CENTER);

        Integer numeoDeColunasDaTabela = this.tabelaMedico.getColumnCount() - 1;
        for (int i = 0; i <= numeoDeColunasDaTabela; i++) {
            this.tabelaMedico.getColumnModel().getColumn(i).setCellRenderer(centralizado);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaMedico = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        inputTelefone = new javax.swing.JTextField();
        inputEspecialidade = new javax.swing.JTextField();
        cancelar = new javax.swing.JButton();
        inputCRM = new javax.swing.JTextField();
        atualizar = new javax.swing.JButton();
        comboBoxPeriodoDeAtendimento = new javax.swing.JComboBox<>();
        limparDados = new javax.swing.JButton();
        inputNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        exdcluir = new javax.swing.JButton();

        setTitle("Gerenciamento");
        setBackground(new java.awt.Color(40, 42, 54));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        tabelaMedico.setBackground(new java.awt.Color(40, 42, 54));
        tabelaMedico.setForeground(new java.awt.Color(245, 245, 245));
        tabelaMedico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Telefone", "Especialidade", "CRM", "Período de Atendimento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaMedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMedicoMouseClicked(evt);
            }
        });
        tabelaMedico.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tabelaMedicoPropertyChange(evt);
            }
        });
        tabelaMedico.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                tabelaMedicoVetoableChange(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaMedico);
        if (tabelaMedico.getColumnModel().getColumnCount() > 0) {
            tabelaMedico.getColumnModel().getColumn(0).setResizable(false);
            tabelaMedico.getColumnModel().getColumn(1).setResizable(false);
            tabelaMedico.getColumnModel().getColumn(2).setResizable(false);
            tabelaMedico.getColumnModel().getColumn(3).setResizable(false);
            tabelaMedico.getColumnModel().getColumn(4).setResizable(false);
            tabelaMedico.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(56, 182, 255));
        jLabel5.setText("Período de Atendimento*:");

        inputTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputTelefoneActionPerformed(evt);
            }
        });

        inputEspecialidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEspecialidadeActionPerformed(evt);
            }
        });

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

        inputCRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCRMActionPerformed(evt);
            }
        });

        atualizar.setBackground(new java.awt.Color(94, 23, 203));
        atualizar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        atualizar.setForeground(new java.awt.Color(245, 245, 245));
        atualizar.setText("Atualizar");
        atualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });

        comboBoxPeriodoDeAtendimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o período", "Matutino", "Vespertino" }));
        comboBoxPeriodoDeAtendimento.setToolTipText("");
        comboBoxPeriodoDeAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxPeriodoDeAtendimentoActionPerformed(evt);
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

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(56, 182, 255));
        jLabel1.setText("Nome*:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(56, 182, 255));
        jLabel2.setText("Telefone*:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(56, 182, 255));
        jLabel3.setText("Especialidade*:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(56, 182, 255));
        jLabel4.setText("CRM*:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(245, 245, 245));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Gerenciamento de Médicos");

        exdcluir.setBackground(new java.awt.Color(94, 23, 203));
        exdcluir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        exdcluir.setForeground(new java.awt.Color(245, 245, 245));
        exdcluir.setText("Excluir");
        exdcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exdcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exdcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1)
                .addGap(15, 15, 15))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(137, Short.MAX_VALUE)
                .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(limparDados)
                .addGap(18, 18, 18)
                .addComponent(exdcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(inputTelefone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                        .addComponent(inputNome, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(inputCRM)
                    .addComponent(comboBoxPeriodoDeAtendimento, 0, 208, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(inputTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputCRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxPeriodoDeAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar)
                    .addComponent(limparDados)
                    .addComponent(exdcluir)
                    .addComponent(atualizar))
                .addGap(17, 17, 17))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void inputTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputTelefoneActionPerformed
    }//GEN-LAST:event_inputTelefoneActionPerformed

    private void inputEspecialidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputEspecialidadeActionPerformed
    }//GEN-LAST:event_inputEspecialidadeActionPerformed

    private void inputCRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCRMActionPerformed
    }//GEN-LAST:event_inputCRMActionPerformed

    private void comboBoxPeriodoDeAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxPeriodoDeAtendimentoActionPerformed
    }//GEN-LAST:event_comboBoxPeriodoDeAtendimentoActionPerformed

    private void inputNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNomeActionPerformed
    }//GEN-LAST:event_inputNomeActionPerformed

    private void limparDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparDadosActionPerformed
        this.limparDados();
    }//GEN-LAST:event_limparDadosActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.limparDados();
        this.setVisible(false);
    }//GEN-LAST:event_cancelarActionPerformed

    private void tabelaMedicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMedicoMouseClicked
        int selectedRow = this.tabelaMedico.getSelectedRow();
        if (selectedRow != -1) {

            this.inputNome.setText(this.tabelaMedico.getValueAt(this.tabelaMedico.getSelectedRow(), 1).toString());
            this.inputTelefone.setText(this.tabelaMedico.getValueAt(this.tabelaMedico.getSelectedRow(), 2).toString());
            this.inputEspecialidade.setText(this.tabelaMedico.getValueAt(this.tabelaMedico.getSelectedRow(), 3).toString());
            this.inputCRM.setText(this.tabelaMedico.getValueAt(this.tabelaMedico.getSelectedRow(), 4).toString());
            this.comboBoxPeriodoDeAtendimento.setSelectedItem(this.tabelaMedico.getValueAt(this.tabelaMedico.getSelectedRow(), 5));

        }
    }//GEN-LAST:event_tabelaMedicoMouseClicked

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
        try {

            Long id = obterIdMedico();
            String nome = this.inputNome.getText();
            String telefone = this.inputTelefone.getText();
            String especialidade = this.inputEspecialidade.getText();
            String crm = this.inputCRM.getText();
            String periodoDeAtendimento = this.comboBoxPeriodoDeAtendimento.getItemAt(this.comboBoxPeriodoDeAtendimento.getSelectedIndex());

            if (((periodoDeAtendimento.equalsIgnoreCase("matutino"))
                    ? (MEDICO_CONTROL.buscarQuantidadeDeMedicosNoPeriodoMatutino() < NUMERO_MAXIMO_DE_MEDICOS_POR_PERIODO_DE_ATENDIMENTO)
                    : (MEDICO_CONTROL.buscarQuantidadeDeMedicosNoPeriodoVespertino() < NUMERO_MAXIMO_DE_MEDICOS_POR_PERIODO_DE_ATENDIMENTO))) {

                MEDICO_CONTROL.editar(id, nome, telefone, especialidade, crm, periodoDeAtendimento);

                JOptionPane.showMessageDialog(null, "Medico atualizado com sucesso!");

                this.limparDados();
                this.carregarMedicos();
            } else {
                JOptionPane.showMessageDialog(null, "Número máximo de médicos neste turno atingido.", "Ocorreu um problema", JOptionPane.WARNING_MESSAGE);
            }
        } catch (RuntimeException e) {

        }
    }//GEN-LAST:event_atualizarActionPerformed
    private void exdcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exdcluirActionPerformed
        try {
            int escolhaDoUsuario = JOptionPane.showConfirmDialog(null, "Deseja, realmente, excluir esse médico? \nEssa ação não poderá ser desfeita!");
            if (escolhaDoUsuario == 0) {
                MEDICO_CONTROL.excluir(this.obterIdMedico());
                JOptionPane.showMessageDialog(null, "O médico foi removido com sucesso!");
                this.carregarMedicos();
                this.limparDados();
            } else {
                JOptionPane.showMessageDialog(null, "O médico será mantido!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_exdcluirActionPerformed
    private void tabelaMedicoVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_tabelaMedicoVetoableChange
    }//GEN-LAST:event_tabelaMedicoVetoableChange
    private void tabelaMedicoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabelaMedicoPropertyChange
    }//GEN-LAST:event_tabelaMedicoPropertyChange
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        this.carregarMedicos();
    }//GEN-LAST:event_formWindowActivated

    private Long obterIdMedico() {

        int selectedRow = this.tabelaMedico.getSelectedRow();
        if (selectedRow != VALOR_DE_RETORNO_QUANDO_NAO_HOUVER_LINHA_SELECIONADA_NA_JTABLE) {
            return Long.parseLong(this.tabelaMedico.getValueAt(selectedRow, 0).toString());
        } else {
            String mensagem = "Nenhuma linha selecionada. Selecione uma linha para alterar seus dados";
            JOptionPane.showMessageDialog(null, mensagem);
            throw new RuntimeException(mensagem);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDeGerenciamentoDeMedicos().setVisible(true);
            }
        });
    }

    private void limparDados() {
        this.inputCRM.setText("");
        this.inputEspecialidade.setText("");
        this.inputNome.setText("");
        this.inputTelefone.setText("");
        this.comboBoxPeriodoDeAtendimento.setSelectedIndex(0);
        Integer numeroDeLinhasSelecionadas = this.tabelaMedico.getRowCount() - 1;
        if (numeroDeLinhasSelecionadas != -1) {
            this.tabelaMedico.removeRowSelectionInterval(0, numeroDeLinhasSelecionadas);
        }
    }

    private void carregarMedicos() {
        DefaultTableModel tabela = (DefaultTableModel) this.tabelaMedico.getModel();
        tabela.setNumRows(0);

        ArrayList<Medico> lista = MEDICO_CONTROL.buscar();

        if (lista != null) {

            lista.forEach(medico -> {
                tabela.addRow(new Object[]{
                    medico.getIdMedico(),
                    medico.getNome(),
                    medico.getTelefone(),
                    medico.getEspecialidade(),
                    medico.getCrm(),
                    medico.getPeriodoDeAtendimento()
                });
            });
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizar;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox<String> comboBoxPeriodoDeAtendimento;
    private javax.swing.JButton exdcluir;
    private javax.swing.JTextField inputCRM;
    private javax.swing.JTextField inputEspecialidade;
    private javax.swing.JTextField inputNome;
    private javax.swing.JTextField inputTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limparDados;
    private javax.swing.JTable tabelaMedico;
    // End of variables declaration//GEN-END:variables
}
