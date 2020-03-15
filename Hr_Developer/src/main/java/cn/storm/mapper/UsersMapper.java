package cn.storm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.storm.pojo.Users;

@Repository
public interface UsersMapper {
	public boolean saveUsers(Users users);
	public boolean selectUserByNameAndPass(@Param(value="UName") String UName , @Param(value="UPassword") String UPassword);
	public List<Users> selectAllUsers();
	public Users selectUsersByUid(int uid);
	public boolean deleteUsersByUid(int uid);
	public int updateUsers(Users users); 
}
