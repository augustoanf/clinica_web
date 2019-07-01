
package br.edu.ifsul.dao;

import br.edu.ifsul.converter.ConverterOrdem;
import br.edu.ifsul.modelo.Consulta;
import java.io.Serializable;
import javax.ejb.Stateful;

@Stateful
public class ConsultaDAO extends DAOGenerico<Consulta> implements Serializable  {
    
    public ConsultaDAO(){
        
        super(Consulta.class);
        
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("medico.nome", "Médico", "like"));
        listaOrdem.add(new Ordem("paciente.nome", "Paciente", "like"));
        // definir qual a ordenação padrão no caso o segundo elemento da lista (indice 1)
        ordemAtual = listaOrdem.get(1);
        // inicializar o conversor com a lista de ordens
        converterOrdem = new ConverterOrdem(listaOrdem);
    }
    
    @Override
    public Consulta getObjectById(Object id) throws Exception {
            Consulta obj = em.find(Consulta.class, id);
            // Deve-se inicializar as coleções para não gerar erro de LazyInicializationException
            obj.getReceituario().size();
            obj.getExames().size();
            return obj;
    }  
}
