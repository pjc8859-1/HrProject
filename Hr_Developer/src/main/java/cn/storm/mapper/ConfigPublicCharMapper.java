package cn.storm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.storm.pojo.ConfigPublicChar;

@Repository
public interface ConfigPublicCharMapper {
	public boolean saveConfigPublicChar(ConfigPublicChar configpublicchar);

	public List<ConfigPublicChar> selectAllConfigPublicChar();

	public ConfigPublicChar selectConfigPublicCharBypbcId(int pbcId);

	public boolean deleteConfigPublicCharBypbcId(int pbcId);

	public int updateConfigPublicChar(ConfigPublicChar configpublicchar);
	
	public List<ConfigPublicChar> selectConfigPublicCharByKey(String key);
}
