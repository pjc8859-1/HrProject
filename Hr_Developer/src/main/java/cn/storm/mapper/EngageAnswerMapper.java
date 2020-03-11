package cn.storm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.storm.pojo.EngageAnswer;

@Repository
public interface EngageAnswerMapper {
	public boolean saveEngageAnswer(EngageAnswer engageanswer);

	public List<EngageAnswer> selectAllEngageAnswer();

	public EngageAnswer selectEngageAnswerByansId(int ansId);

	public boolean deleteEngageAnswerByansId(int ansId);

	public int updateEngageAnswer(EngageAnswer engageanswer);
}
