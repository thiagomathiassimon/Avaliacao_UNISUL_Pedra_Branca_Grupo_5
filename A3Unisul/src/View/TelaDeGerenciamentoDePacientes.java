package View;

import Control.EnderecoControl;
import Control.PacienteControl;
import Model.Paciente;
import static Util.Validacoes.validarDtNascimento;
import static Util.Validacoes.validarCpf;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import org.json.JSONObject;
import static Util.MensagensDestinadasAoUsuario.mensagemAlerta;
import static Util.MensagensDestinadasAoUsuario.mensagemConfirmacao;
import static Util.MensagensDestinadasAoUsuario.mensagemErro;
import static Util.MensagensDestinadasAoUsuario.mensagemSucesso;
import static Util.Validacoes.validarNome;

public class TelaDeGerenciamentoDePacientes extends javax.swing.JFrame {

    private static final PacienteControl PACIENTE_CONTROL = new PacienteControl();
    private static final EnderecoControl ENDERECO_CONTROL = new EnderecoControl();
    private static final Integer RETORNO_DE_CONFIRMACAO_DO_JOPTIONPANE_SHOW_CONFIRM_DIALOG = 0;
    private static final Integer VALOR_DE_RETORNO_QUANDO_NAO_HOUVER_LINHA_SELECIONADA_NA_JTABLE = -1;

    public TelaDeGerenciamentoDePacientes() {
        initComponents();
        getContentPane().setBackground(Color.getColor("282a36"));
        this.carregarPacientes();
        URL imagem = this.getClass().getResource("/Assets/Assets.png");
        Image icone = Toolkit.getDefaultToolkit().getImage(imagem);
        this.setIconImage(icone);

        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();

        centralizado.setHorizontalAlignment(SwingConstants.CENTER);

        Integer numeoDeColunasDaTabela = this.tabelaPacientes.getColumnCount() - 1;
        for (int i = 0; i <= numeoDeColunasDaTabela; i++) {
            this.tabelaPacientes.getColumnModel().getColumn(i).setCellRenderer(centralizado);
        }
    }

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
        jLabel6.setText("Gerenciamento de Pacientes");

        tabelaPacientes.setBackground(new java.awt.Color(40, 42, 54));
        tabelaPacientes.setForeground(new java.awt.Color(245, 245, 245));

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

