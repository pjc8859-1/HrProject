package cn.storm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.storm.pojo.Bonus;


@Repository
public interface BonusMapper {
	public boolean saveBonus(Bonus Bonus);
	public List<Bonus> selectAllBonus();
	public Bonus selectBonusBybonId(int bonid);
	public boolean deleteBonusBybonId(int bonid);
	public int updateBonus(Bonus bonus);
}
