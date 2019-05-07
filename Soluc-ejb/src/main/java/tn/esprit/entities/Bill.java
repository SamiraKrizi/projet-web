package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Bill
 *
 */
@Entity

public class Bill implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="FK_Stock_Price")
	private Stock stock;
	
	@Column(name="TotalPrice")
	private float totalPrice;
	
	@Column(name="Note")
	private String note;
	
	public Bill() {
		super();
	}
	
	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public Stock getStock() {
		return stock;
	}




	public void setStock(Stock stock) {
		this.stock = stock;
	}




	public float getTotalPrice() {
		return totalPrice;
	}




	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}




	public String getNote() {
		return note;
	}




	public void setNote(String note) {
		this.note = note;
	}

	
	

   
}
