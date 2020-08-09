/**
 * 
 */
package com.sabtok.plm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sabtok.plm.entity.Issue;

/**
 * @author Sunil
 *
 * IssueDao.java Aug 9, 2020 11:07:07 AM
 */
@Repository
public interface IssueDao extends JpaRepository<Issue, Integer>{

	
}
