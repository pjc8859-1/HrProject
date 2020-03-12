package cn.storm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.storm.pojo.HumanFileDig;
@Repository
public interface HumanFileDigMapper {
	public boolean saveHumanFileDig(HumanFileDig humanFiledig);

	public List<HumanFileDig> selectAllHumanFileDig();

	public HumanFileDig selectHumanFileDigByhfdId(int hfId);

	public boolean deleteHumanFileDigByhfId(int hfId);

	public int updateHumanFileDig(HumanFileDig humanFiledig);

}
