package in.ineuron.Dto;

import javax.persistence.*;


@Entity
@Table(name="student")
public class Student {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer Id;
	@Column(name="name")
	String name;
	@Column(name="location")
	String location;
	@Column(name="email")
	String email;
	@Column(name="age")
	Integer age;
	
	public Student() {
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", location=" + location + ", email=" + email + ", age=" + age + "]";
	}

	public Integer getId() {
		return Id;
	}
	
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	

}
