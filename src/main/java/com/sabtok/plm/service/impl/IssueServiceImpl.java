/**
 * 
 */
package com.sabtok.plm.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.sabtok.plm.dao.IssueDao;
import com.sabtok.plm.entity.Issue;
import com.sabtok.plm.service.IssueService;
import com.sabtok.plm.util.DateUtils;
import com.sabtok.plm.util.IDGenerator;

/**
 * @author Sunil
 *
 * IssueServiceImpl.java Aug 9, 2020 11:05:18 AM
 */
@Service
public class IssueServiceImpl implements IssueService {

	@Autowired
	private IssueDao issueDao; 
	
	@Override
	public String saveIssue(Issue issue) {
		
		if (issue.getIssueDate() == null || StringUtils.isEmpty(issue.getIssueDate())) {
			issue.setIssueDate(DateUtils.getDateString());
		}
		Issue iss = issueDao.save(issue);
		return String.valueOf(iss.getRowNo());
	}
	

	/* (non-Javadoc)
	 * @see com.sabtok.plm.service.IssueService#getIssueList()
	 */
	@Override
	public List<Issue> getIssueList() {
		return issueDao.findAll();
	}

	/* (non-Javadoc)
	 * @see com.sabtok.plm.service.IssueService#getIssue(int)
	 */
	@Override
	public Optional<Issue> getIssue(int rowNo) {
		return issueDao.findById(rowNo);
	}

	/* (non-Javadoc)
	 * @see com.sabtok.plm.service.IssueService#updateIssue(com.sabtok.plm.entity.Issue)
	 */
	@Override
	public int updateIssueActionTaken(String issueID,String actionTaken) {
		return issueDao.updateIssueActionTaken(actionTaken,issueID);
	}


	/* (non-Javadoc)
	 * @see com.sabtok.plm.service.IssueService#closeIssue(java.lang.String, java.lang.String)
	 */
	@Override
	public int closeIssue(String issueID, String closedDate) {
		return issueDao.closeIssue(issueID, closedDate);
	}


	/* (non-Javadoc)
	 * @see com.sabtok.plm.service.IssueService#getRowNumber()
	 */
	@Override
	public Integer getRowNumber() {
		return issueDao.getRowNumber();
	}

	
}
