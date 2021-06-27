package Principal;

import Control.EnderecoControl;
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
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {
    
    public static void main(String[] args) throws SQLException, IOException {
        
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
//        String[] cepes = {"88150000", "88113300", "88095560"};
//
//        for (String cep : cepes) {
//   
//        }
////    }
//
//        EnderecoControl e = new EnderecoControl();
//        
//        e.bucarEnderecoPeloCEP(88113300);

    }
}
