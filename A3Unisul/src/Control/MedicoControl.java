/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Medico;
import java.util.ArrayList;

public class MedicoControl {

    private final Medico MEDICO;

    public MedicoControl() {
        MEDICO = new Medico();
    }

    public boolean cadastrar(String crm, String especialidade, String periodoDeAtendimento, String nome, String telefone) {
        Long id = this.MEDICO.obterMaiorID() + 1L;
        MEDICO.cadastrar(new Medico(id, crm, especialidade, periodoDeAtendimento, nome, telefone));
        return true;
    }

    public ArrayList<Medico> buscar() {

        return MEDICO.buscar();
    }

    public boolean editar(Long id, String nome, String telefone, String especialidade, String crm, String periodoDeAtendimento) {

        MEDICO.editar(id,new Medico(id, crm, especialidade, periodoDeAtendimento, nome, telefone));
        return true;
    }

    public boolean excluir(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
