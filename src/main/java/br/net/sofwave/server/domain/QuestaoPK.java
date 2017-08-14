/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.sofwave.server.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class QuestaoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "atividade_id")
    private int atividadeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "atividade_disciplina_id")
    private int atividadeDisciplinaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "atividade_disciplina_turma_numero")
    private int atividadeDisciplinaTurmaNumero;

    public QuestaoPK() {
    }

    public QuestaoPK(int id, int atividadeId, int atividadeDisciplinaId, int atividadeDisciplinaTurmaNumero) {
        this.id = id;
        this.atividadeId = atividadeId;
        this.atividadeDisciplinaId = atividadeDisciplinaId;
        this.atividadeDisciplinaTurmaNumero = atividadeDisciplinaTurmaNumero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAtividadeId() {
        return atividadeId;
    }

    public void setAtividadeId(int atividadeId) {
        this.atividadeId = atividadeId;
    }

    public int getAtividadeDisciplinaId() {
        return atividadeDisciplinaId;
    }

    public void setAtividadeDisciplinaId(int atividadeDisciplinaId) {
        this.atividadeDisciplinaId = atividadeDisciplinaId;
    }

    public int getAtividadeDisciplinaTurmaNumero() {
        return atividadeDisciplinaTurmaNumero;
    }

    public void setAtividadeDisciplinaTurmaNumero(int atividadeDisciplinaTurmaNumero) {
        this.atividadeDisciplinaTurmaNumero = atividadeDisciplinaTurmaNumero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) atividadeId;
        hash += (int) atividadeDisciplinaId;
        hash += (int) atividadeDisciplinaTurmaNumero;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuestaoPK)) {
            return false;
        }
        QuestaoPK other = (QuestaoPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.atividadeId != other.atividadeId) {
            return false;
        }
        if (this.atividadeDisciplinaId != other.atividadeDisciplinaId) {
            return false;
        }
        if (this.atividadeDisciplinaTurmaNumero != other.atividadeDisciplinaTurmaNumero) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.net.sofwave.server.domain.QuestaoPK[ id=" + id + ", atividadeId=" + atividadeId + ", atividadeDisciplinaId=" + atividadeDisciplinaId + ", atividadeDisciplinaTurmaNumero=" + atividadeDisciplinaTurmaNumero + " ]";
    }
    
}
