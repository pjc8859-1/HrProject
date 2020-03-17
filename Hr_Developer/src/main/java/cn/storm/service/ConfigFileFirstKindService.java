package cn.storm.service;

import java.util.List;

import cn.storm.pojo.ConfigFileFirstKind;

public interface ConfigFileFirstKindService {
	public boolean addConfigFileFirstKind(ConfigFileFirstKind configFileFirstKind);

	public List<ConfigFileFirstKind> queryAllConfigFileFirstKind();

	public ConfigFileFirstKind queryConfigFileFirstKindByffkId(int ffkId);

	public boolean removeConfigFileFirstKindByffkId(int ffkId);

	public int modifyConfigFileFirstKind(ConfigFileFirstKind configFileFirstKind);
	
	public List<ConfigFileFirstKind> queryConfigFileFirstKindByName(String name);
	public int queryMaxId();
}
