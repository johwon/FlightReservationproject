package com.kr.flightReservation.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.kr.flightReservation.model.AirLineVO;

public class AirlLineRegisterManager {
	public static Scanner sc = new Scanner(System.in);
	//삽입
	public static void AirLineInsert(){
		AirLineDAO dao = new AirLineDAO();
		System.out.println("항공사 번호 입력>>");
		int no = Integer.parseInt(sc.nextLine());
		System.out.println("항공사 이름 입력>>");
		String name = sc.nextLine();
		System.out.println("항공사 영문이름 입력>>");
		String enghlishName = sc.nextLine();
		System.out.println("항공사 나라 입력>>");
		String country = sc.nextLine();
		System.out.println("항공사 등급 입력>>");
		String grade = sc.nextLine();
		AirLineVO airLineVO = new AirLineVO(no, name, enghlishName, country, grade);
		boolean successFlag = dao.AirLineInsert(airLineVO);
		if (successFlag == true) {
			System.out.println("삽입 성공");
		} else {
			System.out.println("삽입 실패");
		}
	}
	//수정
	public static void AirLineUpdate(){
		AirLineDAO dao = new AirLineDAO();
		System.out.println("수정할 항공사 번호 입력>>");
		int no = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 항공사 이름 입력>>");
		String name = sc.nextLine();
		System.out.println("수정할 항공사 영문이름 입력>>");
		String enghlishName = sc.nextLine();
		System.out.println("수정할 항공사 나라 입력>>");
		String country = sc.nextLine();
		System.out.println("수정할 항공사 등급 입력>>");
		String grade = sc.nextLine();
		AirLineVO airLineVO = new AirLineVO(no, name, enghlishName, country, grade);
		boolean successFlag = dao.AirLineUpdate(airLineVO);
		if (successFlag == true) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
	}
	//삭제
	public static void AirLineDelete(){
		AirLineDAO dao = new AirLineDAO();
		System.out.println("삭제할 항공사의 번호를 입력하세요");
		int no = Integer.parseInt(sc.nextLine());
		AirLineVO avo = new AirLineVO();
		avo.setNo(no);
		boolean successFlag = dao.AirLineDelete(avo);
		if (successFlag == true) {
			System.out.println("삭제처리 성공");
		} else {
			System.out.println("삭제처리 실패");
		}
	}
	//출력
	public static void PlayerPrint(){
		AirLineDAO dao = new AirLineDAO();
		ArrayList<AirLineVO> list = new ArrayList<AirLineVO>();
		list = dao.AirLinePrint();
		printAirLineList(list);
			
		}
	//FUNC
	public static void PlayerFunc(){
		AirLineDAO dao = new AirLineDAO();
		System.out.println("선수의 번호를 입력하세요");
		int no = Integer.parseInt(sc.nextLine());
		AirLineVO avo = new AirLineVO();
		avo.setNo(no);
		boolean successFlag = dao.AirLineFunc(avo);
		if (successFlag == true) {
			System.out.println("함수처리 성공");
		} else {
			System.out.println("함수처리 실패");
		}
	}	
	//출력문
	public static void printAirLineList(ArrayList<AirLineVO> list) {
		System.out.println("======================");
		for (AirLineVO avo : list) {
			System.out.println(String.format("%s",avo.toString()));
		}
		System.out.println("======================");
	}
	
	
}


