package tech.reaven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.reaven.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, String> {
    @Query(value =
            "USE rv_is;\n" +
            "SELECT *\n" +
            "FROM [rv_is].[dbo].[stock]\n" +
            "WHERE [isin_code] = :isin_code", nativeQuery = true)
    Stock findByISINCode(@Param("isin_code") String stock_isin);
}
