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
@Table(name = "Etudiant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etudiant.findAll", query = "SELECT e FROM Etudiant e"),
    @NamedQuery(name = "Etudiant.findByEtuId", query = "SELECT e FROM Etudiant e WHERE e.etuId = :etuId"),
    @NamedQuery(name = "Etudiant.findByEtuCandidid", query = "SELECT e FROM Etudiant e WHERE e.etuCandidid = :etuCandidid"),
    @NamedQuery(name = "Etudiant.findByEtuCivilite", query = "SELECT e FROM Etudiant e WHERE e.etuCivilite = :etuCivilite"),
    @NamedQuery(name = "Etudiant.findByEtuNom", query = "SELECT e FROM Etudiant e WHERE e.etuNom = :etuNom"),
    @NamedQuery(name = "Etudiant.findByEtuPrenom", query = "SELECT e FROM Etudiant e WHERE e.etuPrenom = :etuPrenom"),
    @NamedQuery(name = "Etudiant.findByEtuDatenaissance", query = "SELECT e FROM Etudiant e WHERE e.etuDatenaissance = :etuDatenaissance"),
    @NamedQuery(name = "Etudiant.findByEtuAdresse", query = "SELECT e FROM Etudiant e WHERE e.etuAdresse = :etuAdresse"),
    @NamedQuery(name = "Etudiant.findByEtuCp", query = "SELECT e FROM Etudiant e WHERE e.etuCp = :etuCp"),
    @NamedQuery(name = "Etudiant.findByEtuVille", query = "SELECT e FROM Etudiant e WHERE e.etuVille = :etuVille"),
    @NamedQuery(name = "Etudiant.findByEtuTelfixe", query = "SELECT e FROM Etudiant e WHERE e.etuTelfixe = :etuTelfixe"),
    @NamedQuery(name = "Etudiant.findByEtuTelportable", query = "SELECT e FROM Etudiant e WHERE e.etuTelportable = :etuTelportable"),
    @NamedQuery(name = "Etudiant.findByEtuEmail", query = "SELECT e FROM Etudiant e WHERE e.etuEmail = :etuEmail"),
    @NamedQuery(name = "Etudiant.findByEtuBacannee", query = "SELECT e FROM Etudiant e WHERE e.etuBacannee = :etuBacannee"),
    @NamedQuery(name = "Etudiant.findByEtuBacmention", query = "SELECT e FROM Etudiant e WHERE e.etuBacmention = :etuBacmention"),
    @NamedQuery(name = "Etudiant.findByEtuBactype", query = "SELECT e FROM Etudiant e WHERE e.etuBactype = :etuBactype"),
    @NamedQuery(name = "Etudiant.findByEtuDiplome", query = "SELECT e FROM Etudiant e WHERE e.etuDiplome = :etuDiplome"),
    @NamedQuery(name = "Etudiant.findByEtuDiplomeannee", query = "SELECT e FROM Etudiant e WHERE e.etuDiplomeannee = :etuDiplomeannee"),
    @NamedQuery(name = "Etudiant.findByEtuFormation", query = "SELECT e FROM Etudiant e WHERE e.etuFormation = :etuFormation"),
    @NamedQuery(name = "Etudiant.findByEtuTypediplome", query = "SELECT e FROM Etudiant e WHERE e.etuTypediplome = :etuTypediplome"),
    @NamedQuery(name = "Etudiant.findByEtuEtab", query = "SELECT e FROM Etudiant e WHERE e.etuEtab = :etuEtab"),
    @NamedQuery(name = "Etudiant.findByEtuEtabcp", query = "SELECT e FROM Etudiant e WHERE e.etuEtabcp = :etuEtabcp"),
    @NamedQuery(name = "Etudiant.findByEtuEtabville", query = "SELECT e FROM Etudiant e WHERE e.etuEtabville = :etuEtabville"),
    @NamedQuery(name = "Etudiant.findByEtuNivanglais", query = "SELECT e FROM Etudiant e WHERE e.etuNivanglais = :etuNivanglais"),
    @NamedQuery(name = "Etudiant.findByEtuClassement", query = "SELECT e FROM Etudiant e WHERE e.etuClassement = :etuClassement"),
    @NamedQuery(name = "Etudiant.findByEtuCv", query = "SELECT e FROM Etudiant e WHERE e.etuCv = :etuCv"),
    @NamedQuery(name = "Etudiant.findByEtuLettremotiv", query = "SELECT e FROM Etudiant e WHERE e.etuLettremotiv = :etuLettremotiv"),
    @NamedQuery(name = "Etudiant.findByEtuAvispoursuite", query = "SELECT e FROM Etudiant e WHERE e.etuAvispoursuite = :etuAvispoursuite"),
    @NamedQuery(name = "Etudiant.findByEtuAvisperso", query = "SELECT e FROM Etudiant e WHERE e.etuAvisperso = :etuAvisperso"),
    @NamedQuery(name = "Etudiant.findByEtuRmq", query = "SELECT e FROM Etudiant e WHERE e.etuRmq = :etuRmq"),
    @NamedQuery(name = "Etudiant.findByEtuCandidstatut", query = "SELECT e FROM Etudiant e WHERE e.etuCandidstatut = :etuCandidstatut")})
