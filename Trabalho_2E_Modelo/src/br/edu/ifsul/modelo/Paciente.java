
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "paciente")
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING,length = 3)
@DiscriminatorValue(value = "PAC")
@NamedQuery(name="todosPacienteOrdemNome", query="from Paciente order by nome asc")

public class Paciente implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_paciente", sequenceName = "seq_paciente_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_paciente", strategy = GenerationType.SEQUENCE)   
    private Integer id;
    
    @NotNull(message = "O nome do paciente não pode ser nulo")
    @NotBlank(message = "O nome do paciente não ser em branco")
    @Length(max = 20, message = "O nome do paciente não pode ter mais de {max} caracteres")
    @Column(name = "nome", length = 20, nullable = false)  
    private String nome;
    
    @NotNull(message = "O nascimento  não pode ser nula")
    @Temporal(TemporalType.DATE)
    @Column(name = "nascimento", nullable = false)
    private Calendar nascimento;
    
    @NotNull(message = "O telefone principal não pode ser nulo")
    @NotBlank(message = "O telefone principal  não ser em branco")
    @Length(max = 14, message = "O telefone principal não pode ter mais de {max} caracteres")
    @Column(name = "telefone", length = 14, nullable = false) 
    private String telefone;
    
    @NotNull(message = "O sexo não pode ser nulo")
    @NotBlank(message = "O sexo não ser em branco")
    @Length(max = 1, message = "O sexo não pode ter mais de {max} caractere")
    @Column(name = "sexo", length = 1, nullable = false)    
    private String sexo;
    
    @Column(name = "historico", columnDefinition = "text", nullable = false)
    private String historico;
    
    @Min(message = "O peso não pode ser negativo", value = 0)
    @NotNull(message = "O peso deve ser informado")
    @Column(name = "peso", nullable = false, columnDefinition = "numeric(12,2)")    
    private Double peso;
    
    @Min(message = "A altura não pode ser negativa", value = 0)
    @NotNull(message = "A altura deve ser informada")
    @Column(name = "altura", nullable = false, columnDefinition = "numeric(12,2)")    
    private Double altura;
    
    public Paciente(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public java.util.Date getNascimentoDate() {
        if(nascimento != null)
            return new java.util.Date(this.nascimento.getTimeInMillis());
        else
            return null;
    }
    
    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }
    
    public void setNascimentoDate(java.util.Date nascimento) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(nascimento.getTime());
        this.nascimento = c;
    }
      
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
}
