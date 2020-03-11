package cn.storm.service;

import java.util.List;

import cn.storm.pojo.Bonus;

public interface BonusService {
	public boolean addBonus(Bonus bonus);
	public List<Bonus> queryAllBonus();
	public Bonus queryBonusBybonId(int bonId);
	public boolean removeBonusBybonId(int bonId);
	public int modifyBonus(Bonus bonus);
}
