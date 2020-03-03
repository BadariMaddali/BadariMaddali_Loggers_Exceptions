package com.epam.vvit;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
	static final Logger logger = LogManager.getLogger(App.class);
	public static void main(String args[]) throws IOException {
		
		OutputStreamWriter streamWriter = new OutputStreamWriter(System.out);
		Scanner scan = new Scanner(System.in);
		
		logger.info("---Estimating Construction cost of House--- \n\n");
		
		String materialStandard;
		double totalArea;
		String fullyAutomated;
		
		try {
			logger.info("\nEnter standard for materials (normal / above / high) : ");
			streamWriter.flush();
			materialStandard = scan.nextLine();
			
			logger.info("\nEnter Total area of the house (in Square feet) : ");
			streamWriter.flush();
			totalArea = scan.nextDouble();
			scan.nextLine();
			
			logger.info("\nEnter whether house is \"Fully\" Automated or not (yes/no) : ");
			streamWriter.flush();
			fullyAutomated = scan.nextLine();
		}
		catch(InputMismatchException e) {
			logger.error("\nMismatch in Input!!\n");
			streamWriter.close();
			return;
		}
		
		HouseConstruction houseConstruction = new HouseConstruction();
		double costOfConstruction = houseConstruction.calculateConstructionCost(materialStandard,totalArea,fullyAutomated);
		
		if (costOfConstruction != 0)
			logger.info("\n\nConstruction cost of the house : " + String.valueOf(costOfConstruction)+"/-");
		else
			logger.error("\nInvalid Choice of inputs!");
		
		streamWriter.flush();
		streamWriter.close();
	}
}
