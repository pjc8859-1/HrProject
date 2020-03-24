package cn.storm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.storm.mapper.ConfigQuestionSecondKindMapper;
import cn.storm.pojo.ConfigQuestionSecondKind;
import cn.storm.service.ConfigQuestionSecondKindService;

@Service
public class ConfigQuestionSecondKindServiceImpl implements
		ConfigQuestionSecondKindService {
	@Autowired
	private ConfigQuestionSecondKindMapper mapper = null;

	@Override
	public boolean addConfigQuestionSecondKind(
			ConfigQuestionSecondKind configquestionsecondkind) {
		return mapper.saveConfigQuestionSecondKind(configquestionsecondkind);
	}

	@Override
	public List<ConfigQuestionSecondKind> queryAllConfigQuestionSecondKind() {
		return mapper.selectAllConfigQuestionSecondKind();
	}

	@Override
	public ConfigQuestionSecondKind queryConfigQuestionSecondKindByqskId(
			int qskId) {
		return mapper.selectConfigQuestionSecondKindByqskId(qskId);
	}

	@Override
	public boolean removeConfigQuestionSecondKindByqskId(int qskId) {
		// TODO Auto-generated method stub
		return mapper.deleteConfigQuestionSecondKindByqskId(qskId);
	}

	@Override
	public int modifyConfigQuestionSecondKind(
			ConfigQuestionSecondKind configquestionsecondkind) {
		return mapper.updateConfigQuestionSecondKind(configquestionsecondkind);
	}
	
	@Override
	public int queryMaxId() {
		// TODO Auto-generated method stub
		return mapper.selectMaxId();
	}

}
