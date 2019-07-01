
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "exame")
public class Exame implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_exame", sequenceName = "seq_exame_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_exame", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O nome deve ser informado")
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 100, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
            
    
    @NotNull(message = "A descrição deve ser informada")
    @NotBlank(message = "A descrição não pode ser em branco")
    @Length(max = 50, message = "A descrição do exame não pode ter mais que {max} caracteres")
    @Column(name = "descricao", nullable = false, length = 50)  
    private String descricao;
    
    @NotNull(message = "A consulta deve ser informada")
    @ManyToOne
    @JoinColumn(name = "consulta", referencedColumnName = "id", nullable = false, 
            foreignKey = @ForeignKey(name = "fk_exame_consulta"))
    private Consulta consulta;//bidirecional
    
    public Exame(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Exame other = (Exame) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
