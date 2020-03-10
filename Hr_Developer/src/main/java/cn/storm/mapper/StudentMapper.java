package cn.storm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.storm.pojo.Student;

//表单保存数据
//成功表格展示数据
//可以点击查看与删除
@Repository
public interface StudentMapper {
	public boolean saveStudent(Student student);
	public List<Student> selectAllStudent();
	public Student selectStudentBySid(int sid);
	public boolean deleteStudentBySid(int sid);
}
