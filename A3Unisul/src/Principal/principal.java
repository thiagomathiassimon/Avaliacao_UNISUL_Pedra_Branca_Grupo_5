
package Principal;
import DAO.MedicoDAO;
import DAO.PacienteDAO;
import Model.Endereco;
import Model.Medico;
import Model.Paciente;
import java.time.LocalDate;
import java.util.ArrayList;
public class principal {

    public static void main(String[] args) {
     
//        MedicoDAO obj = new MedicoDAO();
//        Medico objt = new Medico(6L,"teste","teste","teste","teste","teste");
////        obj.getConexao().getConexao();
////      /*  obj.cadastrar(objt);
////        obj.editar(1L, objt);*/
////        obj.excluir(4L);
//          ArrayList<Medico> list = new ArrayList<>();
//          list = obj.buscar();
//          System.out.println(list);
//        obj.buscar().forEach(System.out::println);
////        System.out.println(obj.buscarMaiorId());
//        
          PacienteDAO p = new PacienteDAO();
          Endereco endereco = new Endereco(1L, "SC", "Sao Paulo", "Centro", "Avenida Rio Branco", "2000", "sem piso 2");
          Paciente paciente = new Paciente(1L, endereco, LocalDate.parse("3070-12-12"), "nometesteblabla", "2222-2222");
//          p.cadastrar(paciente);

//          ArrayList<Paciente> listp = new ArrayList<>();
//          listp = p.buscar();
//          for (Paciente paciente : listp) {
//
//          System.out.println(paciente.getDataDeNascimento());
            
//            p.editar(1L, paciente);
                p.buscar().forEach(System.out::println);
//          }
            p.excluir(1L);
            p.buscar().forEach(System.out::println);
    }
    
}
