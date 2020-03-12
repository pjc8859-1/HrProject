package cn.storm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.storm.pojo.ConfigMajor;

@Repository
public interface ConfigMajorMapper {
	public boolean saveConfigMajor(ConfigMajor configMajor);
	public List<ConfigMajor> selectAllConfigMajor();
	public ConfigMajor selectConfigMajorByfsk_id(int sid);
	public boolean deleteConfigMajorByfsk_id(int sid);
	public int updateConfigMajor(ConfigMajor configMajor);
}
