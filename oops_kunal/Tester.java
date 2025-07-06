class Encap {

    //so customerName, contactNumber, and address are not accessible from outside the class, they are not visible, is the error we get when we write the below lines
    //customer.customerId = "C101";

	public String customerId;
	private String customerName;
	private long contactNumber;
	private String address;

    public void setcustomerName(String customerName) {
        this.customerName = customerName; 
    }
    public String getcustomerName(){
        return customerName; 
    }
    public void setcustomerNumber(long contactNumber) {
        this.contactNumber = contactNumber; 
    }
    public long getcustomerNumber(){
        return contactNumber; 
    }
    public void setcustomeraddress(String add) {
        address = add; 
    }
    public String getcustomeraddress(){
        return address; 
    }
}

public class Tester {

	public static void main(String args[]) {
		Encap customer = new Encap();
		customer.customerId = "C101";
		customer.setcustomerName("Jack");
		customer.setcustomerNumber (9870345687L);
		customer.setcustomeraddress("D089, St. Louis Street, Springfield");

		System.out.println("Displaying customer details");
		System.out.println("Customer Id : " + customer.customerId);
		System.out.println("Customer Name : " + customer.getcustomerName());
		System.out.println("Contact Number : " + customer.getcustomerNumber());
		System.out.println("Address : " + customer.getcustomeraddress());
	}
}