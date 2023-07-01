package mayton.hibernate;

import java.util.List;
import java.util.Iterator;
import java.util.Map;

import mayton.hibernate.dto.EmployeeBean;
import mayton.hibernate.dto.EmployeeDto;
import mayton.hibernate.dto.EmployeeToEmployeeDtoTransformer;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ManageEmployee {

    private static SessionFactory factory;

    private Session session;

    public static Logger logger = LoggerFactory.getLogger(ManageEmployee.class);

    public ManageEmployee(Session session) {
        this.session = session;
    }

    public static void main(String[] args) {
        logger.info(":: Begin");
        try {
            Configuration conf = new Configuration().configure("hibernate-pg.cfg.xml");
            factory = conf.buildSessionFactory();
        } catch (HibernateException ex) {
            logger.error("Failed to configure or create sessionFactory object.",ex);
            return;
        }

        try(Session session = factory.openSession()) {
            ManageEmployee manageEmployee = new ManageEmployee(session);

            manageEmployee.clean();

            Integer empID1 = manageEmployee.addEmployee("Zara", "Ali", 1000);
            Integer empID2 = manageEmployee.addEmployee("Daisy", "Das", 5000);
            Integer empID3 = manageEmployee.addEmployee("John", "Paul", 10000);

            manageEmployee.listEmployees();
            manageEmployee.listEmployeesDtos();
            manageEmployee.listEmployeesAndTransformToBean();
            manageEmployee.listEmployeesToListOfList();
            manageEmployee.listEmployeesMap();


            manageEmployee.updateEmployee(empID1, 5000);
            manageEmployee.deleteEmployee(empID2);
            manageEmployee.listEmployees();

        } catch (HibernateException ex) {
            logger.error("HibernateException",ex);
        }
        factory.close();
        logger.info(":: End");
    }

    private void listEmployeesToListOfList() {

        logger.info(":: listEmployeesToListOfList");
        Transaction transaction = session.beginTransaction();
        List<List> employeesListOfList = session.createQuery("SELECT e FROM Employee e")
                .setResultTransformer(Transformers.TO_LIST)
                .list();

        employeesListOfList.forEach(x -> logger.info(":: List<List> : {}", x));

        transaction.commit();

    }

    private void clean() {
        logger.info(":: clean");
        Transaction transaction = session.beginTransaction();
            String sql = "DELETE FROM probe.employee";
            int status = session.createSQLQuery(sql).executeUpdate();
            logger.info(":: clean status = {}", status);
        transaction.commit();
    }


    public void listEmployees() {
        logger.info(":: listEmployees");
        Transaction transaction = null;
        transaction = session.beginTransaction();
        List<Employee> employees = (List<Employee>) session.createQuery("FROM Employee")
                .list();

        for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext(); ) {
            Employee employee = iterator.next();
            logger.info("EMPLOYEE : {} ", employee);
        }
        transaction.commit();
    }

    private void listEmployeesAndTransformToBean() {
        logger.info(":: listEmployeesAndTransformToBean");
        Transaction transaction = session.beginTransaction();
        // TODO:
        List<EmployeeBean> employees = (List<EmployeeBean>) session.createQuery("SELECT e.id, e.firstName, e.lastName FROM Employee e")
                .setResultTransformer(Transformers.aliasToBean(EmployeeBean.class))
                .list();


        employees.forEach(x -> logger.info(":: BEAN : {}", x));

        transaction.commit();
    }

    private void listEmployeesMap() {
        logger.info(":: listEmployeesMap");
        Transaction transaction = session.beginTransaction();
        List<Map> employeesListOfMaps = session.createQuery("SELECT e FROM Employee e")
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
                .list();

        employeesListOfMaps.forEach(x -> logger.info(":: MAP : {}", x));

        transaction.commit();
    }

    private void listEmployeesDtos() {
        logger.info(":: listEmployeesDtos");
        Transaction transaction = null;
        transaction = session.beginTransaction();
        List<EmployeeDto> employees = (List<EmployeeDto>) session.createQuery("FROM Employee")
                //.unwrap(org.hibernate.query.Query.class)
                .setResultTransformer(new EmployeeToEmployeeDtoTransformer())
                .getResultList();

        employees.forEach(x -> logger.info(":: DTO : {}", x));

        transaction.commit();
    }

    public Integer addEmployee(String fname, String lname, int salary) {
        Transaction transaction = null;
        Integer employeeID = null;
        transaction = session.beginTransaction();
        Employee employee = new Employee(fname, lname, salary);
        employee.setAddress(new Address("London", "Baker-st,16/1", 55333));
        logger.info(":: add employee {}", employee);
        employeeID = (Integer) session.save(employee);
        transaction.commit();
        return employeeID;
    }


    public void updateEmployee(Integer id, int salary ){
        logger.info(":: updateEmployee id = {} with salary {}", id, salary);
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            employee.setSalary( salary );
            session.update(employee);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("HibernateException",ex);
        } finally {
        }
    }

    /* Method to DELETE an employee from the records */
    public void deleteEmployee(Integer EmployeeID){
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Employee employee = (Employee)session.get(Employee.class, EmployeeID);
            session.delete(employee);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx!=null) {
                tx.rollback();
            }
            logger.error("HibernateException",ex);
        } finally {
        }
    }
}