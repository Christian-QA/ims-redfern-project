package com.qa.ims.services;

import java.util.List;

public interface CrudServicesOrderlineSpecific<T> {

	public List<T> readAll(Long oid);

	T create(T t);

	T update(T t);

	void delete(Long id);

}