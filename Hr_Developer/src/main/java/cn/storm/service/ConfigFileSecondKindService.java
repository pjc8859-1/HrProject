package cn.storm.service;

import java.util.List;

import cn.storm.pojo.ConfigFileSecondKind;

public interface ConfigFileSecondKindService {
	public boolean addConfigFileSecondKind(ConfigFileSecondKind configFileSecondKind);

	public List<ConfigFileSecondKind> queryAllConfigFileSecondKind();

	public ConfigFileSecondKind queryConfigFileSecondKindByfskId(int fskId);

	public boolean removeConfigFileSecondKindByfskId(int fskId);

	public int modifyConfigFileSecondKind(ConfigFileSecondKind configFileSecondKind);
}
