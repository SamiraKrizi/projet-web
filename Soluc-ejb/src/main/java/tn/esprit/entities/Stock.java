package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Stock
 *
 */
@Entity

public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "ProductRef")
    private String productRef;

    @Column(name = "ProductName")
    private String productName;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "PriceUnit")
    private float price;

    @Enumerated(EnumType.STRING)
    @Column(name = "Availability")
    private Availability availability;

    private enum Availability {
        AVAILABLE, UNAVAILABLE
    }

    @OneToMany(mappedBy = "stock")
    private List<Bill> bills;

    public Stock() {
        super();
    }

    @Override
    public String toString() {
        return "Stock{" + "id=" + id + ", productRef=" + productRef + ", productName=" + productName + ", quantity=" + quantity + ", price=" + price + ", availability=" + availability + ", bills=" + bills + '}';
    }

}
