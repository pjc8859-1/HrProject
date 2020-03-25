package cn.storm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.storm.dto.HumanFileQuerryDto;
import cn.storm.dto.MajorManagerDto;
import cn.storm.pojo.HumanFile;
@Repository
public interface HumanFileMapper {
	public boolean saveHumanFile(HumanFile humanFile);

	public List<HumanFile> selectAllHumanFile();
	
	public boolean saveHumainFiles(HumanFile humanfile);
	
	public List<HumanFile> selectAllHumanFileBycheckstu();


	public HumanFile selectHumanFileByhfId(int hfId);

	public HumanFile selectHumanFileByNames(@Param("names") String names);

	public boolean deleteHumanFileByhfId(int hfId);

	public int updateHumanFile(HumanFile humanFile);
	
	public List<HumanFile> selectByCondition(MajorManagerDto mmd);
	
	public HumanFile selectByhumanid(String huid);
	
	public boolean upDateHumanFiles(HumanFile humanfile);
	
	public boolean upDateHumanFileChange(HumanFile humanfile);
	

	public List<HumanFile> selectByHumanFileDto(HumanFileQuerryDto mmd);
	
	/**
	 * 通过查询删除状态来删除档案
	 */
	public List<HumanFile> selectAllHumanFileByDeletestu(@Param("status") short status);
	public boolean updateHumanFileDeleteStues(HumanFile humanfile);
	
	/**
	 * 通过查找删除状态来恢复档案
	 */
	public boolean updateHumanFileRecovery(HumanFile humanfile);
	/**
	 * 永久删除
	 */
	public boolean deleteHumanFileByhuid(@Param("huids") String huid);

}
