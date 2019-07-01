
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuario")
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING,length = 2)
@DiscriminatorValue(value = "US")
@NamedQuery(name="todosUsuarioOrdemNome",query="from Usuario order by nome asc")

//definir uma Namequery para fazer a autenticacao do Usuario na aplicacao web
@NamedQuery(name="autenticacaoUsuario", query = "from Usuario where nomeUsuario = :paramNome and senha = :paramSenha")

@NamedQuery(name="getUsuario", query = "from Usuario where nomeUsuario = :paramNome")

public class Usuario implements Serializable {
    
    @Id
    @NotNull(message = "O nome de usuario não pode ser nulo")
    @NotBlank(message = "O nome de usuario não ser em branco")
    @Length(max = 20, message = "O nome de usuario não pode ter mais de {max} caracteres")
    @Column(name = "nome_usuario", length = 20, nullable = false)  
    private String nomeUsuario;
    
    @NotNull(message = "A senha não pode ser nula")
    @NotBlank(message = "A senha não ser em branco")
    @Length(max = 10, message = "A senha não pode ter mais de {max} caracteres")
    @Column(name = "senha", length = 10, nullable = false)   
    private String senha;
    
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não ser em branco")
    @Length(max = 20, message = "O nome não pode ter mais de {max} caracteres")
    @Column(name = "nome", length = 20, nullable = false)  
    private String nome;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "permissoes",
            joinColumns
            = @JoinColumn(name = "nome_usuario", referencedColumnName = "nome_usuario", nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "permissao", referencedColumnName = "nome", nullable = false))
    private Set<Permissao> permissoes;
    
    public Usuario(){
        
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
 
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.nomeUsuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nomeUsuario, other.nomeUsuario)) {
            return false;
        }
        return true;
    }

    public Set<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(Set<Permissao> permissoes) {
        this.permissoes = permissoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
