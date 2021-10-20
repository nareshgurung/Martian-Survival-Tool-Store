package net.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Data
@Table(name="categories")
public class Categories {
	
	@Id
	@Column(name="category_id")
	private int category_id;
	@Column(name="category_name")
	private String category_name;
	
	@Override
	public String toString() {
		return "Categories [category_id=" + category_id + ", category_name=" + category_name + "]";
	}
}
