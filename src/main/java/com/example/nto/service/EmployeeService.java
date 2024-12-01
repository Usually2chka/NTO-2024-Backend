package com.example.nto.service;

import java.util.List;

import com.example.nto.entity.Employee;

public interface EmployeeService {
    Employee create(Employee employee);
    List<Employee> getAll();
    Employee getById(long id);
    Employee update(long id, Employee employee);
    void deleteById(long id);
    List<Employee> getByName(String name);
    List<Employee> getByLogin(String name);
    void updateNameById(long id, String name);

    List<Employee> getByNameLike(String nameLike);
    List<Employee> getByLoginLike(String loginLike);
}
