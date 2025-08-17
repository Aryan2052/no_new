public class encap {
    //basically 
    //getter and setter
    //binding the variables, methods togetehr
    public static void main(String[] args){
        //encapsulation
        details det = new details();

        det.setName("aryan");
        det.getName();
        det.setPhone(1234567898);
        det.getPhone();
    }
    
}

class details{
    private String name;
    private long phone_no;

    public void setName(String a){
        name = a;
    }
    public void setPhone(long a){
        phone_no = a;
    }
    public void getName(){
        System.out.println(name);
    }
    public void getPhone(){
        System.out.println(phone_no);
    }
}

