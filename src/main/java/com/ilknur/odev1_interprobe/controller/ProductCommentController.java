package com.ilknur.odev1_interprobe.controller;

import com.ilknur.odev1_interprobe.model.ProductComment;
import com.ilknur.odev1_interprobe.repository.ProductCommentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author İlknur Kara
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/productComment")
public class ProductCommentController {

	private final ProductCommentRepo productCommentRepo;

	@PostMapping
	private ProductComment saveProductComment(@RequestBody ProductComment productComment) {

		return productCommentRepo.save(productComment);
	}

	@GetMapping("/by-product-id/{productId}")
	private ProductComment findProductCommentByProductProductId(@PathVariable Long productId) {

		return productCommentRepo.findProductCommentByProductProductId(productId);
	}

	@GetMapping("/by-productId-history/{productId}/{startDate}/{endDate}")
	private List<ProductComment> findProductCommentByProductProductId(@PathVariable Long productId,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {

		return productCommentRepo.findAllByCommentHistoryBetweenAndProductProductId(startDate, endDate, productId);
	}

	@GetMapping("/by-user-id/{userId}")
	private List<ProductComment> findProductCommentsByUserUserId(@PathVariable Long userId) {
		return productCommentRepo.findProductCommentsByUserUserId(userId);
	}

	@GetMapping("/by-userId-history/{startDate}/{endDate}/{userId}")
	private List<ProductComment> findProductCommentsByUserUserIdAndCommentHistoryBetween(@PathVariable Long userId,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {

		return productCommentRepo.findAllByCommentHistoryBetweenAndUserUserId(startDate, endDate, userId);
	}

}
