package com.mindfire.MappingDemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mindfire.MappingDemo.model.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {

}
