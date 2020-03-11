package cn.storm.service;

import java.util.List;

import cn.storm.pojo.HumanFile;
import cn.storm.pojo.Student1;

public interface HumanFileService {
	public boolean addHumanFile(HumanFile humanFile);
	public List<HumanFile> queryAllHumanFile();
	public HumanFile queryHumanFileByHufid(int hufid);
	public boolean removeHumanFileByhufid(int hufid);
	public int modifyHumanFile(HumanFile humanFile);
}