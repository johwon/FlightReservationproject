package com.kh.flightReservation.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.flightReservation.model.CustomerVO;

public class CustomerResigterManager {
	public static Scanner sc = new Scanner(System.in);

	public void selectManager() {
		CustomerDAO cdao = new CustomerDAO();
		ArrayList<CustomerVO> customerList = cdao.customerSelect();

		System.out.println("모든 고객을 조회합니다.");
		System.out.println(String.format("%-15s", "아이디")+String.format("%-15s", "비밀번호")
		+String.format("%-15s", "이름")+String.format("%-15s", "여권번호")
		+String.format("%-15s", "마일리지"));
		for (CustomerVO cvo : customerList) {
			System.out.println(cvo.toString());
		}
	}

	public void insertManager() {
		CustomerDAO cdao = new CustomerDAO();
		CustomerVO cvo = null;

		System.out.println("고객을 등록합니다.");
		System.out.print("아이디를 입력해주세요 : ");
		String id = sc.nextLine();

		System.out.print("비밀번호를 입력해주세요 : ");
		String passwD = sc.nextLine();

		System.out.print("이름을 입력해주세요 : ");
		String name = sc.nextLine();

		System.out.print("여권번호를 입력해주세요 : ");
		String passportNumber = sc.nextLine();

		cvo = new CustomerVO(id, passwD, name, passportNumber, 0);
		cdao.customerInsert(cvo);
	}

	public void updateManager() {
		CustomerDAO cdao = new CustomerDAO();
		CustomerVO cvo = null;

		System.out.println("고객 정보를 수정합니다.");
		System.out.print("수정할 아이디를 입력해주세요 : ");
		String id = sc.nextLine();

		System.out.print("비밀번호를 수정합니다 : ");
		String passwD = sc.nextLine();

		System.out.print("이름을 수정합니다 : ");
		String name = sc.nextLine();

		System.out.print("여권번호를 수정합니다 : ");
		String passportNumber = sc.nextLine();

		cvo = new CustomerVO(id, passwD, name, passportNumber, 0);
		cdao.customerUpdate(cvo);
	}

	public void deleteManager() {
		CustomerDAO cdao = new CustomerDAO();
		CustomerVO cvo = null;

		System.out.println("고객 정보를 삭제합니다.");
		System.out.print("삭제할 아이디를 입력해주세요 : ");
		String id = sc.nextLine();

		cvo = new CustomerVO();
		cvo.setId(id);

		cdao.customerDelete(cvo);
	}

	public void gradePrintManager() {
		CustomerDAO cdao = new CustomerDAO();
		CustomerVO cvo = null;
		
		System.out.println("고객 등급을 조회합니다.");
		System.out.print("조회할 아이디를 입력해주세요 : ");
		String id = sc.nextLine();

		cvo = new CustomerVO();
		cvo.setId(id);

		cdao.customerGradePrint(cvo);
	}

}
