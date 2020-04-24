package com.qa.ims.controllers;

public interface CrudOrderlineController<T> {

	T readSpecific();

	T create();

	T update();

	void delete();

}