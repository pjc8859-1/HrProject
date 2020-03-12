package cn.storm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.storm.pojo.Student;


@Repository
public interface StudentMapper {
	
	
	public boolean saveStudent(Student student);
	public List<Student> selectAllStudent();
	public Student selectStudentBySid(int sid);
	public boolean deleteStudentBySid(int sid);
	public int updateStudent(Student student);
}
