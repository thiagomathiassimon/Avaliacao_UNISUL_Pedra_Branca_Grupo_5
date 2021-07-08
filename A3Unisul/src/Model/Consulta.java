package Model;

import DAO.ConsultaDAO;
import Interface.CrudInterface;
import static Util.Validacoes.validarData;
import static Util.Validacoes.validarHorario;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        if (this.verificarDataEHoraDisponiveis(object)) {
            return this.CONSULTA_DAO.cadastrar(object);
        }
        return false;
    }

    @Override
    public ArrayList<Consulta> buscar() {
        return this.CONSULTA_DAO.buscar();
    }

    @Override
    public boolean editar(Long id, Consulta object) {
        if (this.verificarDataEHoraDisponiveis(object)) {
            return this.CONSULTA_DAO.editar(id, object);
        }
        return false;
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

    public Long obterMaiorIdDeConsultaDisponivel() {
        return CONSULTA_DAO.buscarMaiorId();
    }

    public boolean verificarDataEHoraDisponiveis(Consulta object) {

        LocalDate dataDoExame = object.getDataDoExame();
        String horarioDoExame = object.getHorarioDeExame();
        String periodoDeAtendimento = object.getMedico().getPeriodoDeAtendimento();
        if (!validarHorario(horarioDoExame, periodoDeAtendimento) || !validarData(dataDoExame)) {
            return false;
        }

        ArrayList<Consulta> list = CONSULTA_DAO.buscar();

        String[] dataNova = object.getDataDoExame().toString().split("-");
        String[] horarioNovo = object.getHorarioDeExame().split(":");

        Integer diaView = Integer.parseInt(dataNova[2]);
        Integer mesView = Integer.parseInt(dataNova[1]);
        Integer anoView = Integer.parseInt(dataNova[0]);

        Integer horarioView = Integer.parseInt(horarioNovo[0]) * 60;
        horarioView += Integer.parseInt(horarioNovo[1]);

        for (Consulta consulta : list) {
            horarioDoExame = consulta.getHorarioDeExame();
            dataDoExame = consulta.getDataDoExame();

            String[] dataRedefinida = dataDoExame.toString().split("-");
            Integer diaDAO = Integer.parseInt(dataRedefinida[2]);
            Integer mesDAO = Integer.parseInt(dataRedefinida[1]);
            Integer anoDAO = Integer.parseInt(dataRedefinida[0]);

            String[] horarioRedefinido = horarioDoExame.split(":");
            Integer somaDoHorario = Integer.parseInt(horarioRedefinido[0]) * 60;
            somaDoHorario += Integer.parseInt(horarioRedefinido[1]);

            Integer horarioMinimo = (somaDoHorario - 60);
            Integer horarioMaximo = (somaDoHorario + 60);
   
            if ((anoView.equals(anoDAO)) && (mesView.equals(mesDAO)) && (diaView.equals(diaDAO))
                    && ((object.getMedico().getIdMedico().equals(consulta.getMedico().getIdMedico()))
                    || (object.getPaciente().getIdPaciente().equals(consulta.getPaciente().getIdPaciente())))) {

                if (horarioView.equals(horarioMinimo) || horarioView.equals(horarioMaximo)
                        || (horarioView > horarioMinimo && horarioView < horarioMaximo)) {
                    return false;
                }
            }
        }
        return true;
    }

}
