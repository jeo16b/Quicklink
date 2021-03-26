package com.project2.models;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="POSTS")
public class Posts {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="postSequence")
	@SequenceGenerator(name="postSequence", sequenceName="POST_SEQ", allocationSize=1)
	private int postId;
	
	@Column(name="companyName", nullable=false)
	private String companyName;
	
	@Column(name="TITLE", nullable=false)
	private String title;
	
	@Column(name="CATEGORY", nullable=false)
	private String category;
	
	@Column(name="LOCATION", nullable=false)
	private String location;
	
	@Column(name="SALARY", nullable=false)
	private double salary;
	
	@Column(name="PHONENUMBER", nullable=false)
	private int phoneNumber;	
	
	@Column(name="DESCRIPTION", nullable=false)
	private String description;
	
	@Column(name="EMPLOYER_ID", nullable=false)
	private int employerId;
	
	@Column(name="EMPLOYEE_ID")
	private int employeeId;
	
	public Posts() 
	{
		super();
	}

	/**
	 * @param companyName
	 * @param title
	 * @param category
	 * @param location
	 * @param salary
	 * @param phoneNumber
	 * @param description
	 * @param employerId
	 * @param employeeId
	 */
	public Posts(String companyName, String title, String category, String location, double salary, int phoneNumber,
			String description, int employerId, int employeeId)
	{
		super();
		this.companyName = companyName;
		this.title = title;
		this.category = category;
		this.location = location;
		this.salary = salary;
		this.phoneNumber = phoneNumber;
		this.description = description;
		this.employerId = employerId;
		this.employeeId = employeeId;
	}

	/**
	 * @param postId
	 * @param companyName
	 * @param title
	 * @param category
	 * @param location
	 * @param salary
	 * @param phoneNumber
	 * @param description
	 * @param employerId
	 * @param employeeId
	 */
	public Posts(int postId, String companyName, String title, String category, String location, double salary,
			int phoneNumber, String description, int employerId, int employeeId)
	{
		super();
		this.postId = postId;
		this.companyName = companyName;
		this.title = title;
		this.category = category;
		this.location = location;
		this.salary = salary;
		this.phoneNumber = phoneNumber;
		this.description = description;
		this.employerId = employerId;
		this.employeeId = employeeId;
	}

	/**
	 * @return the postId
	 */
	public int getPostId()
	{ return postId; }

	/**
	 * @param postId the postId to set
	 */
	public void setPostId(int postId)
	{ this.postId = postId; }

	/**
	 * @return the companyName
	 */
	public String getCompanyName()
	{ return companyName; }

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName)
	{ this.companyName = companyName; }

	/**
	 * @return the title
	 */
	public String getTitle()
	{ return title; }

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title)
	{ this.title = title; }

	/**
	 * @return the category
	 */
	public String getCategory()
	{ return category; }

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category)
	{ this.category = category; }

	/**
	 * @return the location
	 */
	public String getLocation()
	{ return location; }

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location)
	{ this.location = location; }

	/**
	 * @return the salary
	 */
	public double getSalary()
	{ return salary; }

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary)
	{ this.salary = salary; }

	/**
	 * @return the phoneNumber
	 */
	public int getPhoneNumber()
	{ return phoneNumber; }

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(int phoneNumber)
	{ this.phoneNumber = phoneNumber; }

	/**
	 * @return the description
	 */
	public String getDescription()
	{ return description; }

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description)
	{ this.description = description; }

	/**
	 * @return the employerId
	 */
	public int getEmployerId()
	{ return employerId; }

	/**
	 * @param employerId the employerId to set
	 */
	public void setEmployerId(int employerId)
	{ this.employerId = employerId; }

	/**
	 * @return the employeeId
	 */
	public int getEmployeeId()
	{ return employeeId; }

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(int employeeId)
	{ this.employeeId = employeeId; }

	@Override
	public int hashCode()
	{
		return Objects.hash(category, companyName, description, employeeId, employerId, location, phoneNumber, postId,
				salary, title);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{ return true; }
		if (!(obj instanceof Posts))
		{ return false; }
		Posts other = (Posts) obj;
		return Objects.equals(category, other.category) && Objects.equals(companyName, other.companyName)
				&& Objects.equals(description, other.description) && employeeId == other.employeeId
				&& employerId == other.employerId && Objects.equals(location, other.location)
				&& phoneNumber == other.phoneNumber && postId == other.postId
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString()
	{
		return "Posts [postId=" + postId + ", companyName=" + companyName + ", title=" + title + ", category="
				+ category + ", location=" + location + ", salary=" + salary + ", phoneNumber=" + phoneNumber
				+ ", description=" + description + ", employerId=" + employerId + ", employeeId=" + employeeId + "]";
	}
	
}
