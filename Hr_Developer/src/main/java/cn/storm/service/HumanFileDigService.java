package cn.storm.service;

import java.util.List;

import cn.storm.pojo.HumanFileDig;

public interface HumanFileDigService {
	public boolean addHumanFileDig(HumanFileDig humanFileDig);
	public List<HumanFileDig> queryAllHumanFileDig();
	public HumanFileDig queryHumanFileDigByHfdid(int hufid);
	public boolean removeHumanFileDigByhfdid(int hufid);
	public int modifyHumanFileDig(HumanFileDig humanFileDig);
}
