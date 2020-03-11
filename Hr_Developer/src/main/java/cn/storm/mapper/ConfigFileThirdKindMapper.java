package cn.storm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.storm.pojo.ConfigFileThirdKind;

@Repository
public interface ConfigFileThirdKindMapper {
	public boolean saveConfigFileThirdKind(
			ConfigFileThirdKind configfilethirdkind);

	public List<ConfigFileThirdKind> selectAllConfigFileThirdKind();

	public ConfigFileThirdKind selectConfigFileThirdKindByftkId(int ftkId);

	public boolean deleteConfigFileThirdKindByftkId(int ftkId);

	public int updateConfigFileThirdKind(ConfigFileThirdKind configfilethirdkind);
}
