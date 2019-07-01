/*
 * 
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.converter.ConverterOrdem;
import br.edu.ifsul.modelo.Paciente;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.ejb.Stateful;

@Stateful
public class PacienteDAO extends DAOGenerico<Paciente> implements Serializable{
    
    public PacienteDAO(){
         super(Paciente.class);
         
        // inicializar as ordenações possiveis        
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("nome", "Nome", "like"));
        // definir qual a ordenação padrão no caso o segundo elemento da lista (indice 1)
        ordemAtual = listaOrdem.get(1);
        // inicializar o conversor com a lista de ordens
        converterOrdem = new ConverterOrdem(listaOrdem);
    }
    
    @Override
    public List<Paciente> getListaTodos() {
            String jpql = "from " + classePersistente.getSimpleName() + " where tipo='PAC'";
            
            return em.createQuery(jpql).getResultList();
    }
    
    @Override
    public Paciente getObjectById(Object id) throws Exception {
        List<Paciente> pacientes = getListaObjetos();
        for(Paciente paciente : pacientes)
            if(Objects.equals(paciente.getId(), id))
                return paciente;
        return pacientes.get(0);
        
    }
}