public class Etudiant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "etu_id")
    private Short etuId;
    @Column(name = "etu_candidid")
    private Short etuCandidid;
    @Size(max = 2147483647)
    @Column(name = "etu_civilite")
    private String etuCivilite;
    @Size(max = 2147483647)
    @Column(name = "etu_nom")
    private String etuNom;
    @Size(max = 2147483647)
    @Column(name = "etu_prenom")
    private String etuPrenom;
    @Column(name = "etu_datenaissance")
    @Temporal(TemporalType.DATE)
    private Date etuDatenaissance;
    @Size(max = 2147483647)
    @Column(name = "etu_adresse")
    private String etuAdresse;
    @Size(max = 2147483647)
    @Column(name = "etu_cp")
    private String etuCp;
    @Size(max = 2147483647)
    @Column(name = "etu_ville")
    private String etuVille;
    @Size(max = 2147483647)
    @Column(name = "etu_telfixe")
    private String etuTelfixe;
    @Size(max = 2147483647)
    @Column(name = "etu_telportable")
    private String etuTelportable;
    @Size(max = 2147483647)
    @Column(name = "etu_email")
    private String etuEmail;
    @Column(name = "etu_bacannee")
    private Short etuBacannee;
    @Size(max = 2147483647)
    @Column(name = "etu_bacmention")
    private String etuBacmention;
    @Size(max = 2147483647)
    @Column(name = "etu_bactype")
    private String etuBactype;
    @Size(max = 2147483647)
    @Column(name = "etu_diplome")
    private String etuDiplome;
    @Column(name = "etu_diplomeannee")
    private Short etuDiplomeannee;
    @Size(max = 2147483647)
    @Column(name = "etu_formation")
    private String etuFormation;
    @Size(max = 2147483647)
    @Column(name = "etu_typediplome")
    private String etuTypediplome;
    @Size(max = 2147483647)
    @Column(name = "etu_etab")
    private String etuEtab;
    @Size(max = 2147483647)
    @Column(name = "etu_etabcp")
    private String etuEtabcp;
    @Size(max = 2147483647)
    @Column(name = "etu_etabville")
    private String etuEtabville;
    @Size(max = 2147483647)
    @Column(name = "etu_nivanglais")
    private String etuNivanglais;
    @Size(max = 2147483647)
    @Column(name = "etu_classement")
    private String etuClassement;
    @Size(max = 2147483647)
    @Column(name = "etu_cv")
    private String etuCv;
    @Size(max = 2147483647)
    @Column(name = "etu_lettremotiv")
    private String etuLettremotiv;
    @Size(max = 2147483647)
    @Column(name = "etu_avispoursuite")
    private String etuAvispoursuite;
    @Size(max = 2147483647)
    @Column(name = "etu_avisperso")
    private String etuAvisperso;
    @Size(max = 2147483647)
    @Column(name = "etu_rmq")
    private String etuRmq;
    @Size(max = 2147483647)
    @Column(name = "etu_candidstatut")
    private String etuCandidstatut;
    @OneToMany(mappedBy = "etretuID")
    private Collection<Entretien> entretienCollection;

    public Etudiant() {
    }

    public Etudiant(Short etuId) {
        this.etuId = etuId;
    }

    public Short getEtuId() {
        return etuId;
    }

    public void setEtuId(Short etuId) {
        this.etuId = etuId;
    }

    public Short getEtuCandidid() {
        return etuCandidid;
    }

    public void setEtuCandidid(Short etuCandidid) {
        this.etuCandidid = etuCandidid;
    }

    public String getEtuCivilite() {
        return etuCivilite;
    }

    public void setEtuCivilite(String etuCivilite) {
        this.etuCivilite = etuCivilite;
    }

    public String getEtuNom() {
        return etuNom;
    }

    public void setEtuNom(String etuNom) {
        this.etuNom = etuNom;
    }

    public String getEtuPrenom() {
        return etuPrenom;
    }

    public void setEtuPrenom(String etuPrenom) {
        this.etuPrenom = etuPrenom;
    }

    public Date getEtuDatenaissance() {
        return etuDatenaissance;
    }

    public void setEtuDatenaissance(Date etuDatenaissance) {
        this.etuDatenaissance = etuDatenaissance;
    }

    public String getEtuAdresse() {
        return etuAdresse;
    }

    public void setEtuAdresse(String etuAdresse) {
        this.etuAdresse = etuAdresse;
    }

    public String getEtuCp() {
        return etuCp;
    }

    public void setEtuCp(String etuCp) {
        this.etuCp = etuCp;
    }

    public String getEtuVille() {
        return etuVille;
    }

    public void setEtuVille(String etuVille) {
        this.etuVille = etuVille;
    }

    public String getEtuTelfixe() {
        return etuTelfixe;
    }

    public void setEtuTelfixe(String etuTelfixe) {
        this.etuTelfixe = etuTelfixe;
    }

    public String getEtuTelportable() {
        return etuTelportable;
    }

    public void setEtuTelportable(String etuTelportable) {
        this.etuTelportable = etuTelportable;
    }

    public String getEtuEmail() {
        return etuEmail;
    }

    public void setEtuEmail(String etuEmail) {
        this.etuEmail = etuEmail;
    }

    public Short getEtuBacannee() {
        return etuBacannee;
    }

    public void setEtuBacannee(Short etuBacannee) {
        this.etuBacannee = etuBacannee;
    }

    public String getEtuBacmention() {
        return etuBacmention;
    }

    public void setEtuBacmention(String etuBacmention) {
        this.etuBacmention = etuBacmention;
    }

    public String getEtuBactype() {
        return etuBactype;
    }

    public void setEtuBactype(String etuBactype) {
        this.etuBactype = etuBactype;
    }

    public String getEtuDiplome() {
        return etuDiplome;
    }

    public void setEtuDiplome(String etuDiplome) {
        this.etuDiplome = etuDiplome;
    }

    public Short getEtuDiplomeannee() {
        return etuDiplomeannee;
    }

    public void setEtuDiplomeannee(Short etuDiplomeannee) {
        this.etuDiplomeannee = etuDiplomeannee;
    }

    public String getEtuFormation() {
        return etuFormation;
    }

    public void setEtuFormation(String etuFormation) {
        this.etuFormation = etuFormation;
    }

    public String getEtuTypediplome() {
        return etuTypediplome;
    }

    public void setEtuTypediplome(String etuTypediplome) {
        this.etuTypediplome = etuTypediplome;
    }

    public String getEtuEtab() {
        return etuEtab;
    }

    public void setEtuEtab(String etuEtab) {
        this.etuEtab = etuEtab;
    }

    public String getEtuEtabcp() {
        return etuEtabcp;
    }

    public void setEtuEtabcp(String etuEtabcp) {
        this.etuEtabcp = etuEtabcp;
    }

    public String getEtuEtabville() {
        return etuEtabville;
    }

    public void setEtuEtabville(String etuEtabville) {
        this.etuEtabville = etuEtabville;
    }

    public String getEtuNivanglais() {
        return etuNivanglais;
    }

    public void setEtuNivanglais(String etuNivanglais) {
        this.etuNivanglais = etuNivanglais;
    }

    public String getEtuClassement() {
        return etuClassement;
    }

    public void setEtuClassement(String etuClassement) {
        this.etuClassement = etuClassement;
    }

    public String getEtuCv() {
        return etuCv;
    }

    public void setEtuCv(String etuCv) {
        this.etuCv = etuCv;
    }

    public String getEtuLettremotiv() {
        return etuLettremotiv;
    }

    public void setEtuLettremotiv(String etuLettremotiv) {
        this.etuLettremotiv = etuLettremotiv;
    }

    public String getEtuAvispoursuite() {
        return etuAvispoursuite;
    }

    public void setEtuAvispoursuite(String etuAvispoursuite) {
        this.etuAvispoursuite = etuAvispoursuite;
    }

    public String getEtuAvisperso() {
        return etuAvisperso;
    }

    public void setEtuAvisperso(String etuAvisperso) {
        this.etuAvisperso = etuAvisperso;
    }

    public String getEtuRmq() {
        return etuRmq;
    }

    public void setEtuRmq(String etuRmq) {
        this.etuRmq = etuRmq;
    }

    public String getEtuCandidstatut() {
        return etuCandidstatut;
    }

    public void setEtuCandidstatut(String etuCandidstatut) {
        this.etuCandidstatut = etuCandidstatut;
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
        hash += (etuId != null ? etuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etudiant)) {
            return false;
        }
        Etudiant other = (Etudiant) object;
        if ((this.etuId == null && other.etuId != null) || (this.etuId != null && !this.etuId.equals(other.etuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.polytech.ogas.Etudiant[ etuId=" + etuId + " ]";
    }
    
}
