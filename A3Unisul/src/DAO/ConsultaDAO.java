package DAO;


import Interface.CrudInterface;
import Model.Consulta;
import Model.Endereco;
import Model.Medico;
import Model.Paciente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultaDAO implements CrudInterface<Consulta> {

    private Conexao conexao = new Conexao();

    public Conexao getConexao() {
        return conexao;
    }

    @Override
    public boolean cadastrar(Consulta object) {

        String sql = "INSERT INTO consulta (idConsulta, dataDoExame, horarioDoExame, descricao, paciente, medico) VALUES (?, ?, ?, ?, ?, ?);";

        try {

            PreparedStatement stmt = this.conexao.getConexao().prepareStatement(sql);

            stmt.setLong(1, object.getIdConsulta());
            stmt.setString(2, object.getDataDoExame().toString());
            stmt.setString(3, object.getHorarioDeExame());
            stmt.setString(4, object.getDescricao());
            stmt.setLong(5, object.getPaciente().getIdPaciente());
            stmt.setLong(6, object.getMedico().getIdMedico());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        } finally {

        }
    }

    @Override
    public ArrayList<Consulta> buscar() {
        ArrayList<Consulta> list = new ArrayList<>();

        try {
            Statement stmt = this.conexao.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT "
                    + " c.idConsulta,c.dataDoExame,c.horarioDoExame,c.descricao,c.paciente,c.medico,"
                    + " m.idMedico,m.nome nomeMedico, m.crm, m.especialidade, m.periodoDeAtendimento, m.telefone telefoneMedico,"
                    + " p.idPaciente,p.nome nomePaciente, p.telefone telefonePaciente, p.dataDeNascimento, p.endereco, p.cpf,"
                    + " e.idendereco, e.estado, e.municipio, e.bairro, e.logradouro, e.numero, e.complemento, e.cep "
                    + " FROM consulta c inner join medico m on c.medico = m.idMedico "
                    + " Inner join paciente p on c.paciente = p.idPaciente "
                    + " INNER JOIN endereco e ON p.endereco=e.idEndereco ORDER BY(c.idConsulta) ASC ");
            while (res.next()) {

                Consulta consulta = obterDadosDoSQL(res);

                list.add(consulta);

            }

            stmt.close();

        } catch (SQLException ex) {
        }
        return list;
    }

    @Override
    public boolean excluir(Long id) {

        try {
            String sql = ("DELETE FROM consulta WHERE idConsulta = ?");
            PreparedStatement stmt = this.conexao.getConexao().prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.execute();
            stmt.close();

        } catch (SQLException erro) {
        }
        return true;
    }

    public boolean editar(Long id, Consulta object) {

        String sql = "UPDATE consulta c set dataDoExame = ?, horarioDoExame = ?, descricao = ?, paciente = ?, medico = ? where c.idConsulta = ?";

        try {
            PreparedStatement stmt = this.conexao.getConexao().prepareStatement(sql);

            stmt.setString(1, object.getDataDoExame().toString());
            stmt.setString(2, object.getHorarioDeExame());
            stmt.setString(3, object.getDescricao());
            stmt.setLong(4, object.getPaciente().getIdPaciente());
            stmt.setLong(5, object.getMedico().getIdMedico());

            stmt.setLong(6, id);

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

    public Long buscarMaiorId() {

        Long idMedico = 0L;
        try {
            Statement stmt = this.conexao.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(idConsulta) id FROM consulta");
            res.next();
            idMedico = res.getLong("id");

            stmt.close();

        } catch (SQLException ex) {
        }

        return idMedico;
    }

    public Consulta carregarConsulta(Long id) throws SQLException {

        try {
            String sql = "SELECT "
                    + " c.idConsulta,c.dataDoExame,c.horarioDoExame,c.descricao,c.paciente,c.medico,"
                    + " m.idMedico,m.nome nomeMedico, m.crm, m.especialidade, m.periodoDeAtendimento, m.telefone telefoneMedico,"
                    + " p.idPaciente,p.nome nomePaciente, p.telefone telefonePaciente, p.dataDeNascimento, p.endereco, p.cpf,"
                    + " e.idendereco, e.estado, e.municipio, e.bairro, e.logradouro, e.numero, e.complemento, e.cep "
                    + " FROM consulta c inner join medico m on c.medico = m.idMedico "
                    + " Inner join paciente p on c.paciente = p.idPaciente"
                    + " INNER JOIN endereco e ON p.endereco=e.idEndereco"
                    + " where idConsulta = ?";
            PreparedStatement stmt = this.conexao.getConexao().prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet res = stmt.executeQuery();
            res.next();

            Consulta consulta = obterDadosDoSQL(res);

            stmt.close();
            return consulta;
        } catch (SQLException erro) {
            throw new SQLException(erro.getMessage());
        }
    }


    public ArrayList<String[]> buscarMedicos() throws SQLException {

        Statement stmt = this.conexao.getConexao().createStatement();
        ArrayList<String[]> list = new ArrayList<>();
        try {
            ResultSet res = stmt.executeQuery("Select m.nome, m.idMedico from medico m");

            while (res.next()) {

                String[] dadosDoMedico = new String[2];
                dadosDoMedico[0] = res.getString("nome");
                dadosDoMedico[1] = res.getLong("idMedico") + "";
                list.add(dadosDoMedico);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    private Consulta obterDadosDoSQL(ResultSet res) throws SQLException {
        String nomeMedico = res.getString("nomeMedico");
        String telefoneMedico = res.getString("telefoneMedico");
        Long idMedico = res.getLong("idMedico");
        String crm = res.getString("crm");
        String especialidade = res.getString("especialidade");
        String periodoDeAtendimento = res.getString("periodoDeAtendimento");

        String nomePaciente = res.getString("nomePaciente");
        String telefonePaciente = res.getString("telefonePaciente");
        Long idPaciente = res.getLong("idPaciente");
        String data = res.getString("dataDeNascimento");
        String cpf = res.getString("cpf");
        LocalDate dataDeNascimento = LocalDate.parse(data);

        String estado = res.getString("estado");
        String municipio = res.getString("municipio");
        String bairro = res.getString("bairro");
        String logradouro = res.getString("logradouro");
        String numero = res.getString("numero");
        String complemento = res.getString("complemento");
        Long idEndereco = res.getLong("idEndereco");
        String cep = res.getString("cep");

        Long idConsulta = res.getLong("idConsulta");
        LocalDate dataDoExame = LocalDate.parse(res.getString("dataDoExame"));
        String horarioDeExame = res.getString("horarioDoExame");
        String descricao = res.getString("descricao");

        Endereco endereco = new Endereco(idEndereco, estado, municipio, bairro, logradouro, numero, complemento, cep);
        Medico medico = new Medico(idMedico, crm, especialidade, periodoDeAtendimento, nomeMedico, telefoneMedico);
        Paciente paciente = new Paciente(idPaciente, endereco, dataDeNascimento, nomePaciente, telefonePaciente, cpf);
        Consulta consulta = new Consulta(idConsulta, paciente, medico, dataDoExame, horarioDeExame, descricao);
        return consulta;
    }

}
