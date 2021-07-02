/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.EnderecoControl;
import Control.PacienteControl;
import Model.Paciente;
import static Util.Validacoes.validarDtNascimento;
import static Util.Validacoes.validarCpf;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import org.json.JSONObject;

/**
 *
 * @author G-fire
 */
public class TelaDeGerenciamentoDePacientes extends javax.swing.JFrame {

    private static final PacienteControl PACIENTE_CONTROL = new PacienteControl();
    private static final EnderecoControl ENDERECO_CONTROL = new EnderecoControl();
    private static final Integer RETORNO_DE_CONFIRMACAO_DO_JOPTIONPANE_SHOW_CONFIRM_DIALOG = 0;
    private static final Integer VALOR_DE_RETORNO_QUANDO_NAO_HOUVER_LINHA_SELECIONADA_NA_JTABLE = -1;

    /**
     * Creates new form TelaDeGerenciarMedicos
     */
    public TelaDeGerenciamentoDePacientes() {
        initComponents();
        this.carregarPacientes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaPacientes = new javax.swing.JTable();
        excluir = new javax.swing.JButton();
        atualizar = new javax.swing.JButton();
        limparDados = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        inputNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        inputBairro = new javax.swing.JTextField();
        inputMunicipio = new javax.swing.JTextField();
        inputEstado = new javax.swing.JFormattedTextField();
        try{
            inputEstado = new JFormattedTextField(new MaskFormatter("UU"));
        }catch(Exception e){
            e.printStackTrace();
        }
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        inputComplemento = new javax.swing.JTextField();
        inputNumero = new javax.swing.JTextField();
        inputLogradouro = new javax.swing.JTextField();
        cancelar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        inputCEP = new javax.swing.JFormattedTextField();
        try{
            inputCEP = new JFormattedTextField(new MaskFormatter("#####-###"));
        }catch(Exception e){
            e.printStackTrace();
        }
        buscarCEP = new javax.swing.JButton();
        inputCPF = new javax.swing.JFormattedTextField();
        try {
            inputCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
        } catch (ParseException ex) {
            Logger.getLogger(TelaDeCadastroDeMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        inputDataDeNascimento = new javax.swing.JFormattedTextField();
        try {
            inputDataDeNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
        } catch (ParseException ex) {
            Logger.getLogger(TelaDeCadastroDeMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        inputTelefone = new javax.swing.JFormattedTextField();
        try {             inputTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));         } catch (Exception e) {          }

        setTitle("Gerenciamento");
        setResizable(false);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Gerenciamento de Pacientes");

        tabelaPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Telefone", "Data de Nascimento", "CPF", "CEP"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
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
        tabelaPacientes.getTableHeader().setReorderingAllowed(false);
        tabelaPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaPacientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaPacientes);
        if (tabelaPacientes.getColumnModel().getColumnCount() > 0) {
            tabelaPacientes.getColumnModel().getColumn(0).setResizable(false);
            tabelaPacientes.getColumnModel().getColumn(1).setResizable(false);
            tabelaPacientes.getColumnModel().getColumn(2).setResizable(false);
            tabelaPacientes.getColumnModel().getColumn(3).setResizable(false);
            tabelaPacientes.getColumnModel().getColumn(4).setResizable(false);
            tabelaPacientes.getColumnModel().getColumn(5).setResizable(false);
        }

        excluir.setText("Excluir");
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        atualizar.setText("Atualizar");
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });

        limparDados.setText("Limpar dados");
        limparDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparDadosActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("CPF*:");

        inputNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNomeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Nome*:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Telefone*:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Data de Nascimento*:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Sigla do Estado*:");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Município*:");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("Bairro*:");

        inputBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputBairroActionPerformed(evt);
            }
        });

        inputMunicipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputMunicipioActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setText("Logradouro*:");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setText("Número*:");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setText("Complemento:");

        inputComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputComplementoActionPerformed(evt);
            }
        });

        inputNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNumeroActionPerformed(evt);
            }
        });

        inputLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputLogradouroActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setText("CEP*:");

        buscarCEP.setText("Buscar");
        buscarCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarCEPActionPerformed(evt);
            }
        });

        inputCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCPFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputTelefone)
                            .addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(4, 4, 4)
                        .addComponent(inputDataDeNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(inputCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(inputCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(90, 90, 90)
                                    .addComponent(limparDados))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(excluir)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(91, 91, 91)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(73, 73, 73)
                                        .addComponent(cancelar)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(atualizar))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(inputComplemento, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                            .addComponent(inputNumero, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(inputLogradouro, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(inputBairro))
                                        .addGap(14, 14, 14))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buscarCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(inputEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(inputMunicipio)))))
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(inputTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputDataDeNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(inputCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(inputBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(atualizar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(excluir)
                        .addComponent(limparDados))
                    .addComponent(cancelar))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void limparDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparDadosActionPerformed
        this.limparDados();
    }//GEN-LAST:event_limparDadosActionPerformed

    private void inputNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNomeActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        try {
            int escolhaDoUsuario = JOptionPane.showConfirmDialog(null, "Deseja, realmente, excluir esse paciente? \nEssa ação não poderá ser desfeita!");
            if (escolhaDoUsuario == RETORNO_DE_CONFIRMACAO_DO_JOPTIONPANE_SHOW_CONFIRM_DIALOG) {
                PACIENTE_CONTROL.excluir(this.obterIdPaciente());
                JOptionPane.showMessageDialog(null, "O paciente foi removido com sucesso!");
                this.carregarPacientes();
                this.limparDados();
            } else {
                JOptionPane.showMessageDialog(null, "O paciente será mantido!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_excluirActionPerformed

    private void inputBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputBairroActionPerformed

    private void inputMunicipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputMunicipioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputMunicipioActionPerformed

    private void inputComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputComplementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputComplementoActionPerformed

    private void inputNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNumeroActionPerformed

    private void inputLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputLogradouroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputLogradouroActionPerformed

    private void buscarCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarCEPActionPerformed
        this.buscarCEP();
    }//GEN-LAST:event_buscarCEPActionPerformed

    private void inputCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputCPFActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.limparDados();
        this.setVisible(false);
    }//GEN-LAST:event_cancelarActionPerformed

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed

        try {

            Long id = obterIdPaciente();
            String nome = this.inputNome.getText();
            String telefone = this.inputTelefone.getText();
            String[] dataInformada = this.inputDataDeNascimento.getText().split("/");
            LocalDate dataDeNascimento = LocalDate.parse(dataInformada[2] + "-" + dataInformada[1] + "-" + dataInformada[0]);

            String cpf = this.inputCPF.getText().substring(0, 3) + this.inputCPF.getText().substring(4, 7)
            + this.inputCPF.getText().substring(8, 11) + this.inputCPF.getText().substring(12, 14);

            String cep = this.inputCEP.getText();
            // && validarCpf(cpf)
            if (!validarDtNascimento(dataDeNascimento)) {
                JOptionPane.showMessageDialog(null, "Data de Nascimento Inválida");
            }
            else if (!validarCpf(cpf)) {
                JOptionPane.showMessageDialog(null, "CPF Inválido", "Erro", JOptionPane.ERROR_MESSAGE);
                //  JOptionPane.showMessageDialog(null, "CPF Inválido");
            } else {
                System.out.println(cpf);
                PACIENTE_CONTROL.editar(id, nome, telefone, dataDeNascimento, cpf);

                JOptionPane.showMessageDialog(null, "Paciente atualizado com sucesso!");

                this.limparDados();
                this.carregarPacientes();
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_atualizarActionPerformed

    private void tabelaPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPacientesMouseClicked
        int selectedRow = this.tabelaPacientes.getSelectedRow();

        if (selectedRow != -1) {
            Paciente paciente = PACIENTE_CONTROL.carregarPaciente(this.obterIdPaciente());
            JTextField nome = this.inputNome;
            JTextField telefone = this.inputTelefone;
            JTextField dataDeNascimento = this.inputDataDeNascimento;
            JTextField cpf = this.inputCPF;

            JTextField cep = this.inputCEP;
            JTextField estado = this.inputEstado;
            JTextField bairro = this.inputBairro;
            JTextField municipio = this.inputMunicipio;
            JTextField logradouro = this.inputLogradouro;
            JTextField numero = this.inputNumero;
            JTextField complemento = this.inputComplemento;
            JTable tabelaPacientes = this.tabelaPacientes;

            nome.setText(tabelaPacientes.getValueAt(tabelaPacientes.getSelectedRow(), 1).toString());
            telefone.setText(tabelaPacientes.getValueAt(tabelaPacientes.getSelectedRow(), 2).toString());
            String[] dataInformada = tabelaPacientes.getValueAt(tabelaPacientes.getSelectedRow(), 3).toString().split("/");
            String dtNascimento = dataInformada[0] + dataInformada[1] + dataInformada[2];
            dataDeNascimento.setText(dtNascimento);
            cpf.setText(tabelaPacientes.getValueAt(tabelaPacientes.getSelectedRow(), 4).toString());

            cep.setText(tabelaPacientes.getValueAt(tabelaPacientes.getSelectedRow(), 5).toString());

            this.buscarCEP();

            estado.setText(paciente.getEndereco().getEstado());
            bairro.setText(paciente.getEndereco().getBairro());
            municipio.setText(paciente.getEndereco().getMunicipio());
            logradouro.setText(paciente.getEndereco().getLogradouro());
            numero.setText(paciente.getEndereco().getNumero());
            complemento.setText(paciente.getEndereco().getComplemento());

        }
    }//GEN-LAST:event_tabelaPacientesMouseClicked

    private void buscarCEP() {
        String cepInformado = this.inputCEP.getText();

        if (cepInformado.trim().length() == 9) {
            try {
                String[] cep = cepInformado.split("-");
                String primeiraParte = cep[0];
                String segundaParte = cep[1];

                JSONObject endereco = ENDERECO_CONTROL.bucarEnderecoPeloCEP(primeiraParte + segundaParte);

                JFormattedTextField estado = this.inputEstado;
                JTextField municipio = this.inputMunicipio;
                JTextField bairro = this.inputBairro;
                JTextField logradouro = this.inputLogradouro;
                JTextField complemento = this.inputComplemento;

                estado.setText(endereco.get("uf").toString());
                municipio.setText(endereco.get("localidade").toString());
                bairro.setText(endereco.get("bairro").toString());
                logradouro.setText(endereco.get("logradouro").toString());
                complemento.setText(endereco.get("complemento").toString());
                this.verificarPermissaoDosCampos();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Informe um CEP completo!");
        }

    }

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
            java.util.logging.Logger.getLogger(TelaDeGerenciamentoDePacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeGerenciamentoDePacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeGerenciamentoDePacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeGerenciamentoDePacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDeGerenciamentoDePacientes().setVisible(true);
            }
        });
    }

    private void limparDados() {
        this.inputCPF.setText("");
        this.inputDataDeNascimento.setText("");
        this.inputNome.setText("");
        this.inputTelefone.setText("");
        this.inputCPF.setText("");
        this.inputCEP.setText("");
        this.inputEstado.setText("");
        this.inputBairro.setText("");
        this.inputMunicipio.setText("");
        this.inputLogradouro.setText("");
        this.inputNumero.setText("");
        this.inputComplemento.setText("");
        this.verificarPermissaoDosCampos();
    }

    private void verificarPermissaoDosCampos() {

        this.inputEstado.setEditable(this.inputEstado.getText().trim().isEmpty());
        this.inputMunicipio.setEditable(this.inputMunicipio.getText().isEmpty());
        this.inputBairro.setEditable(this.inputBairro.getText().isEmpty());
        this.inputLogradouro.setEditable(this.inputLogradouro.getText().isEmpty());
    }

    public void carregarPacientes() {
        DefaultTableModel tabela = (DefaultTableModel) this.tabelaPacientes.getModel();
        tabela.setNumRows(0);

        ArrayList<Paciente> lista = PACIENTE_CONTROL.buscar();

        if (lista != null) {

            lista.forEach(paciente -> {
                String[] dataDeNascimento = paciente.getDataDeNascimento().toString().split("-");
                tabela.addRow(new Object[]{
                    paciente.getIdPaciente(),
                    paciente.getNome(),
                    paciente.getTelefone(),
                    String.format("%s/%s/%s", dataDeNascimento[2], dataDeNascimento[1], dataDeNascimento[0]),
                    paciente.getCpf(),
                    paciente.getEndereco().getCep()
                });
            });
        }
    }

    private Long obterIdPaciente() {

        int selectedRow = this.tabelaPacientes.getSelectedRow();
        if (selectedRow != VALOR_DE_RETORNO_QUANDO_NAO_HOUVER_LINHA_SELECIONADA_NA_JTABLE) {
            return Long.parseLong(this.tabelaPacientes.getValueAt(selectedRow, 0).toString());
        } else {
            String mensagem = "Nenhuma linha selecionada. Selecione uma linha para alterar seus dados";
            JOptionPane.showMessageDialog(null, mensagem);
            throw new RuntimeException(mensagem);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizar;
    private javax.swing.JButton buscarCEP;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton excluir;
    private javax.swing.JTextField inputBairro;
    private javax.swing.JFormattedTextField inputCEP;
    private javax.swing.JFormattedTextField inputCPF;
    private javax.swing.JTextField inputComplemento;
    private javax.swing.JFormattedTextField inputDataDeNascimento;
    private javax.swing.JFormattedTextField inputEstado;
    private javax.swing.JTextField inputLogradouro;
    private javax.swing.JTextField inputMunicipio;
    private javax.swing.JTextField inputNome;
    private javax.swing.JTextField inputNumero;
    private javax.swing.JFormattedTextField inputTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton limparDados;
    private javax.swing.JTable tabelaPacientes;
    // End of variables declaration//GEN-END:variables
}
