import java.util.*;
//Basic+ system requirements
public class Marketplace {
    public void printMenu(int[] productId, String[] productName, int[] price, String[] boughtProduct, int[] userId, String[] userName, int[] amountOfMoney, String[] userProducts) {
        int operation = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nMain Menu:");
            System.out.println("1. Display list of all users");
            System.out.println("2. Display list of all products");
            System.out.println("3. Buy product");
            System.out.println("4. Display list of user products");
            System.out.println("5. Display list of users that bought product");
            System.out.println("6. Close the marketplace");
            do {
                System.out.println("\nChoose operation (Press 1-5): ");
                operation = scanner.nextInt();
                if (operation < 1 || operation > 6) System.out.println("\nWrong choice");
            } while (operation < 1 || operation > 6);
            switch (operation) {
                case 1:
                    new Marketplace().printAllUsers(userId, userName, amountOfMoney);
                    break;
                case 2:
                    new Marketplace().printAllProducts(productId, productName, price);
                    break;
                case 3:
                    new Marketplace().buyProduct(userName, amountOfMoney, userProducts, productId, productName, price, boughtProduct);
                    break;
                case 4:
                    new Marketplace().printUserProducts(userName, userProducts);
                    break;
                case 5:
                    new Marketplace().printWhoBoughtProduct(productName, boughtProduct);
                    break;
            }
        } while(operation != 6);
    }
    public void printAllUsers(int[] userId, String[] userName, int[] amountOfMoney) {
        System.out.println("\nList of all users:");
        System.out.println(userId[0] + " " + userName[0] + " Money: " + amountOfMoney[0] + "$");
        System.out.println(userId[1] + " " + userName[1] + " Money: " + amountOfMoney[1] + "$");
        System.out.println(userId[2] + " " + userName[2] + " Money: " + amountOfMoney[2] + "$");
    }
    public void printAllProducts(int[] productId, String[] productName, int[] price) {
        System.out.println("\nList of all products:");
        System.out.println(productId[0] + " " + productName[0] + " Price: " + price[0] + "$");
        System.out.println(productId[1] + " " + productName[1] + " Price: " + price[1] + "$");
        System.out.println(productId[2] + " " + productName[2] + " Price: " + price[2] + "$");
    }
    public void buyProduct(String[] userName, int[] amountOfMoney, String[] userProducts, int[] productId, String[] productName, int[] price, String[] boughtProduct) {
        int user = 0;
        int product = 0;
        do {
            Scanner userScanner = new Scanner(System.in);
            System.out.println("\nEnter Id of user who want to buy product (to return to the main menu enter 0): ");
            user = userScanner.nextInt();
            if(user < 0 || user > 3) {
                System.out.println("\nThe user with this id doesn't exist");
                continue;
            }
            if(user == 0) continue;
            else {
                System.out.println(userName[user - 1] + " Money: " + amountOfMoney[user - 1] + "$");
                do {
                    Scanner productScanner = new Scanner(System.in);
                    System.out.println("\nEnter Id of product which you want to buy (to complete shopping enter 0): ");
                    product = productScanner.nextInt();
                    if (product < 0 || product > 3) {
                        System.out.println("\nThe product with this id doesn't exist");
                        continue;
                    }
                    if(product == 0) continue;
                    else if(amountOfMoney[user - 1] < price[product - 1]) {
                        System.out.println("Not enough money to buy this product, choose another one from list");
                        new Marketplace().printAllProducts(productId, productName, price);
                    } else {
                        amountOfMoney[user - 1] -= price[product - 1];
                        userProducts[user - 1] += productName[product - 1] + "\n ";
                        boughtProduct[product - 1] += userName[user - 1] + "\n ";
                        System.out.println("\nPurchase successful");
                        System.out.println("You bought a " + productName[product - 1] + " for " + price[product - 1] + "$");
                        System.out.println("Money left: " + amountOfMoney[user - 1] + "$");
                    }
                } while(product != 0);
            }
        } while(user != 0);
    }
    public void printUserProducts(String[] userName, String[] userProducts) {
        int idUser = 0;
        do {
            Scanner userIdScanner = new Scanner(System.in);
            System.out.println("\nEnter user id (0 - to return to the main menu): ");
            idUser = userIdScanner.nextInt();
            if(idUser < 0 || idUser > 3) {
                System.out.println("\nThe user with this id doesn't exist");
                continue;
            }
            if(idUser == 0) continue;
            else {
                System.out.println(userName[idUser - 1] + ":");
                System.out.println(userProducts[idUser - 1]);
            }
        } while(idUser != 0);
    }
    public void printWhoBoughtProduct(String[] productName, String[] boughtProduct) {
        int idProduct = 0;
        do {
            Scanner productIdScanner = new Scanner(System.in);
            System.out.println("\nEnter product id (0 - to return to the main menu): ");
            idProduct = productIdScanner.nextInt();
            if(idProduct < 0 || idProduct > 3) {
                System.out.println("\nThe product with this id doesn't exist");
                continue;
            }
            if(idProduct == 0) continue;
            else {
                System.out.println(productName[idProduct - 1] + ":");
                System.out.println(boughtProduct[idProduct - 1]);
            }
        } while(idProduct != 0);
    }
    public static void main(String[] args) {
        int[] productId = {1, 2, 3};
        String[] productName = {"Smartphone", "TV", "Earphones"};
        int[] price = {1000, 5000, 200};
        String[] boughtProduct = {" ", " ", " "};
        int[] userId = {1, 2, 3};
        String[] userName = {"Vyacheslav Onofriychuk", "Alla Musk", "Elon Onofriychuk"};
        int[] amountOfMoney = {10000, 3000, 5000};
        String[] userProducts = {" ", " ", " "};
        System.out.println("Welcome to Marketplace by Vyacheslav Onofriychuk");
        new Marketplace().printMenu(productId, productName, price, boughtProduct, userId, userName, amountOfMoney, userProducts);
    }
}