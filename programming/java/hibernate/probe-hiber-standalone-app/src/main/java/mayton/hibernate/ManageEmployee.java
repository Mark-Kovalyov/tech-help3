package mayton.hibernate;

import java.util.List;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ManageEmployee {

    private static SessionFactory factory;

    public static Logger logger = LoggerFactory.getLogger(ManageEmployee.class);

    public static void main(String[] args) {
        logger.info(":: Begin");
        try {
            Configuration conf = new Configuration().configure("hibernate-pg.cfg.xml");
            factory = conf.buildSessionFactory();
        } catch (HibernateException ex) {
            logger.error("Failed to configure or create sessionFactory object.",ex);
            return;
        }
        ManageEmployee ME = new ManageEmployee();
        Integer empID1 = ME.addEmployee("Zara", "Ali", 1000);
        Integer empID2 = ME.addEmployee("Daisy", "Das", 5000);
        Integer empID3 = ME.addEmployee("John", "Paul", 10000);
        ME.listEmployees();
        ME.updateEmployee(empID1, 5000);
        ME.deleteEmployee(empID2);
        ME.listEmployees();
        factory.close();
        logger.info(":: End");
    }

    /* Method to CREATE an employee in the database */
    public Integer addEmployee(String fname, String lname, int salary){
        Transaction transaction = null;
        Integer employeeID = null;
        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            Employee employee = new Employee(fname, lname, salary);
            logger.info(":: add employee {}", employee);
            employeeID = (Integer) session.save(employee);
            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction!=null) {
                transaction.rollback();
            }
            logger.error("HibernateException",ex);
        }
        return employeeID;
    }

    public void listEmployees(){
        logger.info(":: listEmployees");
        Transaction transaction = null;
        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            List<Employee> employees = (List<Employee>)session.createQuery("FROM Employee").list();
            for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext();){
                Employee employee = iterator.next();
                logger.info("EMPLOYEE : {} ", employee);
            }
            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction!=null) {
                transaction.rollback();
            }
            logger.error("HibernateException",ex);
        }
    }

    /* Method to UPDATE salary for an employee */
    public void updateEmployee(Integer id, int salary ){
        logger.info(":: updateEmployee id = {} with salary {}", id, salary);
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            employee.setSalary( salary );
            session.update(employee);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx!=null) {
                tx.rollback();
            }
            logger.error("HibernateException",ex);
        } finally {
            session.close();
        }
    }

    /* Method to DELETE an employee from the records */
    public void deleteEmployee(Integer EmployeeID){
        Session session = factory.openSession();
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
            session.close();
        }
    }
}