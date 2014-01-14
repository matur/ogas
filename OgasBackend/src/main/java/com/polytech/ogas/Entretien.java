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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author epulapp
 */
@Entity
@Table(name = "Entretien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entretien.findAll", query = "SELECT e FROM Entretien e"),
    @NamedQuery(name = "Entretien.findByEtrId", query = "SELECT e FROM Entretien e WHERE e.etrId = :etrId"),
    @NamedQuery(name = "Entretien.findByEtrPriorite", query = "SELECT e FROM Entretien e WHERE e.etrPriorite = :etrPriorite"),
    @NamedQuery(name = "Entretien.findByEtrHoraire", query = "SELECT e FROM Entretien e WHERE e.etrHoraire = :etrHoraire")})
public class Entretien implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "etr_id")
    private Short etrId;
    @Column(name = "etr_priorite")
    private Short etrPriorite;
    @Column(name = "etr_horaire")
    @Temporal(TemporalType.TIME)
    private Date etrHoraire;
    @JoinColumn(name = "etr_salleID", referencedColumnName = "salle_id")
    @ManyToOne
    private Salle etrsalleID;
    @JoinColumn(name = "etr_evtID", referencedColumnName = "evt_id")
    @ManyToOne
    private Evenement etrevtID;
    @JoinColumn(name = "etr_etuID", referencedColumnName = "etu_id")
    @ManyToOne
    private Etudiant etretuID;
    @JoinColumn(name = "etr_entID", referencedColumnName = "ent_id")
    @ManyToOne
    private Entreprise etrentID;

    public Entretien() {
    }

    public Entretien(Short etrId) {
        this.etrId = etrId;
    }

    public Short getEtrId() {
        return etrId;
    }

    public void setEtrId(Short etrId) {
        this.etrId = etrId;
    }

    public Short getEtrPriorite() {
        return etrPriorite;
    }

    public void setEtrPriorite(Short etrPriorite) {
        this.etrPriorite = etrPriorite;
    }

    public Date getEtrHoraire() {
        return etrHoraire;
    }

    public void setEtrHoraire(Date etrHoraire) {
        this.etrHoraire = etrHoraire;
    }

    public Salle getEtrsalleID() {
        return etrsalleID;
    }

    public void setEtrsalleID(Salle etrsalleID) {
        this.etrsalleID = etrsalleID;
    }

    public Evenement getEtrevtID() {
        return etrevtID;
    }

    public void setEtrevtID(Evenement etrevtID) {
        this.etrevtID = etrevtID;
    }

    public Etudiant getEtretuID() {
        return etretuID;
    }

    public void setEtretuID(Etudiant etretuID) {
        this.etretuID = etretuID;
    }

    public Entreprise getEtrentID() {
        return etrentID;
    }

    public void setEtrentID(Entreprise etrentID) {
        this.etrentID = etrentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (etrId != null ? etrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entretien)) {
            return false;
        }
        Entretien other = (Entretien) object;
        if ((this.etrId == null && other.etrId != null) || (this.etrId != null && !this.etrId.equals(other.etrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.polytech.ogas.Entretien[ etrId=" + etrId + " ]";
    }
    
}
