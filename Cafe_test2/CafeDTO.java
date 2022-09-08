package Cafe_test2;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CafeDTO implements Serializable {
	private String id;
	private String name;
	private String password;
	private String birthday;
	private String grade;
	private int point;

	// DATE
	private String fd = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));

	// GETTER/SETTER
	public String getFd() {
		return fd;
	}

	public void setFd(String fd) {
		this.fd = fd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "CafeDTO [name=" + name + ", birthday=" + birthday + ", fd=" + fd + ", id=" + id + ", password="
				+ password + ", grade=" + grade + ", point=" + point + "]";
	}

}
