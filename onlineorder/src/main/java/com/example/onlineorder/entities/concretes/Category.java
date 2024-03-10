package com.example.onlineorder.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getter setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="categories")
@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
//This class represents category information.
public class Category {
	@Id
	@Column(name="category_id")
	private int categoryId;
	
	@Column(name="category_name")
	private String categoryName;
	
	@JsonIgnore
	@OneToMany(mappedBy="category")
	private List<Product> products;
}
