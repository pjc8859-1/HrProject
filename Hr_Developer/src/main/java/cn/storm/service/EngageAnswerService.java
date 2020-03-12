package cn.storm.service;

import java.util.List;

import cn.storm.pojo.EngageAnswer;
import cn.storm.pojo.Users;

public interface EngageAnswerService {
	
	public boolean addEngageAnswer(EngageAnswer engageanswer);
	public List<EngageAnswer> queryAllEngageAnswer();
	public Users queryEngageAnswerByAnsId(int ansid);
	public boolean removeEngageAnswerByAnsId(int ansid);
	public int modifyEngageAnswer(Users users);
}
