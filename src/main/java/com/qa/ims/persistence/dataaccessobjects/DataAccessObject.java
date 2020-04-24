package com.qa.ims.persistence.dataaccessobjects;

import java.util.List;

import com.qa.ims.persistence.domain.OrderlineProfile;

public interface DataAccessObject<T> {

	List<T> readAll();

	T create(T t);

	T update(T t);

	void delete(long id);

	/**
	 * Reads all of a specific orderline from the database
	 * 
	 * @return A list of products within an orderline
	 */
	List<OrderlineProfile> readAll(OrderlineProfile id);
}
