package react.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import react.product.model.Product;
import react.product.services.ProductServices;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductServices productServices;

    @GetMapping
    public List<Product> findAll(){
        return productServices.GetAllProduct();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productServices.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        return productServices.updateById(id,product);
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Long id){
        return productServices.findById(id);
    }
    @GetMapping("/search/{name}")
    public Product findProductByName(@PathVariable String name){
        return productServices.findByName(name);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productServices.deleteById(id);
    }
}
