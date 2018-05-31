package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

	//comma as a separator in the CSV file
    private static final String COMMA_DELIMITER = ",";
    
	/**
	 * Reads from "trades.csv"
	 * fields read from trades.csv file: 
	 * "Time stamp","broker","sequence id","type","Symbol","Quantity","Price","Side"
	 * Also, returns the above values from trades.csv
	 * 
	 * @param fileName to be read
	 * @param? 
	 * @return values for all the specific fields
	 * @throws IOException, FileIOException, ParseException
	 */
	public static List<List> readTradesCsv(String filePathName) throws IOException, FileNotFoundException, ParseException{
		
		File tradesCsvFile = new File(filePathName);
		CsvPopulateTradeDetails validateAndPopulate = new CsvPopulateTradeDetails();
		FileReader fileReader= new FileReader(tradesCsvFile);
		//BufferedReader class to read the file
		BufferedReader bufferReader = null;
		//variable to fetch each row from tradesCsvFile
		String message="";
		//Create List for holding Employee objects
        List<List> tradesCombineList = new ArrayList<List>();
        
        TradeReject tradeReject = null;
        Trade trade = null;
		try{
			//BuffereReader to read data from file line by line
			bufferReader = new BufferedReader(fileReader);
			//readLine to skip the headers from the csv
			bufferReader.readLine();
			while((message=bufferReader.readLine()) != null){
				//split the separated message lines by comma
				 String[] tradeDetails = message.split(COMMA_DELIMITER);
				 tradesCombineList=validateAndPopulate.populateCsvWithRejectTrades(tradeDetails,tradeReject,trade,message);

				}
		  } 
		finally {
			if(bufferReader!=null){
				bufferReader.close();
			  }
		  }
		return tradesCombineList;
	}
	
	
	
	/**
	 *Reads from symbols.txt
	 *Helps with fetching symbols from the above file
	 *Also, returns the symbols
	 *
	 *@param fileName to be read - symbols.txt
	 *@param?
	 *@return symbols from symbols.txt
	 *@throws IOException, FileIOException
	 **/
	public void readSymbolsTxt(){
		
	}
	/**
	 * Writes the Broker Names and Sequence IDs of Accepted orders
	 * 
	 * @param?
	 * @return fileName written with the path?
	 * @throws ParseException 
	 * @throws IOException, FileIOException
	 */
	public static void writeToAcceptedIdsAndBrokers(String filePathName,String filePathNameTrades) throws FileNotFoundException, IOException, ParseException{
		  //PrintWriter object for file3.txt
	      PrintWriter pw = new PrintWriter(filePathNameTrades);
		  try{
		  
			  List<List> tradeCombineList = new ArrayList<List>();
			  List<Trade> tradeList = new ArrayList<Trade>();
			  tradeCombineList = readTradesCsv(filePathName);
			  tradeList=tradeCombineList.get(0);
	
			  StringBuilder sb = new StringBuilder();
		      sb.append("Broker Name");
		      sb.append(',');
		      sb.append("Sequence ID");
		      sb.append('\n');

		  //print trades from List
		  for(Trade t : tradeList)
	      	{
			  sb.append(t.getBroker());
		      sb.append(',');
		      sb.append(t.getSequenceId());
		      sb.append('\n');
	      	}	
		  pw.write(sb.toString());
		  }finally{
			  pw.flush();
			  pw.close();
		  }
	}
	
	/**
	 * Writes the Broker Names and Sequence IDs of Rejected orders
	 * 
	 * @param?
	 * @return fileName written with the path?
	 * @throws ParseException 
	 * @throws FileNotFoundException 
	 * @throws IOException, FileIOException
	 */
	public static void writeToRejectedIdsAndBrokers(String filePathName, String filePathNameTrades) throws FileNotFoundException, IOException, ParseException{
		  //PrintWriter object for file3.txt
	      PrintWriter pw = new PrintWriter(filePathNameTrades);
		  try{
		  
			  List<List> tradeCombineList = new ArrayList<List>();
			  List<TradeReject> tradeRejectList = new ArrayList<TradeReject>();
			  tradeCombineList = readTradesCsv(filePathName);
			  tradeRejectList=tradeCombineList.get(1);
			  
			  StringBuilder sb = new StringBuilder();
			  sb.append("Broker Name");
		      sb.append(',');
		      sb.append("Sequence ID");
		      sb.append('\n');

		  //print trades from List
		  for(TradeReject tr : tradeRejectList)
	      	{
			  	sb.append(tr.getBroker());
			  	sb.append(',');
			    sb.append(tr.getSequenceId());
			    sb.append('\n');
	      	}	
		    pw.write(sb.toString());		  
		  }finally{
			  pw.flush();
			  pw.close();
		  }
	}
	
	
	//later?
	public void writeToAcceptedOrders(){
		
	}
	
	//later?
	public void writeToRejectedOrders(){
		
	}
	
	public static void main(String args[]) throws FileNotFoundException, IOException, ParseException{
		
		/*String filePathName = "C:\\Users\\Mad_Vam\\OneDrive\\Documents\\exerciseforltse\\trades_org.csv";
		List<Trade> tradeList = new ArrayList<Trade>();
		//readTradesCsv(filePathName);
		tradeList = readTradesCsv(filePathName); 
		//print trades from List
		for(Trade t : tradeList)
        {
			//System.out.println("kjjkjkj");
            System.out.println(t.getTimeStamp()+"   "+t.getBroker()+"   "
            						+t.getSequenceId()+"   "+t.getType()+"   "+t.getSymbol()+"    "
            								+t.getQuantity()+"    "+t.getPrice()+"    "+t.getSide());
        }*/

		final String filePathNameTrades = "C:\\BINDU\\cvsreader\\CsvReader\\src\\test\\trades_org.csv";
	    final String filePathNameSymbols = "C:\\BINDU\\cvsreader\\CsvReader\\src\\test\\symbols.txt";
	    final String filePathNameBrokersAcceptedTrades = "C:\\BINDU\\cvsreader\\CsvReader\\src\\test\\brokersAcceptedTrades.csv";
	    final String filePathNameBrokersRejectedTrades = "C:\\BINDU\\cvsreader\\CsvReader\\src\\test\\brokersRejectedTrades.csv";
	    
		writeToAcceptedIdsAndBrokers(filePathNameTrades, filePathNameBrokersAcceptedTrades);
		writeToRejectedIdsAndBrokers(filePathNameTrades,filePathNameBrokersRejectedTrades);
	}
}
