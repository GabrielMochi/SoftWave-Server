/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.sofwave.server.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "questao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Questao.findAll", query = "SELECT q FROM Questao q")
    , @NamedQuery(name = "Questao.findById", query = "SELECT q FROM Questao q WHERE q.questaoPK.id = :id")
    , @NamedQuery(name = "Questao.findByRespostaCorreta", query = "SELECT q FROM Questao q WHERE q.respostaCorreta = :respostaCorreta")
    , @NamedQuery(name = "Questao.findByAtividadeId", query = "SELECT q FROM Questao q WHERE q.questaoPK.atividadeId = :atividadeId")
    , @NamedQuery(name = "Questao.findByAtividadeDisciplinaId", query = "SELECT q FROM Questao q WHERE q.questaoPK.atividadeDisciplinaId = :atividadeDisciplinaId")
    , @NamedQuery(name = "Questao.findByAtividadeDisciplinaTurmaNumero", query = "SELECT q FROM Questao q WHERE q.questaoPK.atividadeDisciplinaTurmaNumero = :atividadeDisciplinaTurmaNumero")})
public class Questao implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected QuestaoPK questaoPK;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "pergunta")
    private String pergunta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "resposta_correta")
    private String respostaCorreta;
    @JoinColumn(name = "atividade_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Atividade atividade;
    @JoinColumn(name = "atividade_disciplina_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Disciplina disciplina;
    @JoinColumn(name = "atividade_disciplina_turma_numero", referencedColumnName = "numero", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Turma turma;

    public Questao() {
    }

    public Questao(QuestaoPK questaoPK) {
        this.questaoPK = questaoPK;
    }

    public Questao(QuestaoPK questaoPK, String pergunta, String respostaCorreta) {
        this.questaoPK = questaoPK;
        this.pergunta = pergunta;
        this.respostaCorreta = respostaCorreta;
    }

    public Questao(int id, int atividadeId, int atividadeDisciplinaId, int atividadeDisciplinaTurmaNumero) {
        this.questaoPK = new QuestaoPK(id, atividadeId, atividadeDisciplinaId, atividadeDisciplinaTurmaNumero);
    }

    public QuestaoPK getQuestaoPK() {
        return questaoPK;
    }

    public void setQuestaoPK(QuestaoPK questaoPK) {
        this.questaoPK = questaoPK;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getRespostaCorreta() {
        return respostaCorreta;
    }

    public void setRespostaCorreta(String respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (questaoPK != null ? questaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questao)) {
            return false;
        }
        Questao other = (Questao) object;
        if ((this.questaoPK == null && other.questaoPK != null) || (this.questaoPK != null && !this.questaoPK.equals(other.questaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.net.sofwave.server.domain.Questao[ questaoPK=" + questaoPK + " ]";
    }
    
}
