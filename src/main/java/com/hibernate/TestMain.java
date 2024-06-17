package com.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.hibernate.dao.DaoImple;
import com.hibernate.entity.Department;
import com.hibernate.entity.Employee;
import com.hibernate.entity.EmployeeNameDTO;

public class TestMain {

	public static void main(String[] args) {
		DaoImple dao = new DaoImple();
//		Set<Employee> employees = new HashSet<>();
//		Department dept1=new Department();
//		dept1.setId(10);
//		dept1.setName("Testing");
//		dept1.setLocation("mumbai");
//		dept1.setEmployees(employees);
//		dao.addDepartment(dept1);
//		
//		
//		Employee e1=new Employee();
//		e1.setId(10);
//		e1.setFirstName("makarand");
//		e1.setLastName("matle");
//		e1.setEmail("makarand@gmail.com");
//		e1.setSalary(89000.75);
//		e1.setDepartment(dept1);
//		dao.addEmployee(e1);
//		
// *******ADD EMP DEPT******

//		List<Employee> employees = dao.getAllEmployees();

		// Print each employee
//        for (Employee employee : employees) {
//            System.out.println(employee);
//        }
		// *********To Get Employee**********

//		List<Employee> employees = dao.getSalary(40000);
//
//        // Print each employee
//        for (Employee employee : employees) {
//            System.out.println(employee);
//        }

//************Ordering Result**********

//		List<Employee> employees = dao.getLastNameASC();
//
//		for (Employee employee : employees) {
//			System.out.println(employee);
//		}
//
//	}
//*********Pagination Result************
//		List<Department> dept1 = dao.getPagination();
//
//		for (Department dept : dept1) {
//			System.out.println(dept);
//		}

//***********FetchColumn first and last name*********

//		List<Object[]> dept1 = dao.getFirstLastName();
// 
//		for (Object[] obj : dept1) {
//            String firstName = (String) obj[0];
//            String lastName = (String) obj[1];
//            System.out.println("First Name: " + firstName + ", Last Name: " + lastName);
//        }

//*********Count Employee*******

//		List<Employee> dept1 = dao.getCountEmployee();
//		//
//				for (Employee dept : dept1) {
//					System.out.println(dept);
//				}
//	
//	}

//***********Max Salary*********

//	double maxSalary=dao.getMaxSalary();
//	
//	System.out.println(maxSalary);

//*********AVG Salary**********

//		double maxSalary=dao.getAvgSalary();
//		
//		System.out.println(maxSalary);

//**********CountDistinct*******
//		long count=dao.getCountDistinct();
//		
//		System.out.println(count);

//************Query Projection*******
		// ******Fetch first and last name***

//		List<Object[]> list=dao.fetchFirstLastName();
//		for(Object[] e:list) {
//			
//			String firstName=(String) e[0];
//			String lastName=(String) e[1];
//			
//			System.out.println("firstName:-"+firstName+"**"+"lastName:-"+lastName);
//			
//		}

//*******DTO projection criteria*****

//		List<EmployeeNameDTO> list=dao.getDto();
//		for(EmployeeNameDTO e:list) {
//			
//		System.out.println("Firstname "+e.getFirstName()+" "+"Lastname "+e.getLastName());	
//		}
//		

//*********Get Id FirstName Employee******

//		List<Object[]> list=dao.getIdFirstName();
//			for(Object[] e:list)	{
//			
//				int id=(Integer) e[0];
//				String firstName=(String) e[1]; 
//				System.out.println("id "+id+"firstName "+firstName);
//			}

//*********Aggregation Projection********
//			
//	
//		List<Object[]> countEmployeesByDepartment = dao.getCountEmpDept();
//
//		// Display the result
//		for (Object[] row : countEmployeesByDepartment) {
//			String departmentName = Objects.toString(row[0], "Unknown Department");
//			long employeeCount = (long) row[1];
//			System.out.println("Department: " + departmentName + ", Employee Count: " + employeeCount);
//		}

//********Joins Left Join***********

//		List<Object[]> resultList = dao.getLeftJoin();
//	    
//	    for (Object[] result : resultList) {
//	        int employeeId = (int) result[0];
//	        String firstName = (String) result[1];
//	        Integer departmentId = (Integer) result[2];
//	        String departmentName = (String) result[3];
//	        
//	        System.out.println("Employee ID: " + employeeId + ", First Name: " + firstName +
//	                ", Department ID: " + departmentId + ", Department Name: " + departmentName);
//	    }
//*********InnerJoin********
//
//		List<Department> departments = dao.getFetchJoin();
//	    
//	    for (Department department : departments) {
//	        System.out.println("Department: " + department.getName());
//	        if (!department.getEmployees().isEmpty()) {
//	            System.out.println("Employees:");
//	            for (Employee employee : department.getEmployees()) {
//	                System.out.println("- " + employee.getFirstName() + " " + employee.getLastName());
//	            }
//	        } else {
//	            System.out.println("No employees assigned.");
//	        }
//	    }
	    
//***********One to Many*************
	
		List<Department> dep=dao.getOneToMany();
		for(Department d:dep) {
			
			System.out.println(d);
		}
	    
	}
}
