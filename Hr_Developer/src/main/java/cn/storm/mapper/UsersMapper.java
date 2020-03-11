package cn.storm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.storm.pojo.Student;
import cn.storm.pojo.Users;

@Repository
public interface UsersMapper {
	public boolean saveUsers(Users users);
	public List<Users> selectAllUsers();
	public Users selectUsersByUid(int uid);
	public boolean deleteUsersByUid(int uid);
	public int updateUsers(Users users);
}
