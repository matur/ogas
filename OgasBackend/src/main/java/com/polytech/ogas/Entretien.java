/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.polytech.ogas;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author epulapp
 */
@Entity
@Table(name = "entretien", schema = "ogas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entretien.findAll", query = "SELECT e FROM Entretien e"),
    @NamedQuery(name = "Entretien.findById", query = "SELECT e FROM Entretien e WHERE e.id = :id"),
    @NamedQuery(name = "Entretien.findByPriorite", query = "SELECT e FROM Entretien e WHERE e.priorite = :priorite"),
    @NamedQuery(name = "Entretien.findByHoraire", query = "SELECT e FROM Entretien e WHERE e.horaire = :horaire")})
@XmlType(propOrder={"id","etuid","priorite","horaire","salleid","evtid","etuid","entid"})
public class Entretien implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "priorite")
    private Short priorite;
    @Column(name = "horaire")
    @Temporal(TemporalType.TIME)
    private Date horaire;
    @JoinColumn(name = "salleid", referencedColumnName = "id")
    @ManyToOne
    private Salle salleid;
    @JoinColumn(name = "evtid", referencedColumnName = "id")
    @ManyToOne
    private Evenement evtid;
    @JoinColumn(name = "etuid", referencedColumnName = "id")
    @ManyToOne
    private Etudiant etuid;
    @JoinColumn(name = "entid", referencedColumnName = "id")
    @ManyToOne
    private Entreprise entid;

    public Entretien() {
    }

    public Entretien(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getPriorite() {
        return priorite;
    }

    public void setPriorite(Short priorite) {
        this.priorite = priorite;
    }

    public Date getHoraire() {
        return horaire;
    }

    public void setHoraire(Date horaire) {
        this.horaire = horaire;
    }

    public Salle getSalleid() {
        return salleid;
    }

    public void setSalleid(Salle salleid) {
        this.salleid = salleid;
    }

    public Evenement getEvtid() {
        return evtid;
    }

    public void setEvtid(Evenement evtid) {
        this.evtid = evtid;
    }

    public Etudiant getEtuid() {
        return etuid;
    }

    public void setEtuid(Etudiant etuid) {
        this.etuid = etuid;
    }

    public Entreprise getEntid() {
        return entid;
    }

    public void setEntid(Entreprise entid) {
        this.entid = entid;
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
        if (!(object instanceof Entretien)) {
            return false;
        }
        Entretien other = (Entretien) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.polytech.ogas.Entretien[ id=" + id + " ]";
    }
    
}
