/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Endereco;

import java.sql.SQLException;


/**
 *
 * @author G-fire
 */
public class EnderecoControl {

    private static final Endereco ENDERECO = new Endereco();

    public boolean cadastrar(String estado, String municipio, String bairro, String logradouro, String numero, String complemento) throws SQLException {
        return ENDERECO.cadastrar(new Endereco(ENDERECO.obterMaiorId() + 1, estado, municipio, bairro, logradouro, numero, complemento));
       
    }
    
}
