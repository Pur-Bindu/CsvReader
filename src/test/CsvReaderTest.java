package test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import main.CsvReader;

import org.junit.Before;
import org.junit.Test;

public class CsvReaderTest {

	final String filePathNameTrades = "C:\\BINDU\\cvsreader\\CsvReader\\src\\test\\trades.csv";
    final String filePathNameSymbols = "C:\\BINDU\\cvsreader\\CsvReader\\src\\test\\symbols.txt";
    final String filePathNameBrokersAcceptedTrades = "C:\\BINDU\\cvsreader\\CsvReader\\src\\test\\brokersAcceptedTrades.csv";
    final String filePathNameBrokersRejectedTrades = "C:\\BINDU\\cvsreader\\CsvReader\\src\\test\\brokersRejectedTrades.csv";
    
	@Before
	 public void setUp() throws Exception {
		
	    
	  }
	
	@Test
	  public void parse() throws Exception {
		CsvReader reader = new CsvReader();
		reader.writeToAcceptedIdsAndBrokers(filePathNameTrades, filePathNameBrokersAcceptedTrades);
		reader.writeToRejectedIdsAndBrokers(filePathNameTrades,filePathNameBrokersRejectedTrades);
	  }

}
