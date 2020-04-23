package com.qa.ims.persistence.domain;

import java.math.BigDecimal;

public class ProductProfile {

	private Long id;
	private String name;
	private String category;
	private BigDecimal price;
	private Long inventory;

	public ProductProfile(String name, String category, BigDecimal price, Long inventory) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.inventory = inventory;
	}

	public ProductProfile(Long id, String name, String category, BigDecimal price, Long inventory) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.inventory = inventory;
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

	public final void setInventory(Long inventory) {
		this.inventory = inventory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((price == null) ? 0 : category.hashCode());
		result = prime * result + ((inventory == null) ? 0 : category.hashCode());
		return result;
	}

	public String toString() {
		return "id: " + id + " | Name: " + name + " | Category: " + category + " | Price: £" + price + " | Inventory: "
				+ inventory + "\n ------------------------------------------------------";
	}

}
