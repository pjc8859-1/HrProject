package cn.storm.util.myg.service;

import java.util.List;

import cn.storm.pojo.ConfigPublicChar;

public interface MygConfigPublicCharService {

	//保存
	public boolean addConfigPublicChar(ConfigPublicChar configPublicChar);
	//查询所有
	public List<ConfigPublicChar> queryAllConfigPublicChar();
	//通过ID查询
	public ConfigPublicChar queryConfigPublicCharBypbcId(int pbcId);
	//通过ID删除
	public boolean removeConfigPublicCharBypbcId(int pbcId);
	//修改
	public int modifyConfigPublicChar(ConfigPublicChar configpublicchar);
	
	
	
	/**
	 * 查询职称字段
	 * @return
	 */
	public List<ConfigPublicChar> queryzc();
	
	/**
	 * 查询民族
	 */
	public List<ConfigPublicChar> querymz();
	/**
	 * 查询宗教信仰
	 */
	public List<ConfigPublicChar> queryzjxy();
	
	/**
	 * 政治面貌
	 */
	public List<ConfigPublicChar> queryzzmm();
	
	/**
	 * 国籍
	 */
	public List<ConfigPublicChar> querygj();
	/**
	 * 教育年限
	 */
	public List<ConfigPublicChar> queryjynx();
	
	/**
	 * 学历
	 */
	public List<ConfigPublicChar> queryxl();
	
	/**
	 * 专业
	 */
	public List<ConfigPublicChar> queryzy();
	
	/**
	 * 特长
	 */
	public List<ConfigPublicChar> querytc();
	
	/**
	 * 爱好
	 */
	public List<ConfigPublicChar> queryah();
	
	/**
	 * 培训项目
	 */
	public List<ConfigPublicChar> querypxxm();
	
	/**
	 * 培训成绩
	 */
	public List<ConfigPublicChar> querypxcj();
	
	/**
	 * 奖励项目
	 */
	public List<ConfigPublicChar> queryjlxm();
	
	/**
	 * 奖励等级
	 */
	public List<ConfigPublicChar> queryjldj();
	
	/**
	 * 薪酬标准
	 */
	public List<ConfigPublicChar> queryxcbz();
}
