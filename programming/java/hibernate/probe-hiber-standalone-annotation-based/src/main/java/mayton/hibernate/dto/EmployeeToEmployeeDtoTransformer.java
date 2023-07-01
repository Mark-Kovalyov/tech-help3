package mayton.hibernate.dto;

import mayton.hibernate.Employee;
import org.hibernate.transform.ResultTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class EmployeeToEmployeeDtoTransformer implements ResultTransformer {

    public static Logger logger = LoggerFactory.getLogger(EmployeeToEmployeeDtoTransformer.class);

    @Override
    public Object transformTuple(Object[] tuple, String[] aliases) {
        logger.info("tuples = {}", tuple.length);
        Employee employee = (Employee) tuple[0];
        if (aliases != null) {
            logger.info("aliases = {}", aliases.length);
        }
        return new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getSalary());
    }

    @Override
    public List transformList(List collection) {
        return collection;
    }
}
