package modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.time.LocalDateTime;

public class Employees {
    private Long id;
    private String nom;
    private String prenom;
    private Double salaire;
    private Integer annee_experience;
    private LocalDateTime date_dembauche;
    private Double salaire_final;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    public Integer getAnnee_experience() {
        return annee_experience;
    }

    public void setAnnee_experience(Integer annee_experience) {
        this.annee_experience = annee_experience;
    }

    public LocalDateTime getDate_dembauche() {
        return date_dembauche;
    }

    public void setDate_dembauche(LocalDateTime date_dembauche) {
        this.date_dembauche = date_dembauche;
    }

    public Double getSalaire_final() {
        return salaire_final;
    }

    public void setSalaire_final(Double salaire_final) {
        this.salaire_final = salaire_final;
    }

    public Employees(Long id, String nom, String prenom, Double salaire, Integer annee_experience, LocalDateTime date_dembauche, Double salaire_final) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.salaire = salaire;
        this.annee_experience = annee_experience;
        this.date_dembauche = date_dembauche;
        this.salaire_final = salaire_final;
    }

    @Override
    public String toString() {
        var salairee = "============================================================ \n";
        salairee +="=> Employee n° "+getId()+"                                     \n";
        salairee +="=> Nom du Employee de credit : "+getNom()+" "+getPrenom()+"       \n";
        salairee +="-------------------------------------------------------------\n";
        salairee +="=> Salaire        : "+getSalaire()+" DH\n";
        salairee +="=> Annee d'experience            : "+getAnnee_experience()+" Annee    \n";
        salairee +="=> Date d'embauche           : "+getDate_dembauche()+"     \n";
        salairee +="-------------------------------------------------------------\n";
        salairee +="=> Salaire final       : "
                +(getSalaire_final() == 0.0 ? "NON-CALCULER" : getSalaire_final()+"DH/mois")+"\n";
        salairee += "============================================================ \n";
        return salairee;
    }
}
