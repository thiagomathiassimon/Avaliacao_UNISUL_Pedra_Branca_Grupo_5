package Control;

import Interface.CrudInterface;
import Model.Consulta;
import Model.Medico;
import Model.Paciente;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ConsultaControl {

    private static final Consulta CONSULTA = new Consulta();

    public boolean cadastrar(Paciente paciente, Medico medico, LocalDate dataDaConsulta, String horarioDaConsulta, String descricao) {
        return CONSULTA.cadastrar(
                new Consulta(CONSULTA.obterMaiorIdDeConsultaDisponivel() + 1, paciente, medico, dataDaConsulta, horarioDaConsulta, descricao)
        );
    }

    public boolean cadastrar(LocalDate dataDaConsulta, String horarioDaConsulta, String descricao) {
        return CONSULTA.cadastrar(
                new Consulta(CONSULTA.obterMaiorIdDeConsultaDisponivel() + 1, new Paciente(), new Medico(), dataDaConsulta, horarioDaConsulta, descricao)
        );
    }
    //     public Consulta(Long idConsulta, Paciente paciente, Medico medico, LocalDate dataDoExame, String horarioDeExame, String descricao) {

    public ArrayList<ConsultaControl> buscar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean editar(Long id, ConsultaControl object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean excluir(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<String[]> buscarMedicos() throws SQLException {
        return CONSULTA.buscarMedicos();

    }

}
