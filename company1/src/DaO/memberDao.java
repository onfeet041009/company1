package DaO;

import java.util.List;

import model.member;

public interface memberDao 
{
	//create新增
	//void add(String name,String username,String password,String address,String phone,String mobile)
	void add(member m);//inject注入!上面太長了!換這個!前提是member要先有喔!
	
	//read查詢
	String queryAll1();
	List<member> queryAll2();
	member queryId(int id);
	member queryMember(String username,String password);
	boolean queryUser(String username);
	
	//update修改
	void update(member m);
	
	//delete刪除
	void delete(int id);
}
