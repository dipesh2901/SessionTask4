package com.neosoft.httptest.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.neosoft.httptest.jdbc.Student;

public class StudentController {
	
	

	public static List<Student> fetchStudents() throws SQLException {
		List<Student> students=new ArrayList<Student>();
		Connection con=JDBCConnection.openConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String query="select * from student";
		try {
			pst=con.prepareStatement(query);
			rs=pst.executeQuery();
			while(rs.next()) {
				Student s=new Student();
				s.setStid(rs.getInt(1));
				s.setStname(rs.getString(2));
				s.setStcourse(rs.getString(3));
				s.setMarks(rs.getInt(4));
				students.add(s);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				rs.close();
			}
			if(pst!=null) {
				pst.close();
			}
			JDBCConnection.closeConnection();
		}
		return students;
	}
	
	public static Student fetchStudentById(int stdid) throws SQLException {
		
		Connection con=JDBCConnection.openConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String query="select* from student where stdid=?";
		Student student=new Student();
		try {
			pst=con.prepareStatement(query);
			pst.setInt(1, stdid);
			rs=pst.executeQuery();
			student.setStid(rs.getInt(1));
			student.setStname(rs.getString(2));
			student.setStcourse(rs.getString(3));
			student.setMarks(rs.getInt(4));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(pst!=null)
				pst.close();
			JDBCConnection.closeConnection();
		}
		return student;
	}

	public static void insertStudent(Student student) throws SQLException {
		Connection con=JDBCConnection.openConnection();
		PreparedStatement pst=null;
		String query="insert into student values(?,?,?,?)";
		try {
			pst=con.prepareStatement(query);
			pst.setInt(1, student.getStid());
			pst.setString(2, student.getStname());
			pst.setString(3,student.getStcourse());
			pst.setInt(4, student.getMarks());
			System.out.println("Inserted: "+pst.executeUpdate());
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(pst!=null)
				pst.close();
			JDBCConnection.closeConnection();
		}
	}

	public static void insertStudents(List<Student> students) {
		for(Student list:students) {
			
		}
	}

	public static void updateStudent(int stdid, Student student) throws SQLException {
		Connection con=JDBCConnection.openConnection();
		PreparedStatement pst=null;
		String query1="update student set stdname=?,stdcourse=?,marks=? where stdid=?";
		try {
			pst=con.prepareStatement(query1);
			pst.setString(1, student.getStname());
			pst.setString(2,student.getStcourse());
			pst.setInt(3,student.getMarks());
			pst.setInt(4, stdid);
			pst.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			if(pst!=null)
				pst.close();
			JDBCConnection.closeConnection();
		}
	}

	public static void deleteStudent(int stdid) throws SQLException {
		Connection con=JDBCConnection.openConnection();
		PreparedStatement pst=null;
		String query="delete from student where stdid=?";
		try {
			pst=con.prepareStatement(query);
			pst.setInt(1,stdid);
			System.out.println("Deleted: "+pst.executeUpdate());
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(pst!=null)
				pst.close();
			JDBCConnection.closeConnection();
		}
		
	}

}
