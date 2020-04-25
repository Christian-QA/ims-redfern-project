package com.qa.ims.persistence.dataaccessobjects;

import java.util.List;

public interface DataAccessObjectOrderlineSpecific<T> {

	List<T> readAll(long id);

	T create(T t);

	T update(T t);

	void delete(long pid, long oid);

}
