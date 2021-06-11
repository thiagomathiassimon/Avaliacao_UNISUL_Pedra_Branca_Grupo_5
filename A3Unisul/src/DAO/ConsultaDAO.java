package DAO;

import Interface.CrudInterface;
import Model.Consulta;
import java.util.ArrayList;

public class ConsultaDAO implements CrudInterface<ConsultaDAO> {

    private Conexao conexao = new Conexao();

    public Conexao getConexao() {
        return conexao;
    }

    @Override
    public boolean cadastrar(ConsultaDAO object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ConsultaDAO> buscar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editar(Long id, ConsultaDAO object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
