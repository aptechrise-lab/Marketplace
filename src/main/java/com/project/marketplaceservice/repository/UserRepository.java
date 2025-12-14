package com.project.marketplaceservice.repository;

import com.project.marketplaceservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
