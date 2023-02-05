

package com.api.entity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
//import jakarta.xml.bind.annotation.XmlAttribute;
import java.util.Date;

import org.hibernate.annotations.ColumnDefault;

/**
 * ProductCategory
 */

@Entity
@Table(name = "Employee")
public class Employee {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  @Column
  private String name;
  @Column
  private int age;
  
  @Column(unique=true)
  
  private String email;
  
  
  public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

@Column(unique=true,length = 8,nullable=false,columnDefinition = "int default 100")
  private int phone;


public int getPhone() {
	return phone;
}
public void setPhone(int phone) {
	this.phone = phone;
}
@PrePersist
public void prePersistEmail() {
    if(email == null) { //We set default value in case if the value is not set yet.
        email = "";}
    
}


  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  
}
