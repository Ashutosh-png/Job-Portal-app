package com.workshop.Entity;

import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;



@javax.persistence.Entity
@javax.persistence.Table(name = "role")
public class Role implements GrantedAuthority {
	
    @Id
	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	
	public Role(String string) {
		// TODO Auto-generated constructor stub
	}
	
	public Role() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return name;
	}
	
	

}
