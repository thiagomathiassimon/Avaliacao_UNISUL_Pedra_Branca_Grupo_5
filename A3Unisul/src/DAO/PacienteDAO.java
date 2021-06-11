package DAO;

import Interface.CrudInterface;
import Model.Paciente;
import java.util.ArrayList;

public class PacienteDAO implements CrudInterface<PacienteDAO>{

    private Conexao conexao = new Conexao();
    
    public Conexao getConexao() {
        return conexao;
    }
    
  
    @Override
    public boolean cadastrar(PacienteDAO object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<PacienteDAO> buscar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editar(Long id, PacienteDAO object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
