package Com.admin.model;

import java.time.LocalDate;

public class Booking {
	private int ConsumerId;
	private int BookingId;
	private String CylinderType;
	private int NoOfCylinder;
	private LocalDate Date;
	private LocalDate dDate;
	private double totalamt;
	private boolean cdilivery;
	private String name;
	public Booking(int consumerId, int bookingId, String i, String c_no, String Date) {
		super();
		this.ConsumerId = consumerId;
		this.BookingId = bookingId;
		this.CylinderType = i;
		this.NoOfCylinder =Integer.parseInt(c_no) ;
		this.Date =LocalDate.parse(Date);
	}
	public LocalDate getdDate() {
		return dDate;
	}
	public void setdDate(LocalDate dDate) {
		this.dDate = dDate;
	}
	public double getTotalamt() {
		return totalamt;
	}
	public void setTotalamt(double totalamt) {
		this.totalamt = totalamt;
	}
	public boolean getiCdilivery() {
		return cdilivery;
	}
	public void setCdilivery(boolean cdilivery) {
		this.cdilivery = cdilivery;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Booking(String dDate, double totalamt, boolean cdilivery, String name) {
		super();
		this.dDate =LocalDate.parse(dDate);
		this.totalamt =totalamt;
		this.cdilivery = cdilivery;
		this.name = name;
	}
	public Booking(int consumerId, String cylinderType, int noOfCylinder, String date) {
		super();
		this.ConsumerId = consumerId;
		this.CylinderType = cylinderType;
		this.NoOfCylinder = noOfCylinder;
		this.Date =LocalDate.parse(date);
	}
	public int getConsumerId() {
		return ConsumerId;
	}
	public void setConsumerId(int consumerId) {
		ConsumerId = consumerId;
	}
	public int getBookingId() {
		return BookingId;
	}
	public void setBookingId(int bookingId) {
		BookingId = bookingId;
	}
	public String getCylinderType() {
		return CylinderType;
	}
	public void setCylinderType(String cylinderType) {
		CylinderType = cylinderType;
	}
	public int getNoOfCylinder() {
		return NoOfCylinder;
	}
	public void setNoOfCylinder(int noOfCylinder) {
		NoOfCylinder = noOfCylinder;
	}
	public LocalDate getDate() {
		return Date;
	}
	public void setDate(LocalDate Date) {
		Date = Date;
	}
	
}
