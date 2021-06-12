package Model;

import Interface.CrudInterface;
import java.time.LocalDate;
import java.util.ArrayList;

public class Paciente extends Pessoa implements CrudInterface<Paciente>{

    private Long idPaciente;
    private Endereco endereco;
    private LocalDate dataDeNascimento;

    public Paciente() {
    }

    public Paciente(Long idPaciente, Endereco endereco, LocalDate dataDeNascimento, String nome, String telefone) {
        super(nome, telefone);
        this.idPaciente = idPaciente;
        this.endereco = endereco;
        this.dataDeNascimento = dataDeNascimento;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Paciente> buscar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editar(Long id, Paciente object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Paciente{" + "idPaciente=" + idPaciente + ", endereco=" + endereco + ", dataDeNascimento=" + dataDeNascimento + '}';
    }

    
}
