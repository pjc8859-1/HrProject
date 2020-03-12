package cn.storm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.storm.mapper.HumanFileMapper;
import cn.storm.pojo.HumanFile;
import cn.storm.service.HumanFileService;
@Service
public class HumanFileServiceImpl implements HumanFileService{
	@Autowired
private HumanFileMapper mapper=null;
	@Override
	public boolean addHumanFile(HumanFile humanFile) {
		// TODO Auto-generated method stub
		return mapper.saveHumanFile(humanFile);
	}

	@Override
	public List<HumanFile> queryAllHumanFile() {
		// TODO Auto-generated method stub
		return mapper.selectAllHumanFile();
	}

	@Override
	public HumanFile queryHumanFileByHufid(int hufid) {
		// TODO Auto-generated method stub
		return mapper.selectHumanFileByhfId(hufid);
	}

	@Override
	public boolean removeHumanFileByhufid(int hufid) {
		// TODO Auto-generated method stub
		return mapper.deleteHumanFileByhfId(hufid);
	}

	@Override
	public int modifyHumanFile(HumanFile humanFile) {
		// TODO Auto-generated method stub
		return mapper.updateHumanFile(humanFile);
	}

}
