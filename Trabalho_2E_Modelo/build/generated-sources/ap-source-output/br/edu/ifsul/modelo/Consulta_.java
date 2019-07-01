package br.edu.ifsul.modelo;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Consulta.class)
public abstract class Consulta_ {

	public static volatile ListAttribute<Consulta, Receituario> receituario;
	public static volatile SingularAttribute<Consulta, String> preconsulta;
	public static volatile SingularAttribute<Consulta, String> posconsulta;
	public static volatile SingularAttribute<Consulta, Calendar> hora;
	public static volatile SingularAttribute<Consulta, Paciente> paciente;
	public static volatile SingularAttribute<Consulta, Medico> medico;
	public static volatile SingularAttribute<Consulta, Integer> id;
	public static volatile SingularAttribute<Consulta, Calendar> dia;
	public static volatile ListAttribute<Consulta, Exame> exames;

	public static final String RECEITUARIO = "receituario";
	public static final String PRECONSULTA = "preconsulta";
	public static final String POSCONSULTA = "posconsulta";
	public static final String HORA = "hora";
	public static final String PACIENTE = "paciente";
	public static final String MEDICO = "medico";
	public static final String ID = "id";
	public static final String DIA = "dia";
	public static final String EXAMES = "exames";

}

