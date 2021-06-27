/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Endereco;
import Principal.Principal;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.*;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author G-fire
 */
public class EnderecoControl {

    private static final Endereco ENDERECO = new Endereco();

    public boolean cadastrar(String estado, String municipio, String bairro, String logradouro, String numero, String complemento) throws SQLException {
        return ENDERECO.cadastrar(new Endereco(ENDERECO.obterMaiorId() + 1, estado, municipio, bairro, logradouro, numero, complemento));

    }

    public JSONObject bucarEnderecoPeloCEP(String cep) {
         JSONObject endereco = null;
         
        try {
            HttpResponse<String> response = Unirest.get("http://viacep.com.br/ws/" + cep + "/json/")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .asString();

            JsonNode jsonNode = new JsonNode(response.getBody());
            
             endereco = jsonNode.getObject();
            
//
//            JSONObject object = jsonNode.getObject();

//            endereco = new Endereco(
//                    ENDERECO.obterMaiorId() + 1,
//                    object.get("uf").toString(),
//                    object.get("localidade").toString(),
//                    object.get("bairro").toString(),
//                    object.get("logradouro").toString(),
//                    "",
//                    object.get("complemento").toString());
//
//            System.err.println(endereco.toString());

        } catch (UnirestException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return endereco;
    }

}
