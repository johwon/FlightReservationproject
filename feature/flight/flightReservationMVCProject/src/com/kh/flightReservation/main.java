package com.kh.flightReservation;

import java.util.Scanner;

import com.kh.flightReservation.controller.FlightRegisterManager;
import com.kh.flightReservation.view.FLIGHT_CHOICE;

public class main {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int num = 0;
		FlightRegisterManager frm = new FlightRegisterManager();
		while(true) {
			System.out.println("1.출력 2.입력 3.수정 4.삭제 5.정렬 6.인상");
			num = Integer.parseInt(sc.nextLine());
			switch (num) {
			case 1:
				frm.selectManager();
				break;
			case 2:
				frm.insertManager();
				break;
			case 3:
				frm.updateManager();
				break;
			case 4:
				frm.deleteManager();
				break;
			case 5:
				frm.selectSortManager();
				break;
			case 6:
				frm.salaryUpProcManager();
				break;
			default : 
				break;
			
			}
			
			
			
			
		}
		
	}
	
	private static void shopMenu() throws Exception {
		int choiceNum = 0;
		boolean exitFlag = false;
		FlightRegisterManager frm = new FlightRegisterManager();
		System.out.println();
		while (!exitFlag) {
			   MainViewer.flightMenuView();
			choiceNum = Integer.parseInt(sc.nextLine());
			switch (choiceNum) {
			case FLIGHT_CHOICE.LIST:
				frm.selectManager();
				break;
			case FLIGHT_CHOICE.INSERT:
				frm.selectManager();
				break;
			case FLIGHT_CHOICE.UPDATE:
				frm.selectManager();
				break;
			case FLIGHT_CHOICE.DELETE:
				frm.selectManager();
				break;
			case FLIGHT_CHOICE.LIST_SORT:
				frm.selectManager();
				break;
			case FLIGHT_CHOICE.PRICE_PROC:
				frm.selectManager();
				break;
			case FLIGHT_CHOICE.MAIN:
				break;
			default:
				System.out.println("해당 메뉴 번호만 입력하세요.");
			}
		}
	}

}
