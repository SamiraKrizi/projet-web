package tn.esprit.managedBean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import tn.esprit.entities.Shop;
import tn.esprit.service.ShopFacade;


@ManagedBean(name="ShopBean")
@SessionScoped
public class ShopBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String shopName;
	private Date openingTime;
	private Date closingTime;
	private String location;
	private String service;
	private String image;
	
	private List<Shop> shops;
	
	private Shop selectedShop;
	
	private Part file;
	
	@EJB
	private ShopFacade shopService;
	
	
	@PostConstruct
	public void init(){
		shops = new ArrayList<>();
		shops = shopService.findAll();
	}
	
	
	public String readMore(Shop shop)
	{
		return "/pages/show?faces-redirect=true";
	}
	
	public String edit(Shop shop)
	{
		return "/pages/edit?faces-redirect=true";
	}
	
	public String addShop() throws IOException
	{
		try{
			file.write("C:\\Projet PDEV\\Soluc\\Soluc-web\\src\\main\\webapp\\pages\\"+getFileName(file));
			image = getFileName(file);
		}catch(NullPointerException ex){}
		Shop newS = new Shop(shopName,location,service,openingTime,closingTime, image);
		shopService.create(newS);
		shops = shopService.findAll();
		return "/pages/shops?faces-redirect=true";
	}
	
	public String update() throws IOException
	{
		file.write("C:\\Projet PDEV\\Soluc\\Soluc-web\\src\\main\\webapp\\pages\\"+getFileName(file));
		newImage = getFileName(file);
		selectionAdmin.setImage(newImage);
		shopService.edit(selectionAdmin);
		shops = shopService.findAll();
		return "/pages/shops?faces-redirect=true";
	}
	
	public String delete()
	{
		shopService.remove(selectionAdmin);
		System.out.println("attemping to delete " + selectionAdmin.getId());
		shops = shopService.findAll();
		return "/pages/shops?faces-redirect=true"; 
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	private Shop selectionAdmin;
	
	
	private String newTitle;
	private Date newOpeningTime;
	private Date newClosingTime;
	private String newLocation;
	private String newService;
	private String newImage;
	
	

	public Shop getSelectionAdmin() {
		return selectionAdmin;
	}


	public void setSelectionAdmin(Shop selectionAdmin) {
		this.selectionAdmin = selectionAdmin;
	}


	public String getNewTitle() {
		return newTitle;
	}


	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}


	public Date getNewOpeningTime() {
		return newOpeningTime;
	}


	public void setNewOpeningTime(Date newOpeningTime) {
		this.newOpeningTime = newOpeningTime;
	}


	public Date getNewClosingTime() {
		return newClosingTime;
	}


	public void setNewClosingTime(Date newClosingTime) {
		this.newClosingTime = newClosingTime;
	}


	public String getNewLocation() {
		return newLocation;
	}


	public void setNewLocation(String newLocation) {
		this.newLocation = newLocation;
	}


	public String getNewService() {
		return newService;
	}


	public void setNewService(String newService) {
		this.newService = newService;
	}


	public String getNewImage() {
		return newImage;
	}


	public void setNewImage(String newImage) {
		this.newImage = newImage;
	}
	
	


	///////////////////////////////////////////////////////////////////////////////////////////////////////

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public ShopFacade getShopService() {
		return shopService;
	}

	public void setShopService(ShopFacade shopService) {
		this.shopService = shopService;
	}	
	
	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	private static String getFileName(Part file)
	{
		for(String cd : file.getHeader("content-disposition").split(";")){
			if(cd.trim().startsWith("filename")){
				String fileName= cd.substring(cd.indexOf('=')+1).trim().replace("\"", "");
				return fileName.substring(fileName.lastIndexOf('/')+1).substring(fileName.lastIndexOf('\\')+1);
			}
		}
		return null;
	}

	public List<Shop> getShops() {
		return shops;
	}


	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}


	public Shop getSelectedShop() {
		return selectedShop;
	}


	public void setSelectedShop(Shop selectedShop) {
		this.selectedShop = selectedShop;
	}
	
}
