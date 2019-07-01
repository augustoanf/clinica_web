/*
 * 
 */
package br.edu.ifsul.converter;

import br.edu.ifsul.dao.PacienteDAO;
import br.edu.ifsul.modelo.Paciente;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

@Named(value = "converterPaciente")
@RequestScoped
public class ConverterPaciente  implements Serializable, Converter  {
    
    @EJB
    private PacienteDAO dao; 
    
    public ConverterPaciente(){
        
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if(value == null || value.equals("Selecione") || value.equals("Selecione um registro")){
            return null;
        }
        
        Paciente pc = null;
        try{
            pc =  dao.getObjectById(value);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return pc;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
         if(value == null){
            return null;
        }
        
        Paciente pc =  (Paciente) value;
        return pc.getId().toString();
    }
    
}
