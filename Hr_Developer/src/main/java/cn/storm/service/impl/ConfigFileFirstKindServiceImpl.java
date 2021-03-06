package cn.storm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.storm.mapper.ConfigFileFirstKindMapper;
import cn.storm.pojo.ConfigFileFirstKind;
import cn.storm.service.ConfigFileFirstKindService;

@Service
public class ConfigFileFirstKindServiceImpl implements
		ConfigFileFirstKindService {

	@Autowired
	private ConfigFileFirstKindMapper mapper = null;

	@Override
	public List<ConfigFileFirstKind> queryConfigFileFirstKindByName(String name) {
		// TODO Auto-generated method stub
		return mapper.selectConfigFileFirstKindByName(name);
	}

	@Override
	public boolean addConfigFileFirstKind(
			ConfigFileFirstKind configFileFirstKind) {
		// TODO Auto-generated method stub
		return mapper.saveConfigFileFirstKind(configFileFirstKind);
	}

	@Override
	public List<ConfigFileFirstKind> queryAllConfigFileFirstKind() {
		// TODO Auto-generated method stub
		return mapper.selectAllConfigFileFirstKind();
	}

	@Override
	public ConfigFileFirstKind queryConfigFileFirstKindByffkId(int ffkId) {
		// TODO Auto-generated method stub
		return mapper.selectConfigFileFirstKindByffk_id(ffkId);
	}

	@Override
	public boolean removeConfigFileFirstKindByffkId(int ffkId) {
		// TODO Auto-generated method stub
		return mapper.deleteConfigFileFirstKindByffk_id(ffkId);
	}

	@Override
	public int modifyConfigFileFirstKind(ConfigFileFirstKind configFileFirstKind) {
		// TODO Auto-generated method stub
		return mapper.updateConfigFileFirstKind(configFileFirstKind);
	}

	@Override
	public int queryMaxId() {
		// TODO Auto-generated method stub
		return mapper.selectMaxId();
	}

	@Override
	public String selectIdByNames(String names) {
		// TODO Auto-generated method stub
		return mapper.selectIdByNanmes(names);
	}

}
