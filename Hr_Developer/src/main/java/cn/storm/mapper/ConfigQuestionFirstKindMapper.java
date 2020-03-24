package cn.storm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.storm.pojo.ConfigQuestionFirstKind;

@Repository
public interface ConfigQuestionFirstKindMapper {
	public boolean saveConfigQuestionFirstKind(
			ConfigQuestionFirstKind configquestionfirstkind);

	public List<ConfigQuestionFirstKind> selectAllConfigQuestionFirstKind();

	public ConfigQuestionFirstKind selectConfigQuestionFirstKindByqfkId(
			int qfkId);

	public boolean deleteConfigQuestionFirstKindByqfkId(int qfkId);

	public int updateConfigQuestionFirstKind(
			ConfigQuestionFirstKind configquestionfirstkind);
	public int selectMaxId();
}
