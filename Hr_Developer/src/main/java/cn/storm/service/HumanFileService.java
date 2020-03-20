package cn.storm.service;

import java.util.List;

import cn.storm.dto.MajorManagerDto;
import cn.storm.pojo.HumanFile;

public interface HumanFileService {
	public boolean addHumanFile(HumanFile humanFile);
	public List<HumanFile> queryAllHumanFile();
	public HumanFile queryHumanFileByHufid(int hufid);
	public boolean removeHumanFileByhufid(int hufid);
	public int modifyHumanFile(HumanFile humanFile);
	public List<HumanFile> queryByCondition(MajorManagerDto mmd);
	public List<HumanFile> queryAllHumanFileBycheckstu();
	boolean addHumanFiles(HumanFile humanfile);
	
	public HumanFile queryByhumanid(String huid);
}
