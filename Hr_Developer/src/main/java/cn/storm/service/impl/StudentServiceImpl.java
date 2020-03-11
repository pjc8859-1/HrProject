package cn.storm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.storm.mapper.StudentMapper;
import cn.storm.pojo.Student;
import cn.storm.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentMapper studentMapper = null;
	
	@Override
	public boolean addStudent(Student student) {
		
		return studentMapper.saveStudent(student);
	}

	@Override
	public List<Student> queryAllStudent() {
		// TODO Auto-generated method stub
		return studentMapper.selectAllStudent();
	}

	@Override
	public Student queryStudentBySid(int sid) {
		// TODO Auto-generated method stub
		return studentMapper.selectStudentBySid(sid);
	}

	@Override
	public boolean removeStudentBySid(int sid) {
		// TODO Auto-generated method stub
		return studentMapper.deleteStudentBySid(sid);
	}

	@Override
	public int modifyStudent(Student student) {
		return studentMapper.updateStudent(student);
	}

}
