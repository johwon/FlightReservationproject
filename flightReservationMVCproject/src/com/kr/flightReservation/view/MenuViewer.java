package com.kr.flightReservation.view;

import com.kt.flightReservation.controller.AirLineResigterManager;

public class MenuViewer {

	private static void customerMenu() {
		int choiceNum;
		CustomerResigterManager crm = new CustomerResigterManager();

		System.out.println();
		MainViewer.customerMenuView();
		choiceNum = Integer.parseInt(sc.nextLine());
		switch (choiceNum) {
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
		case CUSTOMER_CHOICE.GRADE_PRINT:
			crm.gradePrintManager();
			break;
		case CUSTOMER_CHOICE.MAIN:
			break;
		}
		System.out.println();
	}

	private static void airLineMenu() {
		int choiceNum;
		AirLineResigterManager arm = new AirLineResigterManager();

		System.out.println();
		MainViewer.AirLineMenuView();
		choiceNum = Integer.parseInt(sc.nextLine());
		switch (choiceNum) {
		case AIRLINE_CHOICE.LIST:
			arm.listManager();
			break;
		case AIRLINE_CHOICE.INSERT:
			arm.insertManager();
			break;
		case AIRLINE_CHOICE.UPDATE:
			arm.updateManager();
			break;
		case AIRLINE_CHOICE.DELETE:
			arm.deleteManager();
			break;
		case AIRLINE_CHOICE.AIRLINE_GRADE:
			arm.funcManager();
			break;
		case AIRLINE_CHOICE.MAIN:
			break;
		}
		System.out.println();
	}

	private static void reservationMenu() {
		int choiceNum;
		ReservationResigterManager rrm = new ReservationResigterManager();

		System.out.println();
		MainViewer.reservationMenuView();
		choiceNum = Integer.parseInt(sc.nextLine());
		switch (choiceNum) {
		case RESERVATION_CHOICE.LIST:
			rrm.selectManager();
			break;
		case RESERVATION_CHOICE.INSERT:
			rrm.insertManager();
			break;
		case RESERVATION_CHOICE.UPDATE:
			rrm.updateManager();
			break;
		case RESERVATION_CHOICE.DELETE:
			rrm.deleteManager();
			break;
		case RESERVATION_CHOICE.LIST_ALL:
			rrm.selectAllManager();
			break;
		case RESERVATION_CHOICE.MAIN:
			break;
		}
		System.out.println();
	}
}
