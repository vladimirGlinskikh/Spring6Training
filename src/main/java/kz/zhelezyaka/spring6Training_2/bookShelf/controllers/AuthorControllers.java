package kz.zhelezyaka.spring6Training_2.bookShelf.controllers;

import kz.zhelezyaka.spring6Training_2.bookShelf.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorControllers {
    private final AuthorService authorService;

    public AuthorControllers(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping("/authors")
    public String getAuthor(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "authors";
    }
}
