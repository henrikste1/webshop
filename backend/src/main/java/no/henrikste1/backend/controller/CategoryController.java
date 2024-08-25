package no.henrikste1.backend.controller;


import no.henrikste1.backend.model.Category;
import no.henrikste1.backend.model.Product;
import no.henrikste1.backend.model.User;
import no.henrikste1.backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewCategory (
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam Product product,
            @RequestParam User user ) {

        Category c = new Category();
        c.setName(name);
        c.setDescription(description);
        c.setProduct(product);
        c.setUser(user);
        categoryRepository.save(c);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }


}
