package com.epam.vvit;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
	static final Logger logger = LogManager.getLogger(App.class);
	public static void main(String argsp[]) throws IOException {
		
		OutputStreamWriter streamWriter = new OutputStreamWriter(System.out);
		Scanner scan = new Scanner(System.in);
		
		float principalAmount;
		float annualIntersetRate;
		int time;
		int choice;
		Interest interest;
		
		try {
			logger.info("Simple Interest and Compound Interest!\n");
			streamWriter.flush();
			
			logger.info("\nEnter Principal amount (in Rs) : ");
			streamWriter.flush();
			principalAmount = scan.nextFloat();
			
			logger.info("\nEnter Rate of Interest (in Percentage) : ");
			streamWriter.flush();
			annualIntersetRate = scan.nextFloat();
			
			logger.info("\nEnter Time period (in Years) : ");
			streamWriter.flush();
			time = scan.nextInt();
			
			interest = new Interest(principalAmount,annualIntersetRate,time);
			
			logger.info("\n1.Simple Interest\n2.Compound Interest\nEnter Your choice : ");
			streamWriter.flush();
			
			choice = scan.nextInt();
		}
		catch(Exception e) {
			logger.error("\nMismatch in input");
			streamWriter.close();
			return ;
		}
		
		if(choice == 1) {
			double simpleInterest = interest.calculateSimpleInterest();
			logger.info("\nSimple Interest is : " + String.valueOf(simpleInterest)+"/-");
			logger.info("\nTotal amount to be paid is : " + String.valueOf(principalAmount+simpleInterest) + "/-");
		}
		else if (choice == 2) {
			double compoundInterest = interest.calculateCompoundInterest();
			logger.info("\nCompound Interest is : " + String.valueOf(compoundInterest)+"/-");
			logger.info("\nTotal amount to be paid is : " + String.valueOf(principalAmount+compoundInterest) + "/-");
			
		}
		else {
			logger.error("\nInvalid Choice!");
		}
		streamWriter.flush();
	}

}