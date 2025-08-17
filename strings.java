public class strings {
    public static void main(String[] args) {

        // String abc = "Aryan God";
        // String str = "Hello, World!";
        // System.out.println(str);

        // //so when we do not use new keyword, it is stored in the string pool, it is quite popular so this woraround

        // String name = new String("Aryan");
        // System.out.println(name);
        // System.out.println(name.hashCode());
        // System.out.println(abc+name);
        // System.out.println(abc.length());
        // System.out.println(abc.charAt(2));

        // //not 2 new objects
        // //but same reference
        // String s1 = "Navin";
        // String s2 = "Navin";

        // System.out.println(s1 == s2); // true, same reference in string pool
        // System.out.println(s1.equals(s2)); // true, same content

        //String Buffer

        // StringBuffer sb = new StringBuffer("Aryan");
        // //empty cap is 16, so aryan will be 5 extra so 21
        // System.out.println(sb.capacity());
        // sb.append("god");
        // System.out.println(sb);

        // String str = sb.toString();
        // System.out.println(str);

        // sb.insert(6, "java");
        // System.out.println(sb);

        // //diff btw stringbuilder and stringbuffer is that string builder is thread safe
        // //talk about it later

    }
    
}
