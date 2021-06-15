package DAO;

import DTO.ConsultaDTO;
import Interface.CrudInterface;
import Model.Consulta;
import Model.Endereco;
import Model.Medico;
import Model.Paciente;
import Util.ConsultaModelMepper;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import static Util.ConsultaModelMepper.toDTO;

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
                    + " e.idendereco, e.estado, e.municipio, e.bairro, e.logradouro, e.numero, e.complemento "
                    + " FROM consulta c inner join medico m on c.medico = m.idMedico "
                    + " Inner join paciente p on c.paciente = p.idPaciente "
                    + " INNER JOIN endereco e ON p.endereco=e.idEndereco");
            while (res.next()) {

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

                Long idConsulta = res.getLong("idConsulta");
                LocalDate dataDoExame = LocalDate.parse(res.getString("dataDoExame"));
                String horarioDeExame = res.getString("horarioDoExame");
                String descricao = res.getString("descricao");

                Endereco endereco = new Endereco(idEndereco, estado, municipio, bairro, logradouro, numero, complemento);
                Medico medico = new Medico(idMedico, crm, especialidade, periodoDeAtendimento, nomeMedico, telefoneMedico);
                Paciente paciente = new Paciente(idPaciente, endereco, dataDeNascimento, nomePaciente, telefonePaciente, cpf);
                Consulta consulta = new Consulta(idConsulta, paciente, medico, dataDoExame, horarioDeExame, descricao);

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

    @Override
    public boolean editar(Long id, Consulta object) {
        ConsultaDTO toDTO = toDTO(object);
        String sql = "update consulta set medico = (select m.idMedico from medico m where crm = ?), "
                + "paciente = (select p.idPaciente from paciente p where cpf = ?), "
                + "dataDoExame = ?, horarioDoExame = ?, descricao = ? where idConsulta = ?";

        try {
            PreparedStatement stmt = this.conexao.getConexao().prepareStatement(sql);

            stmt.setString(1, toDTO.getCrm());
            stmt.setString(2, toDTO.getCpf());
            stmt.setString(3, object.getDataDoExame().toString());
            stmt.setString(4, object.getHorarioDeExame());
            stmt.setString(5, object.getDescricao());
            stmt.setLong(6, id);

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

}
