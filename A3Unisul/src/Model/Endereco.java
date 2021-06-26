package Model;

import DAO.EnderecoDAO;

public class Endereco {

    private Long idEndereco;
    private String estado;
    private String municipio;
    private String bairro;
    private String logradouro;
    private String numero;
    private String complemento;

    private static final EnderecoDAO ENDERECO_DAO = new EnderecoDAO();

    public Endereco() {
    }

    public Endereco(Long idEndereco, String estado, String municipio, String bairro, String logradouro, String numero, String complemento) {
        this.idEndereco = idEndereco;
        this.estado = estado;
        this.municipio = municipio;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public boolean cadastrar(Endereco object) {
        return ENDERECO_DAO.cadastrar(object);
    }

    public Long obterMaiorId() {
        return ENDERECO_DAO.buscarMaiorId();
    }

    @Override
    public String toString() {
        return "Endereco{" + "\nestado=" + estado + ", \nmunicipio=" + municipio + ", \nbairro=" + bairro + ", \nlogradouro=" + logradouro + ", \nnumero=" + numero + ", \ncomplemento=" + complemento + '}';
    }

    public String obterEnderecoEscritoPorExtenso() {
        return String.format("Logradouro: %s%nNúmero: %s%nBairro: %s%nMunicípio: %s%nEstado: %s",
                this.logradouro, this.numero, this.bairro, this.municipio, this.estado);
    }

}
