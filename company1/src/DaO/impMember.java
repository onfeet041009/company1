package DaO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.member;

public class impMember implements memberDao{
//這個檔有動態class-impMember也有靜態的impMember,大概就兩個檔用同一個名字
	public static void main(String[] args) 
	{
		//member m=new member("abc","red","000","台北","44","123");
		
		//new impMember().add(m);
		
		//System.out.println(new impMember().queryAll1());
		//System.out.println(new impMember().queryAll2());
		/*List<member> l=new impMember().queryAll2();
		
		for(member o:l) 
		{
			System.out.println(o.getId()+"\t"+o.getName());
		}
		System.out.println(l.size());//可以查有多少個*/
		
		//System.out.println(new impMember().queryId(10));
		//System.out.println(new impMember().queryMember("abcss","123"));
		
		/*member m=new impMember().queryId(5);//id為5的資料
		m.setPassword("QAQ123");
		
		new impMember().update(m);*/
		
		//new impMember().delete(9);
		
		System.out.println(new impMember().queryUser("abb"));
		
	}

	@Override
	public void add(member m) {
	Connection conn=DbConnection.getDB();
	String SQL="insert into member(name,username,password,address,mobile,phone) "
						+ "values(?,?,?,?,?,?) ";
	try {
					PreparedStatement ps=conn.prepareStatement(SQL);
					ps.setString(1,m.getName());
					ps.setString(2,m.getUsername());
					ps.setString(3,m.getPassword());
					ps.setString(4,m.getAddress());
					ps.setString(5,m.getMobile());
					ps.setString(6,m.getPhone());
					
					ps.executeUpdate();//更新完這句一定要+阿!
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

	@Override
	public String queryAll1() {//全部撈出來~但全部都是String,不能計算有點不行壓!
	Connection conn=DbConnection.getDB();
	String SQL="select * from member";
	String show="";//一個控制串,後面會用到
	
	try {
		PreparedStatement ps=conn.prepareStatement(SQL);//可編輯但不能顯示
		ResultSet rs=ps.executeQuery();
		while(rs.next()) 
		{
			show=show/*控制串出現啦!出現這個就不會只出現一筆而是好多筆啦!*/+
						 rs.getInt("id")+
						 "\t名:"+rs.getString("name")+
						 "\t帳號:"+rs.getString("username")+
						 "\t密碼:"+rs.getString("password")+
						 "\t地址:"+rs.getString("address")+
						 "\t行動:"+rs.getString("mobile")+
						 "\t電話:"+rs.getString("phone")+"\n"/*+這個表示下一筆會換行*/;
						 
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
		return show;
	}

	@Override
	public List<member> queryAll2() {//這種方法撈資料可以計算,因為是物件(?)
		Connection conn=DbConnection.getDB();
		String SQL="select * from member";
		List<member>l=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next())//把rs的東西撈出來填滿member然後回傳List<member>l
			{
				member m=new member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setAddress(rs.getString("address"));
				m.setMobile(rs.getString("mobile"));
				m.setPhone(rs.getString("phone"));
				l.add(m);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return l;
	}

	@Override
	public member queryId(int id) {
		/*
		 * 做之前先寫個大綱步驟,然後照著大綱走,除錯也比較有方向
		 * 1.連線-->Connection
		 * 2.SQL-->where id=?
		 * 3.ResultSet
		 * 4.if-->rs.next-->如果有下一筆的判斷...
		 * 5.true-->確實藉由id找到這筆-->rs-->new member()
		 * 6.false-->藉由id沒找到這筆-->null
		 */
		Connection conn=DbConnection.getDB();
		String SQL="select * from member where id=?";
		member m=null;//先說好沒有就null就不用寫else
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) 
			{
				m=new member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setAddress(rs.getString("address"));
				m.setMobile(rs.getString("mobile"));
				m.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public member queryMember(String username, String password) {
		/*
		 * 1.先連線->Connection
		 * 2.SQL->where username =? and password=?
		 * 3.if(rs.next())
		 * 4.true->new member()->rs填入
		 * 5.false->null
		 */
		Connection conn=DbConnection.getDB();
		String SQL="select *from member where username=? and password=?";
		member m=null;
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, username);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) 
			{
				m=new member();//不用宣告,所以m的前面沒+member
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setAddress(rs.getString("address"));
				m.setMobile(rs.getString("mobile"));
				m.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public void update(member m) {
		/*
		 * 1.先連線
		 * 2.SQL->update 全部內容 where id=?
		 * 3.preparedStatement執行
		 */
		Connection conn=DbConnection.getDB();
		String SQL="update member set name=?,username=?,password=?,address=?,mobile=?,phone=?"
							+ "where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1 ,m.getName());
			ps.setString(2, m.getUsername());
			ps.setString(3, m.getPassword());
			ps.setString(4, m.getAddress());
			ps.setString(5,m.getMobile());
			ps.setString(6, m.getPhone());
			ps.setInt(7, m.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void delete(int id) {
		/*
		 * 1.連線
		 * 2.SQL->where id=?
		 * 3.pre->執行
		 */
		Connection conn=DbConnection.getDB();
		String SQL="delete from member where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean queryUser(String username) {
		Connection conn=DbConnection.getDB();
		String SQL="select * from member where username=?";
		boolean m=false;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1,username);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) m=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}
	

}
