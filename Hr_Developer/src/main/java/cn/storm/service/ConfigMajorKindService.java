package cn.storm.service;

import java.util.List;

import cn.storm.pojo.ConfigMajorKind;

public interface ConfigMajorKindService {
public boolean addConfigMajorKind(ConfigMajorKind configMajorKind);
	
	public List<ConfigMajorKind> queryAllConfigMajorKind();
	
	public ConfigMajorKind queryConfigMajorKindBymfkId(int mfkud);
	
	public boolean removeConfigMajorKindBymfkId(int mfkud);
	
	public int updateConfigMajorKind(ConfigMajorKind configMajorKind);
}
