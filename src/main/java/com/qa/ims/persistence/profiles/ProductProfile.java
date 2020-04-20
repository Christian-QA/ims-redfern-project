package com.qa.ims.persistence.profiles;

import java.math.BigDecimal;

public class ProductProfile {

	private Long id;
	private String name;
	private String category;
	private BigDecimal price;
	private Long inventory;

	public ProductProfile(String name, String category, String price, String inventory) {
		this.name = name;
	}

	public ProductProfile(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getCategory() {
		return category;
	}

	public final void setCategory(String category) {
		this.category = category;
	}

	public final BigDecimal getPrice() {
		return price;
	}

	public final void setPrice(BigDecimal price) {
		this.price = price;
	}

	public final long getInventory() {
		return inventory;
	}

	public final void setInventory(long inventory) {
		this.inventory = inventory;
	}

	public String toString() {
		return "id: " + id + " | name: " + name + " | category: " + category + " | price: " + price + " | inventory"
				+ inventory + "\n ------------------------------------------------------";
	}

}
