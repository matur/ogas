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
@Table(name = "Entreprise")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entreprise.findAll", query = "SELECT e FROM Entreprise e"),
    @NamedQuery(name = "Entreprise.findByEntId", query = "SELECT e FROM Entreprise e WHERE e.entId = :entId"),
    @NamedQuery(name = "Entreprise.findByEntRaison", query = "SELECT e FROM Entreprise e WHERE e.entRaison = :entRaison"),
    @NamedQuery(name = "Entreprise.findByEntNaf", query = "SELECT e FROM Entreprise e WHERE e.entNaf = :entNaf"),
    @NamedQuery(name = "Entreprise.findByEntSiret", query = "SELECT e FROM Entreprise e WHERE e.entSiret = :entSiret"),
    @NamedQuery(name = "Entreprise.findByEntEffectif", query = "SELECT e FROM Entreprise e WHERE e.entEffectif = :entEffectif"),
    @NamedQuery(name = "Entreprise.findByEntOrganisme", query = "SELECT e FROM Entreprise e WHERE e.entOrganisme = :entOrganisme"),
    @NamedQuery(name = "Entreprise.findByEntAdresse", query = "SELECT e FROM Entreprise e WHERE e.entAdresse = :entAdresse"),
    @NamedQuery(name = "Entreprise.findByEntAdresse2", query = "SELECT e FROM Entreprise e WHERE e.entAdresse2 = :entAdresse2"),
    @NamedQuery(name = "Entreprise.findByEntCp", query = "SELECT e FROM Entreprise e WHERE e.entCp = :entCp"),
    @NamedQuery(name = "Entreprise.findByEntVille", query = "SELECT e FROM Entreprise e WHERE e.entVille = :entVille"),
    @NamedQuery(name = "Entreprise.findByEntTel", query = "SELECT e FROM Entreprise e WHERE e.entTel = :entTel"),
    @NamedQuery(name = "Entreprise.findByEntAnneparticipforum", query = "SELECT e FROM Entreprise e WHERE e.entAnneparticipforum = :entAnneparticipforum"),
    @NamedQuery(name = "Entreprise.findByEntNbrapprenti", query = "SELECT e FROM Entreprise e WHERE e.entNbrapprenti = :entNbrapprenti")})
public class Entreprise implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ent_id")
    private Short entId;
    @Size(max = 2147483647)
    @Column(name = "ent_raison")
    private String entRaison;
    @Size(max = 2147483647)
    @Column(name = "ent_naf")
    private String entNaf;
    @Size(max = 2147483647)
    @Column(name = "ent_siret")
    private String entSiret;
    @Column(name = "ent_effectif")
    private Short entEffectif;
    @Size(max = 2147483647)
    @Column(name = "ent_organisme")
    private String entOrganisme;
    @Size(max = 2147483647)
    @Column(name = "ent_adresse")
    private String entAdresse;
    @Size(max = 2147483647)
    @Column(name = "ent_adresse2")
    private String entAdresse2;
    @Size(max = 2147483647)
    @Column(name = "ent_cp")
    private String entCp;
    @Size(max = 2147483647)
    @Column(name = "ent_ville")
    private String entVille;
    @Size(max = 2147483647)
    @Column(name = "ent_tel")
    private String entTel;
    @Size(max = 2147483647)
    @Column(name = "ent_anneparticipforum")
    private String entAnneparticipforum;
    @Column(name = "ent_nbrapprenti")
    private Short entNbrapprenti;
    @OneToMany(mappedBy = "persentID")
    private Collection<PersonneContact> personneContactCollection;
    @OneToMany(mappedBy = "etrentID")
    private Collection<Entretien> entretienCollection;

    public Entreprise() {
    }

    public Entreprise(Short entId) {
        this.entId = entId;
    }

    public Short getEntId() {
        return entId;
    }

    public void setEntId(Short entId) {
        this.entId = entId;
    }

    public String getEntRaison() {
        return entRaison;
    }

    public void setEntRaison(String entRaison) {
        this.entRaison = entRaison;
    }

    public String getEntNaf() {
        return entNaf;
    }

    public void setEntNaf(String entNaf) {
        this.entNaf = entNaf;
    }

    public String getEntSiret() {
        return entSiret;
    }

    public void setEntSiret(String entSiret) {
        this.entSiret = entSiret;
    }

    public Short getEntEffectif() {
        return entEffectif;
    }

    public void setEntEffectif(Short entEffectif) {
        this.entEffectif = entEffectif;
    }

    public String getEntOrganisme() {
        return entOrganisme;
    }

    public void setEntOrganisme(String entOrganisme) {
        this.entOrganisme = entOrganisme;
    }

    public String getEntAdresse() {
        return entAdresse;
    }

    public void setEntAdresse(String entAdresse) {
        this.entAdresse = entAdresse;
    }

    public String getEntAdresse2() {
        return entAdresse2;
    }

    public void setEntAdresse2(String entAdresse2) {
        this.entAdresse2 = entAdresse2;
    }

    public String getEntCp() {
        return entCp;
    }

    public void setEntCp(String entCp) {
        this.entCp = entCp;
    }

    public String getEntVille() {
        return entVille;
    }

    public void setEntVille(String entVille) {
        this.entVille = entVille;
    }

    public String getEntTel() {
        return entTel;
    }

    public void setEntTel(String entTel) {
        this.entTel = entTel;
    }

    public String getEntAnneparticipforum() {
        return entAnneparticipforum;
    }

    public void setEntAnneparticipforum(String entAnneparticipforum) {
        this.entAnneparticipforum = entAnneparticipforum;
    }

    public Short getEntNbrapprenti() {
        return entNbrapprenti;
    }

    public void setEntNbrapprenti(Short entNbrapprenti) {
        this.entNbrapprenti = entNbrapprenti;
    }

    @XmlTransient
    public Collection<PersonneContact> getPersonneContactCollection() {
        return personneContactCollection;
    }

    public void setPersonneContactCollection(Collection<PersonneContact> personneContactCollection) {
        this.personneContactCollection = personneContactCollection;
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
        hash += (entId != null ? entId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entreprise)) {
            return false;
        }
        Entreprise other = (Entreprise) object;
        if ((this.entId == null && other.entId != null) || (this.entId != null && !this.entId.equals(other.entId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.polytech.ogas.Entreprise[ entId=" + entId + " ]";
    }
    
}
