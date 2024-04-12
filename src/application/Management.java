package application;

import java.util.Scanner;

import Product.*;

public class Management {  
    private static final Commander commander = new Commander(); // 假设Commander类已经实现  
  
    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);  
        boolean keepRunning = true;  
  
        while (keepRunning) {  
            clearConsole(); // 清除控制台屏幕  
            printMenu(); // 打印菜单选项  
            System.out.print("choice >");  
            String input = scanner.nextLine(); // 使用nextLine来读取整行输入  
  
            switch (input) {  
                case "1":  
                    commander.displayCatalog(); // 显示产品目录  
                    break;  
                case "2":  
                	commander.displayProductInfo(ProductCatalog.code);
                    // 显示特定产品信息，需要传递产品ID或代码给commander  
                    break;  
                case "3":  
                    commander.displayCurrentOrder(); // 显示当前订单  
                    break;  
                case "4":  
                    commander.addProductToOrder(scanner.next(), scanner.next());// 添加产品到当前订单，需要传递产品ID和数量给commander  
                    break;  
                case "5":  
                    // 从当前订单中移除产品，需要传递产品ID给commander  
                    break;  
                case "6":  
                    commander.registerSale(); // 注册当前订单的销售  
                    break;  
                case "7":  
                    commander.displaySales(); // 显示所有销售记录  
                    break;  
                case "8":  
                    // 显示具有特定产品的订单数量，需要传递产品ID给commander  
                    break;  
                case "9":  
                    // 显示每个产品的总销售数量，需要commander处理  
                    break;  
                case "0":  
                    keepRunning = false; // 设置标志以退出循环  
                    System.out.println("程序已退出。");  
                    break;  
                default:  
                    System.out.println("无效输入，请重新输入。");  
            }  
        }  
  
        // 关闭 Scanner  
        scanner.close();  
    }  
  
    // 清除控制台屏幕的方法（平台相关）  
    private static void clearConsole() {  
        System.out.print("\033[H\033[J");  
        System.out.flush();  
    }  
  
    // 打印菜单选项的方法  
    private static void printMenu() {  
        System.out.println("[0] Quit\r\n"  
                + "[1] Display catalog\r\n"  
                + "[2] Display product \r\n"  
                + "[3] Display current order\r\n"  
                + "[4] Add product to current order\r\n"  
                + "[5] Remove product from current order \r\n"  
                + "[6] Register sale of current order\r\n"  
                + "[7] Display sales\r\n"  
                + "[8] Display number of orders with a specific product\r\n"  
                + "[9] Display the total quantity sold for each product\r\n");  
    }  
}
