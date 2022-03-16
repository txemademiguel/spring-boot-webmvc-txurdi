package com.fptxurdinaga.springbootmvc.repositories.complex;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fptxurdinaga.springbootmvc.domain.complex.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
