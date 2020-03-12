package cn.storm.service;

import java.util.List;

import cn.storm.pojo.EngageSubjects;
import cn.storm.pojo.SalaryGrantDetails;

public interface EngageSubjectsService {
	public boolean addEngageSubjects(EngageSubjects engagesubjects);
	public List<EngageSubjects> queryAllEngageSubjects();
	public EngageSubjects queryEngageSubjectssubId(int subid);
	public boolean removeEngageSubjectsBysubId(int subid);
	public int modifyEngageSubjects(EngageSubjects engagesubjects);
}
