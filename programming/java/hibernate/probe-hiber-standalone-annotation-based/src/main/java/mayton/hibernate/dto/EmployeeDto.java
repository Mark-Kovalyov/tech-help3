package mayton.hibernate.dto;

public record EmployeeDto(
        Integer id,
        String firstName,
        String lastName,
        int salary) {}
