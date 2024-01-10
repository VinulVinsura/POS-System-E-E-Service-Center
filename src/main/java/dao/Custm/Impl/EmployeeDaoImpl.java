package dao.Custm.Impl;

import dao.Custm.EmployeeDao;
import dao.Hibernate;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public boolean save(Employee entity) {
        Session session = Hibernate.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Employee> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Employee entity) {
        return false;
    }

    @Override
    public boolean delete(String data) {
        return false;
    }

    @Override
    public Employee getLastEmployee() {
        System.out.println("1st done");
        Session session = Hibernate.getSession();
        Query query = session.createQuery("FROM Employee E ORDER BY E.employee_ID DESC");
        System.out.println("2nd done");
        List<Employee> list = query.list();
        for (Employee employee:list) {
            return new Employee(employee.getEmployee_ID(),
                    employee.getEmployee_Name(),
                    employee.getPassword(),
                    employee.getEmail(),
                    employee.getPhone_Num());
        }
       return null;
    }
}
