package cn.storm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.storm.pojo.MajorChange;

@Repository
public interface MajorChangeMapper {
	public boolean saveMajorChange(MajorChange majorChange);
	public List<MajorChange> selectAllMajorChange();
	public MajorChange selectMajorChangeByMchId(int mchId);
	public boolean deleteMajorChangeByMchId(int mchId);
	public int updateMajorChange(MajorChange majorChange);
}
