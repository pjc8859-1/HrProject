package cn.storm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.storm.mapper.ConfigPublicCharMapper;
import cn.storm.pojo.ConfigPublicChar;
import cn.storm.service.ConfigPublicCharService;

@Service
public class ConfigPublicCharServiceImpl implements ConfigPublicCharService {
	@Autowired
	private ConfigPublicCharMapper mapper = null;

	@Override
	public boolean addConfigPublicChar(ConfigPublicChar configpublicchar) {
		return mapper.saveConfigPublicChar(configpublicchar);
	}

	@Override
	public List<ConfigPublicChar> queryAllConfigPublicChar() {
		return mapper.selectAllConfigPublicChar();
	}

	@Override
	public ConfigPublicChar queryConfigPublicCharBypbcId(int pbcId) {
		return mapper.selectConfigPublicCharBypbcId(pbcId);
	}

	@Override
	public boolean removeConfigPublicCharBypbcId(int pbcId) {
		return mapper.deleteConfigPublicCharBypbcId(pbcId);
	}

	@Override
	public int modifyConfigPublicChar(ConfigPublicChar configpublicchar) {
		return mapper.updateConfigPublicChar(configpublicchar);
	}
}
