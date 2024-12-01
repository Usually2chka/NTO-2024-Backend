package com.example.nto.repository;

import com.example.nto.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT p FROM Employee p WHERE p.name = :name")
    List<Employee> findByName(@Param("name") String name);

    @Modifying
    @Query("UPDATE Employee p SET p.name = :name WHERE p.id = :id")
    void updateNameById(@Param("id") long id,@Param("name") String name);

    @Query("SELECT p FROM Employee p WHERE p.login = :login")
    List<Employee> findByLogin(@Param("login") String login);

    List<Employee> findByNameContains(String nameLike);
    List<Employee> findByLoginContains(String loginLike);
}
