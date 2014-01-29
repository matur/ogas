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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author epulapp
 */
@Entity
@Table(name = "evenement", schema = "ogas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evenement.findAll", query = "SELECT e FROM Evenement e"),
    @NamedQuery(name = "Evenement.findById", query = "SELECT e FROM Evenement e WHERE e.id = :id"),
    @NamedQuery(name = "Evenement.findByTypeevt", query = "SELECT e FROM Evenement e WHERE e.typeevt = :typeevt"),
    @NamedQuery(name = "Evenement.findByDateevt", query = "SELECT e FROM Evenement e WHERE e.dateevt = :dateevt"),
    @NamedQuery(name = "Evenement.findByDuree", query = "SELECT e FROM Evenement e WHERE e.duree = :duree"),
    @NamedQuery(name = "Evenement.findByDureeEntretien", query = "SELECT e FROM Evenement e WHERE e.dureeEntretien = :dureeEntretien")})
@XmlType(propOrder={"id","typeevt","dateevt","duree","dureeEntretien","evtid"})
public class Evenement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "typeevt")
    private String typeevt;
    @Column(name = "dateevt")
    @Temporal(TemporalType.DATE)
    private Date dateevt;
    @Size(max = 2147483647)
    @Column(name = "duree")
    private String duree;
    @Column(name = "dureeEntretien")
    private Short dureeEntretien;
    @OneToMany(mappedBy = "evtid")
    private Collection<Entretien> entretienCollection;

    public Evenement() {
    }

    public Evenement(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeevt() {
        return typeevt;
    }

    public void setTypeevt(String typeevt) {
        this.typeevt = typeevt;
    }

    public Date getDateevt() {
        return dateevt;
    }

    public void setDateevt(Date dateevt) {
        this.dateevt = dateevt;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public Short getDureeEntretien() {
        return dureeEntretien;
    }

    public void setDureeEntretien(Short dureeEntretien) {
        this.dureeEntretien = dureeEntretien;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evenement)) {
            return false;
        }
        Evenement other = (Evenement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.polytech.ogas.Evenement[ id=" + id + " ]";
    }
    
}
