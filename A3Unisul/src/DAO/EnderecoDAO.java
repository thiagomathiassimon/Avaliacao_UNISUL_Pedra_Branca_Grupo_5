/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interface.CrudInterface;
import Model.Endereco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author G-fire
 */
public class EnderecoDAO implements CrudInterface<Endereco> {

    private Conexao conexao = new Conexao();

    @Override
    public boolean cadastrar(Endereco object) {

        String sql = "INSERT INTO endereco (idEndereco, estado, municipio, bairro, logradouro, numero, complemento) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {

            PreparedStatement stmt = this.conexao.getConexao().prepareStatement(sql);

            stmt.setLong(1, object.getIdEndereco());
            stmt.setString(2, object.getEstado());
            stmt.setString(3, object.getMunicipio());
            stmt.setString(4, object.getNumero());
            stmt.setString(5, object.getLogradouro());
            stmt.setString(6, object.getNumero());
            stmt.setString(7, object.getComplemento());

            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<Endereco> buscar() {

        ArrayList<Endereco> list = new ArrayList<>();

        try {
            Statement stmt = this.conexao.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM endereco");
            while (res.next()) {

                String estado = res.getString("estado");
                String municipio = res.getString("municipio");
                String bairro = res.getString("bairro");
                String logradouro = res.getString("logradouro");
                String numero = res.getString("numero");
                String complemento = res.getString("complemento");
                Long idEndereco = res.getLong("idEndereco");

                Endereco endereco = new Endereco(idEndereco, estado, municipio, bairro, logradouro, numero, complemento);

                list.add(endereco);

            }

            stmt.close();

        } catch (SQLException ex) {
        }
        return list;
    }

    @Override
    public boolean editar(Long id, Endereco object) {

        String sql = "update endereco set estado = ?,municipio = ?,bairro = ?,logradouro = ?,numero = ?,complemento = ?"
                + " where idendereco = ?";
        try {
            PreparedStatement stmt = this.conexao.getConexao().prepareStatement(sql);

            stmt.setString(1, object.getEstado());
            stmt.setString(2, object.getMunicipio());
            stmt.setString(3, object.getBairro());
            stmt.setString(4, object.getLogradouro());
            stmt.setString(5, object.getNumero());
            stmt.setString(6, object.getComplemento());

            stmt.setLong(7, id);

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
            String sql = ("DELETE FROM endereco where idendereco = ?");
            PreparedStatement stmt = this.conexao.getConexao().prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.execute();
            stmt.close();

        } catch (SQLException erro) {
        }
        return true;
    }

    public Long buscarMaiorId() {
        Long id = 0L;
        try {
            Statement stmt = this.conexao.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(idendereco) id FROM Endereco");
            res.next();
            id = res.getLong("id");

            stmt.close();

        } catch (SQLException ex) {
        }
        return id;
    }
}
