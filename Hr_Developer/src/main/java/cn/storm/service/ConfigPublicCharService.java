package cn.storm.service;

import java.util.List;

import cn.storm.pojo.ConfigPublicChar;

public interface ConfigPublicCharService {
	public boolean addConfigPublicChar(ConfigPublicChar configpublicchar);

	public List<ConfigPublicChar> queryAllConfigPublicChar();

	public ConfigPublicChar queryConfigPublicCharBypbcId(int pbcId);

	public boolean removeConfigPublicCharBypbcId(int pbcId);

	public int modifyConfigPublicChar(ConfigPublicChar configpublicchar);
	
	public List<ConfigPublicChar> queryConfigPublicCharByKey(String key);
}
