package tech.reaven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.reaven.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, String> {
    @Query(value = "SELECT * FROM stocks WHERE isincode LIKE BINARY CONCAT('%',:isincode,'%')", nativeQuery = true)
    Stock findByISINCode(@Param("isincode") String stock_isin);
}
