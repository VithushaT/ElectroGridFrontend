package com.group86.electrogrid.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group86.electrogrid.models.Email;



@Repository

public interface EmailRepository extends JpaRepository<Email , Long> {

}
