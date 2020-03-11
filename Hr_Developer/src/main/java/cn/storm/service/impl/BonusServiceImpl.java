package cn.storm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.storm.mapper.BonusMapper;
import cn.storm.pojo.Bonus;
import cn.storm.service.BonusService;

@Service

public class BonusServiceImpl implements BonusService{
	@Autowired
	private BonusMapper mapper = null;
	@Override
	public boolean addBonus(Bonus bonus) {
		// TODO Auto-generated method stub
		return this.mapper.saveBonus(bonus);
	}

	@Override
	public List<Bonus> queryAllBonus() {
		return this.mapper.selectAllBonus();
	}

	@Override
	public Bonus queryBonusBybonId(int bonId) {
		return this.mapper.selectBonusBybonId(bonId);
	}

	@Override
	public boolean removeBonusBybonId(int bonId) {
		return this.mapper.deleteBonusBybonId(bonId);
	}

	@Override
	public int modifyBonus(Bonus bonus) {
		return this.mapper.updateBonus(bonus);
	}

}
