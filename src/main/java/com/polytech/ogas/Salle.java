/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.polytech.ogas;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author epulapp
 */
@Entity
@Table(name = "Salle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salle.findAll", query = "SELECT s FROM Salle s"),
    @NamedQuery(name = "Salle.findBySalleId", query = "SELECT s FROM Salle s WHERE s.salleId = :salleId"),
    @NamedQuery(name = "Salle.findBySalleLibelle", query = "SELECT s FROM Salle s WHERE s.salleLibelle = :salleLibelle"),
    @NamedQuery(name = "Salle.findBySalleLocalisation", query = "SELECT s FROM Salle s WHERE s.salleLocalisation = :salleLocalisation"),
    @NamedQuery(name = "Salle.findBySalleCapacite", query = "SELECT s FROM Salle s WHERE s.salleCapacite = :salleCapacite")})
public class Salle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "salle_id")
    private Short salleId;
    @Size(max = 2147483647)
    @Column(name = "salle_libelle")
    private String salleLibelle;
    @Size(max = 2147483647)
    @Column(name = "salle_localisation")
    private String salleLocalisation;
    @Column(name = "salle_capacite")
    private Short salleCapacite;
    @OneToMany(mappedBy = "etrsalleID")
    private Collection<Entretien> entretienCollection;

    public Salle() {
    }

    public Salle(Short salleId) {
        this.salleId = salleId;
    }

    public Short getSalleId() {
        return salleId;
    }

    public void setSalleId(Short salleId) {
        this.salleId = salleId;
    }

    public String getSalleLibelle() {
        return salleLibelle;
    }

    public void setSalleLibelle(String salleLibelle) {
        this.salleLibelle = salleLibelle;
    }

    public String getSalleLocalisation() {
        return salleLocalisation;
    }

    public void setSalleLocalisation(String salleLocalisation) {
        this.salleLocalisation = salleLocalisation;
    }

    public Short getSalleCapacite() {
        return salleCapacite;
    }

    public void setSalleCapacite(Short salleCapacite) {
        this.salleCapacite = salleCapacite;
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
        hash += (salleId != null ? salleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salle)) {
            return false;
        }
        Salle other = (Salle) object;
        if ((this.salleId == null && other.salleId != null) || (this.salleId != null && !this.salleId.equals(other.salleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.polytech.ogas.Salle[ salleId=" + salleId + " ]";
    }
    
}
