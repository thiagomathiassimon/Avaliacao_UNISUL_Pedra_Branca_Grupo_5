package Control;

import Model.Endereco;
import Principal.Principal;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

public class EnderecoControl {

    private static final Endereco ENDERECO = new Endereco();

    public boolean cadastrar(String estado, String municipio, String bairro, String logradouro, String numero, String complemento, String cep) throws SQLException {
        return ENDERECO.cadastrar(new Endereco(
                ENDERECO.obterMaiorId() + 1, estado, municipio, bairro, logradouro, numero, complemento, cep));
    }

    public boolean editar(Long idEndereco, String estado, String municipio, String bairro, String logradouro, String numero, String complemento, String cep) {
        return ENDERECO.editar(new Endereco(
                idEndereco, estado, municipio, bairro, logradouro, numero, complemento, cep));
    }
            
    
    public JSONObject bucarEnderecoPeloCEP(String cep) {
        JSONObject endereco = null;

        try {
            HttpResponse<String> response = Unirest.get("http://viacep.com.br/ws/" + cep + "/json/")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .asString();

            JsonNode jsonNode = new JsonNode(response.getBody());

            endereco = jsonNode.getObject();

        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return endereco;
    }

}
