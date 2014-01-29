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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author epulapp
 */
@Entity
@Table(name = "personnecontact", schema = "ogas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personnecontact.findAll", query = "SELECT p FROM Personnecontact p"),
    @NamedQuery(name = "Personnecontact.findById", query = "SELECT p FROM Personnecontact p WHERE p.id = :id"),
    @NamedQuery(name = "Personnecontact.findByCivilite", query = "SELECT p FROM Personnecontact p WHERE p.civilite = :civilite"),
    @NamedQuery(name = "Personnecontact.findByNom", query = "SELECT p FROM Personnecontact p WHERE p.nom = :nom"),
    @NamedQuery(name = "Personnecontact.findByPrenom", query = "SELECT p FROM Personnecontact p WHERE p.prenom = :prenom"),
    @NamedQuery(name = "Personnecontact.findByRole", query = "SELECT p FROM Personnecontact p WHERE p.role = :role"),
    @NamedQuery(name = "Personnecontact.findByTelfixe", query = "SELECT p FROM Personnecontact p WHERE p.telfixe = :telfixe"),
    @NamedQuery(name = "Personnecontact.findByTelportable", query = "SELECT p FROM Personnecontact p WHERE p.telportable = :telportable"),
    @NamedQuery(name = "Personnecontact.findByEmail", query = "SELECT p FROM Personnecontact p WHERE p.email = :email")})
@XmlType(propOrder={"id","civilite","nom","prenom","role","telfixe","telportable","email","entid"})
public class Personnecontact implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "civilite")
    private String civilite;
    @Size(max = 2147483647)
    @Column(name = "nom")
    private String nom;
    @Size(max = 2147483647)
    @Column(name = "prenom")
    private String prenom;
    @Size(max = 2147483647)
    @Column(name = "role")
    private String role;
    @Size(max = 2147483647)
    @Column(name = "telfixe")
    private String telfixe;
    @Size(max = 2147483647)
    @Column(name = "telportable")
    private String telportable;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 2147483647)
    @Column(name = "email")
    private String email;
    @JoinColumn(name = "entid", referencedColumnName = "id")
    @ManyToOne
    private Entreprise entid;

    public Personnecontact() {
    }

    public Personnecontact(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTelfixe() {
        return telfixe;
    }

    public void setTelfixe(String telfixe) {
        this.telfixe = telfixe;
    }

    public String getTelportable() {
        return telportable;
    }

    public void setTelportable(String telportable) {
        this.telportable = telportable;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        if (!(object instanceof Personnecontact)) {
            return false;
        }
        Personnecontact other = (Personnecontact) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.polytech.ogas.Personnecontact[ id=" + id + " ]";
    }
    
}
