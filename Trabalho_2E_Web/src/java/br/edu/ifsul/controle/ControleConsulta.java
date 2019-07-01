
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.ConsultaDAO;
import br.edu.ifsul.dao.MedicamentoDAO;
import br.edu.ifsul.modelo.Consulta;
import br.edu.ifsul.modelo.Exame;
import br.edu.ifsul.modelo.Receituario;
import br.edu.ifsul.util.Util;
import br.edu.ifsul.util.UtilRelatorios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "controleConsulta")
@SessionScoped
public class ControleConsulta implements Serializable {
    
    @EJB
    private ConsultaDAO dao;
    
    private Consulta objeto;
    
    @EJB
    private MedicamentoDAO medicamentoDao;
    
    private Receituario receituario;
    
    private Boolean novoReceituario;
	
    private Exame exame;
    
    public ControleConsulta(){
        
    }
    
    public void novoReceituario() {
        setReceituario(new Receituario());
        novoReceituario = true;
        System.out.println("Receituario: " + getReceituario());
    }

    public void alterarReceituario(int index) {
        setReceituario(objeto.getReceituario().get(index));
        novoReceituario = false;
    }

    public void salvarReceituario() {
        if (novoReceituario) {
            objeto.adicionarReceituario(getReceituario());
        }
        Util.mensagemInformacao("Receituario adicionado com sucesso");
    }

    public void removerReceituario(int index) {
        objeto.removerReceituario(index);
        Util.mensagemInformacao("Receituario removido com sucesso");
    }
    
    public void novoExame() {
        setExame(new Exame());
    }

    public void salvarExame() {
        objeto.adicionarExame(getExame());
        Util.mensagemInformacao("Exame adicionado com sucesso!");
    }
    
    public void removerExame(int index) {
        objeto.removerExame(index);
        Util.mensagemInformacao("Exame removido com sucesso!");
    } 
    
    public String listar(){
            return "/privado/consulta/crudconsulta?faces-redirect=true";
    }

    public void novo(){
        
            objeto = new Consulta();  
            objeto.setExames(new ArrayList());
            objeto.setReceituario(new ArrayList());
    }

    public void alterar(Object id){
            try {
                    objeto = getDao().getObjectById(id);            
            } catch (Exception e){
                    Util.mensagemErro("Erro ao recuperar objeto: " + 
                                    Util.getMensagemErro(e));
            } 
    }

    public void excluir(Object id){
            try {
                    objeto = getDao().getObjectById(id);
                    getDao().remover(objeto);
                    Util.mensagemInformacao("Objeto removido com sucesso!");
            } catch (Exception e){
                    Util.mensagemErro("Erro ao remover objeto: " + 
                                    Util.getMensagemErro(e));
            }
    }

    public void salvar(){
            try {
                    if (objeto.getId() == null){
                            getDao().persist(objeto);
                    } else {
                            getDao().merge(objeto);
                    }
                    Util.mensagemInformacao("Objeto persistido com sucesso!");            
            } catch(Exception e){
                    Util.mensagemErro("Erro ao persistir objeto: " + 
                                    Util.getMensagemErro(e));
            }
    }
    

    public Consulta getObjeto() {
        return objeto;
    }

    public void setObjeto(Consulta objeto) {
        this.objeto = objeto;
    }

    public ConsultaDAO getDao() {
        return dao;
    }

    public void setDao(ConsultaDAO dao) {
        this.dao = dao;
    }

    public Receituario getReceituario() {
        return receituario;
    }

    public void setReceituario(Receituario receituario) {
        this.receituario = receituario;
    }

    public MedicamentoDAO getMedicamentoDao() {
        return medicamentoDao;
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }
    
    public void imprimirConsultas() {
        HashMap parametros = new HashMap();
        UtilRelatorios.imprimeRelatorio("relatorioConsultas", parametros, dao.getListaTodos());
    }
}
