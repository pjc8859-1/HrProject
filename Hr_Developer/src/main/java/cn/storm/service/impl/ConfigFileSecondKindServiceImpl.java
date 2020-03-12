package cn.storm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.storm.mapper.ConfigFileSecondKindMapper;
import cn.storm.pojo.ConfigFileSecondKind;
import cn.storm.service.ConfigFileSecondKindService;
@Service
public class ConfigFileSecondKindServiceImpl implements ConfigFileSecondKindService {
 
	@Autowired
	ConfigFileSecondKindMapper mapper = null;
	
	@Override
	public boolean addConfigFileSecondKind(
			ConfigFileSecondKind configFileSecondKind) {
		// TODO Auto-generated method stub
		return mapper.saveConfigFileSecondKind(configFileSecondKind);
	}

	@Override
	public List<ConfigFileSecondKind> queryAllConfigFileSecondKind() {
		// TODO Auto-generated method stub
		return mapper.selectAllConfigFileSecondKind();
	}

	@Override
	public ConfigFileSecondKind queryConfigFileSecondKindByfskId(int fskId) {
		// TODO Auto-generated method stub
		return mapper.selectConfigFileSecondKindByfsk_id(fskId);
	}

	@Override
	public boolean removeConfigFileSecondKindByfskId(int fskId) {
		// TODO Auto-generated method stub
		return mapper.deleteConfigFileSecondKindByfsk_id(fskId);
	}

	@Override
	public int modifyConfigFileSecondKind(
			ConfigFileSecondKind configFileSecondKind) {
		// TODO Auto-generated method stub
		return mapper.updateConfigFileSecondKind(configFileSecondKind);
	}

}
