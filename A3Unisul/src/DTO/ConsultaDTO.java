package DTO;

import java.time.LocalDate;

public class ConsultaDTO {
   
    private Long idConsulta; 
    private String cpf;
    private String crm;
    private LocalDate dataDoExame;
    private String horarioDeExame;
    private String descricao;

    public ConsultaDTO() {
    }

    public ConsultaDTO(Long idConsulta, String cpf, String crm, LocalDate dataDoExame, String horarioDeExame, String descricao) {
        this.idConsulta = idConsulta;
        this.cpf = cpf;
        this.crm = crm;
        this.dataDoExame = dataDoExame;
        this.horarioDeExame = horarioDeExame;
        this.descricao = descricao;
    }

    public Long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Long idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public LocalDate getDataDoExame() {
        return dataDoExame;
    }

    public void setDataDoExame(LocalDate dataDoExame) {
        this.dataDoExame = dataDoExame;
    }

    public String getHorarioDeExame() {
        return horarioDeExame;
    }

    public void setHorarioDeExame(String horarioDeExame) {
        this.horarioDeExame = horarioDeExame;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
}
