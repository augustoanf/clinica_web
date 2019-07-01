
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "receituario")
public class Receituario implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_receituario", sequenceName = "seq_receituario_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_receituario", strategy = GenerationType.SEQUENCE)   
    private Integer id;
    
    @Column(name = "posologia", columnDefinition = "text", nullable = false)
    private String posologia;
    
    @NotNull(message = "A validade  não pode ser nula")
    @Temporal(TemporalType.DATE)
    @Column(name = "validade", nullable = false)
    private Calendar validade;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicamentos", referencedColumnName = "id", nullable = false)
    private List<Medicamento> medicamentos; //associação bidirecional
    
    @NotNull(message = "A consulta deve ser informada")
    @ManyToOne
    @JoinColumn(name = "consulta", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_receituario_consulta"))   
    private Consulta consulta;//bidirecional
    
    public Receituario(){
        medicamentos = new ArrayList<>();
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosologia() {
        return posologia;
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }

    public Calendar getValidade() {
        return validade;
    }

    public java.util.Date getValidadeDate() {
        if(validade != null)
            return new java.util.Date(this.validade.getTimeInMillis());
        else
            return null;
    }
    
    public void setValidade(Calendar nascimento) {
        this.validade = nascimento;
    }
    
    public void setValidadeDate(java.util.Date nascimento) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(nascimento.getTime());
        this.validade = c;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
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
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Receituario other = (Receituario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
