
package cn.storm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.storm.mapper.ConfigMajorMapper;
import cn.storm.pojo.ConfigMajor;
import cn.storm.service.ConfigMajorService;

@Service

public class ConfigMajorServiceImpl implements ConfigMajorService {

	@Autowired
	ConfigMajorMapper mapper = null;
	
	@Override
	public boolean addConfigMajor(ConfigMajor configMajor) {
		// TODO Auto-generated method stub
		return mapper.saveConfigMajor(configMajor);
	}

	@Override
	public List<ConfigMajor> queryAllConfigMajor() {
		// TODO Auto-generated method stub
		return mapper.selectAllConfigMajor();
	}

	@Override
	public ConfigMajor queryConfigMajorBymakId(int makid) {
		// TODO Auto-generated method stub
		return mapper.selectConfigMajorByfsk_id(makid);
	}

	@Override
	public boolean removeConfigMajorBymakId(int makid) {
		// TODO Auto-generated method stub
		return mapper.deleteConfigMajorByfsk_id(makid);
	}

	@Override
	public int updateConfigMajor(ConfigMajor configMajor) {
		// TODO Auto-generated method stub
		return mapper.updateConfigMajor(configMajor);
	}

}

