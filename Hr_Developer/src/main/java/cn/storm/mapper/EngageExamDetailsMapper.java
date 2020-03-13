package cn.storm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.storm.pojo.EngageExamDetails;


@Repository
public interface EngageExamDetailsMapper {
	
	public boolean saveEngageExamDetails(EngageExamDetails engageExamDetails);
	public List<EngageExamDetails> selectAllEngageExamDetails();
	public EngageExamDetails selectEngageExamDetailsByexd_id(int sid);
	public boolean deleteEngageExamDetailsByexd_id(int sid);
	public int updateEngageExamDetails(EngageExamDetails engageExamDetails);
}
