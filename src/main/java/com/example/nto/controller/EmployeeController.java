package com.example.nto.controller;

import com.example.nto.entity.Employee;
import com.example.nto.exception.NoSuchEmployeeException;
import com.example.nto.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/employee")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody Employee employee)
    {
        return employeeService.create(employee);
    }

    @GetMapping("/employee")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAll()
    {
        return employeeService.getAll();
    }

    @GetMapping("/employee/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getById(@PathVariable long id)
    {
        return employeeService.getById(id);
    }

    @PutMapping("/employee/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee update(@PathVariable long id, @RequestBody Employee employee)
    {
        return employeeService.update(id, employee);
    }

    @DeleteMapping("/employee/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable long id)
    {
        employeeService.deleteById(id);
    }

    @GetMapping("/employee/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getByName(@PathVariable String name)
    {
        return employeeService.getByName(name);
    }

    @GetMapping("/employee/{login}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getByLogin(@PathVariable String login)
    {
        return employeeService.getByLogin(login);
    }

    @PatchMapping("/employee/{id}")
    public void updateNameById(@PathVariable long id, @RequestParam String name)
    {
        employeeService.updateNameById(id, name);
    }

    /*@GetMapping("/proba/{name}/info")
    public List<Employee> getByNameLike(@PathVariable String name)
    {
        return employeeService.getByName(name);
    }*/
    @GetMapping("/{string}/info")
    public List<Employee> getByLoginLike(@PathVariable String string)
    {
        if(!employeeService.getByLoginLike(string).isEmpty())
            return employeeService.getByLogin(string);
        else if (!employeeService.getByNameLike(string).isEmpty())
            return employeeService.getByName(string);
        else
            throw new NoSuchEmployeeException("Employee " + string + " not found");
    }

    @GetMapping("/{string}/auth")
    public String getEmployee(@PathVariable String string)
    {
        if(!employeeService.getByLoginLike(string).isEmpty() || !employeeService.getByNameLike(string).isEmpty())
            return "Данный пользователь существует";
        else
            throw new NoSuchEmployeeException("Employee " + string + " not found");
    }

    //@PatchMapping("/{string}/open")
    //public String getByCode(@PathVariable String string)
    //{

    //}
}
