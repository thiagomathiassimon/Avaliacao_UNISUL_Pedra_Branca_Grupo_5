package Model;

import DAO.MedicoDAO;
import Interface.CrudInterface;
import java.sql.SQLException;
import java.util.ArrayList;

public class Medico extends Pessoa implements CrudInterface<Medico> {

    private Long idMedico;
    private String crm;
    private String especialidade;
    private String periodoDeAtendimento;

    private static final MedicoDAO MEDICO_DAO = new MedicoDAO();

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

    public Long obterMaiorID() {
        return this.MEDICO_DAO.buscarMaiorId();
    }

    @Override
    public boolean cadastrar(Medico object) {
        return MEDICO_DAO.cadastrar(object);
    }

    @Override
    public ArrayList<Medico> buscar() {
        return MEDICO_DAO.buscar();
    }

    @Override
    public boolean editar(Long id, Medico object) {
        return MEDICO_DAO.editar(id, object);
    }

    @Override
    public boolean excluir(Long id) {
        return MEDICO_DAO.excluir(id);
    }

    public Medico carregarMedicoEspecificadoPeloId(Long id) {
        try {
            return MEDICO_DAO.carregarMedico(id);
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na consulta no Banco Dados!");
        }
    }

    public int buscarQuantidadeDeMedicosNoPeriodoMatutino() {
        return MEDICO_DAO.buscarQuantidadeDeMedicosNoPeriodoMatutino();
    }

    public int buscarQuantidadeDeMedicosNoPeriodoVespertino() {
        return MEDICO_DAO.buscarQuantidadeDeMedicosNoPeriodoVespertino();
    }

    public String obterOHorarioDeAtendimentoDeUmMedico(Long id) {
        try {
            return MEDICO_DAO.obterOHorarioDeAtendimentoDeUmMedico(id);
        } catch (SQLException ex) {
            throw new RuntimeException("Ocorreu um erro na consulta ao banco de dados!");
        }
    }

}
