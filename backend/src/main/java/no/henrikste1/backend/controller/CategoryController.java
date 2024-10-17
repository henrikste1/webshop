package no.henrikste1.backend.controller;

import no.henrikste1.backend.model.Category;
import no.henrikste1.backend.model.Product;
import no.henrikste1.backend.model.User;
import no.henrikste1.backend.repository.CategoryRepository;
import no.henrikste1.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewCategory (
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam Long userId ) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Category c = new Category();
        c.setName(name);
        c.setDescription(description);
        c.setUser(user);
        categoryRepository.save(c);
        user.getCategories().add(c);
        return "Category saved with ID: " + c.getCategoryId();
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Optional<Category> getCategoryById(@PathVariable Long id) {
        return categoryRepository.findById(id);
    }

    @PutMapping(path = "/update/{id}")
    public @ResponseBody String updateCategory(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam String description) {

        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category c = optionalCategory.get();
            c.setName(name);
            c.setDescription(description);
            categoryRepository.save(c);
            return "Category updated with ID: " + id;
        } else {
            return "Category not found with ID: " + id;
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody String deleteCategory(@PathVariable Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return "Category deleted with ID: " + id;
        } else {
            return "Category not found with ID: " + id;
        }
    }
}
