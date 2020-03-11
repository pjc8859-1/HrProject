package cn.storm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.storm.mapper.MajorChangeMapper;
import cn.storm.mapper.SalaryGrantDetailsMapper;
import cn.storm.pojo.MajorChange;
import cn.storm.pojo.SalaryGrantDetails;
import cn.storm.service.MajorChangeService;
@Service
public class MajorChangeServiceImpl implements MajorChangeService{
	@Autowired
private MajorChangeMapper mapper=null;

	@Override
	public boolean addMajorChange(MajorChange majorChange) {
		return this.mapper.saveMajorChange(majorChange);
	}

	@Override
	public List<MajorChange> queryAllMajorChange() {
		return this.mapper.selectAllMajorChange();
	}

	@Override
	public MajorChange querySMajorChangeMchId(int mchid) {
		return this.mapper.selectMajorChangeByMchId(mchid);
	}

	@Override
	public boolean removeMajorChangeByMchId(int mchid) {
		return this.mapper.deleteMajorChangeByMchId(mchid);
	}

	@Override
	public int modifyMajorChange(MajorChange majorchange) {
		return this.mapper.updateMajorChange(majorchange);
	}

}
