package com.tn.repository;

import com.tn.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<School,Integer>{
    List<School> findBySchoolName(String schoolName);
    List<School> findByAddress(String address);
}
