package tech.reaven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.reaven.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
}
