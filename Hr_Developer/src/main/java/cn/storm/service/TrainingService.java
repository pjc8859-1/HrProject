package cn.storm.service;

import java.util.List;

import cn.storm.pojo.Training;
import cn.storm.pojo.Users;

public interface TrainingService {
	public boolean addTraining(Training training);
	public List<Training> queryAllTraining();
	public Training queryTrainingByTid(int tid);
	public boolean removeTrainingByTid(int tid);
	public int modifyTraining(Training training);
}
