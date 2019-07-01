/*
 * 
 */
package br.edu.ifsul.converter;

import br.edu.ifsul.dao.MedicoDAO;
import br.edu.ifsul.modelo.Medico;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

@Named(value = "converterMedico")
@RequestScoped
public class ConverterMedico  implements Serializable, Converter  {
    
    @EJB
    private MedicoDAO dao; 
    
    public ConverterMedico(){
        
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if(value == null || value.equals("Selecione") || value.equals("Selecione um registro")){
            return null;
        }
        
        Medico md = null;
        try{
            md =  dao.getObjectById(value);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return md;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
         if(value == null){
            return null;
        }
        
        Medico md =  (Medico) value;
        return md.getId().toString();
    }
    
}