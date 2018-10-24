package org.unndevs.spring5webapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String isbn;
  private String title;
  @OneToOne
  private Publisher publisher;
  @ManyToMany
  @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
  inverseJoinColumns = @JoinColumn(name = "author_id"))
  private Set<Author> authors = new HashSet<>();

  public static Book of(final String isbn, final String title, final Publisher publisher){
    Book book = new Book();
    book.setIsbn(isbn);
    book.setTitle(title);
    book.setPublisher(publisher);
    return book;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Book book = (Book) o;

    return id != null ? id.equals(book.id) : book.id == null;
  }
  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}
