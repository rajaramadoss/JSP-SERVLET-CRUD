package com.task2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.task2.dao.UserDAO;
import com.task2.model.User;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/")
public class IndexServlet extends HttpServlet {
	UserDAO userDao=new UserDAO();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		String action=request.getServletPath();
		System.out.println("Action :: ==>"+action);
		
		switch (action) {
		case "/list":
			System.out.println("LIst of values");
			ListOfDataTableValues(request,response);
			break;
		case "/new":
			System.out.println("New of values");
			NewRegister(request,response);
			break;
		case "/edit":
			System.out.println("Edit values");
			editedValues(request,response);
			break;
		case "/insert":
			System.out.println("Insert values");
			insertUser(request,response);
			break;
		case "/update":
			System.out.println("Update of values");
			updateUsers(request,response);
			break;
		case "/register":
			System.out.println("register");
			//DisplayLoginPage(request,response);
			break;
		case "/delete":
			System.out.println("register");
			try {
				deleteUser(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		default :
			System.out.println("This is default load values");
			ListOfDataTableValues(request,response);
			break;
		}
		
		 
	}

	

	private void editedValues(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(" Inside :: editedValues ::  ");
		int id;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			System.out.println("ID :: ====>"+id);
			User existingUser=userDao.SelectedUser(id);
			System.out.println(":: existingUser ::============> "+existingUser);
			request.setAttribute("existingUser", existingUser);
			RequestDispatcher dispatcher=request.getRequestDispatcher("Index.jsp");
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(" Inside :: editedValues :: END ");
	}

	private void ListOfDataTableValues(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println( " ================= ListOfDataTableValues  ========================= ");
		
		List<User> us=userDao.ListOfUser();
		System.out.println(" User us values :: ===>>>"+us);
		request.setAttribute("us", us);
		RequestDispatcher dispatcher= request.getRequestDispatcher("Welcome.jsp");
		dispatcher.forward(request, response);
		System.out.println( " ================= ListOfDataTableValues  =================== end ====== ");
	}

	private void NewRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Date date=new Date();
		System.out.println(" This is new register");
		User us=new User();
		//us.setId(0);
		us.setName("");
		us.setPassword("");
		us.setAge( 0);
		us.setGender("");
		us.setCountry("");
		us.setDateofbirth(date);
		us.setSalary(0.0);
		us.setAddress("");
		us.setDescription("");
		us.setTypeofrequest("new");
		request.setAttribute("us", us);
		
		
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("Index.jsp");
		dispatcher.forward(request, response);
		System.out.println(" This is new register ============ END");
		
	}

	private void DisplayLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" =====:: DisplayLoginPage::====");
		RequestDispatcher dispatcher= request.getRequestDispatcher("Index.jsp");
		dispatcher.forward(request, response);
		
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		System.out.println("=======  :: insertUser ::======="+request.toString());
		String reqType = request.getParameter("reqType");
		System.out.println("req Type : "+reqType);
		int id=0;
		if("new".equals(reqType)) {
		
			  //id=Integer.parseInt( request.getParameter("id"));
			//System.out.println(" ================if============================INSERT ID ===>"+id);
		}else {
			  id=Integer.parseInt( request.getParameter("id"));
			System.out.println(" ===========================else=================INSERT ID ===>"+id);
				}
			 
			
			String name=request.getParameter("name");
			String password=request.getParameter("password");
