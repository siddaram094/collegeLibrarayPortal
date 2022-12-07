package com.college.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.library.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
