
package Principal;
import DAO.MedicoDAO;
import Model.Medico;
public class principal {

    public static void main(String[] args) {
     
        MedicoDAO obj = new MedicoDAO();
        Medico objt = new Medico(6L,"teste","teste","teste","teste","teste");
        obj.getConexao().getConexao();
      /*  obj.cadastrar(objt);
        obj.editar(1L, objt);*/
        obj.excluir(4L);
        obj.buscar().forEach(System.out::println);
        System.out.println(obj.buscarMaiorId());
        
       
    }
    
}
