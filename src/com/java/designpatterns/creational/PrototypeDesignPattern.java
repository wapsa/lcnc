package com.java.designpatterns.creational;

import java.util.ArrayList;
import java.util.List;

/**
 * The Prototype Design Pattern is a creational design pattern that allows for
 * the creation of new objects by copying an existing object, known as the
 * prototype. This pattern is particularly useful when the process of creating a
 * new object is costly in terms of time or resources, and a similar object
 * already exists.
 */
public class PrototypeDesignPattern {

	public static void main(String[] args) {
		Employees emps = new Employees();
		// read all employees from database and put into the list
		emps.loadData();

		// Use the clone method to get the Employee object
		Employees emps1 = emps.deepCopy();

		List<String> list1 = emps1.getEmpList();
		list1.add("John");

		Employees emps2 = emps.deepCopy();
		List<String> list2 = emps2.getEmpList();
		list2.remove("Pankaj");

		System.out.println("emps1: " + emps.getEmpList());
		System.out.println("list1: " + list1);
		System.out.println("list2: " + list2);
	}

	static class Employees {
		private final List<String> employees;

		public Employees() {
			this.employees = new ArrayList<>();
		}

		public Employees(List<String> list) {
			this.employees = list;
		}

		public void loadData() {
			employees.add("Pankaj");
			employees.add("Raj");
			employees.add("David");
			employees.add("Lisa");
		}

		public List<String> getEmpList() {
			return employees;
		}

		public Employees deepCopy() {
			List<String> temp = new ArrayList<>();
			for (String s : this.getEmpList()) {
				temp.add(s);
			}
			return new Employees(temp);
		}
	}
}
