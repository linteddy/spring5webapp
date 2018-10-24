package org.unndevs.spring5webapp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Publisher {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String address;
  public static Publisher of(final String name, final String address){
    Publisher publisher = new Publisher();
    publisher.name = name;
    publisher.address = address;
    return publisher;
  }
}
