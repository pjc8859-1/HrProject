package cn.storm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.storm.pojo.Student;
import cn.storm.pojo.Training;
@Repository
public interface TrainingMapper {
	public boolean saveTraining(Training training);
	public List<Training> selectAllTraining();
	public Training selectTrainingByTid(int tid);
	public boolean deleteTrainingByTid(int tid);
	public int updateTraining(Training training);
}
