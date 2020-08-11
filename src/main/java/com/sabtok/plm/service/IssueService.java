/**
 * 
 */
package com.sabtok.plm.service;

import java.util.List;
import java.util.Optional;

import com.sabtok.plm.entity.Issue;

/**
 * @author Sunil
 *
 * IssueService.java Aug 9, 2020 11:04:53 AM
 */
public interface IssueService {

	public String saveIssue(Issue issue);
	public List<Issue> getIssueList();
	public Optional<Issue> getIssue(int rowNo);
	public int updateIssueActionTaken(String issueID,String actionTaken);
	public int closeIssue(String issueID,String closedDate);
}
