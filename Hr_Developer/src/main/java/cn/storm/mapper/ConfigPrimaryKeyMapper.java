package cn.storm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.storm.pojo.ConfigPrimaryKey;

@Repository
public interface ConfigPrimaryKeyMapper {
	public boolean saveConfigPrimaryKey(ConfigPrimaryKey configprimarykey);

	public List<ConfigPrimaryKey> selectAllConfigPrimaryKey();

	public ConfigPrimaryKey selectConfigPrimaryKeyByftkId(int prkId);

	public boolean deleteConfigPrimaryKeyByftkId(int prkId);

	public int updateConfigPrimaryKey(ConfigPrimaryKey configprimarykey);
}
