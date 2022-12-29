package dsalgjava.ch02.lst0205;

public class ClassDataApp {

    public static void main(String[] args) {
        ClassDataArray arr = new ClassDataArray(100);
        
        arr.insert(new Person("Evans", "Patty", 24));
        arr.insert(new Person("Smith", "Lorraine", 37));
        arr.insert(new Person("Yee", "Tom", 43));
        arr.insert(new Person("Adams", "Henry", 63));
        arr.insert(new Person("Hashimoto", "Sato", 21));
        arr.insert(new Person("Stimson", "Henry", 29));
        arr.insert(new Person("Velasquez", "Jose", 72));
        arr.insert(new Person("Lamarque", "Henry", 54));
        arr.insert(new Person("Vang", "Minh", 22));
        arr.insert(new Person("Creswell", "Lucinda", 18));
        
        arr.display();

        String searchKey = "Stimson";
        Person found = arr.find(searchKey);
        if (found != null) {
            System.out.print("Found ");
            found.display();
        } else {
            System.out.println("Can't find " + searchKey);
        }
        
        arr.delete("Smith");
        arr.delete("Yee");
        arr.delete("Creswell");
        
        arr.display();
    }

}
