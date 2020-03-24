package cn.storm.service;

import java.util.List;

import cn.storm.pojo.ConfigQuestionSecondKind;

public interface ConfigQuestionSecondKindService {
	public boolean addConfigQuestionSecondKind(
			ConfigQuestionSecondKind configquestionsecondkind);

	public List<ConfigQuestionSecondKind> queryAllConfigQuestionSecondKind();

	public ConfigQuestionSecondKind queryConfigQuestionSecondKindByqskId(
			int qskId);

	public boolean removeConfigQuestionSecondKindByqskId(int qskId);

	public int modifyConfigQuestionSecondKind(
			ConfigQuestionSecondKind configquestionsecondkind);
	public int queryMaxId();
}
