package cn.storm.service;

import java.util.List;

import cn.storm.pojo.ConfigMajor;

public interface ConfigMajorService {
	
	public boolean addConfigMajor(ConfigMajor configMajor);
	
	public List<ConfigMajor> queryAllConfigMajor();
	
	public ConfigMajor queryConfigMajorBymakId(int makid);
	
	public boolean removeConfigMajorBymakId(int makid);
	
	public int updateConfigMajor(ConfigMajor configMajor);
	public String queryNamesByIds(String mkid,String mid);
	public int queryMaxId();
}

