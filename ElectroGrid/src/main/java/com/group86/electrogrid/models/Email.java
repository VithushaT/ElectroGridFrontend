package com.group86.electrogrid.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(	name = "Email")

public class Email {
	
	 @Id
	 @GeneratedValue(generator = "increment")
	 private Long id;

	 @Column(unique = true)
	 private String email;

	 @Column()
	 private String password;
	 
	 public Email() {
	    }
	 
	 public Email(Long id, String email, String password) {
	        this.id = id;
	        this.email = email;
	        this.password = password;
	        
	    }
	 
	 public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	   
}
