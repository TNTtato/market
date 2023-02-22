package com.gustavo.market.web.controller;

import com.gustavo.market.domain.ProductDomain;
import com.gustavo.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDomain>> getAll() {

        List<ProductDomain> products = productService.getAll();
        return products.isEmpty() ? ResponseEntity.noContent().build() : new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<ProductDomain>> getProduct(@PathVariable("id") long productId) {
        Optional<ProductDomain> product = productService.getProduct(productId);
        return !product.isPresent() ? ResponseEntity.notFound().build() : new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("category/{id}")
    public ResponseEntity<List<ProductDomain>> getByCategoryId(@PathVariable("id") long categoryId) {
        List<ProductDomain> products = productService.getByCategoryId(categoryId);
        return products.isEmpty() ? ResponseEntity.noContent().build() : new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("scarce/{quantity}")
    public ResponseEntity<Optional<List<ProductDomain>>> getScarce(@PathVariable int quantity) {
        Optional<List<ProductDomain>> products = productService.getScarce(quantity);
        return products.get().isEmpty() ? ResponseEntity.noContent().build() : new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDomain> save(@RequestBody ProductDomain productDomain) {
        if (productDomain == null) return ResponseEntity.badRequest().build();
        ProductDomain product = productService.save(productDomain);
        return product == null ? ResponseEntity.badRequest().build() : new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") long productId) {

        return productService.delete(productId) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
