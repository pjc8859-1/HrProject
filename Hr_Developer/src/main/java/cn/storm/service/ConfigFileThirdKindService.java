package cn.storm.service;

import java.util.List;

import cn.storm.pojo.ConfigFileThirdKind;

public interface ConfigFileThirdKindService {
	public boolean addConfigFileThirdKind(
			ConfigFileThirdKind configfilethirdkind);

	public List<ConfigFileThirdKind> queryAllConfigFileThirdKind();

	public ConfigFileThirdKind queryConfigFileThirdKindByftkId(int ftkId);

	public boolean removeConfigFileThirdKindByftkId(int ftkId);

	public int modifyConfigFileThirdKind(ConfigFileThirdKind configfilethirdkind);

	public int queryMaxId();

	public String querryNamesByFirstSceondThrid(String firstId,
			String secondId, String thridId);

}
