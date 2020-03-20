package cn.storm.mapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.storm.dto.MajorManagerDto;
import cn.storm.pojo.HumanFile;
@Repository
public interface HumanFileMapper {
	public boolean saveHumanFile(HumanFile humanFile);

	public List<HumanFile> selectAllHumanFile();
	
	public boolean saveHumainFiles(HumanFile humanfile);
	
	public List<HumanFile> selectAllHumanFileBycheckstu();


	public HumanFile selectHumanFileByhfId(int hfId);

	public boolean deleteHumanFileByhfId(int hfId);

	public int updateHumanFile(HumanFile humanFile);
	
	public List<HumanFile> selectByCondition(MajorManagerDto mmd);
}
