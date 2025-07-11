class Vehicle{
    private String VehicleNumber;

    public Vehicle(String Vehiclenumber){
        this.VehicleNumber = Vehiclenumber;
    }

    public void honl(){
        System.out.println("Honk !!!!!!!!!!!!");
    }

    public void printVehicleNumber(){
        System.out.println("Vehicle Number: " + VehicleNumber);
    }
}

//derived class
class bus extends Vehicle{
    public bus(String busNumber){
        super(busNumber);
    }
}

//derived class
class car extends Vehicle{
    public car(String carNumber){
        super(carNumber);
    }

    @Override
    public void honl() {
        System.out.println("Car Honk !!!!!!!");
    }

}

//main
public class Main{
    public static void main(String[] args){
        car car1 = new car("KA-01-1234");
        bus bus1 = new bus("KA-02-5678");
        car1.honl();
        car1.printVehicleNumber();
        bus1.honl();    
        bus1.printVehicleNumber();
    }

}