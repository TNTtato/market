package com.gustavo.market.web.controller;

import com.gustavo.market.domain.ProductDomain;
import com.gustavo.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<ProductDomain> getAll() {
        return productService.getAll();
    }

    @GetMapping("{id}")
    public Optional<ProductDomain> getProduct(@PathVariable("id") long productId) {
        return productService.getProduct(productId);
    }

    @GetMapping("category/{id}")
    public  List<ProductDomain> getByCategoryId(@PathVariable("id") long categoryId) {
        return productService.getByCategoryId(categoryId);
    }

    @GetMapping("scarce/{quantity}")
    public  Optional<List<ProductDomain>> getScarce(@PathVariable int quantity) {
        return productService.getScarce(quantity);
    }

    @PostMapping
    public ProductDomain save(@RequestBody ProductDomain productDomain) {
        return productService.save(productDomain);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable("id") long productId) {
        return productService.delete(productId);
    }
}
