package com.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import com.hibernate.config.HibernateConfig;
import com.hibernate.entity.Department;
import com.hibernate.entity.Employee;
import com.hibernate.entity.EmployeeNameDTO;

public class DaoImple {

	SessionFactory sf = HibernateConfig.getSessionFactory();

	public String addEmployee(Employee e) {

		Session session = sf.openSession();
		session.get(Employee.class, e.getId());
//		session.evict(e);
		session.save(e);
		session.beginTransaction().commit();
		return null;

	}

	public String addDepartment(Department d) {

		Session session = sf.openSession();
		session.get(Department.class, d.getId());
//		session.evict(d);
		session.save(d);
		session.beginTransaction().commit();
		return null;

	}

	public List<Employee> getAllEmployees() {
		List<Employee> employees;
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Employee.class); // Create Criteria for Employee class
		employees = criteria.list(); // Get all employees from the database
		session.close(); // Close the session

		return employees;

	}

	public List<Employee> getSalary(double salary) {
		Session session = sf.openSession();
//		session.get(Employee.class, salary);
		Criteria c = session.createCriteria(Employee.class);
		c.add(Restrictions.gt("salary", salary));
		List list = c.list();
		return list;

	}

	public List<Employee> getLastNameASC() {
		Session session = sf.openSession();
		Criteria c = session.createCriteria(Employee.class);
		c.addOrder(Order.asc("lastName"));
		List list = c.list();
		return list;

	}

	public List<Department> getPagination() {

		Session session = sf.openSession();
		Criteria c = session.createCriteria(Department.class);
		c.setFirstResult(0);
		c.setMaxResults(6);
		List list = c.list();

		return list;
	}

	public List<Object[]> getFirstLastName() {

		Session session = sf.openSession();
		Criteria c = session.createCriteria(Employee.class);
		c.setProjection(Projections.projectionList().add(Projections.property("firstName"))
				.add(Projections.property("lastName")));
		List<Object[]> list = c.list();
		return list;
	}

	public List<Employee> getCountEmployee() {

		Session session = sf.openSession();
		Criteria c = session.createCriteria(Employee.class);
		c.setProjection(Projections.rowCount());
		long count = (Long) c.uniqueResult();
		List list = c.list();
		count = (long) list.get(0);
		return list;

	}

	public double getMaxSalary() { // using projection we can get maxBalance from table
		double maxBalance;
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.setProjection(Projections.max("salary"));
		List<Double> list = criteria.list();
		maxBalance = list.get(0);
		return maxBalance;

	}

	public double getAvgSalary() { // using projection we can get maxBalance from table
		double maxBalance;
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.setProjection(Projections.avg("salary"));
		List<Double> list = criteria.list();
		maxBalance = list.get(0);
		return maxBalance;

	}

	public Long getCountDistinct() {

		Session session = sf.openSession();
		Criteria c = session.createCriteria(Department.class);
		c.setProjection(Projections.countDistinct("name"));
		Long count = (Long) c.uniqueResult();
		return count;

	}

	public List<Object[]> fetchFirstLastName() {
		Session session = sf.openSession();
		Criteria c = session.createCriteria(Employee.class);
		c.setProjection(Projections.projectionList().add(Projections.property("firstName"))
				.add(Projections.property("lastName")));
		List<Object[]> list = c.list();
		return list;

	}

	public List<EmployeeNameDTO> getDto() {

		Session session = sf.openSession();
		Criteria c = session.createCriteria(Employee.class);
		c.setProjection(Projections.projectionList().add(Projections.property("firstName"), "firstName")
				.add(Projections.property("lastName"), "lastName"));
		c.setResultTransformer(Transformers.aliasToBean(EmployeeNameDTO.class));
		List<EmployeeNameDTO> list = c.list();
		return list;

	}

	public List<Object[]> getIdFirstName() {

		Session session = sf.openSession();
		Criteria c = session.createCriteria(Employee.class);
		Query<Object[]> query = session.createQuery(
				"SELECT d.name, COUNT(e) FROM Employee e JOIN e.department d GROUP BY d.name", Object[].class);

		// Execute query and get the result list
		List<Object[]> list = query.getResultList();
		return list;
	}

	public List<Object[]> getCountEmpDept() {
		Session session = sf.openSession();
		Criteria c = session.createCriteria(Employee.class);
		c.createAlias("department", "dept"); // Create an alias for department

		c.setProjection(Projections.projectionList().add(Projections.groupProperty("dept.id"))
				.add(Projections.rowCount(), "employeeCount"));

		List<Object[]> list = c.list();
		return list;

	}

	public List<Object[]> getLeftJoin() {

		Session session = sf.openSession();

		List<Object[]> resultList = session
				.createQuery("select e.id, e.firstName, d.id, d.name from Employee e left join e.department d")
				.getResultList();

		session.close();

		return resultList;

	}

	public List<Object[]> getInnerJoin() {

		Session session = sf.openSession();

		List<Object[]> resultList = session
				.createQuery("select e.id, e.firstName, d.id, d.name from Employee e inner join e.department d")
				.getResultList();

		session.close();

		return resultList;

	}

	public List<Department> getFetchJoin() {

		Session session = sf.openSession();
		Criteria c = session.createCriteria(Department.class);
		List<Department> resultList = session.createQuery("select d from Department d left join fetch d.employee")
				.getResultList();

		session.close();

		return resultList;

	}

	public List<Department> getOneToMany() {

		Session session = sf.openSession();
		Criteria c = session.createCriteria(Department.class);
		c.setFetchMode("employees", FetchMode.JOIN);
		List<Department> dept = c.list();
		return dept;

	}
	
//	public List<Department> getInsertOneToMany(Department department_Id){
//		
//		Session session=sf.openSession();
//		Department dept=session.get(Department.class, department_Id);
//		return null;
//		
//	}
}
