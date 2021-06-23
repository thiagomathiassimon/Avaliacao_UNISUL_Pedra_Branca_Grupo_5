package Principal;

import Control.MedicoControl;
import DAO.ConsultaDAO;
import DAO.MedicoDAO;
import DAO.PacienteDAO;
import Model.Consulta;
import Model.Endereco;
import Model.Medico;
import Model.Paciente;
import Util.Validacoes;
import View.TelaDeCadastroDeConsulta;
import View.TelaInicial;
import java.sql.SQLException;

public class Principal {

    public static void main(String[] args) throws SQLException {

       TelaInicial objeto = new TelaInicial();
        objeto.setVisible(true);
//        PacienteDAO pdao = new PacienteDAO();
//        Paciente p = new Paciente();
//
//        System.err.println(pdao.cadastrar(new Endereco(
//                p.obterMaiorId(),
//                "SC",
//                "Águas Mornas",
//                "Santa Isabel",
//                "Estarda Geral Santa Isabel",
//                "Sem número",
//                "Sem número"
//        )));
//        TelaDeCadastroDeConsulta m = new TelaDeCadastroDeConsulta();
//
//       
//        System.out.println(carregarMedico.toString());
//
//
//        ConsultaDAO c = new  ConsultaDAO();
//        
//        Long idConsulta = c.buscarMaiorId() + 1;
//
//        System.out.println(idConsulta);
    }

}