        excluir.setBackground(new java.awt.Color(94, 23, 203));
        excluir.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        excluir.setForeground(new java.awt.Color(245, 245, 245));
        excluir.setText("Excluir");
        excluir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        atualizar.setBackground(new java.awt.Color(94, 23, 203));
        atualizar.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        atualizar.setForeground(new java.awt.Color(245, 245, 245));
        atualizar.setText("Atualizar");
        atualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });

        limparDados.setBackground(new java.awt.Color(94, 23, 203));
        limparDados.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        limparDados.setForeground(new java.awt.Color(245, 245, 245));
        limparDados.setText("Limpar dados");
        limparDados.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        limparDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparDadosActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(56, 182, 246));
        jLabel5.setText("CPF*:");

        inputNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNomeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(56, 182, 246));
        jLabel1.setText("Nome*:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(56, 182, 246));
        jLabel2.setText("Telefone*:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(56, 182, 246));
        jLabel4.setText("Data de Nascimento*:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(56, 182, 246));
        jLabel7.setText("Sigla do Estado*:");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(56, 182, 246));
        jLabel8.setText("Município*:");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(56, 182, 246));
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
        jLabel10.setForeground(new java.awt.Color(56, 182, 246));
        jLabel10.setText("Logradouro*:");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(56, 182, 246));
        jLabel11.setText("Número*:");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(56, 182, 246));
        jLabel12.setText("Complemento*:");

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

        cancelar.setBackground(new java.awt.Color(94, 23, 203));
        cancelar.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        cancelar.setForeground(new java.awt.Color(245, 245, 245));
        cancelar.setText("Voltar");
        cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(56, 182, 246));
        jLabel13.setText("CEP*:");

        buscarCEP.setBackground(new java.awt.Color(94, 23, 203));
        buscarCEP.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        buscarCEP.setForeground(new java.awt.Color(245, 245, 245));
        buscarCEP.setText("Buscar");
        buscarCEP.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        inputDataDeNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputDataDeNascimentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputDataDeNascimento, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inputNome, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                            .addComponent(inputTelefone)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(limparDados)
                                .addGap(2, 2, 2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(inputCEP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buscarCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(inputCPF))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel10))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(inputNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(inputLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(44, 44, 44)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel9))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(inputBairro, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                                        .addComponent(inputMunicipio)
                                        .addComponent(inputEstado))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                        .addComponent(atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(inputComplemento))))
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(inputEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inputMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(inputBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputDataDeNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(inputLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel11)
                    .addComponent(inputNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(inputComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(atualizar)
                    .addComponent(excluir)
                    .addComponent(limparDados)
                    .addComponent(cancelar))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void limparDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparDadosActionPerformed
        this.limparDados();
    }//GEN-LAST:event_limparDadosActionPerformed
    private void inputNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNomeActionPerformed
    }//GEN-LAST:event_inputNomeActionPerformed
    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        try {
            int escolhaDoUsuario = mensagemConfirmacao("Deseja, realmente, excluir esse paciente? \nEssa ação não poderá ser desfeita!");
            if (escolhaDoUsuario == RETORNO_DE_CONFIRMACAO_DO_JOPTIONPANE_SHOW_CONFIRM_DIALOG) {
                PACIENTE_CONTROL.excluir(this.obterIdPaciente());
                mensagemSucesso("O paciente foi removido com sucesso! ");
                this.carregarPacientes();
                this.limparDados();
            } else {
                mensagemAlerta("O paciente será mantido! ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_excluirActionPerformed
    private void inputBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputBairroActionPerformed
    }//GEN-LAST:event_inputBairroActionPerformed
    private void inputMunicipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputMunicipioActionPerformed
    }//GEN-LAST:event_inputMunicipioActionPerformed
    private void inputComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputComplementoActionPerformed
    }//GEN-LAST:event_inputComplementoActionPerformed
    private void inputNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNumeroActionPerformed
    }//GEN-LAST:event_inputNumeroActionPerformed
    private void inputLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputLogradouroActionPerformed
    }//GEN-LAST:event_inputLogradouroActionPerformed
    private void buscarCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarCEPActionPerformed
        this.buscarCEP();
    }//GEN-LAST:event_buscarCEPActionPerformed
    private void inputCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCPFActionPerformed
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
            String estado = this.inputEstado.getText();
            String municipio = this.inputMunicipio.getText();
            String bairro = this.inputBairro.getText();
            String logradouro = this.inputLogradouro.getText();
            String numero = this.inputNumero.getText();
            String complemento = this.inputComplemento.getText();
            
            if (!validarNome(nome)) {
                mensagemErro("Nome informado inválido.");
            } else if (!validarDtNascimento(dataDeNascimento)) {
                mensagemErro("Data de nascimento inválida");
            } else if (!validarCpf(cpf)) {
                mensagemErro("CPF inválido", "Erro");
            } else if (estado.isEmpty() || municipio.isEmpty() || bairro.isEmpty() || logradouro.isEmpty() || numero.isEmpty() || 
                    complemento.isEmpty() || cep.isEmpty()){
                mensagemErro("Todos os campos são obrigatórios.");
            } else {
                System.out.println(cpf);
                System.out.println(id);
                ENDERECO_CONTROL.editar(id, estado, municipio, bairro, logradouro, numero, complemento, cep);
                PACIENTE_CONTROL.editar(id, nome, telefone, dataDeNascimento, cpf);

                mensagemSucesso("Paciente atualizado com sucesso!");

                this.limparDados();
                this.carregarPacientes();
            }
        } catch (Exception e) {
           mensagemErro("Não foi possível concluir a operação. Por favor, verifique seus dados e tente novamente.");
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
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        this.carregarPacientes();
    }//GEN-LAST:event_formWindowActivated
    private void inputDataDeNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputDataDeNascimentoActionPerformed
    }//GEN-LAST:event_inputDataDeNascimentoActionPerformed

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
                mensagemErro("Não foi possível concluir a operação. Por favor, tente novamente.");
                e.printStackTrace();
            }
        } else {
            mensagemAlerta("Informe um CEP completo!");
        }

    }

    public static void main(String args[]) {
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
        Integer numeroDeLinhasSelecionadas = this.tabelaPacientes.getRowCount() - 1;
        if (numeroDeLinhasSelecionadas != -1) {
            this.tabelaPacientes.removeRowSelectionInterval(0, numeroDeLinhasSelecionadas);
        }
        this.verificarPermissaoDosCampos();
    }

    private void verificarPermissaoDosCampos() {

        this.inputEstado.setEditable(this.inputEstado.getText().trim().isEmpty());
        this.inputMunicipio.setEditable(this.inputMunicipio.getText().isEmpty());
        this.inputBairro.setEditable(this.inputBairro.getText().isEmpty());
        this.inputLogradouro.setEditable(this.inputLogradouro.getText().isEmpty());
    }

    private void carregarPacientes() {
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
            mensagemAlerta(mensagem);
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
