package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Shop
 *
 */
@Entity

public class Shop implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "ShopName")
    private String shopName;

    @Column(name = "Location")
    private String location;

    @Column(name = "Service")
    private String service;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OpeningTime")
    private Date openingTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ClosingTime")
    private Date closingTime;
    
    
    private String gcoding;
    
    private String image;

    public Shop() {
        super();
    }

    public Shop(String shopName, String location, String service, Date openingTime, Date closingTime, String image) {
		super();
		this.shopName = shopName;
		this.location = location;
		this.service = service;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
		this.image = image;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Date getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(Date openingTime) {
        this.openingTime = openingTime;
    }

    public Date getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(Date closingTime) {
        this.closingTime = closingTime;
    }

    

	@Override
	public String toString() {
		return "Shop [id=" + id + ", shopName=" + shopName + ", location=" + location + ", service=" + service
				+ ", openingTime=" + openingTime + ", closingTime=" + closingTime + ", image=" + image + "]";
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGcoding() {
		return gcoding;
	}

	public void setGcoding(String gcoding) {
		this.gcoding = gcoding;
	}

}
