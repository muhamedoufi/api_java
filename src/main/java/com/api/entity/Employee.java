

package com.api.entity;
import jakarta.persistence.*;
//import jakarta.xml.bind.annotation.XmlAttribute;
import java.util.Date;

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
