package cn.storm.service;

import java.util.List;

import cn.storm.pojo.ConfigQuestionFirstKind;

public interface ConfigQuestionFirstKindService {
	public boolean addConfigQuestionFirstKind(
			ConfigQuestionFirstKind configquestionfirstkind);

	public List<ConfigQuestionFirstKind> queryAllConfigQuestionFirstKind();

	public ConfigQuestionFirstKind queryConfigQuestionFirstKindByqfkId(int qfkId);

	public boolean removeConfigQuestionFirstKindByqfkId(int qfkId);

	public int modifyConfigQuestionFirstKind(
			ConfigQuestionFirstKind configquestionfirstkind);
}
