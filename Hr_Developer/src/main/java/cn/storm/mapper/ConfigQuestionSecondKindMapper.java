package cn.storm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.storm.pojo.ConfigQuestionSecondKind;

@Repository
public interface ConfigQuestionSecondKindMapper {

	public boolean saveConfigQuestionSecondKind(
			ConfigQuestionSecondKind configquestionsecondkind);

	public List<ConfigQuestionSecondKind> selectAllConfigQuestionSecondKind();

	public ConfigQuestionSecondKind selectConfigQuestionSecondKindByqskId(
			int qskId);

	public boolean deleteConfigQuestionSecondKindByqskId(int qskId);

	public int updateConfigQuestionSecondKind(
			ConfigQuestionSecondKind configquestionsecondkind);

}
