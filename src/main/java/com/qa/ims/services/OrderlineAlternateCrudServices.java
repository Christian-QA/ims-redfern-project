package com.qa.ims.services;

public interface OrderlineAlternateCrudServices<T> {

	T readSpecific(Long oid);

	T create(T t);

	T update(T t);

	void delete(Long id);

}