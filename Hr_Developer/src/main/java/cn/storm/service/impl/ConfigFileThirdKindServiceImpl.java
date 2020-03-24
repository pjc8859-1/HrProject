package cn.storm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.storm.mapper.ConfigFileThirdKindMapper;
import cn.storm.pojo.ConfigFileThirdKind;
import cn.storm.service.ConfigFileThirdKindService;

@Service
public class ConfigFileThirdKindServiceImpl implements
		ConfigFileThirdKindService {
	@Autowired
	private ConfigFileThirdKindMapper mapper = null;

	@Override
	public boolean addConfigFileThirdKind(
			ConfigFileThirdKind configfilethirdkind) {
		return mapper.saveConfigFileThirdKind(configfilethirdkind);
	}

	@Override
	public List<ConfigFileThirdKind> queryAllConfigFileThirdKind() {
		return mapper.selectAllConfigFileThirdKind();
	}

	@Override
	public ConfigFileThirdKind queryConfigFileThirdKindByftkId(int ftkId) {
		return mapper.selectConfigFileThirdKindByftkId(ftkId);
	}

	@Override
	public boolean removeConfigFileThirdKindByftkId(int ftkId) {
		return mapper.deleteConfigFileThirdKindByftkId(ftkId);
	}

	@Override
	public int modifyConfigFileThirdKind(ConfigFileThirdKind configfilethirdkind) {
		return mapper.updateConfigFileThirdKind(configfilethirdkind);
	}

	@Override
	public int queryMaxId() {
		// TODO Auto-generated method stub
		return mapper.selectMaxId();
	}

	@Override
	public String querryNamesByFirstSceondThrid(String firstId,
			String secondId, String thridId) {
		// TODO Auto-generated method stub
		return mapper.selectNamesByIds(firstId, secondId, thridId);
	}
}
