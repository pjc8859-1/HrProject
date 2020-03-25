package cn.storm.service;

import java.util.List;

import cn.storm.dto.HumanFileQuerryDto;
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
	/**
	 * 通过档案更新humanfile
	 */
	public boolean modifysHumanFile(HumanFile humanfile);
	
	/**
	 * 人力资源档案变更
	 * @param mmd
	 * @return
	 */
	public boolean modifyHumanFileChange(HumanFile humanfile);
	
	public List<HumanFile> querryByHumanFileDto(HumanFileQuerryDto mmd);
	
	public HumanFile querryHumanFileByNames(String names);
	/**
	 * 人力资源档案删除，查询可删除的档案以及查询可恢复的档案
	 */
	public List<HumanFile> queryAllHumanFileByDeletestu(short a);
	/**
	 * 通过huid来删除档案
	 */
	public boolean modifyHumanFilesWithDeleteStatus(HumanFile humanfile);
	/**
	 * 通过huid来恢复档案
	 */
	public boolean modifyHumanFileRecovery(HumanFile humanfile);
	/**
	 * 永久删除
	 */
	public boolean removeHumanFileByhuid(String huid);
}
