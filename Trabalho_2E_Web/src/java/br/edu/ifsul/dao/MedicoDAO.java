/*
 * 
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.converter.ConverterOrdem;
import java.io.Serializable;
import br.edu.ifsul.modelo.Medico;
import java.util.List;
import java.util.Objects;
import javax.ejb.Stateful;

@Stateful
public class MedicoDAO extends DAOGenerico<Medico> implements Serializable{
    
    public MedicoDAO(){
        
        super(Medico.class);
        
        // inicializar as ordenações possiveis        
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("crm", "CRM", "="));
        // definir qual a ordenação padrão no caso o segundo elemento da lista (indice 1)
        ordemAtual = listaOrdem.get(1);
        // inicializar o conversor com a lista de ordens
        converterOrdem = new ConverterOrdem(listaOrdem);
    }
    
    @Override
    public List<Medico> getListaTodos() {
            String jpql = "from " + classePersistente.getSimpleName() + " where tipo='MED'";
            
            return em.createQuery(jpql).getResultList();
    }
    
    @Override
    public Medico getObjectById(Object id) throws Exception {
        List<Medico> pacientes = getListaObjetos();
        System.out.println("ID: " + id);
        for(Medico paciente : pacientes)
            if(Objects.equals(paciente.getId(), id))
                return paciente;
        return pacientes.get(0);
        
    }
    
}
