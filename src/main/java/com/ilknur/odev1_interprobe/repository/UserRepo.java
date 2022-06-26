package com.ilknur.odev1_interprobe.repository;

import com.ilknur.odev1_interprobe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author İlknur Kara
 */

@Repository
@Transactional
public interface UserRepo extends JpaRepository<User, Long> {

	void deleteByUserId(Long userId);

}
