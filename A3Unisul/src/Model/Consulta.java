package Model;

import DAO.ConsultaDAO;
import Interface.CrudInterface;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Consulta implements CrudInterface<Consulta> {

    private Long idConsulta;
    private Paciente paciente;
    private Medico medico;
    private LocalDate dataDoExame;
    private String horarioDeExame;
    private String descricao;

    private static final ConsultaDAO CONSULTA_DAO = new ConsultaDAO();

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
        return this.CONSULTA_DAO.cadastrar(object);
    }

    @Override
    public ArrayList<Consulta> buscar() {
        return this.CONSULTA_DAO.buscar();
    }

    @Override
    public boolean editar(Long id, Consulta object) {
        return this.CONSULTA_DAO.editar(id, object);
    }

    @Override
    public boolean excluir(Long id) {
        return this.CONSULTA_DAO.excluir(id);
    }

    @Override
    public String toString() {
        return "Consulta{" + "idConsulta=" + idConsulta + ", paciente=" + paciente + ", medico=" + medico + ", dataDoExame=" + dataDoExame + ", horarioDeExame=" + horarioDeExame + ", descricao=" + descricao + '}';
    }

    public ArrayList<String[]> buscarMedicos() throws SQLException {
        return CONSULTA_DAO.buscarMedicos();

    }
    
    public Long obterMaiorIdDeConsultaDisponivel(){
        return CONSULTA_DAO.buscarMaiorId();
    }

}
