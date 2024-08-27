package no.henrikste1.backend.controller;

import no.henrikste1.backend.model.Category;
import no.henrikste1.backend.model.Product;
import no.henrikste1.backend.model.User;
import no.henrikste1.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewProduct (
            @RequestParam String name,
            @RequestParam String price,
            @RequestParam String picture,
            @RequestParam String description,
            @RequestParam Category category,
            @RequestParam User user ) {

        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        p.setPicture(picture);
        p.setDescription(description);
        p.setCategory(category);
        p.setUser(user);
        productRepository.save(p);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
