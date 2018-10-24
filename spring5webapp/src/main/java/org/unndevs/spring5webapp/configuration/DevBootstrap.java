package org.unndevs.spring5webapp.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.unndevs.spring5webapp.model.Author;
import org.unndevs.spring5webapp.model.Book;
import org.unndevs.spring5webapp.model.Publisher;
import org.unndevs.spring5webapp.repository.AuthorRepository;
import org.unndevs.spring5webapp.repository.BookRepository;
import org.unndevs.spring5webapp.repository.PublisherRepository;

@RequiredArgsConstructor
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
  private final BookRepository bookRepository;
  private final AuthorRepository authorRepository;
  private  final PublisherRepository publisherRepository;

  @Override
  public void onApplicationEvent(final ContextRefreshedEvent contextRefreshedEvent) {
    initData();
  }

  private void initData() {
    Author eric = Author.of("Dale","Carnegie");
    final Publisher publisher = Publisher.of("Simon & Schuster","New York City, New York, United States" );
    Book ddd = Book.of("1234","How to win friends and influence people", publisher);
    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);

    publisherRepository.save(publisher);
    authorRepository.save(eric);
    bookRepository.save(ddd);

    Author rod = Author.of("Rod","Johnson");
    final Publisher publisher2 =  Publisher.of("Worx","Birmingham, England");
    Book jee = Book.of("1234","JEE Development without EJB",publisher2);
    rod.getBooks().add(jee);
    jee.getAuthors().add(rod);

    publisherRepository.save(publisher2);
    authorRepository.save(rod);
    bookRepository.save(jee);
  }
}
