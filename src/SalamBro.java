import java.util.*;
public class SalamBro {
    public static void main(String[] args)
    {
        MenuAdmin ok = new MenuAdmin();
        MenuAdmin.adminPanel();
    }
}
class MenuAdmin {
    public static void adminPanel() {
        Scanner s = new Scanner(System.in);
        boolean exit = true;
        String welcomeMessage = "";
        int i;
        String[] menu = new String[100];
        String[][] submenu = new String[100][100];
        int[][] price = new int[100][100];
        int check;
        System.out.print("Welcome to the Admin Panel of \"Salam Bro\" Fast Food Station!\nHere you can do the following activities:\n\n");
        while (exit) {
            System.out.print("0. Exit. \n1. Change Welcome Message. \n2. Change Menu. \n3. Change SubMenu.\n4. Change Prices. \n5. Display Welcome Message. \n6. Display Menu. \n7. Display SubMenu. \n8. Display Prices. \n9. Switch to Client Mode.");
            System.out.print("\n\nChoose an activity: ");
            i = s.nextInt();
            switch (i) {
                case 0:
                    exit = false;
                    break;
                case 1:
                    System.out.print("\nPlease, type the message that clients will see when they enter the menu:\nTip: use underscore (_) as a splitter\n> ");
                    s.nextLine();
                    welcomeMessage = s.nextLine().replaceAll("_", "\n");
                    break;
                case 2:
                    System.out.print("\nHere you can do the following activities:\n0.Go Back.\n1.Add categories.\n2.Remove categories\n\nYour choice: ");
                    i = s.nextInt();
                    switch (i) {
                        case 1:
                            System.out.print("\nWrite the names of categories separated by comma (c1, c2, ...):\n> ");
                            s.nextLine();
                            String[] tempMenu = s.nextLine().split(", ");
                            for (int j = 0; j < tempMenu.length; j++) {
                                menu[j] = tempMenu[j];
                            }
                            break;
                        case 2:
                            check = 0;
                            for (int j = 0; j < 100; j++) {
                                if (menu[j] != null) {
                                    check++;
                                }
                            }
                            if (check != 0) {
                                for (int j = 0; j < 100; j++) {
                                    if (menu[j] != null) {
                                        System.out.println(j + 1 + ". " + menu[j]);
                                    }
                                }
                                System.out.print("\nTip: write the indexes separated by comma (i1, i2, ...)\n> ");
                                s.nextLine();
                                String[] tempMenuRemove = s.nextLine().split(", ");
                                int[] menuRemoveIndex = new int[100];
                                for (int j = 0; j < tempMenuRemove.length; j++) {
                                    menuRemoveIndex[j] = Integer.parseInt(tempMenuRemove[j].trim());
                                }
                                for (int j = 0; j < tempMenuRemove.length; j++) {
                                    menu[menuRemoveIndex[j] - 1] = null;
                                    for (int k = 0; k < 100; k++) {
                                        submenu[menuRemoveIndex[j]-1][k] = null;
                                        price[menuRemoveIndex[j]-1][k] = 0;
                                    }

                                }
                            } else System.out.println("You don't have a menu yet\n");
                            break;
                    }
                    break;
                case 3:
                    System.out.print("\nHere you can do the following activities:\n0.Go Back.\n1.Add subcategories.\n2.Remove subcategories\n\nYour choice: ");
                    i = s.nextInt();
                    switch (i) {
                        case 1:
                            check = 0;
                            for (int j = 0; j < 100; j++) {
                                if (menu[j] != null) {
                                    check++;
                                }
                            }
                            if (check != 0) {
                                System.out.print("\nChoose a category for which you want to add subcategories:\n");
                                for (int j = 0; j < 100; j++) {
                                    if (menu[j] != null) {
                                        System.out.println(j + 1 + ". " + menu[j]);
                                    }
                                }
                                System.out.print("> ");
                                i = s.nextInt();
                                if (menu[i - 1] != null) {
                                    System.out.print("\nWrite the names of subcategories separated by comma (c1, c2, ...):\n> ");
                                    s.nextLine();
                                    String[] tempSubmenu = s.nextLine().split(", ");
                                    for (int j = 0; j < tempSubmenu.length; j++) {
                                        submenu[i - 1][j] = tempSubmenu[j];
                                    }
                                }
                            } else System.out.println("\nYou don't have a menu yet\n");
                            break;
                        case 2:
                            check = 0;
                            for (int j = 0; j < 100; j++) {
                                if (menu[j] != null) {
                                    check++;
                                }
                            }
                            if (check != 0) {
                                for (int j = 0; j < 100; j++) {
                                    if (menu[j] != null) {
                                        System.out.println(j + 1 + ". " + menu[j]);
                                    }
                                }
                                check = 0;
                                System.out.print("> ");
                                i = s.nextInt();
                                for (int j = 0; j < 100; j++) {
                                    if (submenu[i - 1][j] != null) {
                                        check++;
                                    }
                                }
                                if(menu[i-1] == null){
                                    continue;
                                }
                                else if (check != 0) {
                                    System.out.println();
                                    for (int j = 0; j < 100; j++) {
                                        if (submenu[i - 1][j] != null) {
                                            System.out.println(j + 1 + ". " + submenu[i - 1][j]);
                                        }
                                    }
                                    System.out.println();
                                    System.out.print("\nTip: write the indexes separated by comma (i1, i2, ...) \n> ");
                                    s.nextLine();
                                    String[] tempSubmenuRemove = s.nextLine().split(", ");
                                    int[] submenuRemoveIndex = new int[100];
                                    for (int j = 0; j < tempSubmenuRemove.length; j++) {
                                        submenuRemoveIndex[j] = Integer.parseInt(tempSubmenuRemove[j].trim());
                                    }
                                    for (int j = 0; j < tempSubmenuRemove.length; j++) {
                                        submenu[i - 1][submenuRemoveIndex[j] - 1] = null;
                                        price[i - 1][submenuRemoveIndex[j] - 1] = 0;
                                    }
                                } else System.out.print("\n\nYou don't have subcategories in this category\n\n");
                            } else System.out.println("\nYou don't have a menu yet\n");
                            break;
                    }
                    break;
                case 4:
                    check = 0;
                    for (int j = 0; j < 100; j++) {
                        if (menu[j] != null) {
                            check++;
                        }
                    }
                    if (check != 0) {
                        System.out.print("\nChoose a category for which you want to change prices of subcategories:\n");
                        for (int j = 0; j < 100; j++) {
                            if (menu[j] != null){
                                System.out.println(j + 1 + ". " + menu[j]);
                            }
                        }
                        check = 0;
                        System.out.print("> ");
                        i = s.nextInt();
                        for (int j = 0; j < 100; j++) {
                            if (submenu[i - 1][j] != null) {
                                check++;
                            }
                        }
                        if(menu[i-1] == null){
                            continue;
                        }
                        else if (check != 0) {
                            System.out.println();
                            System.out.print("\nChoose subcategories for which you want to change prices:\n");
                            for (int j = 0; j < 100; j++) {
                                if (submenu[i - 1][j] != null) {
                                    System.out.println(j + 1 + ". " + submenu[i - 1][j] + " - " + price[i - 1][j] + " kzt");
                                }
                            }
                            System.out.println();
                            System.out.print("\nTip: write the indexes separated by comma (i1, i2, ...)\n> ");
                            s.nextLine();
                            String[] tempPrice = s.nextLine().split(", ");
                            int[] priceIndex = new int[100];
                            for (int j = 0; j < tempPrice.length; j++) {
                                priceIndex[j] = Integer.parseInt(tempPrice[j].trim());
                            }
                            for (int j = 0; j < tempPrice.length; j++) {
                                if (submenu[i - 1][j] != null) {
                                    System.out.print("\nEnter a new price for " + submenu[i - 1][priceIndex[j] - 1] + ":");
                                    price[i - 1][priceIndex[j] - 1] = s.nextInt();
                                }
                            }
                        } else System.out.print("\n\nYou don't have subcategories in this category\n\n");
                    } else System.out.println("\nYou don't have a menu yet\n");
                    break;
                case 5:
                    System.out.println("\n" + welcomeMessage + "\n");
                    break;
                case 6:
                    check = 0;
                    for (int j = 0; j < 100; j++) {
                        if (menu[j] != null) {
                            check++;
                        }
                    }
                    if (check != 0) {
                        for (int j = 0; j < 100; j++) {
                            if (menu[j] != null) {
                                System.out.println(j + 1 + ". " + menu[j]);
                            }
                        }
                        System.out.println();
                    } else System.out.println("\nYou don't have a menu yet\n");
                    break;
                case 7:
                    check = 0;
                    for (int j = 0; j < 100; j++){
                        if (menu[j] != null){
                            check++;
                        }
                    }
                    if (check != 0){
                        System.out.print("\nChoose the category for which you want to see its subcategories:\n");
                        for (int j = 0; j < 100; j++) {
                            if (menu[j] != null) {
                                System.out.println(j + 1 + ". " + menu[j]);
                            }
                        }
                        check = 0;
                        System.out.print("> ");
                        i = s.nextInt();
                            for (int j = 0; j < 100; j++) {
                                if (submenu[i - 1][j] != null) {
                                    check++;
                                }
                            }
                            if(menu[i-1] == null){
                                continue;
                            }
                            else if (check != 0) {
                                System.out.println();
                                for (int j = 0; j < 100; j++) {
                                    if (submenu[i - 1][j] != null) {
                                        System.out.println(j + 1 + ". " + submenu[i - 1][j]);
                                    }
                                }
                                System.out.println();
                            } else System.out.print("\n\nYou don't have subcategories in this category\n\n");
                    } else System.out.println("\nYou don't have a menu yet\n");
                    break;
                case 8:
                    check = 0;
                    for (int j = 0; j < 100; j++){
                        if (menu[j] != null){
                            check++;
                        }
                    }
                    if (check != 0){
                        System.out.println("Choose the category for which you want to see its subcategories' prices:");
                        for (int j = 0; j < 100; j++){
                            if (menu[j] != null){
                                System.out.println(j + 1 + ". " + menu[j]);
                            }
                        }
                        check = 0;
                        System.out.print("> ");
                        i = s.nextInt();
                        for (int j = 0; j < 100; j++){
                            if (submenu[i - 1][j] != null){
                                check++;
                            }
                        }
                        if(menu[i-1] == null){
                            continue;
                        }
                        else if (check != 0){
                            System.out.println();
                            for (int j = 0; j < 100; j++){
                                if (submenu[i - 1][j] != null){
                                    System.out.println(j + 1 + ". " + submenu[i - 1][j]+" - "+price[i-1][j]+" kzt");
                                }
                            }
                            System.out.println();
                        }
                        else System.out.print("\n\nYou don't have subcategories in this category\n\n");
                    }
                    else System.out.println("\nYou don't have a menu yet\n");
                    break;
                case 9:
                    check = 0;
                    for (int j = 0; j < 100; j++){
                        if(menu[j]!=null){
                            check++;
                        }
                    }
                    if(check!=0){
                        MenuClients mod = new MenuClients();
                        MenuClients.clientMod(menu, submenu, price);
                        break;
                    }
                    else System.out.println("\nYou don't have a menu yet\n");
            }
        }
    }
}
class MenuClients {
    public static void clientMod(String[] menu, String[][] submenu, int[][] price)
    {
        Scanner s = new Scanner(System.in);
        ArrayList<String> basket = new ArrayList<String>();
        ArrayList<Integer> totalprice = new ArrayList<Integer>();
        boolean exit = true;
        int check;
        System.out.println("Hi there!\n");
        System.out.println("Welcome to the menu of \"Salam Bro\" Fast Food Station.");
        System.out.println("Here you can see our menu below.\n");
        while (exit){
            int count = 0;
            System.out.println("\n0. Exit menu");
            for (int k = 0; k < menu.length; k++){
                if (menu[k] != null){
                    System.out.println(k + 1 + ". " + menu[k]);
                    count++;
                }
            }
            System.out.println(count + 1 + ". " + "Clear basket");
            System.out.println(count + 2 + ". " + "Check basket");
            System.out.print("\nChoose one: ");
            int i = s.nextInt();
            if (i == 0){
                exit = false;
            }
            else if (i <= count){
                check = 0;
                for (int k = 0; k <submenu[i-1].length ; k++){
                    if(submenu[i-1][k]!=null){
                        check++;
                    }
                }
                if(check!=0){
                    System.out.println("\n0. Exit menu");
                    for (int k = 0; k < submenu[i - 1].length; k++){
                        if (submenu[i - 1][k] != null){
                            System.out.println((k + 1) + ". " + submenu[i - 1][k] + " - " + price[i - 1][k] + " kzt");
                        }
                    }
                    System.out.print("\nChoose one: ");
                    int indeeex = s.nextInt();
                    if(submenu[i-1][indeeex-1] != null) {
                        basket.add(submenu[i - 1][indeeex - 1] + " - " + price[i - 1][indeeex - 1] + " kzt");
                        totalprice.add(price[i - 1][indeeex - 1]);
                        System.out.println();
                    }
                }
                else System.out.println("\nYou don't have subcategories in this category\n");
            }
            else if(i == count+2){
                int basketchecker = 0;
                for (int k = 0; k < basket.size(); k++){
                    System.out.println(k+1+". "+basket.get(k));
                    basketchecker++;
                }
                if(basketchecker == 0){
                    System.out.println("\nBasket is empty");
                }
                System.out.println();
                System.out.print("Total price: ");
                int sum = 0;
                for (int k = 0; k < totalprice.size(); k++){
                    sum+=totalprice.get(k);
                }
                System.out.print(sum+" kzt");
                System.out.println();
                System.out.println();
            }
            else if(i == count+1){
                totalprice.clear();
                basket.clear();
            }
        }
    }
}