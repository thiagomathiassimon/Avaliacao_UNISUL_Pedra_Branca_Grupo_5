package DAO;

import Interface.CrudInterface;
import Model.Medico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO implements CrudInterface<Medico> {

    private Conexao conexao = new Conexao();

    public Conexao getConexao() {
        return conexao;
    }

    @Override
    public boolean cadastrar(Medico object) {

        String sql = "INSERT INTO medico(idMedico, crm, especialidade, periodoDeAtendimento, nome, telefone) VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = this.conexao.getConexao().prepareStatement(sql);

            stmt.setLong(1, object.getIdMedico());
            stmt.setString(2, object.getCrm());
            stmt.setString(3, object.getEspecialidade());
            stmt.setString(4, object.getPeriodoDeAtendimento());
            stmt.setString(5, object.getNome());
            stmt.setString(6, object.getTelefone());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    @Override
    public ArrayList<Medico> buscar() {

        ArrayList<Medico> list = new ArrayList<>();

        try {
            Statement stmt = this.conexao.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM medico");
            while (res.next()) {

                String nome = res.getString("nome");
                String telefone = res.getString("telefone");
                Long idMedico = res.getLong("idMedico");
                String crm = res.getString("crm");
                String especialidade = res.getString("especialidade");
                String periodoDeAtendimento = res.getString("periodoDeAtendimento");

                Medico medico = new Medico(idMedico, crm, especialidade, periodoDeAtendimento, nome, telefone);

                list.add(medico);

            }

            stmt.close();

        } catch (SQLException ex) {
        }
        return list;
    }

    @Override
    public boolean editar(Long id, Medico object) {
        String sql = "UPDATE medico SET crm = ?, especialidade = ?, periodoDeAtendimento = ?, nome = ?, telefone = ? WHERE idMedico = ?";

        try {
            PreparedStatement stmt = this.conexao.getConexao().prepareStatement(sql);

            stmt.setString(1, object.getCrm());
            stmt.setString(2, object.getEspecialidade());
            stmt.setString(3, object.getPeriodoDeAtendimento());
            stmt.setString(4, object.getNome());
            stmt.setString(5, object.getTelefone());
            stmt.setLong(6, id);

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    @Override
    public boolean excluir(Long id) {

        try {
            String sql = ("DELETE FROM medico WHERE idMedico = ?");
            PreparedStatement stmt = this.conexao.getConexao().prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.execute();
            stmt.close();

        } catch (SQLException erro) {
        }
        return true;
    }

    public Long buscarMaiorId() {

        Long idMedico = 0L;
        try {
            Statement stmt = this.conexao.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(idMedico) id FROM medico");
            res.next();
            idMedico = res.getLong("id");

            stmt.close();

        } catch (SQLException ex) {
        }

        return idMedico;
    }

    public Medico carregarMedico(Long id) throws SQLException {

        try {
            String sql = "SELECT * FROM medico WHERE IdMedico = ?";
            PreparedStatement stmt = this.conexao.getConexao().prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet res = stmt.executeQuery();
            res.next();

            String nome = res.getString("nome");
            String telefone = res.getString("telefone");
            Long idMedico = res.getLong("idMedico");
            String crm = res.getString("crm");
            String especialidade = res.getString("especialidade");
            String periodoDeAtendimento = res.getString("periodoDeAtendimento");

            Medico objeto = new Medico(idMedico, crm, especialidade, periodoDeAtendimento, nome, telefone);
            stmt.close();
            return objeto;
        } catch (SQLException erro) {
            throw new SQLException(erro.getMessage());
        }
    }

    public static Medico buscarMedicoPorCRM(String crm) throws SQLException {
         Conexao conexao = new Conexao();
        try {
            String sql = "SELECT * FROM medico WHERE crm = ?";
            PreparedStatement stmt = conexao.getConexao().prepareStatement(sql);
            stmt.setString(1, crm);
            ResultSet res = stmt.executeQuery();
            res.next();

            String nome = res.getString("nome");
            String telefone = res.getString("telefone");
            Long idMedico = res.getLong("idMedico");
            String especialidade = res.getString("especialidade");
            String periodoDeAtendimento = res.getString("periodoDeAtendimento");

            Medico objeto = new Medico(idMedico, crm, especialidade, periodoDeAtendimento, nome, telefone);
            stmt.close();
            return objeto;

        } catch (SQLException erro) {
            throw new SQLException(erro.getMessage());
        }

    }

}
