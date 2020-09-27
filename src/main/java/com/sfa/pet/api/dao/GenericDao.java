package com.sfa.pet.api.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.sfa.pet.api.entity.util.AbstractEntity;

/**
 * This is the article 10 years ago, we should follow this
 * 
 * @see https://www.ibm.com/developerworks/jp/java/library/j-genericdao/
 */
public interface GenericDao<T extends AbstractEntity, PK extends Serializable> {

	/** Persist the newInstance object into database */
	void createOrUpdate(T newInstance);

	/**
	 * Retrieve an object that was previously persisted to the database using the
	 * indicated id as primary key
	 */
	T read(PK id);

	List<T> read(PageRequest pageRequest);

	/** Remove an object from persistent storage in the database */
	void delete(PK id) throws Exception;

	void delete(T persistentObject) throws Exception;
}