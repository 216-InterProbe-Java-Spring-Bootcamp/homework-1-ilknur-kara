package com.ilknur.odev1_interprobe.controller;

import com.ilknur.odev1_interprobe.model.Product;
import com.ilknur.odev1_interprobe.repository.ProductRepo;
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
@RequestMapping("/product")
public class ProductController {

	private final ProductRepo productRepo;

	@PostMapping
	public Product saveProduct(@RequestBody Product product) {
		return productRepo.save(product);
	}

	@GetMapping("/greater-than/{date}")
	@ResponseBody
	public List<Product> findAllByExpirationDateGreaterThan(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		return productRepo.findAllByExpirationDateGreaterThan(date);
	}

	@GetMapping("/less-than/{date}")
	@ResponseBody
	public List<Product> findAllByExpirationDateIsLessThanEqual(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		return productRepo.findAllByExpirationDateIsLessThanEqual(date);
	}

	@DeleteMapping("/{productId}")
	public void deleteByProductId(@PathVariable Long productId) {
		productRepo.deleteByProductId(productId);
	}

}
