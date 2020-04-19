package com.qa.ims.persistence.dataaccessobjects;

import java.util.List;

public interface DataAccessObject<T> {

	List<T> readAll();

	T create(T t);

	T update(T t);

	void delete(long id);
}
