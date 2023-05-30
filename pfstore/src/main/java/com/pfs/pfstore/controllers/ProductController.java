package com.pfs.pfstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pfs.pfstore.models.Product;
import com.pfs.pfstore.services.ProductService;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService ps;

    @PostMapping("/register")
    private ResponseEntity<?> register(@RequestBody Product product) {
        return ps.registerOrUpdate(product, "register");

    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Product product) {
        return ps.registerOrUpdate(product, "update");
    }

    @GetMapping("/list")
    public Iterable<Product> list() {

        return ps.list();

    }
}
