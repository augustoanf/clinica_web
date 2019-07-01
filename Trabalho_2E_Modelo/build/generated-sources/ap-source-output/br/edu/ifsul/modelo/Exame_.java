package br.edu.ifsul.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Exame.class)
public abstract class Exame_ {

	public static volatile SingularAttribute<Exame, String> nome;
	public static volatile SingularAttribute<Exame, Integer> id;
	public static volatile SingularAttribute<Exame, Consulta> consulta;
	public static volatile SingularAttribute<Exame, String> descricao;

	public static final String NOME = "nome";
	public static final String ID = "id";
	public static final String CONSULTA = "consulta";
	public static final String DESCRICAO = "descricao";

}

