/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.polytech.ogas;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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

/**
 *
 * @author epulapp
 */
@Entity
@Table(name = "Evenement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evenement.findAll", query = "SELECT e FROM Evenement e"),
    @NamedQuery(name = "Evenement.findByEvtId", query = "SELECT e FROM Evenement e WHERE e.evtId = :evtId"),
    @NamedQuery(name = "Evenement.findByEvtType", query = "SELECT e FROM Evenement e WHERE e.evtType = :evtType"),
    @NamedQuery(name = "Evenement.findByEvtDate", query = "SELECT e FROM Evenement e WHERE e.evtDate = :evtDate"),
    @NamedQuery(name = "Evenement.findByEvtDuree", query = "SELECT e FROM Evenement e WHERE e.evtDuree = :evtDuree"),
    @NamedQuery(name = "Evenement.findByEvtdureeEntretien", query = "SELECT e FROM Evenement e WHERE e.evtdureeEntretien = :evtdureeEntretien")})
public class Evenement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "evt_id")
    private Short evtId;
    @Size(max = 2147483647)
    @Column(name = "evt_type")
    private String evtType;
    @Column(name = "evt_date")
    @Temporal(TemporalType.DATE)
    private Date evtDate;
    @Size(max = 2147483647)
    @Column(name = "evt_duree")
    private String evtDuree;
    @Column(name = "evt_dureeEntretien")
    private Short evtdureeEntretien;
    @OneToMany(mappedBy = "etrevtID")
    private Collection<Entretien> entretienCollection;

    public Evenement() {
    }

    public Evenement(Short evtId) {
        this.evtId = evtId;
    }

    public Short getEvtId() {
        return evtId;
    }

    public void setEvtId(Short evtId) {
        this.evtId = evtId;
    }

    public String getEvtType() {
        return evtType;
    }

    public void setEvtType(String evtType) {
        this.evtType = evtType;
    }

    public Date getEvtDate() {
        return evtDate;
    }

    public void setEvtDate(Date evtDate) {
        this.evtDate = evtDate;
    }

    public String getEvtDuree() {
        return evtDuree;
    }

    public void setEvtDuree(String evtDuree) {
        this.evtDuree = evtDuree;
    }

    public Short getEvtdureeEntretien() {
        return evtdureeEntretien;
    }

    public void setEvtdureeEntretien(Short evtdureeEntretien) {
        this.evtdureeEntretien = evtdureeEntretien;
    }

    @XmlTransient
    public Collection<Entretien> getEntretienCollection() {
        return entretienCollection;
    }

    public void setEntretienCollection(Collection<Entretien> entretienCollection) {
        this.entretienCollection = entretienCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evtId != null ? evtId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evenement)) {
            return false;
        }
        Evenement other = (Evenement) object;
        if ((this.evtId == null && other.evtId != null) || (this.evtId != null && !this.evtId.equals(other.evtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.polytech.ogas.Evenement[ evtId=" + evtId + " ]";
    }
    
}
