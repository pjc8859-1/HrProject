package cn.storm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.storm.pojo.ConfigMajorKind;
@Repository
public interface ConfigMajorKindMapper {
	public boolean saveConfigMajorKind(ConfigMajorKind configMajorKind);
	public List<ConfigMajorKind> selectAllConfigMajorKind();
	public ConfigMajorKind selectConfigMajorKindByfsk_id(int sid);
	public boolean deleteConfigMajorKindByfsk_id(int sid);
	public int updateConfigMajorKind(ConfigMajorKind configMajorKind);
	public int selectMaxId();
	public String selectIdByNames(String id);

}
