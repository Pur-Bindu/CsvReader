package main;

import java.io.File;

public class CsvValidator {
	
	boolean ifFileSizeIsNotZero(File file){
		double kilobytes = (file.length())/1024;
		if(kilobytes==0){
			return false;
		}
		return true;
	}
	
	boolean getNumberOfColumns(String[] tradeDetails){
		//Make sure you have all values in tradeDetails from Trades.csv
		 if(tradeDetails.length!=8){
			 return true;
		 }
		return false;
	}

	boolean checkForInvalidString(String message){
		if(message.contains(",,") || message.contains(", ,") || message.contains("null") || message.contains(", ")){
			return true;
		}
		return false;
	}
}
