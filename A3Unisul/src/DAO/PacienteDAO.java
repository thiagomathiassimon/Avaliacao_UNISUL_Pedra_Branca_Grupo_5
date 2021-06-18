package DAO;

import Exception.InvalidBornDateException;
import Exception.InvalidCPFException;
import Interface.CrudInterface;
import Model.Endereco;
import Model.Paciente;
import static Util.Validacoes.validarCpf;
import static Util.Validacoes.validarDtNascimento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class PacienteDAO implements CrudInterface<Paciente> {

    private Conexao conexao = new Conexao();

    public Conexao getConexao() {
        return conexao;
    }

    @Override
    public boolean cadastrar(Paciente object) {

        if (!validarCpf(object.getCpf())) {
            throw new InvalidCPFException("CPF informado não é válido.");
        } else if (!validarDtNascimento(object.getDataDeNascimento())) {
            throw new InvalidBornDateException("A data de nascimento informada é inválida.");
        }

        String sql = "INSERT INTO endereco (idEndereco, estado, municipio, bairro, logradouro, numero, complemento) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement stmt = this.conexao.getConexao().prepareStatement(sql);

            stmt.setLong(1, object.getEndereco().getIdEndereco());
            stmt.setString(2, object.getEndereco().getEstado());
            stmt.setString(3, object.getEndereco().getMunicipio());
            stmt.setString(4, object.getEndereco().getNumero());
            stmt.setString(5, object.getEndereco().getLogradouro());
            stmt.setString(6, object.getEndereco().getNumero());
            stmt.setString(7, object.getEndereco().getComplemento());

            stmt.execute();
            stmt.close();

            sql = "INSERT INTO paciente(idPaciente, nome, telefone, dataDeNascimento, endereco, cpf) VALUES(?,?,?,?,?,?)";
            stmt = this.conexao.getConexao().prepareStatement(sql);
            stmt.setLong(1, object.getIdPaciente());
            stmt.setString(2, object.getNome());
            stmt.setString(3, object.getTelefone());
            stmt.setString(4, object.getDataDeNascimento().toString());
            stmt.setLong(5, object.getEndereco().getIdEndereco());
            stmt.setString(6, object.getCpf());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

    @Override
    public ArrayList<Paciente> buscar() {

        ArrayList<Paciente> list = new ArrayList<>();

        try {
            Statement stmt = this.conexao.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM paciente p INNER JOIN endereco e ON p.endereco=e.idEndereco");
            while (res.next()) {

                String nome = res.getString("nome");
                String telefone = res.getString("telefone");
                Long idPaciente = res.getLong("idPaciente");
                String data = res.getString("dataDeNascimento");
                LocalDate dataDeNascimento = LocalDate.parse(data);
                String estado = res.getString("estado");
                String municipio = res.getString("municipio");
                String bairro = res.getString("bairro");
                String logradouro = res.getString("logradouro");
                String numero = res.getString("numero");
                String complemento = res.getString("complemento");
                Long idEndereco = res.getLong("idEndereco");
                String cpf = res.getString("cpf");

                Endereco endereco = new Endereco(idEndereco, estado, municipio, bairro, logradouro, numero, complemento);

                Paciente paciente = new Paciente(idPaciente, endereco, dataDeNascimento, nome, telefone, cpf);

                list.add(paciente);

            }

            stmt.close();

        } catch (SQLException ex) {
        }
        return list;
    }

    @Override
    public boolean editar(Long id, Paciente object) {
       
         if (validarCpf(object.getCpf())) {
            throw new InvalidCPFException("CPF informado não é válido.");
        } else if (validarDtNascimento(object.getDataDeNascimento())) {
            throw new InvalidBornDateException("A data de nascimento informada é inválida.");
        }
        
        String sql = "UPDATE paciente p INNER JOIN endereco e ON p.endereco=e.idEndereco "
                + "SET p.nome = ?, p.telefone = ?, p.dataDeNascimento = ?, "
                + "e.estado = ?, e.municipio = ?, e.bairro = ?, e.logradouro = ?, e.numero = ?, e.complemento = ?  "
                + "WHERE p.idPaciente= ?";

        try {
            PreparedStatement stmt = this.conexao.getConexao().prepareStatement(sql);

            stmt.setString(1, object.getNome());
            stmt.setString(2, object.getTelefone());
            stmt.setString(3, object.getDataDeNascimento().toString());
            stmt.setString(4, object.getEndereco().getEstado());
            stmt.setString(5, object.getEndereco().getMunicipio());
            stmt.setString(6, object.getEndereco().getBairro());
            stmt.setString(7, object.getEndereco().getLogradouro());
            stmt.setString(8, object.getEndereco().getNumero());
            stmt.setString(9, object.getEndereco().getComplemento());

            stmt.setLong(10, id);

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
            String sql = ("DELETE e FROM endereco e INNER JOIN paciente p ON e.idEndereco=p.endereco WHERE p.idPaciente=?");
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

    public Paciente carregarPaciente(Long id) throws SQLException {

        try {
            String sql = "SELECT * FROM paciente p INNER JOIN endereco e ON p.endereco=e.idEndereco where idPaciente = ?";
            PreparedStatement stmt = this.conexao.getConexao().prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet res = stmt.executeQuery();
            res.next();

            String nome = res.getString("nome");
            String telefone = res.getString("telefone");
            Long idPaciente = res.getLong("idPaciente");
            String data = res.getString("dataDeNascimento");
            LocalDate dataDeNascimento = LocalDate.parse(data);
            String estado = res.getString("estado");
            String municipio = res.getString("municipio");
            String bairro = res.getString("bairro");
            String logradouro = res.getString("logradouro");
            String numero = res.getString("numero");
            String complemento = res.getString("complemento");
            Long idEndereco = res.getLong("idEndereco");
            String cpf = res.getString("cpf");

            Endereco endereco = new Endereco(idEndereco, estado, municipio, bairro, logradouro, numero, complemento);

            Paciente objeto = new Paciente(idPaciente, endereco, dataDeNascimento, nome, telefone, cpf);

            stmt.close();
            return objeto;

        } catch (SQLException erro) {
            throw new SQLException(erro.getMessage());
        }

    }

    public static Paciente buscarPacientePorCPF(String cpf) throws SQLException {
        Conexao conexao = new Conexao();
        try {
            String sql = "SELECT * FROM paciente p INNER JOIN endereco e ON p.endereco=e.idEndereco where cpf = ?";
            PreparedStatement stmt = conexao.getConexao().prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet res = stmt.executeQuery();
            res.next();

            String nome = res.getString("nome");
            String telefone = res.getString("telefone");
            Long idPaciente = res.getLong("idPaciente");
            String data = res.getString("dataDeNascimento");
            LocalDate dataDeNascimento = LocalDate.parse(data);
            String estado = res.getString("estado");
            String municipio = res.getString("municipio");
            String bairro = res.getString("bairro");
            String logradouro = res.getString("logradouro");
            String numero = res.getString("numero");
            String complemento = res.getString("complemento");
            Long idEndereco = res.getLong("idEndereco");

            Endereco endereco = new Endereco(idEndereco, estado, municipio, bairro, logradouro, numero, complemento);

            Paciente objeto = new Paciente(idPaciente, endereco, dataDeNascimento, nome, telefone, cpf);

            stmt.close();
            return objeto;

        } catch (SQLException erro) {
            throw new SQLException(erro.getMessage());
        }

    }

}
