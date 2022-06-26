package com.ilknur.odev1_interprobe.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * @author İlknur Kara
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT_COMMENT_TABLE")
public class ProductComment {

	@Id
	@SequenceGenerator(name = "product_comment_sequence", sequenceName = "product_comment_sequence", allocationSize = 1)
	@GeneratedValue(generator = "product_comment_sequence", strategy = GenerationType.SEQUENCE)
	@Column(name = "PRODUCT_COMMENT_ID")
	private Long productCommentId;

	@Column(name = "COMMENT", length = 500, nullable = false)
	private String comment;

	@Column(name = "COMMENT_HISTORY", nullable = false)
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(value = TemporalType.DATE)
	private Date commentHistory;

	@JsonManagedReference
	@OneToOne(
			cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE},
			fetch = FetchType.LAZY,
			orphanRemoval = true
	)
	@JoinColumn(
			name = "PRODUCT_ID",
			referencedColumnName = "PRODUCT_ID",
			foreignKey = @ForeignKey(name = "FK_PRODUCT_ID")
	)
	private Product product;

	@JsonManagedReference
	@ManyToOne(
			cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE},
			fetch = FetchType.LAZY
	)
	@JoinColumn(
			name = "USER_ID",
			referencedColumnName = "USER_ID",
			foreignKey = @ForeignKey(name = "FK_USER_ID")
	)
	private User user;
}
