package Model;

import Interface.CrudInterface;
import java.util.ArrayList;

public class Medico extends Pessoa implements CrudInterface<Medico>{

    private Long idMedico;
    private String crm;
    private String especialidade;
    private String periodoDeAtendimento;

    public Medico() {
    }

    public Medico(Long idMedico, String crm, String especialidade, String periodoDeAtendimento, String nome, String telefone) {
        super(nome, telefone);
        this.idMedico = idMedico;
        this.crm = crm;
        this.especialidade = especialidade;
        this.periodoDeAtendimento = periodoDeAtendimento;
    }


    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getPeriodoDeAtendimento() {
        return periodoDeAtendimento;
    }

    public void setPeriodoDeAtendimento(String periodoDeAtendimento) {
        this.periodoDeAtendimento = periodoDeAtendimento;
    }

    public Long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }

    @Override
    public String toString() {
        return "Medico{" + "idMedico=" + idMedico + ", crm=" + crm + ", especialidade=" + especialidade + ", periodoDeAtendimento=" + periodoDeAtendimento + '}';
    }

    
    
    @Override
    public boolean cadastrar(Medico object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Medico> buscar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editar(Long id, Medico object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
