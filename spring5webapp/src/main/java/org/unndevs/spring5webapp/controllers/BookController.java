package org.unndevs.spring5webapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.unndevs.spring5webapp.repository.BookRepository;

@Controller
@RequiredArgsConstructor
public class BookController {
  private final BookRepository bookRepository;

  @RequestMapping("/books")
  public String getAllBooks(Model model) {
    model.addAttribute("books", bookRepository.findAll());
    return "books";
  }
}
