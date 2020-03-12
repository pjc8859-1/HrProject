package cn.storm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.storm.pojo.ConfigFileSecondKind;

@Repository
public interface ConfigFileSecondKindMapper {
	public boolean saveConfigFileSecondKind(ConfigFileSecondKind configFileSecondKind);
	public List<ConfigFileSecondKind> selectAllConfigFileSecondKind();
	public ConfigFileSecondKind selectConfigFileSecondKindByfsk_id(int sid);
	public boolean deleteConfigFileSecondKindByfsk_id(int sid);
	public int updateConfigFileSecondKind(ConfigFileSecondKind configFileSecondKind);
}
