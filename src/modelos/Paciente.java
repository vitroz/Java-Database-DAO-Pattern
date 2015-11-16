/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p"),
    @NamedQuery(name = "Paciente.findById", query = "SELECT p FROM Paciente p WHERE p.pacientePK.id = :id"),
    @NamedQuery(name = "Paciente.findByNome", query = "SELECT p FROM Paciente p WHERE p.nome = :nome"),
    @NamedQuery(name = "Paciente.findByDataNasc", query = "SELECT p FROM Paciente p WHERE p.dataNasc = :dataNasc"),
    @NamedQuery(name = "Paciente.findByTurma", query = "SELECT p FROM Paciente p WHERE p.turma = :turma"),
    @NamedQuery(name = "Paciente.findByNaturalidade", query = "SELECT p FROM Paciente p WHERE p.naturalidade = :naturalidade"),
    @NamedQuery(name = "Paciente.findByTelefone", query = "SELECT p FROM Paciente p WHERE p.telefone = :telefone"),
    @NamedQuery(name = "Paciente.findBySexo", query = "SELECT p FROM Paciente p WHERE p.sexo = :sexo"),
    @NamedQuery(name = "Paciente.findByRaca", query = "SELECT p FROM Paciente p WHERE p.raca = :raca"),
    @NamedQuery(name = "Paciente.findByMatricula", query = "SELECT p FROM Paciente p WHERE p.matricula = :matricula"),
    @NamedQuery(name = "Paciente.findByCampusId", query = "SELECT p FROM Paciente p WHERE p.pacientePK.campusId = :campusId")})
public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PacientePK pacientePK;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "data_nasc")
    @Temporal(TemporalType.DATE)
    private Date dataNasc;
    @Basic(optional = false)
    @Column(name = "turma")
    private String turma;
    @Basic(optional = false)
    @Column(name = "naturalidade")
    private String naturalidade;
    @Basic(optional = false)
    @Column(name = "telefone")
    private String telefone;
    @Basic(optional = false)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @Column(name = "raca")
    private String raca;
    @Column(name = "matricula")
    private String matricula;
    @JoinColumn(name = "campus_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Campus campus;

    public Paciente() {
    }

    public Paciente(PacientePK pacientePK) {
        this.pacientePK = pacientePK;
    }

    public Paciente(PacientePK pacientePK, String nome, Date dataNasc, String turma, String naturalidade, String telefone, String sexo, String raca) {
        this.pacientePK = pacientePK;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.turma = turma;
        this.naturalidade = naturalidade;
        this.telefone = telefone;
        this.sexo = sexo;
        this.raca = raca;
    }

    public Paciente(int id, int campusId) {
        this.pacientePK = new PacientePK(id, campusId);
    }

    public PacientePK getPacientePK() {
        return pacientePK;
    }

    public void setPacientePK(PacientePK pacientePK) {
        this.pacientePK = pacientePK;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
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

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pacientePK != null ? pacientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.pacientePK == null && other.pacientePK != null) || (this.pacientePK != null && !this.pacientePK.equals(other.pacientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lab2.labbd.Paciente[ pacientePK=" + pacientePK + " ]";
    }
    
}
