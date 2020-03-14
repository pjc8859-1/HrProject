package cn.storm.util.myg.service.Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.storm.pojo.ConfigPublicChar;
import cn.storm.util.myg.service.MygConfigPublicCharService;

@Service
public class MygConfigPublicCharServiceImpl implements MygConfigPublicCharService {

	@Autowired
	private cn.storm.mapper.ConfigPublicCharMaoMapper mapper = null;
	
	@Override
	public boolean addConfigPublicChar(ConfigPublicChar configPublicChar) {
		// TODO Auto-generated method stub
		return mapper.saveConfigPublicChar(configPublicChar);
	}

	@Override
	public List<ConfigPublicChar> queryAllConfigPublicChar() {
		// TODO Auto-generated method stub
		return mapper.selectAllConfigPublicChar();
	}

	@Override
	public ConfigPublicChar queryConfigPublicCharBypbcId(int pbcId) {
		// TODO Auto-generated method stub
		return mapper.selectConfigPublicCharBypbcId(pbcId);
	}

	@Override
	public boolean removeConfigPublicCharBypbcId(int pbcId) {
		// TODO Auto-generated method stub
		return mapper.deleteConfigPublicCharBypbcId(pbcId);
	}

	@Override
	public int modifyConfigPublicChar(ConfigPublicChar configpublicchar) {
		// TODO Auto-generated method stub
		return mapper.updateConfigPublicChar(configpublicchar);
	}

	@Override
	public List<ConfigPublicChar> queryzc() {
		// TODO Auto-generated method stub
		return mapper.queryzc();
	}

	@Override
	public List<ConfigPublicChar> querymz() {
		// TODO Auto-generated method stub
		return mapper.querymz();
	}

	@Override
	public List<ConfigPublicChar> queryzjxy() {
		// TODO Auto-generated method stub
		return mapper.queryzjxy();
	}

	@Override
	public List<ConfigPublicChar> queryzzmm() {
		// TODO Auto-generated method stub
		return mapper.queryzzmm();
	}

	@Override
	public List<ConfigPublicChar> queryjynx() {
		// TODO Auto-generated method stub
		return mapper.queryjynx();
	}

	@Override
	public List<ConfigPublicChar> queryxl() {
		// TODO Auto-generated method stub
		return mapper.queryxl();
	}

	@Override
	public List<ConfigPublicChar> queryzy() {
		// TODO Auto-generated method stub
		return mapper.queryzy();
	}

	@Override
	public List<ConfigPublicChar> querytc() {
		// TODO Auto-generated method stub
		return mapper.querytc();
	}

	@Override
	public List<ConfigPublicChar> queryah() {
		// TODO Auto-generated method stub
		return mapper.queryah();
	}

	@Override
	public List<ConfigPublicChar> querypxxm() {
		// TODO Auto-generated method stub
		return mapper.querypxxm();
	}

	@Override
	public List<ConfigPublicChar> querypxcj() {
		// TODO Auto-generated method stub
		return mapper.querypxcj();
	}

	@Override
	public List<ConfigPublicChar> queryjlxm() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConfigPublicChar> queryjldj() {
		// TODO Auto-generated method stub
		return mapper.queryjldj();
	}

	@Override
	public List<ConfigPublicChar> queryxcbz() {
		// TODO Auto-generated method stub
		return mapper.queryxcbz();
	}

	@Override
	public List<ConfigPublicChar> querygj() {
		// TODO Auto-generated method stub
		return mapper.querygj();
	}

}
