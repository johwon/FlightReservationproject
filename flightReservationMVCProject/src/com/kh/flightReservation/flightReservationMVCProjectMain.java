package com.kh.flightReservation;

import java.util.Scanner;

import com.kh.flightReservation.controller.CustomerResigterManager;
import com.kh.flightReservation.view.CUSTOMER_CHOICE;
import com.kh.flightReservation.view.MENU_CHOICE;
import com.kh.flightReservation.view.MainViewer;

public class flightReservationMVCProjectMain {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		boolean exitFlag = false;
		int choiceNum;
			while(!exitFlag) {
				MainViewer.mainMenuView();
				choiceNum = Integer.parseInt(sc.nextLine());
				switch(choiceNum) {
				case MENU_CHOICE.CUSTOMER :
					customerMenu();
					break;
				case MENU_CHOICE.AIRLINE :
					airlineMenu();
					break;
				case MENU_CHOICE.FLIGHT :
					flightMenu();
					break;
				case MENU_CHOICE.RESERVATION :
					reservationMenu();
					break;
				case MENU_CHOICE.EXIT:
					exitFlag = true;
					break;
				default :
					System.out.println("올바른 번호를 선택해주세요.");
				}
			}
		System.out.println("프로그램을 종료합니다.");

	}
	
	private static void reservationMenu() {
		MainViewer.reservationMenuView();
	}

	private static void flightMenu() {
		MainViewer.flightMenuView();
	}

	private static void airlineMenu() {
		MainViewer.airlineMenuView();
	}

	private static void customerMenu() {
		int choiceNum;
		CustomerResigterManager crm = new CustomerResigterManager();
		MainViewer.customerMenuView();
		choiceNum = Integer.parseInt(sc.nextLine());
		switch(choiceNum) {
		case CUSTOMER_CHOICE.LIST:
			crm.selectManager();
			break;
		case CUSTOMER_CHOICE.INSERT:
			crm.insertManager();
			break;
		case CUSTOMER_CHOICE.UPDATE:
			crm.updateManager();
			break;
		case CUSTOMER_CHOICE.DELETE:
			crm.deleteManager();
			break;
		case CUSTOMER_CHOICE.MAIN:
			break;
		}
	}

}
