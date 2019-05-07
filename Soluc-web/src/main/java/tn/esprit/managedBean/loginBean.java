package tn.esprit.managedBean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.entities.User;
import tn.esprit.entities.UserRole;
import tn.esprit.service.UserFacade;


@ManagedBean(name="loginBean")
@SessionScoped
public class loginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	
	@EJB
	private UserFacade service;
	
	private User user;
	
	public loginBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String doLogin()
	{
		String navigateTo = "null";
		
		user = service.login(username, password);
		
		if(!user.getEmail().equals("empty"))
		{
			System.out.println("Connected");
			if(user.getRole() == UserRole.ADMIN)
			{
				System.out.println("Admin");
				return "/pages/admin2?faces-redirect=true";
			}
				
		}
		return navigateTo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserFacade getService() {
		return service;
	}

	public void setService(UserFacade service) {
		this.service = service;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	
}
