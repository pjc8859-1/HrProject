package cn.storm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.storm.dto.HumanFileQuerryDto;
import cn.storm.dto.MajorManagerDto;
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

	@Override
	public List<HumanFile> queryByCondition(MajorManagerDto mmd) {
		
		return this.mapper.selectByCondition(mmd);
	}

	@Override
	public boolean addHumanFiles(HumanFile humanfile) {
		// TODO Auto-generated method stub
		return mapper.saveHumainFiles(humanfile);
	}

	@Override
	public List<HumanFile> queryAllHumanFileBycheckstu() {
		// TODO Auto-generated method stub
		return mapper.selectAllHumanFileBycheckstu();
	}

	@Override
	public HumanFile queryByhumanid(String huid) {
		// TODO Auto-generated method stub
		return mapper.selectByhumanid(huid);
	}

	@Override
	public boolean modifysHumanFile(HumanFile humanfile) {
		// TODO Auto-generated method stub
		return mapper.upDateHumanFiles(humanfile);
	}

	@Override
	public List<HumanFile> querryByHumanFileDto(HumanFileQuerryDto mmd) {
		// TODO Auto-generated method stub
		return mapper.selectByHumanFileDto(mmd);
	}

	@Override
	public HumanFile querryHumanFileByNames(String names) {
		// TODO Auto-generated method stub
		return mapper.selectHumanFileByNames(names);
	}

	@Override
	public boolean modifyHumanFileChange(HumanFile humanfile) {
		// TODO Auto-generated method stub
		return mapper.upDateHumanFileChange(humanfile);
	}

	@Override
	public List<HumanFile> queryAllHumanFileByDeletestu(short a) {
		// TODO Auto-generated method stub
		return mapper.selectAllHumanFileByDeletestu(a);
	}

	@Override
	public boolean modifyHumanFilesWithDeleteStatus(HumanFile humanfile) {
		// TODO Auto-generated method stub
		return mapper.updateHumanFileDeleteStues(humanfile);
	}

	@Override
	public boolean modifyHumanFileRecovery(HumanFile humanfile) {
		// TODO Auto-generated method stub
		return mapper.updateHumanFileRecovery(humanfile);
	}

	@Override
	public boolean removeHumanFileByhuid(String huid) {
		// TODO Auto-generated method stub
		return mapper.deleteHumanFileByhuid(huid);
	}

}
