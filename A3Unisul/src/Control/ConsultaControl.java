package Control;

import Interface.CrudInterface;
import Model.Consulta;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsultaControl {

    private static final Consulta CONSULTA = new Consulta();

    public boolean cadastrar(ConsultaControl object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
