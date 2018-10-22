package org.unndevs.spring5webapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.unndevs.spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {}
