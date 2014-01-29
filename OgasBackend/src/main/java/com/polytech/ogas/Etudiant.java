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
@Table(name = "etudiant", schema = "ogas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etudiant.findAll", query = "SELECT e FROM Etudiant e"),
    @NamedQuery(name = "Etudiant.findById", query = "SELECT e FROM Etudiant e WHERE e.id = :id"),
    @NamedQuery(name = "Etudiant.findByCandidid", query = "SELECT e FROM Etudiant e WHERE e.candidid = :candidid"),
    @NamedQuery(name = "Etudiant.findByCivilite", query = "SELECT e FROM Etudiant e WHERE e.civilite = :civilite"),
    @NamedQuery(name = "Etudiant.findByNom", query = "SELECT e FROM Etudiant e WHERE e.nom = :nom"),
    @NamedQuery(name = "Etudiant.findByPrenom", query = "SELECT e FROM Etudiant e WHERE e.prenom = :prenom"),
    @NamedQuery(name = "Etudiant.findByDatenaissance", query = "SELECT e FROM Etudiant e WHERE e.datenaissance = :datenaissance"),
    @NamedQuery(name = "Etudiant.findByAdresse", query = "SELECT e FROM Etudiant e WHERE e.adresse = :adresse"),
    @NamedQuery(name = "Etudiant.findByCp", query = "SELECT e FROM Etudiant e WHERE e.cp = :cp"),
    @NamedQuery(name = "Etudiant.findByVille", query = "SELECT e FROM Etudiant e WHERE e.ville = :ville"),
    @NamedQuery(name = "Etudiant.findByTelfixe", query = "SELECT e FROM Etudiant e WHERE e.telfixe = :telfixe"),
    @NamedQuery(name = "Etudiant.findByTelportable", query = "SELECT e FROM Etudiant e WHERE e.telportable = :telportable"),
    @NamedQuery(name = "Etudiant.findByEmail", query = "SELECT e FROM Etudiant e WHERE e.email = :email"),
    @NamedQuery(name = "Etudiant.findByBacannee", query = "SELECT e FROM Etudiant e WHERE e.bacannee = :bacannee"),
    @NamedQuery(name = "Etudiant.findByBacmention", query = "SELECT e FROM Etudiant e WHERE e.bacmention = :bacmention"),
    @NamedQuery(name = "Etudiant.findByBactype", query = "SELECT e FROM Etudiant e WHERE e.bactype = :bactype"),
    @NamedQuery(name = "Etudiant.findByDiplome", query = "SELECT e FROM Etudiant e WHERE e.diplome = :diplome"),
    @NamedQuery(name = "Etudiant.findByDiplomeannee", query = "SELECT e FROM Etudiant e WHERE e.diplomeannee = :diplomeannee"),
    @NamedQuery(name = "Etudiant.findByFormation", query = "SELECT e FROM Etudiant e WHERE e.formation = :formation"),
    @NamedQuery(name = "Etudiant.findByTypediplome", query = "SELECT e FROM Etudiant e WHERE e.typediplome = :typediplome"),
    @NamedQuery(name = "Etudiant.findByEtab", query = "SELECT e FROM Etudiant e WHERE e.etab = :etab"),
    @NamedQuery(name = "Etudiant.findByEtabcp", query = "SELECT e FROM Etudiant e WHERE e.etabcp = :etabcp"),
    @NamedQuery(name = "Etudiant.findByEtabville", query = "SELECT e FROM Etudiant e WHERE e.etabville = :etabville"),
    @NamedQuery(name = "Etudiant.findByNivanglais", query = "SELECT e FROM Etudiant e WHERE e.nivanglais = :nivanglais"),
    @NamedQuery(name = "Etudiant.findByClassement", query = "SELECT e FROM Etudiant e WHERE e.classement = :classement"),
    @NamedQuery(name = "Etudiant.findByCv", query = "SELECT e FROM Etudiant e WHERE e.cv = :cv"),
    @NamedQuery(name = "Etudiant.findByLettremotiv", query = "SELECT e FROM Etudiant e WHERE e.lettremotiv = :lettremotiv"),
    @NamedQuery(name = "Etudiant.findByAvispoursuite", query = "SELECT e FROM Etudiant e WHERE e.avispoursuite = :avispoursuite"),
    @NamedQuery(name = "Etudiant.findByAvisperso", query = "SELECT e FROM Etudiant e WHERE e.avisperso = :avisperso"),
    @NamedQuery(name = "Etudiant.findByRmq", query = "SELECT e FROM Etudiant e WHERE e.rmq = :rmq"),
    @NamedQuery(name = "Etudiant.findByCandidstatut", query = "SELECT e FROM Etudiant e WHERE e.candidstatut = :candidstatut")})
