package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Offre
 *
 */
@Entity

public class Offre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OffreId")
    private int id;

    @Column(name = "OffreName")
    private String offreName;

    @Column(name = "Description")
    private String Description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOffreName() {
        return offreName;
    }

    public void setOffreName(String offreName) {
        this.offreName = offreName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Offre() {
        super();
    }

    @Override
    public String toString() {
        return "Offre{" + "id=" + id + ", offreName=" + offreName + ", Description=" + Description + '}';
    }
    
    

}
