package com.task2.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.task2.model.User;

public class UserDAO {
	
	String select_All_User="select id, name, password, age, gender, country, dateofbirth, salary, address, description from user;";
	String select_UserById="select id, name, password, age, gender, country, dateofbirth, salary, address, description from user where id=?;";
	String inser_Query=" insert into user"+" ( id,name, password, age, gender, country, dateofbirth, salary, address, description) values"+ "(?,?,?,?,?,?,?,?,?,?);";
	String update_User="update user set name=?, password=?, age=?, gender=?, country=?, dateofbirth=?, salary=?, address=?, description=? where id=?;";
	String delete_User="delete from user where id=?;";
	String url="jdbc:mysql://localhost:3306/employees?useSSL=false";
	String name="root";
	String password="admin";
	

	 
	public int UpdateUser(User user) {
		int id=user.getId();
		System.out.println("========== USER DAO UpdateUser ================"+id);
//		boolean upuser=false;
		int result=0;
		Connection con= getConnection();
		try {
			PreparedStatement pre=con.prepareStatement(update_User);
			
			
			pre.setString(1, user.getName());
			pre.setString(2, user.getPassword());
			pre.setInt(3, user.getAge());
			pre.setString(4, user.getGender());
			pre.setString(5, user.getCountry());
			pre.setDate(6, (java.sql.Date) user.getDateofbirth());
			pre.setDouble(7, user.getSalary());
			pre.setString(8, user.getAddress());
			pre.setString(9, user.getDescription());
			pre.setInt(10, user.getId());
			System.out.println("==BEFORE EXECUTE ========= >>>>>> "+pre);
			result=pre.executeUpdate();
			 System.out.println("===AFTER EXECUTE ======== >>>>>> "+pre);
//			upuser=true;
			System.out.println("========== USER DAO UpdateUser ============== END ---==");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}
	
	
	public User SelectedUser(int id) {
		User user=null;
		Connection con=getConnection();
		try {
			System.out.println(" UserDAO :: SelectedUser ====  ");
			PreparedStatement pre=con.prepareStatement(select_UserById);
			pre.setInt(1, id);
			ResultSet rs=pre.executeQuery();
			while (rs.next()) {
//				int ids=rs.getInt("id");
				String name=rs.getString("name");
				String password=rs.getString("password");
				int age=rs.getInt("age");
				String gender=rs.getString("gender");
				String country=rs.getString("country");
				Date dateofbirth=rs.getDate("dateofbirth");
				double salary=rs.getDouble("salary");
				String address=rs.getString("address");
				String description=rs.getString("description");
				user=new User(id,name,password,age,gender,country,dateofbirth,salary,address,description,"update");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println(" UserDAO :: SelectedUser ====   END ==");
		return user;
		
	}
	
	
	public void insertLogic(User user,HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(" insertLogic :: "+user);
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		Connection con=getConnection();
		try {
			PreparedStatement pre=con.prepareStatement(inser_Query);
			pre.setInt(1, user.getId());
			pre.setString(2,user.getName() );
			pre.setString(3, user.getPassword());
			pre.setInt(4, user.getAge());
			pre.setString(5, user.getGender());
			pre.setString(6, user.getCountry());
//			new Timestamp(utilDate.getTime()
			pre.setDate(7,  (java.sql.Date) user.getDateofbirth());
			pre.setDouble(8,user.getSalary() );
			pre.setString(9,user.getAddress() );
			pre.setString(10,user.getDescription() );
			int count=pre.executeUpdate();
			 if(count==1) {
				 out.println("<h2>Record Register Successfully !!!</h2>");
				 
			 }else {
				 out.println("<h2>Record Not Register   !!!</h2>");
			 }
			
			System.out.println(" insertLogic ::  End :: ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.println("<a href='list'><button>Show User</button></a>");
	}
	
	public Connection getConnection() {
		System.out.println("=======:: getConnection ::   ");
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    connection=DriverManager.getConnection(url,name,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("getConnection :: End ");
		return connection;
	}

	public List<User> ListOfUser() { // data table values showing 
		ArrayList<User> user= new ArrayList<>();
		try {
					Connection con=getConnection();
					PreparedStatement preparedStatement=con.prepareStatement(select_All_User);
					ResultSet re=preparedStatement.executeQuery();
					while (re.next()) {
						int id=re.getInt("id");
						String name=re.getString("name");
						String password=re.getString("password");
						int age=re.getInt("age");
						String gender=re.getString("gender");
						String country=re.getString("country");
						Date dateofbirth=re.getDate("dateofbirth");
						double salary=re.getDouble("salary");
						String address=re.getString("address");
						String description=re.getString("description");
						user.add( new User(id,name,password,age,gender,country,dateofbirth,salary,address,description,""));
						   
						
					}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		
	}

	public void deleteUserData(String id) throws SQLException {
		System.out.println(" deleteUserData ====>");
		Connection  con=getConnection();
		 PreparedStatement preparedStatement=con.prepareStatement(delete_User);
		 preparedStatement.setString(1,id);
		int count = preparedStatement.executeUpdate();
		if (count==1) {
			System.out.println("<h2> Delete Successfuly !!!</h2>");
		}else {
			System.out.println("<h2> Delete Successfuly !!!</h2>");
		}
		 System.out.println(" deleteUserData ====> END");
	}


	
}
