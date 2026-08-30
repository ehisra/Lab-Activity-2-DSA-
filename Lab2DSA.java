import java.util.Scanner;

public class Lab2DSA {
    static int count = 0;
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int size = 0;
        int array [] = null;
        boolean created = false;
        
        options(sc, array, size, created);
    }
    
    public static void options(Scanner sc,int[] array, int size, boolean created) {
        int choice;
        
        do{
            menu ();

            while (!sc.hasNextInt()){
                System.out.println("Integers 0-5 are only accepted! Press any key to continue...");
                sc.nextLine();
                sc.nextLine();
                menu ();
            }
            
            choice = sc.nextInt();
            
            if (choice > 5 || choice < 0){
                System.out.println("Invalid input! Only enter choices 0 - 5. Press any key to continue...");
                sc.nextLine();
                sc.nextLine();
            } else if (choice != 1){
                System.out.println("You must create an array first! Press any key to continue...");
                sc.nextLine();
                sc.nextLine();
            } 

        } while (choice != 1);
        
        do{
            switch (choice){
            case 1:
                if (created){
                    System.out.println("Array already exists! Press any key to continue...");
                    sc.nextLine();
                    sc.nextLine();
                }else{
                    size = one(sc);
                    array = new int[size];
                    created = true;
                }
                menu (); 
                while (!sc.hasNextInt()){
                    System.out.println("Invalid input! Only enter choices 0 - 5. Press any key to continue...");
                    sc.nextLine();
                    sc.nextLine();
                menu ();
                }
                choice = sc.nextInt();
                break;
            case 2:
                array = two(sc, array, size);
                menu ();
                choice = sc.nextInt();
                break;
            case 3:
                if (count == 0){
                    System.out.println("You must populate the array first!");
                } else {
                    three (sc, array, count);
                }
                menu ();
                choice = sc.nextInt();
                break;
            case 4:
                if (count == 0){
                    System.out.println("You must populate the array first!");
                } else {
                    four (sc, count, array);
                }
                menu ();
                choice = sc.nextInt();
                break;
            case 5:
                if (count == 0){
                    System.out.println("You must populate the array first!");
                } else {
                    five (sc, array);
                }
                menu ();
                choice = sc.nextInt();
                break;
                
            default:
                if (choice > 5 || choice < 0){
                    System.out.println("Invalid input! Only enter choices 0 - 5. Press any key to continue...");
                    sc.nextLine();
                    sc.nextLine();
                }
                menu ();
                choice = sc.nextInt();
                break;
            }
            
            if (choice == 0) {
                zero ();
            }
            
         } while (choice !=0);
    }
    
    public static void menu (){
        header("Array Options", 50);
        header("Menu", 50);
        System.out.println("[1] Create Array");
        System.out.println("[2] Insert Elements");
        System.out.println("[3] Search");
        System.out.println("[4] Display");
        System.out.println("[5] Delete");
        System.out.println("[0] Stop");
        System.out.println(" ");
        System.out.print("Enter Choice: ");
    }

    public static int one (Scanner sc){
        int size;
        header("Create an Array", 50);

        System.out.print("Enter your desired array size. Please pick from 5 - 20: ");
        
        while (!sc.hasNextInt()){
                System.out.println();
                System.out.println("Invalid input! Only integers are accepted.");
                System.out.print("Enter your desired array size. Please pick from 5 - 20: ");
                sc.next(); 
        }

        size = sc.nextInt();

        while (size < 5 || size > 20){
            System.out.print("Invalid input! Range must be from 5-20: ");

            while (!sc.hasNextInt()){
                System.out.println(" ");
                System.out.println("Invalid input! Only integers are accepted.");
                System.out.print("Enter your desired array size. Please pick from 5 - 20: ");
                sc.next(); 
            }
            size = sc.nextInt();
        }

        if(size >= 5 && size <= 20){
            System.out.println("Array with " + size + " slots successfully created!");
        }
        return size;
    }

    public static int[] two (Scanner sc, int[] array, int size){
        header("Insert Elements", 50);

        if (array == null){
            array = new int [size];
        }

        if (count >= size){
            System.out.println("Array is already full! Press any key to continue...");
            sc.nextLine();
            sc.nextLine();
            return array;
        }
        
        System.out.println("Available Slots: " + (size - count));
        System.out.print("Enter an element or enter -99 to exit: ");
        
        while(count < size){            
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input! Only integers are accepted.");
                System.out.print("Enter an element or enter -99 to exit: ");
                sc.next();
            }
            
            int element = sc.nextInt();

            if (element == -99){
                break;
            }

            boolean duplicate = false;
            for (int i = 0; i < count; i++){
                if (array[i] == element){
                    duplicate = true;
                    break;
                }
            }
            if (duplicate){
                System.out.print(element + " already exists! Enter another element or enter -99 to exit: ");
            }else{
                array[count] = element;
                count++;
                if (count >= size){
                    System.out.println("Array is now full! Press any key to continue...");
                    sc.nextLine();
                    sc.nextLine();
                    return array;
                }
            }
        }
        return array;
    }

    static void three (Scanner sc, int array[], int count) {
        header("Search", 50);

        System.out.print ("Enter an integer to search: ");
        boolean found = false;
        
        while (!sc.hasNextInt()) {
                System.out.println("Invalid input! Only integers are accepted.");
                System.out.print("Enter an integer to search: ");
                sc.next();
        }
        
        int searchId = sc.nextInt();   
        int indexCount = 0;

        for (int j = 0; j < count; j++) {
                if (array[j] == searchId) {
                    found = true;
                    indexCount = j;
                    break;
                } 
            }
        System.out.println();
        if (found) {
            System.out.println("Integer " + searchId + " found at index " + indexCount);
        } else {
            System.out.println("Integer " + searchId + " not found");
        }
        System.out.print("Press Any Key to Continue..."); 
        sc.nextLine();
        sc.nextLine();
    }

    static void four (Scanner sc, int count, int[] array) {
        header("Display", 50);

        System.out.println("Elements of the Array: ");
        System.out.println();
        if (count == 0) {
            System.out.println("Your array is empty!");
        
        } else {
            
            for (int i = 0; i < count; i += 5) {
                for (int j = 0; j < 5 && i + j < count; j++) {
                    System.out.printf("%7d", array[i + j]);
                } 
                System.out.println(); 
            }
        }
        System.out.println();
        //System.out.println();
        System.out.print("Press Any Key to Continue..."); 
        sc.nextLine();
        sc.nextLine();
    }
    
    static void five (Scanner sc, int[] array) {
        header("Delete", 50);

        if (count == 0) {
            System.out.println("Array is empty! Nothing to delete.");
            System.out.print("Press Any Key to continue...");
            sc.nextLine();
            sc.nextLine();
            return;
        }

        System.out.println("\nCurrent Array:");
        for (int i = 0; i < count; i++) {
            System.out.printf("%7d", array[i]);
        }
        System.out.println();

        System.out.print("Enter an integer to delete: ");
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input! Only integers are accepted.");
            System.out.print("Enter an integer to delete: ");
            sc.next();
        }
        int target = sc.nextInt();
        int targetIndex = -1;
        
        for (int i = 0; i < count; i++) {
            if (array[i] == target) {
                targetIndex = i;
                break;
            }
        }
        
        if (targetIndex == -1) {
            System.out.println(target + " was not found in the array.");
        } else {
            for (int i = targetIndex; i < count -1; i++) {
                array [i] = array [i + 1];
            }
            count --;
            System.out.println(target + " was deleted");
        }
        System.out.println("\nUpdated Array:");
        for (int i = 0; i < count; i++) {
            System.out.printf("%7d", array[i]);
        }
        System.out.println();
        System.out.print("Press Any Key to continue...");
        sc.nextLine();
        sc.nextLine();
    }

    public static String center(String text, int width) {
        if (text == null || width <= text.length()) 
        return text;
        int padding = (width - text.length()) / 2;
        return String.format("%" + padding + "s%s%" + (width - text.length() - padding) + "s", "", text, "");
    }

    public static void header (String text, int width) {
        String line = String.format("%50s", "").replace(' ', '-');
        String header = center(text, width);
        
        System.out.println(line);
        System.out.println(header);
        System.out.println(line);
    }

    static void zero() {
        System.out.println("Program terminated. Goodbye!");
    }
}