@XmlType(propOrder={"id","candidid","civilite","nom","prenom","datenaissance","adresse","cp","ville","telfixe","telportable","email","bacannee","bacmention","bactype","diplome","diplomeannee","formation","typediplome","etab","etabcp","etabville","nivanglais","classement","classement","cv","lettremotiv","avispoursuite","avisperso","rmq","candidstatut"})
public class Etudiant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "candidid")
    private Short candidid;
    @Size(max = 2147483647)
    @Column(name = "civilite")
    private String civilite;
    @Size(max = 2147483647)
    @Column(name = "nom")
    private String nom;
    @Size(max = 2147483647)
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "datenaissance")
    @Temporal(TemporalType.DATE)
    private Date datenaissance;
    @Size(max = 2147483647)
    @Column(name = "adresse")
    private String adresse;
    @Size(max = 2147483647)
    @Column(name = "cp")
    private String cp;
    @Size(max = 2147483647)
    @Column(name = "ville")
    private String ville;
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
    @Column(name = "bacannee")
    private Short bacannee;
    @Size(max = 2147483647)
    @Column(name = "bacmention")
    private String bacmention;
    @Size(max = 2147483647)
    @Column(name = "bactype")
    private String bactype;
    @Size(max = 2147483647)
    @Column(name = "diplome")
    private String diplome;
    @Column(name = "diplomeannee")
    private Short diplomeannee;
    @Size(max = 2147483647)
    @Column(name = "formation")
    private String formation;
    @Size(max = 2147483647)
    @Column(name = "typediplome")
    private String typediplome;
    @Size(max = 2147483647)
    @Column(name = "etab")
    private String etab;
    @Size(max = 2147483647)
    @Column(name = "etabcp")
    private String etabcp;
    @Size(max = 2147483647)
    @Column(name = "etabville")
    private String etabville;
    @Size(max = 2147483647)
    @Column(name = "nivanglais")
    private String nivanglais;
    @Size(max = 2147483647)
    @Column(name = "classement")
    private String classement;
    @Size(max = 2147483647)
    @Column(name = "cv")
    private String cv;
    @Size(max = 2147483647)
    @Column(name = "lettremotiv")
    private String lettremotiv;
    @Size(max = 2147483647)
    @Column(name = "avispoursuite")
    private String avispoursuite;
    @Size(max = 2147483647)
    @Column(name = "avisperso")
    private String avisperso;
    @Size(max = 2147483647)
    @Column(name = "rmq")
    private String rmq;
    @Size(max = 2147483647)
    @Column(name = "candidstatut")
    private String candidstatut;
    @OneToMany(mappedBy = "etuid")
    private Collection<Entretien> entretienCollection;

    public Etudiant() {
    }

    public Etudiant(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getCandidid() {
        return candidid;
    }

    public void setCandidid(Short candidid) {
        this.candidid = candidid;
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

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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

    public Short getBacannee() {
        return bacannee;
    }

    public void setBacannee(Short bacannee) {
        this.bacannee = bacannee;
    }

    public String getBacmention() {
        return bacmention;
    }

    public void setBacmention(String bacmention) {
        this.bacmention = bacmention;
    }

    public String getBactype() {
        return bactype;
    }

    public void setBactype(String bactype) {
        this.bactype = bactype;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public Short getDiplomeannee() {
        return diplomeannee;
    }

    public void setDiplomeannee(Short diplomeannee) {
        this.diplomeannee = diplomeannee;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public String getTypediplome() {
        return typediplome;
    }

    public void setTypediplome(String typediplome) {
        this.typediplome = typediplome;
    }

    public String getEtab() {
        return etab;
    }

    public void setEtab(String etab) {
        this.etab = etab;
    }

    public String getEtabcp() {
        return etabcp;
    }

    public void setEtabcp(String etabcp) {
        this.etabcp = etabcp;
    }

    public String getEtabville() {
        return etabville;
    }

    public void setEtabville(String etabville) {
        this.etabville = etabville;
    }

    public String getNivanglais() {
        return nivanglais;
    }

    public void setNivanglais(String nivanglais) {
        this.nivanglais = nivanglais;
    }

    public String getClassement() {
        return classement;
    }

    public void setClassement(String classement) {
        this.classement = classement;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getLettremotiv() {
        return lettremotiv;
    }

    public void setLettremotiv(String lettremotiv) {
        this.lettremotiv = lettremotiv;
    }

    public String getAvispoursuite() {
        return avispoursuite;
    }

    public void setAvispoursuite(String avispoursuite) {
        this.avispoursuite = avispoursuite;
    }

    public String getAvisperso() {
        return avisperso;
    }

    public void setAvisperso(String avisperso) {
        this.avisperso = avisperso;
    }

    public String getRmq() {
        return rmq;
    }

    public void setRmq(String rmq) {
        this.rmq = rmq;
    }

    public String getCandidstatut() {
        return candidstatut;
    }

    public void setCandidstatut(String candidstatut) {
        this.candidstatut = candidstatut;
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
        if (!(object instanceof Etudiant)) {
            return false;
        }
        Etudiant other = (Etudiant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.polytech.ogas.Etudiant[ id=" + id + " ]";
    }
    
}
