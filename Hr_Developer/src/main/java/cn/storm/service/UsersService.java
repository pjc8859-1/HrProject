package cn.storm.service;

import java.util.List;

import cn.storm.pojo.Users;

public interface UsersService {
	public boolean addUsers(Users users);
	public boolean queryUserByNameAndPass(String uname,String upass);
	public List<Users> queryAllUsers();
	public Users queryUsersByUid(int uid);
	public boolean removeUsersByUid(int uid);
	public int modifyUsers(Users users);

}
