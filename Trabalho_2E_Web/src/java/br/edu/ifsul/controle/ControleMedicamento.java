package br.edu.ifsul.controle;

import br.edu.ifsul.dao.MedicamentoDAO;
import br.edu.ifsul.modelo.Medicamento;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import br.edu.ifsul.util.Util;
import javax.faces.view.ViewScoped;

@Named(value = "controleMedicamento")
@ViewScoped
public class ControleMedicamento implements Serializable {
    
    @EJB
    private MedicamentoDAO dao;

    private Medicamento objeto;

    public ControleMedicamento(){

    }
    
    public String listar(){
        return "/privado/medicamento/crudmedicamento?faces-redirect=true";
    }

    public void novo(){
        objeto = new Medicamento();      
    }

    public MedicamentoDAO getDao() {
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

    public Medicamento getObjeto() {
        return objeto;
    }

    public void setObjeto(Medicamento objeto) {
        this.objeto = objeto;
    }
    
    
}
