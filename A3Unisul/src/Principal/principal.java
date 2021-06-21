package Principal;

import DAO.PacienteDAO;
import Model.Endereco;
import Model.Paciente;
import Util.Validacoes;
import View.TelaInicial;

public class Principal {

    public static void main(String[] args) {

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

    }

}
