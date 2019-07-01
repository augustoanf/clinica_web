
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.MedicoDAO;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import br.edu.ifsul.modelo.Medico;
import br.edu.ifsul.util.Util;
import javax.ejb.EJB;

/**
 *
 * @author Telmo
 */
@Named(value = "controleMedico")
@ViewScoped
public class ControleMedico implements Serializable {
    
    @EJB
    private MedicoDAO dao;
    
    private Medico objeto;
    
    private Boolean isEdit = false;
    
    public ControleMedico(){
        
    }

    public MedicoDAO getDao() {
        return dao;
    }

    public Medico getObjeto() {
        return objeto;
    }

    public void setObjeto(Medico objeto) {
        this.objeto = objeto;
    }
    
    public String listar(){
        return "/privado/medico/crudmedico?faces-redirect=true";
    }
    
    public void novo(){
        setObjeto(new Medico());
        isEdit = false;
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


