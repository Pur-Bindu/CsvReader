package main;

import java.util.Date;

public class TradeReject {

	private Date timeStamp;
	private String broker;
	private String sequenceId;
	private String type;
	private String symbol;
	private String quantity;
	private String price;
	private String side;
	
	public TradeReject(Date timeStamp, String broker, String sequenceId, String type,
						String symbol,String quantity,String price,String side ){
		this.timeStamp=timeStamp;
		this.broker=broker;
		this.sequenceId=sequenceId;
		this.type=type;
		this.symbol=symbol;
		this.quantity=quantity;
		this.price=price;
		this.side=side;
		
		
	}

	@Override
	public String toString() {
		return "Trades [getTimeStamp()=" + getTimeStamp() + ", getBroker()="
				+ getBroker() + ", getSequenceId()=" + getSequenceId()
				+ ", getType()=" + getType() + ", getSymbol()=" + getSymbol()
				+ ", getQuantity()=" + getQuantity() + ", getPrice()="
				+ getPrice() + ", getSide()=" + getSide() + "]";
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getBroker() {
		return broker;
	}

	public void setBroker(String broker) {
		this.broker = broker;
	}

	public String getSequenceId() {
		return sequenceId;
	}

	public void setSequenceId(String sequenceId) {
		this.sequenceId = sequenceId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}
}
