package com.pfs.pfstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pfs.pfstore.models.Product;
import com.pfs.pfstore.models.Response;
import com.pfs.pfstore.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private Response response;

    public Iterable<Product> list() {

        return repository.findAll();
    }

    public ResponseEntity<?> registerOrUpdate(Product product, String action) {
        if (product.getName().equals("")) {
            response.setMessage("Impossível cadastrar com descrição vazia!");
            return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
        } else if (product.getBrand().equals("")) {
            response.setMessage("Impossível cadastrar com marca vazia!");
            return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
        } else if (product.getSection().equals("")) {
            response.setMessage("Impossível cadastrar com Seção vazia!");
            return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
        } else if (product.getCost() == null) {
            response.setMessage("Impossível cadastrar com custo vazio!");
            return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
        } else {
            if (action.equals("register")) {
                return new ResponseEntity<Product>(repository.save(product), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<Product>(repository.save(product), HttpStatus.OK);
            }
        }
    }
}
