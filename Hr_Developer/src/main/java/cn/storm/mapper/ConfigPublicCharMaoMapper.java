package cn.storm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.storm.pojo.ConfigPublicChar;

public interface ConfigPublicCharMaoMapper{

	//保存公共字段
	@Insert("insert into config_public_char values(null,#{attributeKind},#{attributeName})")
	@ResultMap("PublicMapper")
	public boolean saveConfigPublicChar(ConfigPublicChar configpublicchar);
	
	//查询所有
	@Select("select * from config_public_char")
	@ResultMap("PublicMapper")
	public List<ConfigPublicChar> selectAllConfigPublicChar();
	
	//通过ID查找
	@Select("select * from config_public_char where pbc_id=#{pbcId}")
	@ResultMap("PublicMapper")
	public ConfigPublicChar selectConfigPublicCharBypbcId(int pbcId);
	
	
	//通过id删除 
	@Delete("delete * from config_public_char where pbc_id=#{pbcId}")
	@ResultMap("PublicMapper")
	public boolean deleteConfigPublicCharBypbcId(int pbcId);
	
	
	//修改
	@Update("update config_public_char set attribute_kind = #{attributeKind},attribute_name = #{attributeName},where pbc_id = #{pbcId}")
	@ResultMap("PublicMapper")
	public int updateConfigPublicChar(ConfigPublicChar configpublicchar);
	
	/**
	 * 查询职称字段
	 * @return
	 */
	@Select("select * from config_public_char where attribute_kind='职称'")
	@ResultMap("PublicMapper")
	public List<ConfigPublicChar> queryzc();
	
	/**
	 * 查询民族
	 */
	@Select("select * from config_public_char where attribute_kind='民族'")
	@ResultMap("PublicMapper")
	public List<ConfigPublicChar> querymz();
	
	/**
	 * 查询宗教信仰
	 */
	@Select("select * from config_public_char where attribute_kind='宗教信仰'")
	@ResultMap("PublicMapper")
	public List<ConfigPublicChar> queryzjxy();
	
	/**
	 * 政治面貌
	 */
	@Select("select * from config_public_char where attribute_kind='政治面貌'")
	@ResultMap("PublicMapper")
	public List<ConfigPublicChar> queryzzmm();
	
	/**
	 * 教育年限
	 */
	@Select("select * from config_public_char where attribute_kind='教育年限'")
	@ResultMap("PublicMapper")
	public List<ConfigPublicChar> queryjynx();
	
	/**
	 * 学历
	 */
	@Select("select * from config_public_char where attribute_kind='学历'")
	@ResultMap("PublicMapper")
	public List<ConfigPublicChar> queryxl();
	
	/**
	 * 专业
	 */
	@Select("select * from config_public_char where attribute_kind='专业'")
	@ResultMap("PublicMapper")
	public List<ConfigPublicChar> queryzy();
	
	/**
	 * 特长
	 */
	@Select("select * from config_public_char where attribute_kind='特长'")
	@ResultMap("PublicMapper")
	public List<ConfigPublicChar> querytc();
	
	/**
	 * 爱好
	 */
	@Select("select * from config_public_char where attribute_kind='爱好'")
	@ResultMap("PublicMapper")
	public List<ConfigPublicChar> queryah();
	
	/**
	 * 培训项目
	 */
	@Select("select * from config_public_char where attribute_kind='培训项目'")
	@ResultMap("PublicMapper")
	public List<ConfigPublicChar> querypxxm();
	
	/**
	 * 培训成绩
	 */
	@Select("select * from config_public_char where attribute_kind='培训成绩'")
	@ResultMap("PublicMapper")
	public List<ConfigPublicChar> querypxcj();
	
	/**
	 * 奖励项目
	 */
	@Select("select * from config_public_char where attribute_kind='奖励项目'")
	@ResultMap("PublicMapper")
	public List<ConfigPublicChar> queryjlxm();
	
	/**
	 * 奖励等级
	 */
	@Select("select * from config_public_char where attribute_kind='奖励等级'")
	@ResultMap("PublicMapper")
	public List<ConfigPublicChar> queryjldj();
	
	/**
	 * 奖励国籍
	 */
	@Select("select * from config_public_char where attribute_kind='国籍'")
	@ResultMap("PublicMapper")
	public List<ConfigPublicChar> querygj();
	
	/**
	 * 薪酬标准
	 */
	@Select("select * from config_public_char where attribute_kind='薪酬标准'")
	@ResultMap("PublicMapper")
	public List<ConfigPublicChar> queryxcbz();
}
