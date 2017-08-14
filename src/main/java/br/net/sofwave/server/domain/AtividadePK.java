package br.net.sofwave.server.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class AtividadePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "disciplina_id")
    private int disciplinaId;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "disciplina_turma_numero")
    private int disciplinaTurmaNumero;

    public AtividadePK() {
    }

    public AtividadePK(int id, int disciplinaId, int disciplinaTurmaNumero) {
        this.id = id;
        this.disciplinaId = disciplinaId;
        this.disciplinaTurmaNumero = disciplinaTurmaNumero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(int disciplinaId) {
        this.disciplinaId = disciplinaId;
    }

    public int getDisciplinaTurmaNumero() {
        return disciplinaTurmaNumero;
    }

    public void setDisciplinaTurmaNumero(int disciplinaTurmaNumero) {
        this.disciplinaTurmaNumero = disciplinaTurmaNumero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) disciplinaId;
        hash += (int) disciplinaTurmaNumero;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AtividadePK)) {
            return false;
        }
        AtividadePK other = (AtividadePK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.disciplinaId != other.disciplinaId) {
            return false;
        }
        return this.disciplinaTurmaNumero == other.disciplinaTurmaNumero;
    }

    @Override
    public String toString() {
        return "br.net.sofwave.server.domain.AtividadePK[ id=" + id + ", disciplinaId=" + disciplinaId + ", disciplinaTurmaNumero=" + disciplinaTurmaNumero + " ]";
    }
    
}
