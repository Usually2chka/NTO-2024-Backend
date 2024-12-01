package com.example.nto.service.impl;

import lombok.RequiredArgsConstructor;
import com.example.nto.entity.Employee;
import com.example.nto.exception.NoSuchEmployeeException;
import com.example.nto.repository.EmployeeRepository;
import com.example.nto.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;


    @Override
    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @Override
    public Employee getById(long id) {

        Optional<Employee> optionalEmployee = repository.findById(id);

        if (!optionalEmployee.isPresent())
        {
            throw new NoSuchEmployeeException("Person with id " + id + " not found!");
        }
        return optionalEmployee.get();
    }

    @Override
    public Employee update(long id, Employee employee) {
        Employee updateEmployee = repository.findById(id)
                .orElseThrow(() -> new NoSuchEmployeeException("Person with id" + id + "not found!"));

        updateEmployee.setName(employee.getName());

        return repository.save(updateEmployee);
    }

    @Override
    public void deleteById(long id)
    {
        Employee updateEmployee = repository.findById(id)
                .orElseThrow(() -> new NoSuchEmployeeException("Person with id" + id + "not found!"));

        repository.delete(updateEmployee);

    }

    @Override
    public List<Employee> getByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Employee> getByLogin(String login) {
        return repository.findByLogin(login);
    }

    @Override
    @Transactional
    public void updateNameById(long id, String name) {
        repository.updateNameById(id, name);
    }

    @Override
    public List<Employee> getByNameLike(String nameLike)
    {
        return repository.findByNameContains(nameLike);
    }

    @Override
    public List<Employee> getByLoginLike(String loginLike) {
        return repository.findByLoginContains(loginLike);
    }
}
