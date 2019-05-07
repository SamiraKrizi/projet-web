package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Promotion
 *
 */
@Entity

public class Promotion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "StartDate")
    private int startDate;

    @Column(name = "EndDate")
    private int endDate;

    @Column(name = "PackName")
    private int packName;

    @Column(name = "PackPrice")
    private float packPrice;

    @Column(name = "Description")
    private int description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    public int getPackName() {
        return packName;
    }

    public void setPackName(int packName) {
        this.packName = packName;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public Promotion() {
        super();
    }

    @Override
    public String toString() {
        return "Promotion{" + "id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", packName=" + packName + ", packPrice=" + packPrice + ", description=" + description + '}';
    }

}
