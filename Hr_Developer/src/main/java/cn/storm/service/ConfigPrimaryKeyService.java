package cn.storm.service;

import java.util.List;

import cn.storm.pojo.ConfigPrimaryKey;

public interface ConfigPrimaryKeyService {
	public boolean addConfigPrimaryKey(ConfigPrimaryKey configprimarykey);

	public List<ConfigPrimaryKey> queryAllConfigPrimaryKey();

	public ConfigPrimaryKey queryConfigPrimaryKeyByprkId(int prkId);

	public boolean removeConfigPrimaryKeyByprkId(int prkId);

	public int modifyConfigPrimaryKey(ConfigPrimaryKey configprimarykey);
}
