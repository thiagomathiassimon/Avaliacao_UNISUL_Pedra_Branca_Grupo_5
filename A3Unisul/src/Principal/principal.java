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
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class principal {

    public static void main(String[] args) throws SQLException {

        PacienteDAO pdao = new PacienteDAO();
       Endereco endereco = new Endereco(pdao.buscarMaiorId() + 1L, "SC", "Sao Paulo", "Centro", "Avenida Rio Branco", "2000", "sem piso 2");
//         Paciente p = new Paciente();
//         Paciente cadastrado = new Paciente(pdao.buscarMaiorId()+21L,endereco,LocalDate.parse("2005-11-11"),"paulo","889888988898","87608162015");
//        // 76839309037
//        //Long idPaciente, Endereco endereco, LocalDate dataDeNascimento, String nome, String telefone, String cpf
//        
//       // System.out.println(p.cadastrar(cadastrado));
//        p.editar(21L,cadastrado);
//        p.buscar().forEach(System.out::println);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        PacienteDAO p = new PacienteDAO();
         
        
       // Paciente paciente = new Paciente(56L, endereco, LocalDate.parse("2070-12-12"), "nometesteblabla", "2222-2222", "00000");
//         // Medico medico = new Medico(1L, "123", "123","321","321","321");
    Paciente paciente = p.carregarPaciente(21L);
    paciente.setIdPaciente(1L);
    paciente.setCpf("19534 616036");
    Endereco e = paciente.getEndereco();
    e.setIdEndereco(1L);
    paciente.setEndereco(e);
       //   MedicoDAO m = new MedicoDAO();
p.cadastrar(paciente);
p.buscar().forEach(System.out::println);
//
//        //  p.cadastrar(paciente);
//  
//       Long idConsulta, String cpf, String crm, LocalDate dataDoExame, String horarioDeExame, String descricao     
//        ConsultaDAO c = new ConsultaDAO();
//        ConsultaDTO dto = new ConsultaDTO(23L,"222","22222",LocalDate.parse("2070-12-12"),"08:00","Texto bem longo");
//        
////        System.out.print(PacienteDAO.buscarPacientePorCPF("222"));
////        try {
////            Consulta consulta = new Consulta(7L,p.carregarPaciente(21L),m.carregarMedico(1L),LocalDate.parse("2070-12-12"),"09:00","Texto bem longo");
////            c.cadastrar(consulta);
////        } catch (SQLException ex) {
////            //Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
////        }
//
//        Consulta consulta = c.carregarConsulta(5L);
//     //   consulta.setIdConsulta(15L);
//        consulta.setDescricao("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
//        consulta.setHorarioDeExame("15:20");
//        //c.verificarDataEHoraDisponiveis(consulta);
//        c.editar(2L, consulta);
//       
//        
//     //   c.verificarDataEHoraDisponiveis(objeto);
////              p.buscar().forEach(System.out::println);
//
//    //    System.out.print(c.buscarMaiorId());
//       // c.buscarMaiorId();
//      //  c.editar(3L, toConsulta(dto));
//   //     c.buscar().forEach(System.out::println);
//
//
//
////c.verificarDataEHoraDisponiveis(LocalDate.parse("2002-11-02"), "09:00");
////System.out.print(c.verificarDataEHoraDisponiveis(LocalDate.parse("2002-11-02"), "09:00"));








    }

}
