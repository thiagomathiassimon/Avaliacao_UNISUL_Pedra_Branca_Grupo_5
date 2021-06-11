package Model;

import Interface.CrudInterface;
import java.time.LocalDate;
import java.util.ArrayList;

public class Consulta implements CrudInterface<Consulta>{
    
    private Long idConsulta; 
    private Paciente paciente;
    private Medico medico;
    private LocalDate dataDoExame;
    private String horarioDeExame;
    private String descricao;

    public Consulta() {
    }    

    public Consulta(Long idConsulta, Paciente paciente, Medico medico, LocalDate dataDoExame, String horarioDeExame, String descricao) {
        this.idConsulta = idConsulta;
        this.paciente = paciente;
        this.medico = medico;
        this.dataDoExame = dataDoExame;
        this.horarioDeExame = horarioDeExame;
        this.descricao = descricao;
    }

    
    public Long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Long idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public LocalDate getDataDoExame() {
        return dataDoExame;
    }

    public void setDataDoExame(LocalDate dataDoExame) {
        this.dataDoExame = dataDoExame;
    }

    public String getHorarioDeExame() {
        return horarioDeExame;
    }

    public void setHorarioDeExame(String horarioDeExame) {
        this.horarioDeExame = horarioDeExame;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean cadastrar(Consulta object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Consulta> buscar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editar(Long id, Consulta object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    


    
    
}
