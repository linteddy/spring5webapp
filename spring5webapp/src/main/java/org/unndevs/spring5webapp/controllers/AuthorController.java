package org.unndevs.spring5webapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.unndevs.spring5webapp.repository.AuthorRepository;
import org.unndevs.spring5webapp.repository.BookRepository;

@Controller
@RequiredArgsConstructor
public class AuthorController {
  private final AuthorRepository authorRepository;

  @RequestMapping("/authors")
  public String getAllBooks(Model model) {
    model.addAttribute("authors", authorRepository.findAll());
    return "authors";
  }
}
