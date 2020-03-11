package cn.storm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.storm.pojo.EngageAnswer;
import cn.storm.pojo.EngageAnswerDetails;
import cn.storm.pojo.Users;

@Repository
public interface EngageAnswerDetailsMapper {
	public boolean saveEngageAnswerDetails(EngageAnswerDetails engageanswerdetails);
	public List<EngageAnswerDetails> selectAllEngageAnswerDetails();
	public EngageAnswerDetails selectEngageAnswerDetailsByAnsId(int ansid);
	public boolean deleteEngageAnswerDetailsByAnsId(int ansid);
	public int updateEngageAnswerDetails(EngageAnswerDetails engageanswerdetails);
}
