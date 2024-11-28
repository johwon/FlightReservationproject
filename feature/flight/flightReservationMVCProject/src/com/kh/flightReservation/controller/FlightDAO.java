package com.kh.flightReservation.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.flightReservation.model.FlightVO;

public class FlightDAO {
	public final String FLIGHT_SELECT = "SELECT * FROM FLIGHT"; 
	public final String FLIGHT_SELECT_SORT = "select * from FLIGHT ORDER BY NAME"; 
	public final String FLIGHT_DELETE = "delete from FLIGHT where no = ?";
	public final String FLIGHT_UPDATE = "UPDATE FLIGHT SET ABBRE = ?, NAME = ? WHERE NO = ? ";
	public final String FLIGHT_INSERT = "INSERT INTO FLIGHT VALUES(FLIGHT_seq.NEXTVAL, ?, ?) ";

	// Lesson 테이블에서 select 출력레코드를 리턴한다. (Read)
	public ArrayList<FlightVO> lessonSelect(FlightVO fvo) {
		Connection con = null; 				//오라클접속관문
		PreparedStatement pstmt = null; 	//오라클에서 작업할 쿼리문 사용할게 하는 명령문
		ResultSet rs = null;				//오라클에서 결과물을 받는객체
		ArrayList<FlightVO> lessonList = new ArrayList<FlightVO>();	//결과값을 다른객체전달하기 위해서 사용하는객체
		
		try {
			con = DBUtility.dbCon(); 
			pstmt = con.prepareStatement(FLIGHT_SELECT);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("NO");
				int aNo = rs.getInt("A_NO");
			    Date departmentDate = rs.getDate("DEPARTURE_DATE");
			    String departmentAirport = rs.getString("DEPARTURE_AIRPORT");
			    String arrivalAirport = rs.getString("ARRIVAL_AIRPORT");
			    int price = rs.getInt("PRICE");
			    String seat = rs.getString("SEAT");
			    
				FlightVO FlightVO = new FlightVO(no, abbre, name);
				lessonList.add(FlightVO); 
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt, rs);
		}
		
		return lessonList;
	}
	
	// Lesson 테이블에서 select 출력레코드를 리턴한다. (Read)
	public ArrayList<FlightVO> lessonSelectSort(FlightVO fvo) {
		Connection con = null; 				//오라클접속관문
		PreparedStatement pstmt = null; 	//오라클에서 작업할 쿼리문 사용할게 하는 명령문
		ResultSet rs = null;				//오라클에서 결과물을 받는객체
		ArrayList<FlightVO> lessonList = new ArrayList<FlightVO>();	//결과값을 다른객체전달하기 위해서 사용하는객체
		
		try {
			con = DBUtility.dbCon(); 
			pstmt = con.prepareStatement(FLIGHT_SELECT_SORT);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("NO");
				String abbre = rs.getString("ABBRE");
				String name = rs.getString("NAME");
				FlightVO FlightVO = new FlightVO(no, abbre, name);
				lessonList.add(FlightVO); 
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt, rs);
		}
		
		return lessonList;
	}

	// Lesson 테이블에서 delete 레코드를 삭제한다. (delete)
	public boolean lessonDelete(FlightVO fvo) {
        Connection con = null; // 오라클에 DB접속
        PreparedStatement pstmt = null; // 오라클에서 작업할 쿼리문을 사용할 수 있게하는 명령문
        boolean successFlag = false;
        try {
            con = DBUtility.dbCon();
            con.setAutoCommit(false);
            
            pstmt = con.prepareStatement(FLIGHT_DELETE);
            pstmt.setInt(1, fvo.getNo());
            int count = pstmt.executeUpdate();
            if(count != 0) {
            	con.commit();
            	successFlag = true; 
            }else {
            	con.rollback();
            	successFlag = false; 
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            DBUtility.dbClose(con, pstmt);
        }
        return successFlag;
    }

	// Lesson 테이블에서 update 레코드를 수정한다. (update)
	public boolean lessonUpdate(FlightVO fvo) {
		Connection con = null; 				//오라클접속관문
		PreparedStatement pstmt = null; 	//오라클에서 작업할 쿼리문 사용할게 하는 명령문
		boolean successFlag = false; 
		
		try {
			con = DBUtility.dbCon(); 
			pstmt = con.prepareStatement(FLIGHT_UPDATE);
			pstmt.setString(1, fvo.getAbbre());
			pstmt.setString(2, fvo.getName()); 
			pstmt.setInt(3, fvo.getNo());
			
			int count = pstmt.executeUpdate();
			successFlag = (count != 0)?(true):(false); 
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag ;
	}

	// Lesson 테이블에서 insert 레코드를 삽입한다. (insert)
	public boolean lessonInsert(FlightVO fvo) {
		Connection con = null; 				//오라클접속관문
		PreparedStatement pstmt = null; 	//오라클에서 작업할 쿼리문 사용할게 하는 명령문
		boolean successFlag = false; 
		
		try {
			con = DBUtility.dbCon(); 
			pstmt = con.prepareStatement(FLIGHT_INSERT);
			pstmt.setString(1, fvo.getAbbre());
			pstmt.setString(2, fvo.getName()); 

			int count = pstmt.executeUpdate();
			successFlag = (count != 0)?(true):(false); 
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag ;
	}
}