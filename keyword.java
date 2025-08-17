public class keyword {

    //mian is staic
    //beacuse we cannot cretae the obj of keyword because the execution has not started yet
    // so therefor we have static keyword to start directly
    //execution start from main 
    public static void main(String[] args) throws ClassNotFoundException{
        mobile obj1 = new mobile();
        mobile.name = "smart";
        obj1.price = 50000;
        obj1.brand = "black";

        // mobile obj2 = new mobile();
        // mobile.name = "smart";
        // obj2.price = 50000;
        // obj2.brand = "blackberry";

        // mobile obj3 = new mobile();
        // obj3.name = "smart123";
        // obj3.price = 50000;
        // obj3.brand = "apple";

        // System.out.println(obj3.name);

        //this just prints the static block
        Class.forName("mobile");
        mobile.show1(obj1);


    }
    
}
class mobile{

    //these are instance varibales

    //with static we make it same for all the objects
    //all the objects refer to the same obj
    //we can call the static var with class name

    static String name;
    int price;
    String brand;

    //this static block called only once
    static{
        name = "Phone";
        System.out.println(name);

    }

    public mobile(){
        brand = "";
        price = 2000;
        System.out.println("constructor");
    }

    public void show(){
        System.out.println(name+" "+brand+" "+price);
    }

    public static void show1(mobile obj){
        System.out.println("in static");

        //System.out.println(name+" "+brand+" "+price);

        //non static variable in static var is not possible
        // because there will be confusion to which objects value are we referring, 
        ///instead if we pass the obj itself it will work
        /// 
        System.out.println(name+" "+obj.brand+" "+obj.price);

        //there is a thing called class loder
        //so each class only loaded once
        //so thereby static method also loaded once
    }

    

}

