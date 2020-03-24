package cn.storm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.storm.pojo.ConfigFileFirstKind;

@Repository
public interface ConfigFileFirstKindMapper {
	public boolean saveConfigFileFirstKind(
			ConfigFileFirstKind configFileFirstKind);

	public List<ConfigFileFirstKind> selectAllConfigFileFirstKind();

	public ConfigFileFirstKind selectConfigFileFirstKindByffk_id(int sid);

	public boolean deleteConfigFileFirstKindByffk_id(int sid);

	public int updateConfigFileFirstKind(ConfigFileFirstKind configFileFirstKind);

	public List<ConfigFileFirstKind> selectConfigFileFirstKindByName(String name);

	public int selectMaxId();

	public String selectIdByNanmes(String names);

}
