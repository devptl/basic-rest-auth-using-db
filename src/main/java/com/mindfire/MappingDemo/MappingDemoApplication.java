package com.mindfire.MappingDemo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mindfire.MappingDemo.model.Address;
import com.mindfire.MappingDemo.model.Asset;
import com.mindfire.MappingDemo.model.Department;
import com.mindfire.MappingDemo.model.Employee;

@SpringBootApplication
@Controller
public class MappingDemoApplication {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	public static void main(String[] args) {
		SpringApplication.run(MappingDemoApplication.class, args);
	}

	@RequestMapping("/")
	@ResponseBody
	public void map() {
		// Create Entity Manager
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Begin transaction
		entityManager.getTransaction().begin();
		System.out.println("Transaction started!");

		// Creating address
		Address address1 = new Address();
		address1.setDetails("Park Avenue, UK");
		address1.setZip(713204);

		Address address2 = new Address();
		address2.setDetails("Indiana, US");
		address2.setZip(713204);

		// Creating jobs
		Department dept1 = new Department("UI Designer");
		Department dept2 = new Department("DB Developer");

		// Creating employee
		Employee employee1 = new Employee();
		employee1.setName("Mr. XYZ");
		employee1.setAddress(address2);
		employee1.setDept(dept1);

		Employee employee2 = new Employee();
		employee2.setName("Mr. ABC");
		employee2.setAddress(address1);
		employee2.setDept(dept2);

		Employee employee3 = new Employee();
		employee3.setName("Mr. RST");
		employee3.setAddress(address2);
		employee3.setDept(dept1);

		Asset asset1 = new Asset("Lenovo Laptop");
		Asset asset2 = new Asset("Logitech Mouse");
		Asset asset3 = new Asset("JBL Headphones");

		Set<Asset> assets1 = new HashSet<>();
		assets1.add(asset1);
		assets1.add(asset2);
		assets1.add(asset3);

		Set<Asset> assets2 = new HashSet<>();
		assets2.add(asset1);
		assets2.add(asset3);

		dept1.setAssets(assets1);
		dept2.setAssets(assets2);

		// Saving address - employee (One-One)
		entityManager.persist(address1);
		entityManager.persist(address2);

		// Saving employee - department (Many-One)
		entityManager.persist(asset1);
		entityManager.persist(asset2);
		entityManager.persist(asset3);

		// Saving employee - department (Many-One)
		entityManager.persist(dept1);
		entityManager.persist(dept2);

		entityManager.persist(employee1);
		entityManager.persist(employee2);
		entityManager.persist(employee3);

		// Committing data
		entityManager.getTransaction().commit();
		//entityManagerFactory.close();
		System.out.println("Commited!");
	}

}