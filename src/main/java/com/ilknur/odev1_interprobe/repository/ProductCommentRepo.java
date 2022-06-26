package com.ilknur.odev1_interprobe.repository;

import com.ilknur.odev1_interprobe.model.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author İlknur Kara
 */

@Repository
public interface ProductCommentRepo extends JpaRepository<ProductComment, Long> {

	ProductComment findProductCommentByProductProductId(Long id);

	List<ProductComment> findAllByCommentHistoryBetweenAndProductProductId(Date startDate, Date endDate, Long userId);

	List<ProductComment> findProductCommentsByUserUserId(Long userId);

	List<ProductComment> findAllByCommentHistoryBetweenAndUserUserId(Date startDate, Date endDate, Long userId);

}
