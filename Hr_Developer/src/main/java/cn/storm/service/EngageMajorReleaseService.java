package cn.storm.service;

import java.util.List;

import cn.storm.pojo.EngageMajorRelease;

public interface EngageMajorReleaseService {
	
	public boolean addEngageMajorRelease(EngageMajorRelease engagemajorrelease);
	public List<EngageMajorRelease> queryAllEngageMajorRelease();
	public EngageMajorRelease queryEngageMajorReleaseBymreId(int mreId);
	public boolean removeEngageMajorReleaseBymreId(int mreId);
	public int modifyEngageMajorRelease(EngageMajorRelease engagemajorrelease);
}
