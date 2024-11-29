package com.kh.flightReservaion.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.flightReservaion.model.ReservationAllVO;
import com.kh.flightReservaion.model.ReservationVO;

public class ReservationRegisterManager {
	public Scanner sc=new Scanner(System.in);

	public void selectManager() throws SQLException {
		ReservationDAO rdao = new ReservationDAO();
		ArrayList<ReservationVO> reservationList = new ArrayList<ReservationVO>();

		reservationList = rdao.reservationSelect();
		if (reservationList == null) {
			System.out.println("데이터가 존재하지 않습니다.");
			return;
		}
		printReservationList(reservationList);
	}
	
	public void insertManager() {
		ReservationDAO rdao = new ReservationDAO(); 
		System.out.print("예약번호를 입력하시오 : ");
		int no= Integer.parseInt((sc.nextLine()).trim());
		System.out.print("고객 아이디를 입력하시오 : ");
		String id= (sc.nextLine()).trim();
		System.out.print("항공편을 입력하시오 : ");
		int flight_no= Integer.parseInt((sc.nextLine()).trim());
		System.out.print("예매매수를 입력하시오 : ");
		int quantity= Integer.parseInt((sc.nextLine()).trim());
		
		ReservationVO rvo = new ReservationVO(no, id, flight_no, quantity); 
		boolean successFlag = rdao.reservationInsert(rvo); 
		
		if(successFlag == true) {
			System.out.println("입력 성공하였습니다.");
		}else {
			System.out.println("입력 실패하였습니다.");
		}
	} 

	public void deleteManager() {
		ReservationDAO rdao = new ReservationDAO();
		ReservationVO rvo = new ReservationVO(); 

		ArrayList<ReservationVO> reservationList = new ArrayList<ReservationVO>();

		reservationList = rdao.reservationSelect();
		if (reservationList == null) {
			System.out.println("데이터가 존재하지 않습니다.");
			return;
		}
		printReservationList(reservationList);
		
		
		System.out.print("삭제할 데이터의 예약번호를 입력하시오 : ");
		int no = Integer.parseInt((sc.nextLine()).trim());
		rvo.setNo(no);
		
		boolean successFlag = rdao.reservationDelete(rvo); 
		
		if(successFlag == true) {
			System.out.println("삭제 완료 하였습니다.");
		}else {
			System.out.println("삭제에 실패하였습니다.");
		}
	} 
	
	public void updateManager() {
		ReservationDAO rdao = new ReservationDAO();
		ReservationVO rvo = new ReservationVO();
		ArrayList<ReservationVO> reservationList = new ArrayList<ReservationVO>();

		reservationList = rdao.reservationSelect();
		if (reservationList == null) {
			System.out.println("데이터가 존재하지 않습니다.");
			return;
		}
		printReservationList(reservationList);
		
		
		System.out.print("수정할 데이터의 예약번호를 입력하시오 : ");
		int no = Integer.parseInt(sc.nextLine().trim());
		
		System.out.print("고객 아이디를 입력하시오 : ");
		String id= (sc.nextLine()).trim();

		System.out.print("항공편을 입력하시오 : ");
		int flight_no = Integer.parseInt(sc.nextLine().trim());
		
		System.out.print("예매 매수를 입력하시오 : ");
		int quantity = Integer.parseInt(sc.nextLine().trim());
		
		rvo = new ReservationVO(no, id, flight_no, quantity); 
		boolean successFlag = rdao.reservationUpdate(rvo); 
		
		if(successFlag == true) {
			System.out.println("수정 완료하였습니다.");
		}else {
			System.out.println("수정에 실패하였습니다.");
		}
	} 
	
	public void selectAllManager() {
		ReservationDAO rdao = new ReservationDAO();
		ArrayList<ReservationAllVO> reservationAllList = new ArrayList<ReservationAllVO>();

		reservationAllList = rdao.reservationAllSelect();
		if (reservationAllList == null) {
			System.out.println("데이터가 존재하지 않습니다.");
			return;
		}
		printAllReservationList(reservationAllList);
	}
	
	private void printAllReservationList(ArrayList<ReservationAllVO> reservationAllList) {
		for (ReservationAllVO rv : reservationAllList) {
			System.out.println(rv.toString());
		}
	}

	private void printReservationList(ArrayList<ReservationVO> reservationList) {
		for (ReservationVO rv : reservationList) {
			System.out.println(rv.toString());
		}
	}
}