//			int age=Integer.parseInt( request.getParameter("age"));
			String age=request.getParameter("age");
			String gender=request.getParameter("gender");
			String country=request.getParameter("country");
			String dateofbirth=request.getParameter("dateofbirth");
			System.out.println("dateofbirth"+dateofbirth);
			SimpleDateFormat sdf=new SimpleDateFormat("ddMMYYYY");
			System.out.println(" sdf  "+sdf);
			java.util.Date de;
			java.sql.Date sq=null;
			try {
				de = sdf.parse(dateofbirth);
			
				  sq= new java.sql.Date(de.getTime());
				System.out.println( " sq date :: ==>"+sq);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			Double salary=Double.parseDouble(request.getParameter("salary"));
			String address=request.getParameter("address");
			String description=request.getParameter("description");
			String typeofrequest=request.getParameter("reqType");
			User user=new User();
			if("new".equals(reqType)) {
//				user.setId(0);
			}else {
				user.setId(id);
			}
			
			user.setName(name);
			user.setPassword(password);
			int ages=Integer.parseInt(age);
			user.setAge(ages);
			user.setGender(gender);
			user.setCountry(country);
			user.setDateofbirth(sq);
			user.setSalary(salary);
			user.setAddress(address);
			user.setDescription(description);
			user.setTypeofrequest(typeofrequest);
//		}else if("update".equals(reqType)){
//			
//		}else {
//			
//		}
//		
		 
		System.out.println("User :: Retrive Result :: INSER METHODS ==>"+user);
		if("insert".equals(reqType)){
			System.out.println( " insert if loop =========>");
			if("update".equals(typeofrequest)) {
				System.out.println( " insert if loop =========> to UPDATE ===================>>>>>>>>");
				userDao.UpdateUser(user);
				
			}else {
			userDao.insertLogic(user,request,response);
			}
		}else if("update".equals(reqType)) {
			userDao.UpdateUser(user);
			
			out.println("<h3> Updated Sucessfully !!!</h3>");
			
			out.println("<a href='list'> Show Users</a>");
			
			
			
		}else if("new".equals(reqType)){
			userDao.insertLogic(user,request,response);
		}else {
			
		}
			
		
		
		// RequestDispatcher re=request.getRequestDispatcher("Welcome.jsp");
		//	re.forward(request, response);
		 
	}
	private void updateUsers(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("=======  :: updateUser ::======="+request.toString());
		int id=Integer.parseInt( request.getParameter("id"));
		System.out.println("updateUser =======>>>> :id:: ===========:: updateUser ::"+id);
		String name=request.getParameter("name");
		String password=request.getParameter("password");
//		int age=Integer.parseInt( request.getParameter("age"));
		String age=request.getParameter("age");
		String gender=request.getParameter("gender");
		String country=request.getParameter("country");
		String dateofbirth=request.getParameter("dateofbirth");
		System.out.println("dateofbirth"+dateofbirth);
		SimpleDateFormat sdf=new SimpleDateFormat("ddMMYYYY");
		System.out.println(" sdf  "+sdf);
		java.util.Date de;
		java.sql.Date sq=null;
		try {
			de = sdf.parse(dateofbirth);
		
			  sq= new java.sql.Date(de.getTime());
			System.out.println( " sq date :: ==>"+sq);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Double salary=Double.parseDouble(request.getParameter("salary"));
		String address=request.getParameter("address");
		String description=request.getParameter("description");
		
		User user=new User();
		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		int ages=Integer.parseInt(age);
		user.setAge(ages);
		user.setGender(gender);
		user.setCountry(country);
		user.setDateofbirth(sq);
		user.setSalary(salary);
		user.setAddress(address);
		user.setDescription(description);
		user.setTypeofrequest("update");
		System.out.println("User :: Retrive Result :: ==>"+user);
		userDao.UpdateUser(user);
		System.out.println(" Update   :: C :: Values :: ==>> "+user);
		response.sendRedirect("Welcome.jsp");
	}
	
	private void deleteUser(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException  {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		System.out.println(" deleteUser ====>  ");
		 //int id= Integer.parseInt( request.getParameter("id"));
		 String id=request.getParameter("id");
		 System.out.println("ID :: "+id);
		 userDao.deleteUserData(id);
		 System.out.println(" deleteUser ====> END ");

			out.println("<h3> Deleted Sucessfully !!!</h3>");
			
			out.println("<a href='list'> Show Users</a>");
	 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
