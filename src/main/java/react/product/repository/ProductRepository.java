package react.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import react.product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Product findByTitle(String name);
}
