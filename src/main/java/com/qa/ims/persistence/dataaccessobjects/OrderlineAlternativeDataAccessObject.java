package com.qa.ims.persistence.dataaccessobjects;

public interface OrderlineAlternativeDataAccessObject<T> {

	T readSpecific();

	T create(T t);

	T update(T t);

	void delete(long id);

}
