package cn.storm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.storm.mapper.ConfigMajorKindMapper;
import cn.storm.pojo.ConfigMajorKind;
import cn.storm.service.ConfigMajorKindService;

@Service

public class ConfigMajorKindServiceImpl implements ConfigMajorKindService {

	@Autowired
	ConfigMajorKindMapper mapper = null ;
	
	@Override
	public boolean addConfigMajorKind(ConfigMajorKind configMajorKind) {
		// TODO Auto-generated method stub
		return mapper.saveConfigMajorKind(configMajorKind);
	}

	@Override
	public List<ConfigMajorKind> queryAllConfigMajorKind() {
		// TODO Auto-generated method stub
		return mapper.selectAllConfigMajorKind();
	}

	@Override
	public ConfigMajorKind queryConfigMajorKindBymfkId(int mfkud) {
		// TODO Auto-generated method stub
		return mapper.selectConfigMajorKindByfsk_id(mfkud);
	}

	@Override
	public boolean removeConfigMajorKindBymfkId(int mfkud) {
		// TODO Auto-generated method stub
		return mapper.deleteConfigMajorKindByfsk_id(mfkud);
	}

	@Override
	public int updateConfigMajorKind(ConfigMajorKind configMajorKind) {
		// TODO Auto-generated method stub
		return mapper.updateConfigMajorKind(configMajorKind);
	}
	
	@Override
	public String querryIdByNames(String names) {
		// TODO Auto-generated method stub
		return mapper.selectIdByNames(names);
	}
	
	@Override
	public int queryMaxId() {
		// TODO Auto-generated method stub
		return mapper.selectMaxId();
	}


}
