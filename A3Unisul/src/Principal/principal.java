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

        PacienteDAO p = new PacienteDAO();
//          Endereco endereco = new Endereco(56L, "SC", "Sao Paulo", "Centro", "Avenida Rio Branco", "2000", "sem piso 2");
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
        ConsultaDTO dto = new ConsultaDTO(3L,"222","22222",LocalDate.parse("2070-12-12"),"09:00","Texto bem longo");
        
//        System.out.print(PacienteDAO.buscarPacientePorCPF("222"));
//        try {
//            Consulta consulta = new Consulta(5L,p.carregarPaciente(2L),m.carregarMedico(2L),LocalDate.parse("2070-12-12"),"09:00","Texto bem longo");
//            c.cadastrar(consulta);
//        } catch (SQLException ex) {
//            //Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
//        }
//              p.buscar().forEach(System.out::println);
        
        c.editar(3L, toConsulta(dto));
        c.buscar().forEach(System.out::println);

    }

}
