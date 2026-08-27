import java.util.Scanner;

public class Lab2DSA {
    static int count = 0;
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int size = 0;
        int array [] = null;
        int choice;
        boolean created = false, populated = false;

        do{
            menu ();
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
                    created = true;
                }   
                menu ();
                choice = sc.nextInt();
                break;
            case 2:
                array = two(array, size);
                menu ();
                choice = sc.nextInt();
                break;
            default:
                if (choice > 5 || choice < 0){
                    System.out.println("Invalid input! Only enter choices 0 - 5. Press any key to continue...");
                    sc.nextLine();
                    sc.nextLine();
                } else if (!populated){
                    System.out.println("You must populate the array first! Press any key to continue...");
                    sc.nextLine();
                    sc.nextLine();
                }
                menu ();
                choice = sc.nextInt();
                break;
            }
         } while (choice!= 0);
    }

    public static void menu (){
        System.out.println("------------------");
        System.out.println("Array Operations");
        System.out.println("      Menu      ");
        System.out.println(" ");
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
        System.out.println("Enter your desired array size. Please pick from 5 - 20.");

        size = sc.nextInt();

        while (size < 5 || size > 20){
            System.out.println("Invalid input! Range must be from 5-20.");
            size = sc.nextInt();
        }

        if(size >= 5 && size <= 20){
            System.out.println("Array with " + size + " slots successfully created!");
        }
        return size;
    }

    public static int[] two (int[] array, int size){
        Scanner sc = new Scanner (System.in);
        
        if (array == null){
            array = new int [size];
        }

        if (count > size){
            System.out.println("Array is already full! Press any key to continue...");
            sc.nextLine();
            sc.nextLine();
            return array;
        }

        System.out.println("Enter an element or enter -99 to exit: ");
        while(count <= size){
            int element = sc.nextInt();

            if (element == -99){
                break;
            }

            boolean duplicate = false;
            for (int i = 0; i <= count; i++){
                if (array[i] == element){
                    duplicate = true;
                }
            }
            if (duplicate){
                System.out.println(element + " already exists! Enter another element or enter -99 to exit: ");
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
}