package com.prince.ecommerce.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product_category")
// @Data -- Known Bug ( when we use relationship like @OnetoMany , @ManyToOne  etc...., so will use @Getter and @Setter which work same as @Data)
@Getter
@Setter
public class ProductCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="category_name")
	private String categoryName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private Set<Product> product;
	
	

}
