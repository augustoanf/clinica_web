/*
 * 
 */
package br.edu.ifsul.converter;

import br.edu.ifsul.dao.EspecialidadeDAO;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import br.edu.ifsul.modelo.Especialidade;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "converterEspecialidade")
@RequestScoped
public class ConverterEspecialidade implements Converter, Serializable {

    @EJB
    private EspecialidadeDAO dao;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if(value == null || value.equals("Selecione") || value.equals("Selecione um registro")){
            return null;
        }
        return dao.find(Integer.parseInt(value));
        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null){
            return null;
        }
        Especialidade e = (Especialidade) value;    
        return e.getId().toString();
        
    }
    
}
