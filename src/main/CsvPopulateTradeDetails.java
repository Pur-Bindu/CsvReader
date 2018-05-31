package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CsvPopulateTradeDetails {
	
	List<TradeReject> tradeRejectList = new ArrayList<TradeReject>();
	List<Trade> tradeList = new ArrayList<Trade>();
	List<List> tradesCombineList = new ArrayList<List>();
	SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy HH:mm");
	CsvValidator validator = new CsvValidator();
	
	//Make sure you have all values in tradeDetails from Trades.csv
	List<List> populateCsvWithRejectTrades(String[] tradeDetails, TradeReject tradeReject, Trade trade, String message) throws ParseException{
		if(validator.getNumberOfColumns(tradeDetails)){
		tradeReject = new TradeReject(formatter.parse(tradeDetails[0]),tradeDetails[1],tradeDetails[2],
 				tradeDetails[3],tradeDetails[4],tradeDetails[5],tradeDetails[6],"none");
		tradeRejectList.add(tradeReject);
		} else if(validator.checkForInvalidString(message)){
			 tradeReject = new TradeReject(formatter.parse(tradeDetails[0]),tradeDetails[1],tradeDetails[2],
		 				tradeDetails[3],tradeDetails[4],tradeDetails[5],tradeDetails[6],tradeDetails[7]);
			 tradeRejectList.add(tradeReject);
		}
		else {
			trade = new Trade(formatter.parse(tradeDetails[0]),tradeDetails[1],tradeDetails[2],
					tradeDetails[3],tradeDetails[4],tradeDetails[5],tradeDetails[6],tradeDetails[7]);
			tradeList.add(trade);
		}
		System.out.println(message);
		
		
		tradesCombineList.add(tradeList);
		tradesCombineList.add(tradeRejectList);
		return tradesCombineList;
	}
	
}
