package com.fptxurdinaga.springbootmvc.repositories.onetoone;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fptxurdinaga.springbootmvc.domain.onetoone.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone,Long> {
}
