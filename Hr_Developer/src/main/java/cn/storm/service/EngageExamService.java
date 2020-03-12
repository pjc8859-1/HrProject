package cn.storm.service;

import java.util.List;

import cn.storm.pojo.EngageExam;

public interface EngageExamService {

	
	public boolean addEngageExam(EngageExam engageExam);

	public List<EngageExam> queryAllEngageExam();

	public EngageExam queryEngageExamByexaId(int exaId);

	public boolean removeEngageExamByexaId(int exaId);

	public int modifyEngageExam(EngageExam engageExam);
}
