package cn.storm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.storm.pojo.Bonus;


@Repository
public interface BonusMapper {
	public boolean saveBonus(Bonus Bonus);
	public List<Bonus> selectAllBonus();
	public Bonus selectBonusByBon_id(int sid);
	public boolean deleteBonusByBon_id(int sid);
	public int updateBonus(Bonus bonus);
}
