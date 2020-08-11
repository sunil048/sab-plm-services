/**
 * 
 */
package com.sabtok.plm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sabtok.plm.entity.Log;

/**
 * @author Sunil
 *
 * Logdao.java Aug 11, 2020 3:53:01 PM
 */
@Repository
public interface Logdao extends JpaRepository<Log, Integer>{

	@Query("select Count(*) from Log")
	public Long nextLogRowno();
}
