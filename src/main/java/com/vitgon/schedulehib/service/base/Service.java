package com.vitgon.schedulehib.service.base;

import java.util.List;

public interface Service<T, K> {
	K save(T obj);
	void update(T obj);
	T findById(K id);
	List<T> findAll();
}
