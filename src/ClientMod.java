import java.util.*;
public class ClientMod{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int i = 0;
        int j = 0;
        String[] menu = new String[100];
        String[][] submenu = new String[100][100];
        boolean bbb = true;
        String w = "";
        int[][] ppp = new int[100][100];
        String a = "";
        String[] ww = new String[100];
        System.out.print("Welcome to the Admin Panel of \"Salam Bro\" Fast Food Station!\nHere you can do the following activities:\n\n");
        while(bbb){
            System.out.print("0. Exit. \n1. Change Welcome Message. \n2. Change Menu. \n3. Change SubMenu.\n4. Change Prices. \n5. Display Welcome Message. \n6. Display Menu. \n7. Display SubMenu. \n8. Display Prices. \n9. Switch to Client Mode.");
            System.out.print("\n\nChoose an activity: ");
            i = s.nextInt();
            switch(i){
                case 0:
                    bbb = false;
                    break;
                case 1:
                    System.out.print("\nPlease, type the message that clients will see when they enter the menu:\nTip: use underscore (_) as a splitter\n> ");
                    s.nextLine();
                    a = s.nextLine();
                    a = a.replaceAll("_ ","\n");
                    System.out.println();
                    break;
                case 2:
                    System.out.print("\nHere you can do the following activities:\n0.Go Back.\n1.Add categories.\n2.Remove categories\n\nYour choice: ");
                    i = s.nextInt();
                    switch(i){
                        case 1:
                            System.out.print("\nWrite the names of categories separated by comma (c1, c2, ...):\n> ");
                            s.nextLine();
                            w = s.nextLine();
                            String[] word = w.split(", ");
                            for (int k = 0; k<word.length;k++) {
                                menu[k] = word[k];

                            }
                            break;
                        case 2:
                            int chel = 0;
                            for(int k = 0; k<menu.length;k++){
                                if(menu[k] == null){
                                    continue;
                                }
                                else{
                                    chel++;
                                    System.out.println((k+1)+". "+menu[k]);
                                }
                            }
                            if(chel == 0){
                                System.out.println("You don't have a menu yet\n");
                            }
                            else{
                                System.out.print("\nTip: write the indexes separated by comma (i1, i2, ...)\n> ");
                                s.nextLine();
                                String[] pls = s.nextLine().split(", ");
                                int[] avv = new int[100];
                                for(int k = 0; k<pls.length;k++){
                                    avv[k] = Integer.parseInt(pls[k].trim());
                                }
                                for(int k = 0; k<pls.length;k++){


                                    menu[avv[k]-1] = null;


                                }
                            }
                            break;
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.print("\nHere you can do the following activities:\n0.Go Back.\n1.Add subcategories.\n2.Remove subcategories\n\nYour choice: ");
                    i = s.nextInt();
                    switch(i){
                        case 1:
                            int chet = 0;
                            System.out.print("\nChoose a category for which you want to add subcategories:\n");
                            for (int k = 0; k<menu.length;k++) {
                                if(menu[k] == null){
                                    continue;
                                }
                                else{
                                    chet++;
                                    System.out.println((k+1)+". "+menu[k]);
                                    j++;
                                }
                            }
                            if(chet == 0){
                                System.out.println("\n\nYou don't have a menu yet.\n\n");
                            }
                            else{
                                System.out.println();
                                System.out.print("> ");
                                i = s.nextInt();
                                if(menu[i-1] == null){
                                    System.out.println("");
                                }
                                else{
                                    System.out.print("\nWrite the names of subcategories separated by comma (c1, c2, ...):\n> ");
                                    s.nextLine();
                                    ww[i-1] = s.nextLine();
                                    String[] jbuhu = ww[i-1].split(", ");
                                    for(int k = 0; k<jbuhu.length;k++){
                                        submenu[i-1][k] = jbuhu[k];
                                    }
                                }
                            }
                            break;
                        case 2:
                            System.out.println("\nChoose the category from which you want to remove subcategories:");
                            int cheta = 0;
                            for(int k = 0; k<menu.length;k++){
                                if(menu[k] == null){
                                    continue;
                                }else{
                                    cheta++;
                                    System.out.println((k+1)+". "+menu[k]);
                                }
                            }
                            if(cheta == 0){
                                System.out.println("\n\nYou don't have a menu yet\n");
                            }
                            else{
                                System.out.print("\n> ");
                                int n = s.nextInt();
                                int cop = 0;
                                if(menu[n-1] == null){
                                    System.out.println("");
                                }
                                else{
                                    for(int k = 0; k<submenu[n-1].length;k++){
                                        if(submenu[n-1][k] == null){
                                            continue;
                                        }
                                        else{
                                            cop++;
                                            System.out.println((k+1)+". "+submenu[n-1][k]);
                                        }
                                    }
                                    if(cop == 0){
                                        System.out.print("\n\nYou don't have subcategories in this category\n\n");
                                    }
                                    else{
                                        System.out.print("\nTip: write the indexes separated by comma (i1, i2, ...)\n> ");
                                        s.nextLine();
                                        String[] removesub = s.nextLine().split(", ");
                                        int[] att = new int[100];
                                        for(int k = 0;k<removesub.length;k++){
                                            att[k] = Integer.parseInt(removesub[k].trim());
                                        }
                                        for(int k = 0;k<removesub.length;k++){
                                            submenu[n-1][att[k]-1] = null;
                                        }
                                    }
                                }
                            }
                            break;
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.print("\nChoose a category for which you want to change prices of subcategories:\n");
                    int che = 0;
                    for(int k = 0; k<menu.length;k++){
                        if(menu[k] == null){
                            continue;
                        }else{
                            che++;
                            System.out.println((k+1)+". "+menu[k]);
                        }
                    }
                    if(che == 0){
                        System.out.print("");
                    }
                    else{
                        int chez = 0;
                        System.out.print("\n> ");
                        i = s.nextInt();
                        if(menu[i-1] == null){
                            System.out.println("");
                        }
                        else{
                            System.out.print("\nChoose subcategories for which you want to change prices:\n");

                            for(int k = 0; k<submenu[i-1].length;k++){
                                if(submenu[i-1][k] == null){
                                    continue;
                                }else{
                                    chez++;
                                    System.out.println((k+1)+". "+submenu[i-1][k]+" - "+ppp[i-1][k]+" kzt");
                                }
                            }
                            if(chez == 0){
                                System.out.println("\n\nYou don't have subcategories in this category\n\n");
                            }
                            else{
                                System.out.print("\nTip: write the indexes separated by comma (i1, i2, ...)\n> ");
                                s.nextLine();
                                String x = s.nextLine();
                                String[] xx = x.split(", ");
                                int[] arr = new int[100];
                                for(int k = 0; k<xx.length;k++){
                                    arr[k] = Integer.parseInt(xx[k].trim());
                                }
                                for(int k = 0; k<xx.length;k++){
                                    if(submenu[i-1][arr[k] - 1] == null){
                                        continue;
                                    }
                                    else{
                                        System.out.print("\nEnter a new price for "+submenu[i-1][arr[k]-1]+":");
                                        ppp[i-1][arr[k]-1] = s.nextInt();
                                    }
                                }
                            }
                        }
                    }
                    System.out.println();
                    break;
                case 5:
                    System.out.println("\n"+a+"\n");
                    break;
                case 6:
                    int chet = 0;
                    System.out.println();
                    for (int k = 0; k<menu.length;k++) {
                        if(menu[k] == null){
                            continue;
                        }else{
                            chet++;
                            System.out.println((k+1)+". "+menu[k]);
                        }
                    }
                    if(chet == 0){
                        System.out.println("\nYou don't have a menu yet.\n");
                    }
                    System.out.println();
                    break;
                case 7:
                    System.out.print("\nChoose the category for which you want to see its subcategories:\n");
                    int chet2 = 0;
                    for (int k = 0; k<menu.length;k++) {
                        if(menu[k] == null){
                            continue;
                        } else{
                            chet2++;
                            System.out.println((k+1)+". "+menu[k]);
                        }
                    }
                    System.out.println();
                    if(chet2 == 0){
                        System.out.print("\n\nYou don't have a menu yet.\n\n");
                    }else{
                        System.out.print("> ");
                        i = s.nextInt();
                        if(menu[i-1] == null){
                            System.out.println("");
                        }
                        else{
                            int chet1 = 0;
                            for (int k = 0; k<submenu[i-1].length;k++) {
                                if(submenu[i-1][k] == null){
                                    continue;
                                }else{
                                    chet1++;
                                    System.out.println((k+1)+". "+submenu[i-1][k]);
                                }
                            }
                            if(chet1 == 0){
                                System.out.println("\n\nYou don't have subcategories in this category\n\n");
                            }
                        }
                    }
                    System.out.println();
                    break;
                case 8:
                    int cheese = 0;
                    System.out.println("Choose the category for which you want to see its subcategories' prices:");
                    for(int k = 0; k<menu.length;k++){
                        if(menu[k] == null){
                            continue;
                        }else{
                            cheese++;
                            System.out.println((k+1)+". "+menu[k]);
                        }
                    }
                    if(cheese == 0){
                        System.out.println("You don't have a menu yet");
                    }
                    else{
                        System.out.print("\n> ");
                        i = s.nextInt();
                        if(menu[i-1] == null){
                            System.out.println("");
                        }else{
                            int cheza = 0;
                            for(int k = 0; k<submenu[i-1].length;k++){
                                if(submenu[i-1][k] == null){
                                    continue;
                                }else{
                                    cheza++;
                                    System.out.println((k+1)+". "+submenu[i-1][k]+" - "+ppp[i-1][k]+" kzt");
                                }
                            }
                            if(cheza == 0){
                                System.out.print("\n\nYou don't have subcategories in this category\n\n");
                            }
                        }
                    }
                    System.out.println();
                    break;
                case 9:
                    int menucheckeer = 0;
                    for (int k = 0; k < menu.length; k++) {
                        if(menu[k]!=null){
                            menucheckeer++;
                        }
                    }

                    if(menucheckeer != 0) {
                        MenuClient modFunction = new MenuClient();
                        modFunction.clientChanger(menu, submenu, ppp);
                        break;
                    }
                    else System.out.println("\nYou don't have a menu yet\n");
            }
        }
    }
}


class MenuClient {
    public static void clientChanger(String[] menu, String[][] submenu, int[][] ppp) {
        Scanner s = new Scanner(System.in);
        ArrayList<String> basket = new ArrayList<String>();
        ArrayList<Integer> totalprice = new ArrayList<Integer>();
        boolean exit = true;
        System.out.println("Hi there!\n");
        System.out.println("Welcome to the menu of \"Salam Bro\" Fast Food Station.");
        System.out.println("Here you can see our menu below.\n");
        while (exit) {
            int counteer = 0;
            System.out.println("\n0. Exit menu");
            for (int k = 0; k < menu.length; k++) {
                if (menu[k] != null) {
                    System.out.println(k + 1 + ". " + menu[k]);
                    counteer++;
                }
            }
            System.out.println(counteer + 1 + ". " + "Clear basket");
            System.out.println(counteer + 2 + ". " + "Check basket");
            System.out.print("\nChoose one: ");
            int i = s.nextInt();
            if (i == 0) {
                exit = false;
            } else if (i <= counteer) {
                int checker = 0;
                for (int k = 0; k <submenu[i-1].length ; k++) {
                    if(submenu[i-1][k]!=null){
                        checker++;
                    }
                }
                if(checker!=0) {
                    System.out.println("\n0. Exit menu");
                    for (int k = 0; k < submenu[i - 1].length; k++) {
                        if (submenu[i - 1][k] != null) {

                            System.out.println((k + 1) + ". " + submenu[i - 1][k] + " - " + ppp[i - 1][k] + " kzt");
                        }
                    }
                    System.out.print("\nChoose one: ");
                    int indeeex = s.nextInt();
                    basket.add(submenu[i - 1][indeeex - 1] + " - " + ppp[i - 1][indeeex - 1] + " kzt");
                    totalprice.add(ppp[i - 1][indeeex - 1]);
                    System.out.println();
                }
                else System.out.println("\nYou don't have subcategories in this category\n");
            }
            else if(i == counteer+2){
                int basketchecker = 0;
                for (int k = 0; k < basket.size(); k++) {
                    System.out.println(k+1+". "+basket.get(k));
                    basketchecker++;
                }
                if(basketchecker == 0){
                    System.out.println("\nBasket is empty");
                }
                System.out.println();
                System.out.print("Total price: ");
                int sum = 0;
                for (int k = 0; k < totalprice.size(); k++) {
                    sum+=totalprice.get(k);
                }
                System.out.print(sum+" kzt");
                System.out.println();
                System.out.println();
            }
            else if(i == counteer+1){
                totalprice.clear();
                basket.clear();
            }
        }
    }
}