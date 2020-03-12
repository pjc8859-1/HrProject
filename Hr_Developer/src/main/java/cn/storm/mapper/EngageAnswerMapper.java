package cn.storm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.storm.pojo.EngageAnswer;
import cn.storm.pojo.Users;

@Repository
public interface EngageAnswerMapper {
	public boolean saveEngageAnswer(EngageAnswer engageanswer);

	public List<EngageAnswer> selectAllEngageAnswer();

	public Users selectEngageAnswerByAnsId(int ansid);

	public boolean deleteEngageAnswerByAnsId(int ansid);

	public int updateEngageAnswer(EngageAnswer engageanswer);
}
