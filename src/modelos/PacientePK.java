/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Daniel
 */
@Embeddable
public class PacientePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @Column(name = "campus_id")
    private int campusId;

    public PacientePK() {
    }

    public PacientePK(int id, int campusId) {
        this.id = id;
        this.campusId = campusId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCampusId() {
        return campusId;
    }

    public void setCampusId(int campusId) {
        this.campusId = campusId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) campusId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PacientePK)) {
            return false;
        }
        PacientePK other = (PacientePK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.campusId != other.campusId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lab2.labbd.PacientePK[ id=" + id + ", campusId=" + campusId + " ]";
    }
    
}
