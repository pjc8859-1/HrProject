package cn.storm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.storm.pojo.EngageMajorRelease;
@Repository
public interface EngageMajorReleaseMapper {
	public boolean saveEngageMajorRelease(EngageMajorRelease engagemajorrelease);

	public List<EngageMajorRelease> selectAllEngageMajorRelease();

	public EngageMajorRelease selectEngageMajorReleaseBymreid(int mreid);

	public boolean deleteEngageMajorReleaseBymreid(int mreid);

	public int updateEngageMajorRelease(EngageMajorRelease engagemajorrelease);
}
