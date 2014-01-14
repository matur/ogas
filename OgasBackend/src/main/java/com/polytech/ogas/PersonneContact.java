/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.polytech.ogas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author epulapp
 */
@Entity
@Table(name = "PersonneContact")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonneContact.findAll", query = "SELECT p FROM PersonneContact p"),
    @NamedQuery(name = "PersonneContact.findByPersId", query = "SELECT p FROM PersonneContact p WHERE p.persId = :persId"),
    @NamedQuery(name = "PersonneContact.findByPersCivilite", query = "SELECT p FROM PersonneContact p WHERE p.persCivilite = :persCivilite"),
    @NamedQuery(name = "PersonneContact.findByPersNom", query = "SELECT p FROM PersonneContact p WHERE p.persNom = :persNom"),
    @NamedQuery(name = "PersonneContact.findByPersPrenom", query = "SELECT p FROM PersonneContact p WHERE p.persPrenom = :persPrenom"),
    @NamedQuery(name = "PersonneContact.findByPersRole", query = "SELECT p FROM PersonneContact p WHERE p.persRole = :persRole"),
    @NamedQuery(name = "PersonneContact.findByPersTelfixe", query = "SELECT p FROM PersonneContact p WHERE p.persTelfixe = :persTelfixe"),
    @NamedQuery(name = "PersonneContact.findByPersTelportable", query = "SELECT p FROM PersonneContact p WHERE p.persTelportable = :persTelportable"),
    @NamedQuery(name = "PersonneContact.findByPersEmail", query = "SELECT p FROM PersonneContact p WHERE p.persEmail = :persEmail")})
public class PersonneContact implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pers_id")
    private Short persId;
    @Size(max = 2147483647)
    @Column(name = "pers_civilite")
    private String persCivilite;
    @Size(max = 2147483647)
    @Column(name = "pers_nom")
    private String persNom;
    @Size(max = 2147483647)
    @Column(name = "pers_prenom")
    private String persPrenom;
    @Size(max = 2147483647)
    @Column(name = "pers_role")
    private String persRole;
    @Size(max = 2147483647)
    @Column(name = "pers_telfixe")
    private String persTelfixe;
    @Size(max = 2147483647)
    @Column(name = "pers_telportable")
    private String persTelportable;
    @Size(max = 2147483647)
    @Column(name = "pers_email")
    private String persEmail;
    @JoinColumn(name = "pers_entID", referencedColumnName = "ent_id")
    @ManyToOne
    private Entreprise persentID;

    public PersonneContact() {
    }

    public PersonneContact(Short persId) {
        this.persId = persId;
    }

    public Short getPersId() {
        return persId;
    }

    public void setPersId(Short persId) {
        this.persId = persId;
    }

    public String getPersCivilite() {
        return persCivilite;
    }

    public void setPersCivilite(String persCivilite) {
        this.persCivilite = persCivilite;
    }

    public String getPersNom() {
        return persNom;
    }

    public void setPersNom(String persNom) {
        this.persNom = persNom;
    }

    public String getPersPrenom() {
        return persPrenom;
    }

    public void setPersPrenom(String persPrenom) {
        this.persPrenom = persPrenom;
    }

    public String getPersRole() {
        return persRole;
    }

    public void setPersRole(String persRole) {
        this.persRole = persRole;
    }

    public String getPersTelfixe() {
        return persTelfixe;
    }

    public void setPersTelfixe(String persTelfixe) {
        this.persTelfixe = persTelfixe;
    }

    public String getPersTelportable() {
        return persTelportable;
    }

    public void setPersTelportable(String persTelportable) {
        this.persTelportable = persTelportable;
    }

    public String getPersEmail() {
        return persEmail;
    }

    public void setPersEmail(String persEmail) {
        this.persEmail = persEmail;
    }

    public Entreprise getPersentID() {
        return persentID;
    }

    public void setPersentID(Entreprise persentID) {
        this.persentID = persentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (persId != null ? persId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonneContact)) {
            return false;
        }
        PersonneContact other = (PersonneContact) object;
        if ((this.persId == null && other.persId != null) || (this.persId != null && !this.persId.equals(other.persId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.polytech.ogas.PersonneContact[ persId=" + persId + " ]";
    }
    
}
