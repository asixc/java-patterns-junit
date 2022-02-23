package com.example.structural.facade;


import com.example.structural.facade.pieces.SmartPhone;

public class Main {
	
	public static void main(String[] args) {
		
		// crear un smartphone
		SmartPhone oneplus = SmartPhoneFacade.startSmartPhone();
	}

}
