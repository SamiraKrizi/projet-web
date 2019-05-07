/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ksamih
 */
@Entity
public class ReponseReclamation implements Serializable {

    private static final long serialVersionUID = 27L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReponse;
    
    private String description;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReponse;
    
    @ManyToOne //Master
    @JoinColumn(name = "idReclamation")
    private Reclamation reclamation = new Reclamation();
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private User user;

    public ReponseReclamation() {

    }

    public int getIdReponse() {
        return this.idReponse;
    }

    public void setIdReponse(int idReponse) {
        this.idReponse = idReponse;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateReponse() {
        return this.dateReponse;
    }

    public void setDateReponse(Date dateReponse) {
        this.dateReponse = dateReponse;
    }

    public Reclamation getReclamation() {
        return reclamation;
    }

    public void setReclamation(Reclamation reclamation) {
        this.reclamation = reclamation;
    }

    @Override
    public String toString() {
        return "ReponseReclamation [idReponse=" + idReponse + ", description=" + description + ", dateReponse="
                + dateReponse + ", reclamation=" + reclamation + "]";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    

}
