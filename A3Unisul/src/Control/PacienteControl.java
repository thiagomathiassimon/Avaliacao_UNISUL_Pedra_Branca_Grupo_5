package Control;

import Model.Endereco;
import Model.Paciente;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class PacienteControl {

    private static final Paciente PACIENTE = new Paciente();
    private static final Endereco ENDERECO = new Endereco();

    public boolean cadastrar(String nome, String telefone, LocalDate dataDeNascimento, String cpf) throws SQLException {
        return PACIENTE.cadastrar(new Paciente(
                PACIENTE.obterMaiorId() + 1, ENDERECO.carregarEndereco(ENDERECO.buscarMaiorIdDeEndereco()), dataDeNascimento, nome, telefone, cpf));
    }

    public ArrayList<Paciente> buscar() {
        return PACIENTE.buscar();
    }

    public boolean editar(Long id, String nome, String telefone, LocalDate dataDeNascimento, String cpf) throws SQLException {

        return PACIENTE.editar(id, new Paciente(id, ENDERECO.carregarEndereco(id), dataDeNascimento, nome, telefone, cpf));

    }

    public boolean excluir(Long id) {
        return PACIENTE.excluir(id);
    }

    public Paciente buscarPacientePorCPF(String cpf) {
        return PACIENTE.buscarPacientePorCPF(cpf);
    }

    public Paciente carregarPaciente(Long id) {
        return PACIENTE.carregarPaciente(id);
    }
}
