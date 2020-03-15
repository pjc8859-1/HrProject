package cn.storm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.storm.mapper.UsersMapper;
import cn.storm.pojo.Users;
import cn.storm.service.UsersService;
@Service
public class UsersServiceImpl implements UsersService{
	@Autowired
private UsersMapper usersmapper=null;
	@Override
	public boolean addUsers(Users users) {
		// TODO Auto-generated method stub
		return usersmapper.saveUsers(users);
	}

	@Override
	public List<Users> queryAllUsers() {
		// TODO Auto-generated method stub
		return usersmapper.selectAllUsers();
	}

	@Override
	public Users queryUsersByUid(int uid) {
		// TODO Auto-generated method stub
		return usersmapper.selectUsersByUid(uid);
	}

	@Override
	public boolean removeUsersByUid(int uid) {
		// TODO Auto-generated method stub
		return usersmapper.deleteUsersByUid(uid);
	}

	@Override
	public int modifyUsers(Users users) {
		// TODO Auto-generated method stub
		return usersmapper.updateUsers(users);
	}

	@Override
	public boolean queryUserByNameAndPass(String uname, String upass) {
		return usersmapper.selectUserByNameAndPass(uname, upass);
	}

}
