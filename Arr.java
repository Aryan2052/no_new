public class Arr {
    public static void main(String[] args) {
        // int nums[][] = new int[3][4];

        // int random = 0;

        // for(int i=0; i<3; i++){
        //     for(int j=0; j<4; j++){
        //         random = (int)(Math.random()*100);
        //         System.out.print(random + " ");
        //         nums[i][j]=random;
        //     }
        // }

        // //there is a jagged array also
        // //we specify the no of columns of each row
        // int nums1[][] = new int[3][];
        // nums1[0] = new int[2];
        // nums1[1] = new int[3];

        // for(int n[]: nums){
        //     for(int x: n){
        //         System.out.print(x + " ");
        //     }
        //     System.out.println();
        // }

        // //drwabacks
        // //1. we cannot change the size of the array after it is created
        // //inside the heap memmory, it will occupy a contigious space
        // //2. we cannot store different data types in the same array
        // //3. we cannot use methods like add, remove, etc.

        // int nums2[] = new int[5];
        // nums2[0] = 10;
        // nums2[1] = 20;
        // nums2[2] = 30;
        // nums2[3] = 40;

        // for(int i=0; i<7; i++){
        //     if(i < nums2.length) {
        //         System.out.print(nums2[i] + " ");
        //     }
        // }

        // student s1 = new student();
        // s1.roll = 101;
        // s1.name = "John";
        // s1.marks = 85;

        // student s2 = new student();
        // s2.roll = 102;
        // s2.name = "Jane";
        // s2.marks = 90;

        // student s3 = new student();
        // s3.roll = 103;
        // s3.name = "Doe";
        // s3.marks = 95;

        // student[] students = new student[3];

        // //these are student references, and not objects
        // students[0] = s1;
        // students[1] = s2;
        // students[2] = s3; 

        // // for(student s: students){
        // //     System.out.println("Roll: " + s.roll + ", Name: " + s.name + ", Marks: " + s.marks);
        // // }

        // for(int i=0; i<students.length; i++){
        //     System.out.println("Roll: " + students[i].roll + ", Name: " + students[i].name + ", Marks: " + students[i].marks);
        // }

        //for each loop
        //only worksin array currently for our study

        int[] nums2 = {1,2,3,4,5};

        for(int n: nums2){
            System.out.print(n + " ");
        }

    }
    
}
class student{
    int marks;
    int roll;
    String name;
}
