package cn.chenhuanming.hibernate5ModuleIssueDemo.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "student", catalog = "test")
public class Student implements java.io.Serializable {

	// Fields

	private Integer id;
	private Teacher teacher;
	private String name;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** full constructor */
	public Student(Teacher teacher, String name) {
		this.teacher = teacher;
		this.name = name;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "teacher_id")
	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}