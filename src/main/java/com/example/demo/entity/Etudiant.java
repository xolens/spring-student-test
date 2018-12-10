package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Etudiant {
	
	@Id
    private String matricule;
    private String nom;
    private String sexe;
    private String anneeNaissance;
    private String niveauAcademique;
    
    protected Etudiant() {}

	public Etudiant(String matricule, String nom, String sexe, String anneeNaissance, String niveauAcademique) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.sexe = sexe;
		this.anneeNaissance = anneeNaissance;
		this.niveauAcademique = niveauAcademique;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAnneeNaissance() {
		return anneeNaissance;
	}

	public void setAnneeNaissance(String anneeNaissance) {
		this.anneeNaissance = anneeNaissance;
	}

	public String getNiveauAcademique() {
		return niveauAcademique;
	}

	public void setNiveauAcademique(String niveauAcademique) {
		this.niveauAcademique = niveauAcademique;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	@Override
	public String toString() {
		return "Etudiant [matricule=" + matricule + ", nom=" + nom + ", sexe=" + sexe + ", anneeNaissance="
				+ anneeNaissance + ", niveauAcademique=" + niveauAcademique + "]";
	}   
    
}
