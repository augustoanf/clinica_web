
package br.edu.ifsul.converter;

import br.edu.ifsul.dao.MedicamentoDAO;
import br.edu.ifsul.modelo.Medicamento;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

@Named(value = "converterMedicamento")
@RequestScoped   
public class ConverterMedicamento implements Serializable, Converter{
    
    @EJB
    private MedicamentoDAO dao;

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
        
        Medicamento md = (Medicamento) value;
        return md.getId().toString();
        
    }
    
}
