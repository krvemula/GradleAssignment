package com.springMongoDB.extractdata;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.MongoClient;

public class ExtractDataConfig {

	public static void main(String[] args) {

		MongoTemplate mongoTemplate = null;
		mongoTemplate = new MongoTemplate(new MongoClient("127.0.0.1"), "company1");

		List<Employees> employeesList = new ArrayList<Employees>();
		Employees employee1 = new Employees(9, "Avni", "Neil");
		Employees employee2 = new Employees(10, "Briana", "Hall");
		Employees employee3 = new Employees(11, "ava", "micheal");
		Employees employee4 = new Employees(12, "viva", "bren");
		employeesList.add(employee1);
		employeesList.add(employee2);
		employeesList.add(employee3);
		employeesList.add(employee4);
		mongoTemplate.insert(employeesList, Employees.class);

		BasicQuery query1 = new BasicQuery("{ EmpNo : 9, FirstName : 'Avni' }");
		Employees userTest1 = mongoTemplate.findOne(query1, Employees.class);

		System.out.println("query1 - " + query1.toString());
		System.out.println("userTest1 - " + userTest1);

		Query query2 = new Query();
		query2.addCriteria(Criteria.where("EmpNo").lt(40));

		List<Employees> userTest2 = mongoTemplate.find(query2, Employees.class);
		System.out.println("query2 - " + query2.toString());

		for (Employees employee : userTest2) {
			System.out.println("userTest2 - " + employee);
			
			//mongoOperation.dropCollection(Employees.class);
		}
	}
}
