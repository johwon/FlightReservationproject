package com.kr.flightReservation.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import com.kr.flightReservation.model.AirLineVO;

public class AirLineDAO {
	public static String AIRLINE_SELECT = "SELECT * FROM PLAYER";
	public static String AIRLINE_INSERT = "INSERT INTO PLAYER VALUES(PLAYER_NO_SEQ.nextval,?,?,?,?)";
	public static String AIRLINE_UPDATE = "UPDATE PLAYER SET NAME = ?, POSSIT = ?, WEEKSAL = ? , GAME = ? WHERE NO = ?";
	public static String AIRLINE_DELETE = "DELETE FROM PLAYER WHERE NO =?";
	public static String AIRLINE_GRADE_FUNC = "{ ? = call PLAYER_FUNCTION(?)}";

	// 삽입
	public boolean AirLineInsert(AirLineVO avo) {
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		ArrayList<AirLineVO> playerlist = new ArrayList<AirLineVO>();
		playerlist = null;
		try {
			con = DBUtility.dbCon();

			pstmt = con.prepareStatement(AIRLINE_INSERT);
			pstmt.setInt(1, avo.getNo());
			pstmt.setString(2, avo.getName());
			pstmt.setString(3, avo.getEnglishName());
			pstmt.setString(4, avo.getCountry());
			pstmt.setString(5, avo.getGrade());
			int result = pstmt.executeUpdate();
			successFlag = (result != 0) ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			DBUtility.dbClose(con, pstmt);
		}

		return successFlag;
	}

	// 수정
	public boolean AirLineUpdate(AirLineVO avo) {
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtility.dbCon();

			pstmt = con.prepareStatement(AIRLINE_UPDATE);
			pstmt.setString(1, avo.getName());
			pstmt.setString(2, avo.getEnglishName());
			pstmt.setString(3, avo.getCountry());
			pstmt.setString(4, avo.getGrade());
			pstmt.setInt(5, avo.getNo());
			int result = pstmt.executeUpdate();
			successFlag = (result != 0) ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			DBUtility.dbClose(con, pstmt);
		}
		return successFlag;
	}

	// 삭제
	public boolean AirLineDelete(AirLineVO avo) {
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtility.dbCon();

			pstmt = con.prepareStatement(AIRLINE_DELETE);
			pstmt.setInt(1, avo.getNo());
			int result = pstmt.executeUpdate();
			successFlag = (result != 0) ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			DBUtility.dbClose(con, pstmt);
		}
		return successFlag;
	}

	// 출력
	public ArrayList<AirLineVO> AirLinePrint() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<AirLineVO> airLinelist = new ArrayList<AirLineVO>();
		try {
			if (rs.next()) {

				con = DBUtility.dbCon();
				stmt = con.createStatement();
				rs = stmt.executeQuery(AIRLINE_SELECT);
				{
					int no = rs.getInt("NO");
					String name = rs.getNString("NAME");
					String englishName = rs.getNString("ENGLISH_NAME");
					String country = rs.getNString("COUNTRY");
					String grade = rs.getNString("GRADE");
					AirLineVO avo = new AirLineVO(no, name, englishName, country, grade);
					airLinelist.add(avo);

				}
				while (rs.next());
			} else {
				airLinelist = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			DBUtility.dbClose(con, stmt, rs);
		}
		return airLinelist;

	}

	// 함수
	public boolean AirLineFunc(AirLineVO avo) {
		boolean successFlag = false;
		Connection con = null;
		CallableStatement cstmt = null;
		try {
			con = DBUtility.dbCon();

			cstmt = con.prepareCall(AIRLINE_GRADE_FUNC);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.setInt(2, avo.getNo());
			int result = cstmt.executeUpdate();
			String message = cstmt.getNString(1);
			successFlag = (result != 0) ? true : false;
			System.out.println(message);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			DBUtility.dbClose(con, cstmt);
		}
		return successFlag;
	}

}
