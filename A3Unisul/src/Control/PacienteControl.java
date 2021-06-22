/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Interface.CrudInterface;
import Model.Endereco;
import Model.Paciente;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author G-fire
 */
public class PacienteControl {

    private static final Paciente PACIENTE = new Paciente();

    public boolean cadastrar(String nome, String telefone, LocalDate dataDeNascimento, String cpf) throws SQLException {
        return PACIENTE.cadastrar(new Paciente(PACIENTE.obterMaiorId() + 1,PACIENTE.carregarEndereco(PACIENTE.obterMaiorIdDeEndereco()), dataDeNascimento, nome, telefone, cpf));
    }

    public ArrayList<PacienteControl> buscar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean editar(Long id, PacienteControl object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean excluir(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
