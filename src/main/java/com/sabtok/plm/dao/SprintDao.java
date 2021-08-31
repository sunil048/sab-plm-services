package com.sabtok.plm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sabtok.plm.entity.Sprint;

@Repository
public interface SprintDao extends JpaRepository<Sprint, String> {

}
