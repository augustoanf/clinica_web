
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.PacienteDAO;
import br.edu.ifsul.modelo.Paciente;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import br.edu.ifsul.util.Util;
import java.io.Serializable;

@Named(value = "controlePaciente")
@ViewScoped
public class ControlePaciente implements  Serializable{
    
    @EJB
    private PacienteDAO dao;
    
    private Paciente objeto;
    
    private Boolean isEdit = false;
    
    public ControlePaciente(){                
    }
    
    public String listar(){
        return "/privado/paciente/crudpaciente?faces-redirect=true";
    }
    
    public void novo(){
        setObjeto(new Paciente());
        isEdit = false;
    }

    public Paciente getObjeto() {
        return objeto;
    }

    public void setObjeto(Paciente objeto) {
        this.objeto = objeto;
    }

    public PacienteDAO getDao() {
        return dao;
    }
    
    public void alterar(Object id){
             try {
                    setObjeto(dao.getObjectById(id));
                    isEdit = true;
             } catch (Exception e){
                     Util.mensagemErro("Erro ao recuperar objeto: " + 
                                     Util.getMensagemErro(e));
             } 
     }

    public void excluir(Object id){
            try {
                    setObjeto(dao.getObjectById(id));
                    dao.remover(getObjeto());
                    Util.mensagemInformacao("Objeto removido com sucesso!");
            } catch (Exception e){
                    Util.mensagemErro("Erro ao remover objeto: " + 
                                    Util.getMensagemErro(e));
            }
    }

    public void salvar(){
        try {
            
                if(!getIsEdit()){
                    dao.persist(objeto);
                    Util.mensagemInformacao("Objeto inserido com sucesso!");
                }else{
                    dao.merge(objeto);
                    Util.mensagemInformacao("Objeto alterado com sucesso!");
                }
                    
            } catch(Exception e){
                    Util.mensagemErro("Erro ao persistir objeto: " + 
                                    Util.getMensagemErro(e));
            }
    }
    

    public Boolean getIsEdit() {
        return isEdit;
    }
    
}
