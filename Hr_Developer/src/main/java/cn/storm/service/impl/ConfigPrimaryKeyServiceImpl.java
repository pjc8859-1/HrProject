package cn.storm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.storm.mapper.ConfigPrimaryKeyMapper;
import cn.storm.pojo.ConfigPrimaryKey;
import cn.storm.service.ConfigPrimaryKeyService;

@Service
public class ConfigPrimaryKeyServiceImpl implements ConfigPrimaryKeyService {
	@Autowired
	private ConfigPrimaryKeyMapper mapper = null;

	@Override
	public boolean addConfigPrimaryKey(ConfigPrimaryKey configprimarykey) {
		return mapper.saveConfigPrimaryKey(configprimarykey);
	}

	@Override
	public List<ConfigPrimaryKey> queryAllConfigPrimaryKey() {
		return mapper.selectAllConfigPrimaryKey();
	}

	@Override
	public ConfigPrimaryKey queryConfigPrimaryKeyByprkId(int prkId) {
		return mapper.selectConfigPrimaryKeyByftkId(prkId);
	}

	@Override
	public boolean removeConfigPrimaryKeyByprkId(int prkId) {
		return mapper.deleteConfigPrimaryKeyByftkId(prkId);
	}

	@Override
	public int modifyConfigPrimaryKey(ConfigPrimaryKey configprimarykey) {
		return mapper.updateConfigPrimaryKey(configprimarykey);
	}
}
