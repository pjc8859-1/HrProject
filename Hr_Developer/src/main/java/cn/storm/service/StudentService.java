package cn.storm.service;

import java.util.List;

import cn.storm.pojo.Student;

public interface StudentService {
	public boolean addStudent(Student student);
	public List<Student> queryAllStudent();
	public Student queryStudentBySid(int sid);
	public boolean removeStudentBySid(int sid);
}
