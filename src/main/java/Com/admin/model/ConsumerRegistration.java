package Com.admin.model;
import java.time.LocalDate;

public class ConsumerRegistration {
	private int consumerId;
	private String name;
	private int passbook;
	private Long adhar;
	private int ration;
	private String gender;
	private String address;
	private int pincode;
	private int phone;
	private LocalDate DOB;
	private LocalDate dateOfRegister;
	private String ctype;
	private int no_of_cylinder;
	
	public ConsumerRegistration(int consumerId, String name, int passbook, Long adhar, int ration, String gender, String address,
			int pincode, int phone, String DOB, String dateOfRegister, String ctype, int no_of_cylinder ) {
		super();
		this.consumerId = consumerId;
		this.name = name;
		this.passbook = passbook;
		this.adhar = adhar;
		this.ration = ration;
		this.gender = gender;
		this.address = address;
		this.pincode = pincode;
		this.phone = phone;
		this.DOB = LocalDate.parse(DOB);
		this.dateOfRegister = LocalDate.parse(dateOfRegister);
		this.ctype = ctype;
		this.no_of_cylinder = no_of_cylinder;		
	}
	
	public ConsumerRegistration(int cOnsumerId, String name) {
		super();
		consumerId = consumerId;
		this.name = name;
	}

	public int getConsumerId() {
		return consumerId;
	}
	public void setCOnsumerId(int cOnsumerId) {
		consumerId = cOnsumerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPassbook() {
		return passbook;
	}
	public void setPassbook(int passbook) {
		this.passbook = passbook;
	}
	public Long getAdhar() {
		return adhar;
	}
	public void setAdhar(Long adhar) {
		this.adhar = adhar;
	}
	public int getRation() {
		return ration;
	}
	public void setRation(int ration) {
		this.ration = ration;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public LocalDate getDOB() {
		return DOB;
	}
	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}
	public LocalDate getDateOfRegister() {
		return dateOfRegister;
	}
	public void dateOfRegister(LocalDate dateOfRegister) {
		this.dateOfRegister = dateOfRegister;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public int getNo_of_cylinder() {
		return no_of_cylinder;
	}
	public void setNo_of_cylinder(int no_of_cylinder) {
		this.no_of_cylinder = no_of_cylinder;
	}
	
	
}