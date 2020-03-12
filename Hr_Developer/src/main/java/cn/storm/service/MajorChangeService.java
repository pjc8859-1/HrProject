package cn.storm.service;

import java.util.List;

import cn.storm.pojo.MajorChange;

public interface MajorChangeService {
	public boolean addMajorChange(MajorChange majorChange);
	public List<MajorChange> queryAllMajorChange();
	public MajorChange querySMajorChangeMchId(int mchid);
	public boolean removeMajorChangeByMchId(int mchid);
	public int modifyMajorChange(MajorChange majorchange);
}
