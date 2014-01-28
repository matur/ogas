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
@Table(name = "utilisateur", schema = "ogas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u"),
    @NamedQuery(name = "Utilisateur.findById", query = "SELECT u FROM Utilisateur u WHERE u.id = :id"),
    @NamedQuery(name = "Utilisateur.findByLogin", query = "SELECT u FROM Utilisateur u WHERE u.login = :login"),
    @NamedQuery(name = "Utilisateur.findByMdp", query = "SELECT u FROM Utilisateur u WHERE u.mdp = :mdp"),
    @NamedQuery(name = "Utilisateur.findByAdmin", query = "SELECT u FROM Utilisateur u WHERE u.admin = :admin"),
    @NamedQuery(name = "Utilisateur.findByLecture", query = "SELECT u FROM Utilisateur u WHERE u.lecture = :lecture"),
    @NamedQuery(name = "Utilisateur.findByEcriture", query = "SELECT u FROM Utilisateur u WHERE u.ecriture = :ecriture")})
public class Utilisateur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Short id;
    @Size(max = 2147483647)
    @Column(name = "login")
    private String login;
    @Size(max = 2147483647)
    @Column(name = "mdp")
    private String mdp;
    @Column(name = "admin")
    private Boolean admin;
    @Column(name = "lecture")
    private Boolean lecture;
    @Column(name = "ecriture")
    private Boolean ecriture;

    public Utilisateur() {
    }

    public Utilisateur(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Boolean getLecture() {
        return lecture;
    }

    public void setLecture(Boolean lecture) {
        this.lecture = lecture;
    }

    public Boolean getEcriture() {
        return ecriture;
    }

    public void setEcriture(Boolean ecriture) {
        this.ecriture = ecriture;
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
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.polytech.ogas.Utilisateur[ id=" + id + " ]";
    }
    
}
