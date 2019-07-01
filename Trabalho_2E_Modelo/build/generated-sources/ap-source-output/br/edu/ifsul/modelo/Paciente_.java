package br.edu.ifsul.modelo;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Paciente.class)
public abstract class Paciente_ {

	public static volatile SingularAttribute<Paciente, Calendar> nascimento;
	public static volatile SingularAttribute<Paciente, String> telefone;
	public static volatile SingularAttribute<Paciente, Double> peso;
	public static volatile SingularAttribute<Paciente, Double> altura;
	public static volatile SingularAttribute<Paciente, String> historico;
	public static volatile SingularAttribute<Paciente, String> nome;
	public static volatile SingularAttribute<Paciente, Integer> id;
	public static volatile SingularAttribute<Paciente, String> sexo;

	public static final String NASCIMENTO = "nascimento";
	public static final String TELEFONE = "telefone";
	public static final String PESO = "peso";
	public static final String ALTURA = "altura";
	public static final String HISTORICO = "historico";
	public static final String NOME = "nome";
	public static final String ID = "id";
	public static final String SEXO = "sexo";

}

