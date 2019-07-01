package br.edu.ifsul.controle;

import br.edu.ifsul.dao.EspecialidadeDAO;
import br.edu.ifsul.modelo.Especialidade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import br.edu.ifsul.util.Util;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Telmo
 */
@Named(value = "controleEspecialidade")
@ViewScoped
public class ControleEspecialidade implements Serializable {
    
    @EJB
    private EspecialidadeDAO dao;

    private Especialidade objeto;

    public ControleEspecialidade(){

    }
    
    public String listar(){
        return "/privado/especialidade/crudespecialidade?faces-redirect=true";
    }

    public void novo(){
        objeto = new Especialidade();      
    }

    public EspecialidadeDAO getDao() {
        return dao;
    }
    
    
    
    public void alterar(Object id){
                try {
                        setObjeto(dao.getObjectById(id));            
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
                        if (getObjeto().getId() == null){
                                dao.persist(getObjeto());
                        } else {
                                dao.merge(getObjeto());
                        }
                        Util.mensagemInformacao("Objeto persistido com sucesso!");            
                } catch(Exception e){
                        Util.mensagemErro("Erro ao persistir objeto: " + 
                                        Util.getMensagemErro(e));
                }
        }

    public Especialidade getObjeto() {
        return objeto;
    }

    public void setObjeto(Especialidade objeto) {
        this.objeto = objeto;
    }
    
    
}
