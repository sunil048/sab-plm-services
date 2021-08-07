package com.sabtok.plm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sabtok.plm.entity.BackUp;

public interface BackupDao extends JpaRepository<BackUp, String> {

}
