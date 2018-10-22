package org.unndevs.spring5webapp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Author {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String surname;
  @ManyToMany(mappedBy = "authors")
  private Set<Book> books = new HashSet<>();

  public static Author of(final String name, final String surname){
    Author author = new Author();
    author.setName(name);
    author.setSurname(surname);
    return  author;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Author author = (Author) o;

    return id != null ? id.equals(author.id) : author.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}
