package cn.storm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.storm.mapper.ConfigQuestionFirstKindMapper;
import cn.storm.pojo.ConfigQuestionFirstKind;
import cn.storm.service.ConfigQuestionFirstKindService;

@Service
public class ConfigQuestionFirstKindServiceImpl implements
		ConfigQuestionFirstKindService {
	@Autowired
	private ConfigQuestionFirstKindMapper mapper = null;

	@Override
	public boolean addConfigQuestionFirstKind(
			ConfigQuestionFirstKind configquestionfirstkind) {
		return mapper.saveConfigQuestionFirstKind(configquestionfirstkind);
	}

	@Override
	public List<ConfigQuestionFirstKind> queryAllConfigQuestionFirstKind() {
		return mapper.selectAllConfigQuestionFirstKind();
	}

	@Override
	public ConfigQuestionFirstKind queryConfigQuestionFirstKindByqfkId(int qfkId) {
		return mapper.selectConfigQuestionFirstKindByqfkId(qfkId);
	}

	@Override
	public boolean removeConfigQuestionFirstKindByqfkId(int qfkId) {
		return mapper.deleteConfigQuestionFirstKindByqfkId(qfkId);
	}

	@Override
	public int modifyConfigQuestionFirstKind(
			ConfigQuestionFirstKind configquestionfirstkind) {
		return mapper.updateConfigQuestionFirstKind(configquestionfirstkind);
	}
	@Override
	public int queryMaxId() {
		// TODO Auto-generated method stub
		return mapper.selectMaxId();
	}

}
