package cn.storm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.storm.mapper.TrainingMapper;
import cn.storm.pojo.Training;
import cn.storm.service.TrainingService;

@Service
public class TrainingServiceImpl implements TrainingService{
	@Autowired
	private TrainingMapper mapper=null;
    
	
	@Override
	public boolean addTraining(Training training) {
		// TODO Auto-generated method stub
		return mapper.saveTraining(training);
	}

	@Override
	public List<Training> queryAllTraining() {
		// TODO Auto-generated method stub
		return mapper.selectAllTraining();
	}

	@Override
	public Training queryTrainingByTid(int tid) {
		// TODO Auto-generated method stub
		return mapper.selectTrainingByTid(tid);
	}

	@Override
	public boolean removeTrainingByTid(int tid) {
		// TODO Auto-generated method stub
		return mapper.deleteTrainingByTid(tid);
	}

	@Override
	public int modifyTraining(Training training) {
		// TODO Auto-generated method stub
		return mapper.updateTraining(training);
	}

}
