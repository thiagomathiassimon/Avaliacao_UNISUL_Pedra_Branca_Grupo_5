package Model;

import DAO.PacienteDAO;
import Exception.InvalidBornDateException;
import Exception.InvalidCPFException;
import Interface.CrudInterface;
import Util.Validacoes;
import java.time.LocalDate;
import java.util.ArrayList;
import static Util.Validacoes.validarCpf;
import static Util.Validacoes.validarDtNascimento;

public class Paciente extends Pessoa implements CrudInterface<Paciente> {

    private Long idPaciente;
    private Endereco endereco;
    private LocalDate dataDeNascimento;
    private String cpf;
    private static PacienteDAO pacienteDAO = new PacienteDAO();

    public Paciente() {
    }

    public Paciente(Long idPaciente, Endereco endereco, LocalDate dataDeNascimento, String nome, String telefone, String cpf) {
        super(nome, telefone);
        this.idPaciente = idPaciente;
        this.endereco = endereco;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public boolean cadastrar(Paciente object) {

        try {
            return ((validarCpf(object.getCpf())
                    || validarDtNascimento(object.getDataDeNascimento())) ? pacienteDAO.cadastrar(object) : false);

        } catch (InvalidCPFException ice) {
            throw new InvalidCPFException("CPF informado não é válido.");
        } catch (InvalidBornDateException ibde) {
            throw new InvalidBornDateException("A data de nascimento informada é inválida.");

        }

    }

    @Override
    public ArrayList<Paciente> buscar() {
        return pacienteDAO.buscar();
    }

    @Override
    public boolean editar(Long id, Paciente object) {
        try {
            return ((validarCpf(object.getCpf())
                    || validarDtNascimento(object.getDataDeNascimento())) ? pacienteDAO.editar(id, object) : false);

        } catch (InvalidCPFException ice) {
            throw new InvalidCPFException("CPF informado não é válido.");
        } catch (InvalidBornDateException ibde) {
            throw new InvalidBornDateException("A data de nascimento informada é inválida.");

        }
    }

    @Override
    public boolean excluir(Long id) {
        return pacienteDAO.excluir(id);
    }

    @Override
    public String toString() {
        return "Paciente{" + "idPaciente=" + idPaciente + ", \nendereco=" + endereco + ", \ndataDeNascimento=" + dataDeNascimento + ", cpf=" + cpf + "}\n";
    }

}
