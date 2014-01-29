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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author epulapp
 */
@Entity
@Table(name = "entreprise", schema = "ogas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entreprise.findAll", query = "SELECT e FROM Entreprise e"),
    @NamedQuery(name = "Entreprise.findById", query = "SELECT e FROM Entreprise e WHERE e.id = :id"),
    @NamedQuery(name = "Entreprise.findByRaison", query = "SELECT e FROM Entreprise e WHERE e.raison = :raison"),
    @NamedQuery(name = "Entreprise.findByNaf", query = "SELECT e FROM Entreprise e WHERE e.naf = :naf"),
    @NamedQuery(name = "Entreprise.findBySiret", query = "SELECT e FROM Entreprise e WHERE e.siret = :siret"),
    @NamedQuery(name = "Entreprise.findByEffectif", query = "SELECT e FROM Entreprise e WHERE e.effectif = :effectif"),
    @NamedQuery(name = "Entreprise.findByOrganisme", query = "SELECT e FROM Entreprise e WHERE e.organisme = :organisme"),
    @NamedQuery(name = "Entreprise.findByAdresse", query = "SELECT e FROM Entreprise e WHERE e.adresse = :adresse"),
    @NamedQuery(name = "Entreprise.findByAdresse2", query = "SELECT e FROM Entreprise e WHERE e.adresse2 = :adresse2"),
    @NamedQuery(name = "Entreprise.findByCp", query = "SELECT e FROM Entreprise e WHERE e.cp = :cp"),
    @NamedQuery(name = "Entreprise.findByVille", query = "SELECT e FROM Entreprise e WHERE e.ville = :ville"),
    @NamedQuery(name = "Entreprise.findByTel", query = "SELECT e FROM Entreprise e WHERE e.tel = :tel"),
    @NamedQuery(name = "Entreprise.findByAnneparticipforum", query = "SELECT e FROM Entreprise e WHERE e.anneparticipforum = :anneparticipforum"),
    @NamedQuery(name = "Entreprise.findByNbrapprenti", query = "SELECT e FROM Entreprise e WHERE e.nbrapprenti = :nbrapprenti")})
@XmlType(propOrder={"id","raison","naf","siret","effectif","organisme","adresse","adresse2","cp","ville","tel","anneparticipationforum","nbapprenti"})
public class Entreprise implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "raison")
    private String raison;
    @Size(max = 2147483647)
    @Column(name = "naf")
    private String naf;
    @Size(max = 2147483647)
    @Column(name = "siret")
    private String siret;
    @Column(name = "effectif")
    private Short effectif;
    @Size(max = 2147483647)
    @Column(name = "organisme")
    private String organisme;
    @Size(max = 2147483647)
    @Column(name = "adresse")
    private String adresse;
    @Size(max = 2147483647)
    @Column(name = "adresse2")
    private String adresse2;
    @Size(max = 2147483647)
    @Column(name = "cp")
    private String cp;
    @Size(max = 2147483647)
    @Column(name = "ville")
    private String ville;
    @Size(max = 2147483647)
    @Column(name = "tel")
    private String tel;
    @Size(max = 2147483647)
    @Column(name = "anneparticipforum")
    private String anneparticipforum;
    @Column(name = "nbrapprenti")
    private Short nbrapprenti;
    @OneToMany(mappedBy = "entid")
    private Collection<Entretien> entretienCollection;
    @OneToMany(mappedBy = "entid")
    private Collection<Personnecontact> personnecontactCollection;

    public Entreprise() {
    }

    public Entreprise(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    public String getNaf() {
        return naf;
    }

    public void setNaf(String naf) {
        this.naf = naf;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public Short getEffectif() {
        return effectif;
    }

    public void setEffectif(Short effectif) {
        this.effectif = effectif;
    }

    public String getOrganisme() {
        return organisme;
    }

    public void setOrganisme(String organisme) {
        this.organisme = organisme;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAdresse2() {
        return adresse2;
    }

    public void setAdresse2(String adresse2) {
        this.adresse2 = adresse2;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAnneparticipforum() {
        return anneparticipforum;
    }

    public void setAnneparticipforum(String anneparticipforum) {
        this.anneparticipforum = anneparticipforum;
    }

    public Short getNbrapprenti() {
        return nbrapprenti;
    }

    public void setNbrapprenti(Short nbrapprenti) {
        this.nbrapprenti = nbrapprenti;
    }

    @XmlTransient
    public Collection<Entretien> getEntretienCollection() {
        return entretienCollection;
    }

    public void setEntretienCollection(Collection<Entretien> entretienCollection) {
        this.entretienCollection = entretienCollection;
    }

    @XmlTransient
    public Collection<Personnecontact> getPersonnecontactCollection() {
        return personnecontactCollection;
    }

    public void setPersonnecontactCollection(Collection<Personnecontact> personnecontactCollection) {
        this.personnecontactCollection = personnecontactCollection;
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
        if (!(object instanceof Entreprise)) {
            return false;
        }
        Entreprise other = (Entreprise) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.polytech.ogas.Entreprise[ id=" + id + " ]";
    }
    
}
