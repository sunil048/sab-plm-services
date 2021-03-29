/**
 * 
 */
package com.sabtok.plm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sabtok.plm.entity.Issue;

/**
 * @author Sunil
 *
 * IssueDao.java Aug 9, 2020 11:07:07 AM
 */
@Repository
public interface IssueDao extends JpaRepository<Issue, Integer>{

	@Transactional
	@Modifying
	@Query("update Issue set ACTION_TAKEN = ?1 where ISSUEID = ?2")
	public int updateIssueActionTaken(String actionTaken , String issueID);
	
	@Transactional
	@Modifying
	@Query("update Issue set closedDate = :closedDate ,isClosed = true where ISSUEID = :issueID")
	public int closeIssue(@Param("issueID") String issueID, @Param("closedDate") String closedDate);
	
	@Query("select count (*) from Issue")
	public Integer getRowNumber();
	
}
