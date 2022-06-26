package com.ilknur.odev1_interprobe.repository;

import com.ilknur.odev1_interprobe.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author İlknur Kara
 */

@Repository
@Transactional
public interface ProductRepo extends JpaRepository<Product, Long> {

	List<Product> findAllByExpirationDateGreaterThan(Date date);

	List<Product> findAllByExpirationDateIsLessThanEqual(Date date);

	void deleteByProductId(Long productId);
}
