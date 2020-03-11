package cn.storm.service;

import java.util.List;

import cn.storm.pojo.Student;
import cn.storm.pojo.Users;

public interface UsersService {
	public boolean addUsers(Users users);
	public List<Users> queryAllUsers();
	public Users queryUsersByUid(int uid);
	public boolean removeUsersByUid(int uid);
	public int modifyUsers(Users users);

}
