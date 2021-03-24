package com.project2.models;

import javax.persistence.*;

@Entity
@Table(name="POSTS")
public class Posts {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="postSequence")
	@SequenceGenerator(name="postSequence", sequenceName="POST_SEQ", allocationSize=1)
	private int postId;
	
	@Column(name="CITY", nullable=false)
	private String city;
	
	@Column(name="STATE", nullable=false)
	private String state;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="EMPLOYER_ID", nullable=false)
	private int employerId;
	
	@Column(name="EMPLOYEE_ID")
	private int employeeId;
	
	@Column(name="CATEGORY", nullable=false)
	private String category;
	
	@Column(name="SALARY", nullable=false)
	private double salary;
	
	@Column(name="TITLE", nullable=false)
	private String title;

	public Posts() {
		super();
	}

	public Posts(String city, String state, String description, int employerId, int employeeId, String category,
			double salary, String title) {
		super();
		this.city = city;
		this.state = state;
		this.description = description;
		this.employerId = employerId;
		this.employeeId = employeeId;
		this.category = category;
		this.salary = salary;
		this.title = title;
	}

	public Posts(String city, String state, String description, int employerId, String category, double salary,
			String title) {
		super();
		this.city = city;
		this.state = state;
		this.description = description;
		this.employerId = employerId;
		this.category = category;
		this.salary = salary;
		this.title = title;
	}

	public Posts(int postId, String city, String state, String description, int employerId, int employeeId,
			String category, double salary, String title) {
		super();
		this.postId = postId;
		this.city = city;
		this.state = state;
		this.description = description;
		this.employerId = employerId;
		this.employeeId = employeeId;
		this.category = category;
		this.salary = salary;
		this.title = title;
	}

	public Posts(int postId, String city, String state, String description, int employerId, String category,
			double salary, String title) {
		super();
		this.postId = postId;
		this.city = city;
		this.state = state;
		this.description = description;
		this.employerId = employerId;
		this.category = category;
		this.salary = salary;
		this.title = title;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEmployerId() {
		return employerId;
	}

	public void setEmployerId(int employerId) {
		this.employerId = employerId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + employeeId;
		result = prime * result + employerId;
		result = prime * result + postId;
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posts other = (Posts) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (employerId != other.employerId)
			return false;
		if (postId != other.postId)
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Posts [postId=" + postId + ", city=" + city + ", state=" + state + ", description=" + description
				+ ", employerId=" + employerId + ", employeeId=" + employeeId + ", category=" + category + ", salary="
				+ salary + ", title=" + title + "]";
	}
	
	
	

}
