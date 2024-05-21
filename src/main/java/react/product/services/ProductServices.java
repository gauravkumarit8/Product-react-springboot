package react.product.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import react.product.model.Product;
import react.product.repository.ProductRepository;

import java.util.List;

@Service
public class ProductServices {
    @Autowired
    private ProductRepository productRepository;

    //create and save new product
    public Product save(Product product){
        return productRepository.save(product);
    }

    //update product by id
    public Product updateById(Long id, Product product){
        Product product1=productRepository.findById(id).orElse(null);
        product1.setTitle(product.getTitle());
        product1.setPrice(product.getPrice());
        product1.setQuantity(product.getQuantity());
        return productRepository.save(product1);
    }

    //Get all products
    public List<Product> GetAllProduct(){
        return productRepository.findAll();
    }

    //Find product by id
    public Product findById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public Product findByName(String name){
        return productRepository.findByTitle(name);
    }

    //delete product using id
    public void deleteById(Long id){
        productRepository.deleteById(id);
    }
}
