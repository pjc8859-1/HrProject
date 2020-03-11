package cn.storm.service;

import java.util.List;

import cn.storm.pojo.Student1;

public interface BonusService {
	public boolean addStudent(Student1 student);
	public List<Student1> queryAllStudent();
	public Student1 queryStudentBySid(int sid);
	public boolean removeStudentBySid(int sid);
	public int modifyStudent(Student1 student);
}
