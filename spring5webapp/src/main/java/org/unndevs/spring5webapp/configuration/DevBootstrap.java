package org.unndevs.spring5webapp.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.unndevs.spring5webapp.model.Author;
import org.unndevs.spring5webapp.model.Book;
import org.unndevs.spring5webapp.repository.AuthorRepository;
import org.unndevs.spring5webapp.repository.BookRepository;

@RequiredArgsConstructor
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
  private final BookRepository bookRepository;
  private final AuthorRepository authorRepository;

  @Override
  public void onApplicationEvent(final ContextRefreshedEvent contextRefreshedEvent) {
    initData();
  }

  private void initData() {
    Author eric = Author.of("Eric","Evans");
    Book ddd = Book.of("1234","Domain Driven Design","Harper Collins");
    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);

    authorRepository.save(eric);
    bookRepository.save(ddd);

    Author rod = Author.of("Rod","Johnson");
    Book jee = Book.of("1234","JEE Development without EJB","Worx");
    rod.getBooks().add(jee);
    jee.getAuthors().add(rod);

    authorRepository.save(rod);
    bookRepository.save(jee);
  }
}
