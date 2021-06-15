package Util;

import DAO.Conexao;
import static DAO.PacienteDAO.buscarPacientePorCPF;
import static DAO.MedicoDAO.buscarMedicoPorCRM;
import DTO.ConsultaDTO;
import Model.Consulta;
import java.sql.SQLException;

public class ConsultaModelMepper {

    public static ConsultaDTO toDTO(Consulta consulta) {
        return (new ConsultaDTO(
                consulta.getIdConsulta(),
                consulta.getPaciente().getCpf(),
                consulta.getMedico().getCrm(),
                consulta.getDataDoExame(),
                consulta.getHorarioDeExame(),
                consulta.getDescricao()
        ));

    }

    public static Consulta toConsulta(ConsultaDTO consultaDTO) throws SQLException {
        return (new Consulta(
                consultaDTO.getIdConsulta(),
                buscarPacientePorCPF(consultaDTO.getCpf()),
                buscarMedicoPorCRM(consultaDTO.getCrm()),
                consultaDTO.getDataDoExame(),
                consultaDTO.getHorarioDeExame(),
                consultaDTO.getDescricao()
         
        ));

    }
}
