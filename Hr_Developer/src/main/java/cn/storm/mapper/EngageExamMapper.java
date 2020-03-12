package cn.storm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.storm.pojo.EngageExam;


@Repository
public interface EngageExamMapper {

	public boolean saveEngageExam(EngageExam engageExam);
	public List<EngageExam> selectAllEngageExam();
	public EngageExam selectEngageExamByexa_id(int sid);
	public boolean deleteEngageExamByexa_id(int sid);
	public int updateEngageExam(EngageExam engageExam);
	
}
