package br.edu.ifsul.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Medico.class)
public abstract class Medico_ extends br.edu.ifsul.modelo.Paciente_ {

	public static volatile SingularAttribute<Medico, Especialidade> especialidade;
	public static volatile SingularAttribute<Medico, String> crm;

	public static final String ESPECIALIDADE = "especialidade";
	public static final String CRM = "crm";

}

