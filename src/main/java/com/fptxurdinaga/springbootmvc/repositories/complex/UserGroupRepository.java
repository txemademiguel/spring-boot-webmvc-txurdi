package com.fptxurdinaga.springbootmvc.repositories.complex;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fptxurdinaga.springbootmvc.domain.complex.UserGroup;

public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {
}
