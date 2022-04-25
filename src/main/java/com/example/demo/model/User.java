package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

   private long id;
   private String Name;
   private String email;
 /*   @OneToOne
   private Photo profilpic;*/
   
public long getId() {
	return id;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public void setId(long id) {
	this.id = id;
}
 
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
/*public Photo getProfilpic() {
	return profilpic;
}
public void setProfilpic(Photo profilpic) {
	this.profilpic = profilpic;
} */
public User(long id, String name, String email/*, Photo profilpic*/) {
	super();
	this.id = id;
	this.Name = name;
	this.email = email;
 	//this.profilpic = profilpic;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}

   }
