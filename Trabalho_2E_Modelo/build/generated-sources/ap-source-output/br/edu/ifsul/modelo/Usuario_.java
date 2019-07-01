package br.edu.ifsul.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuario.class)
public abstract class Usuario_ {

	public static volatile SingularAttribute<Usuario, String> nomeUsuario;
	public static volatile SingularAttribute<Usuario, String> senha;
	public static volatile SetAttribute<Usuario, Permissao> permissoes;
	public static volatile SingularAttribute<Usuario, String> nome;

	public static final String NOME_USUARIO = "nomeUsuario";
	public static final String SENHA = "senha";
	public static final String PERMISSOES = "permissoes";
	public static final String NOME = "nome";

}

