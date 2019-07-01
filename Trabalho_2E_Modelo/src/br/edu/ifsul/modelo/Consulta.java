
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "consulta")
public class Consulta implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_consulta", sequenceName = "seq_consulta_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_consulta", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "A data  não pode ser nula")
    @Temporal(TemporalType.DATE)
    @Column(name = "dia", nullable = false)
    private Calendar dia;
    
    @NotNull(message = "A hora  não pode ser nula")
    @Temporal(TemporalType.DATE)
    @Column(name = "hora", nullable = false)
    private Calendar hora;
    
    @Column(name = "preconsulta", columnDefinition = "text", nullable = false)
    private String preconsulta;
    
    @Column(name = "posconsulta", columnDefinition = "text")
    private String posconsulta;
    
    @NotNull(message = "O paciente deve ser informado")
    @ManyToOne
    @JoinColumn(name = "paciente", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_consulta_pac"))
    private Paciente paciente;
    
    @NotNull(message = "O medico deve ser informado")
    @ManyToOne
    @JoinColumn(name = "medico", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_consulta_medico"))
    private Medico medico;
    /*
    @NotNull(message = "O usuário deve ser informado")
    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "nome_usuario", nullable = false,
            foreignKey = @ForeignKey(name = "fk_consulta_usuario"))
    private Usuario usuario;*/
    
    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL,
        orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Exame> exames; //agregação por composição (como é dependente, orphanRemoval = true)
    
    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL,//persistencia implicita
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Receituario> receituario; //agregação por composição
    
    public Consulta(){
        
    }
    //quem sabe esses metodos podem ser apresentados a medida que forem necessários
    
    public void adicionarReceituario(Receituario obj) {
        obj.setConsulta(this);
        this.getReceituario().add(obj);
    }

    public void removerReceituario(int index) {
        this.getReceituario().remove(index);
    }   

    public void adicionarExame(Exame obj) {
        obj.setConsulta(this);
        this.getExames().add(obj);
    }

    public void removerExame(int index) {
        this.getExames().remove(index);
    }    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDia() {
        return dia;
    }

    public java.util.Date getDiaDate() {
        if(dia != null)
            return new java.util.Date(this.dia.getTimeInMillis());
        else
            return null;
    }
    
    public void setDia(Calendar nascimento) {
        this.dia = nascimento;
    }
    
    public void setDiaDate(java.util.Date nascimento) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(nascimento.getTime());
        this.dia = c;
    }

    public Calendar getHora() {
        return hora;
    }

    public java.util.Date getHoraDate() {
        if(hora != null)
            return new java.util.Date(this.hora.getTimeInMillis());
        else
            return null;
    }
    
    public void setHora(Calendar nascimento) {
        this.hora = nascimento;
    }
    
    public void setHoraDate(java.util.Date nascimento) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(nascimento.getTime());
        this.hora = c;
    }

    public String getPreconsulta() {
        return preconsulta;
    }

    public void setPreconsulta(String preConsulta) {
        this.preconsulta = preConsulta;
    }

    public String getPosconsulta() {
        return posconsulta;
    }

    public void setPosconsulta(String posconsulta) {
        this.posconsulta = posconsulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
/*
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
*/
    public List<Exame> getExames() {
        return exames;
    }

    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }

    public List<Receituario> getReceituario() {
        return receituario;
    }

    public void setReceituario(List<Receituario> receituario) {
        this.receituario = receituario;
    }
}