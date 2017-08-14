package br.net.sofwave.server.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "atividade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Atividade.findAll", query = "SELECT a FROM Atividade a"),
    @NamedQuery(name = "Atividade.findById", query = "SELECT a FROM Atividade a WHERE a.atividadePK.id = :id"),
    @NamedQuery(name = "Atividade.findByLancada", query = "SELECT a FROM Atividade a WHERE a.lancada = :lancada"),
    @NamedQuery(name = "Atividade.findByDisciplinaId", query = "SELECT a FROM Atividade a WHERE a.atividadePK.disciplinaId = :disciplinaId"),
    @NamedQuery(name = "Atividade.findByDisciplinaTurmaNumero", query = "SELECT a FROM Atividade a WHERE a.atividadePK.disciplinaTurmaNumero = :disciplinaTurmaNumero")
})
public class Atividade implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected AtividadePK atividadePK;
    
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descricao")
    private String descricao;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "lancada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lancada;
    
    @JoinColumn(name = "disciplina_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Disciplina disciplina;
    
    @JoinColumn(name = "disciplina_turma_numero", referencedColumnName = "numero", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Turma turma;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "atividade")
    private Collection<Questao> questaoCollection;

    public Atividade() {
    }

    public Atividade(AtividadePK atividadePK) {
        this.atividadePK = atividadePK;
    }

    public Atividade(AtividadePK atividadePK, String descricao, Date lancada) {
        this.atividadePK = atividadePK;
        this.descricao = descricao;
        this.lancada = lancada;
    }

    public Atividade(int id, int disciplinaId, int disciplinaTurmaNumero) {
        this.atividadePK = new AtividadePK(id, disciplinaId, disciplinaTurmaNumero);
    }

    public AtividadePK getAtividadePK() {
        return atividadePK;
    }

    public void setAtividadePK(AtividadePK atividadePK) {
        this.atividadePK = atividadePK;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getLancada() {
        return lancada;
    }

    public void setLancada(Date lancada) {
        this.lancada = lancada;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @XmlTransient
    public Collection<Questao> getQuestaoCollection() {
        return questaoCollection;
    }

    public void setQuestaoCollection(Collection<Questao> questaoCollection) {
        this.questaoCollection = questaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (atividadePK != null ? atividadePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Atividade)) {
            return false;
        }
        Atividade other = (Atividade) object;
        return !((this.atividadePK == null && other.atividadePK != null) || (this.atividadePK != null && !this.atividadePK.equals(other.atividadePK)));
    }

    @Override
    public String toString() {
        return "br.net.sofwave.server.domain.Atividade[ atividadePK=" + atividadePK + " ]";
    }
    
}
