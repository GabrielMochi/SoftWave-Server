package br.net.sofwave.server.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "disciplina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disciplina.findAll", query = "SELECT d FROM Disciplina d"),
    @NamedQuery(name = "Disciplina.findById", query = "SELECT d FROM Disciplina d WHERE d.disciplinaPK.id = :id"),
    @NamedQuery(name = "Disciplina.findByNome", query = "SELECT d FROM Disciplina d WHERE d.nome = :nome"),
    @NamedQuery(name = "Disciplina.findByTurmaNumero", query = "SELECT d FROM Disciplina d WHERE d.disciplinaPK.turmaNumero = :turmaNumero")
})
public class Disciplina implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected DisciplinaPK disciplinaPK;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nome")
    private String nome;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplina")
    private Collection<Atividade> atividadeCollection;
    
    @JoinColumn(name = "turma_numero", referencedColumnName = "numero", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Turma turma;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplina")
    private Collection<Questao> questaoCollection;

    public Disciplina() {
    }

    public Disciplina(DisciplinaPK disciplinaPK) {
        this.disciplinaPK = disciplinaPK;
    }

    public Disciplina(DisciplinaPK disciplinaPK, String nome) {
        this.disciplinaPK = disciplinaPK;
        this.nome = nome;
    }

    public Disciplina(int id, int turmaNumero) {
        this.disciplinaPK = new DisciplinaPK(id, turmaNumero);
    }

    public DisciplinaPK getDisciplinaPK() {
        return disciplinaPK;
    }

    public void setDisciplinaPK(DisciplinaPK disciplinaPK) {
        this.disciplinaPK = disciplinaPK;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Atividade> getAtividadeCollection() {
        return atividadeCollection;
    }

    public void setAtividadeCollection(Collection<Atividade> atividadeCollection) {
        this.atividadeCollection = atividadeCollection;
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
        hash += (disciplinaPK != null ? disciplinaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Disciplina)) {
            return false;
        }
        Disciplina other = (Disciplina) object;
        return !((this.disciplinaPK == null && other.disciplinaPK != null) || (this.disciplinaPK != null && !this.disciplinaPK.equals(other.disciplinaPK)));
    }

    @Override
    public String toString() {
        return "br.net.sofwave.server.domain.Disciplina[ disciplinaPK=" + disciplinaPK + " ]";
    }
    
}
