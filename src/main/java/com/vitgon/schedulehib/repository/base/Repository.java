package com.vitgon.schedulehib.repository.base;

import java.util.List;

public interface Repository<T, K> {
	K save(T obj);
	void update(T obj);
	T findById(K id);
	List<T> findAll();
}
