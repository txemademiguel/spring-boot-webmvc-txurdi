package com.fptxurdinaga.springbootmvc.repositories.complex;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fptxurdinaga.springbootmvc.domain.complex.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
