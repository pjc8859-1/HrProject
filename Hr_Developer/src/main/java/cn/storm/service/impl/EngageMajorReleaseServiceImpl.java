package cn.storm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.storm.mapper.EngageMajorReleaseMapper;
import cn.storm.pojo.EngageMajorRelease;
import cn.storm.service.EngageMajorReleaseService;
@Service
public class EngageMajorReleaseServiceImpl implements EngageMajorReleaseService {
	@Autowired
	private EngageMajorReleaseMapper mapper = null;
	
	@Override
	public boolean addEngageMajorRelease(EngageMajorRelease engagemajorrelease) {

		return this.mapper.saveEngageMajorRelease(engagemajorrelease);
	}

	@Override
	public List<EngageMajorRelease> queryAllEngageMajorRelease() {
		return this.mapper.selectAllEngageMajorRelease();
	}

	@Override
	public EngageMajorRelease queryEngageMajorReleaseBymreId(int mreId) {
		return this.mapper.selectEngageMajorReleaseBymreid(mreId);
	}

	@Override
	public boolean removeEngageMajorReleaseBymreId(int mreId) {
		return this.mapper.deleteEngageMajorReleaseBymreid(mreId);
	}

	@Override
	public int modifyEngageMajorRelease(EngageMajorRelease engagemajorrelease) {
		return this.mapper.updateEngageMajorRelease(engagemajorrelease);
	}

}
