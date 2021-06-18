package Model;

import DAO.PacienteDAO;
import Interface.CrudInterface;
import java.time.LocalDate;
import java.util.ArrayList;

public class Paciente extends Pessoa implements CrudInterface<Paciente> {

    private Long idPaciente;
    private Endereco endereco;
    private LocalDate dataDeNascimento;
    private String cpf;
    
    private static final PacienteDAO PACIENTE_DAO = new PacienteDAO();

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
        return PACIENTE_DAO.cadastrar(object);
    }

    @Override
    public ArrayList<Paciente> buscar() {
        return PACIENTE_DAO.buscar();
    }

    @Override
    public boolean editar(Long id, Paciente object) {
        return PACIENTE_DAO.editar(id, object);
    }

    @Override
    public boolean excluir(Long id) {
        return PACIENTE_DAO.excluir(id);
    }

    @Override
    public String toString() {
        return "Paciente{" + "idPaciente=" + idPaciente + ", \nendereco=" + endereco + ", \ndataDeNascimento=" + dataDeNascimento + ", cpf=" + cpf + "}\n";
    }

}
