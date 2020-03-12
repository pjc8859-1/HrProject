package cn.storm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.storm.mapper.HumanFileDigMapper;
import cn.storm.mapper.HumanFileMapper;
import cn.storm.pojo.HumanFileDig;
import cn.storm.service.HumanFileDigService;
@Service
public class HumanFileDigServiceImpl implements HumanFileDigService{
	@Autowired
private HumanFileDigMapper mapper=null;
	@Override
	public boolean addHumanFileDig(HumanFileDig humanFileDig) {
		// TODO Auto-generated method stub
		return mapper.saveHumanFileDig(humanFileDig);
	}

	@Override
	public List<HumanFileDig> queryAllHumanFileDig() {
		// TODO Auto-generated method stub
		return mapper.selectAllHumanFileDig();
	}

	@Override
	public HumanFileDig queryHumanFileDigByHfdid(int hfdid) {
		// TODO Auto-generated method stub
		return mapper.selectHumanFileDigByhfdId(hfdid);
	}

	@Override
	public boolean removeHumanFileDigByhfdid(int hfdid) {
		// TODO Auto-generated method stub
		return mapper.deleteHumanFileDigByhfId(hfdid);
	}

	@Override
	public int modifyHumanFileDig(HumanFileDig humanFileDig) {
		// TODO Auto-generated method stub
		return mapper.updateHumanFileDig(humanFileDig);
	}

}
