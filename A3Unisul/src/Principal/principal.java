package Principal;

import DAO.Conexao;
import DAO.ConsultaDAO;
import DAO.MedicoDAO;
import DAO.PacienteDAO;
import DTO.ConsultaDTO;
import Model.Consulta;
import Model.Endereco;
import Model.Medico;
import Model.Paciente;
import static Util.ConsultaModelMepper.toConsulta;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class principal {

    public static void main(String[] args) throws SQLException {

        PacienteDAO pdao = new PacienteDAO();
         Endereco endereco = new Endereco(pdao.buscarMaiorId() + 1L, "SC", "Sao Paulo", "Centro", "Avenida Rio Branco", "2000", "sem piso 2");
         Paciente p = new Paciente();
         Paciente cadastrado = new Paciente(pdao.buscarMaiorId()+21L,endereco,LocalDate.parse("2005-11-11"),"paulo","889888988898","87608162015");
        // 76839309037
        //Long idPaciente, Endereco endereco, LocalDate dataDeNascimento, String nome, String telefone, String cpf
        
       // System.out.println(p.cadastrar(cadastrado));
        p.editar(21L,cadastrado);
        p.buscar().forEach(System.out::println);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
   //     PacienteDAO p = new PacienteDAO();
         
//        Paciente paciente = new Paciente(56L, endereco, LocalDate.parse("2070-12-12"), "nometesteblabla", "2222-2222", "00000");
//         // Medico medico = new Medico(1L, "123", "123","321","321","321");
//          MedicoDAO m = new MedicoDAO();
//p.cadastrar(paciente);
//p.buscar().forEach(System.out::println);
//
//        //  p.cadastrar(paciente);
//  
//       Long idConsulta, String cpf, String crm, LocalDate dataDoExame, String horarioDeExame, String descricao     
        ConsultaDAO c = new ConsultaDAO();
        ConsultaDTO dto = new ConsultaDTO(23L,"222","22222",LocalDate.parse("2070-12-12"),"09:00","Texto bem longo");
        
//        System.out.print(PacienteDAO.buscarPacientePorCPF("222"));
//        try {
//            Consulta consulta = new Consulta(5L,p.carregarPaciente(2L),m.carregarMedico(2L),LocalDate.parse("2070-12-12"),"09:00","Texto bem longo");
//            c.cadastrar(consulta);
//        } catch (SQLException ex) {
//            //Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
//        }
//              p.buscar().forEach(System.out::println);

    //    System.out.print(c.buscarMaiorId());
//        c.buscarMaiorId();
//        c.editar(3L, toConsulta(dto));
//        c.buscar().forEach(System.out::println);













    }

}
