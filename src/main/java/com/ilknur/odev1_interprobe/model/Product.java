package com.ilknur.odev1_interprobe.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author İlknur Kara
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT_TABLE")
public class Product {

	@Id
	@SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 1)
	@GeneratedValue(generator = "product_sequence", strategy = GenerationType.SEQUENCE)
	@Column(name = "PRODUCT_ID")
	private Long productId;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "PRICE", nullable = false)
	private double price;

	@Column(name = "EXPIRATION_DATE")
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(value = TemporalType.DATE)
	private Date expirationDate;

}
