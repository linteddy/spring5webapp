package org.unndevs.spring5webapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.unndevs.spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {}
