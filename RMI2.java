/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmi2 ;
import java.util.Scanner;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
public class RMI2 {

       public static int nhapSoTN() {
              Scanner input = new Scanner(System.in);
              boolean check = false;
              int n = 0;
              while (!check) {
                     try {
                           n = Integer.parseInt(input.nextLine());
                           if (n < 0) {
                                  System.out.println("Bạn phải nhập số tự nhiên! Hãy nhập lại.");
                                  continue;
                           }
                           check = true;
                     } catch (Exception e) {
                           System.out.println("Bạn phải nhập số tự nhiên! Hãy nhập lại.");
                     }
              }
              return (n);
       }

       public static void nhapSoTN(int arrInt[]) {
              for (int i = 0; i < arrInt.length; i++) {
                     System.out.print("So thu " + (i + 1) + " : ");
                     arrInt[i] = nhapSoTN();
              }
       }

       public static int UCLN(int a, int b) {
              while (a != b) {
                     if (a > b)
                           a = a - b;
                     else
                           b = b - a;
              }
              return (a);
       }

       public static int UCLN1(int a, int b) {
              while (a != 0 && b != 0) {
                     int temp = Math.max(a, b) % Math.min(a, b);
                     a = Math.min(a, b);
                     b = temp;
              }
              return Math.max(a, b);
       }

       public static int BCNN(int a, int b) {
              return a * b / UCLN(a, b);
       }

       public static int UCLN(int arrInt[]) {
              int i, temp = UCLN(arrInt[0], arrInt[1]);
              for (i = 0; i < arrInt.length - 1; i++) {
                     if (UCLN(arrInt[i], arrInt[i + 1]) <= temp) {
                           temp = UCLN(temp, arrInt[i + 1]);
                     }
              }
              return temp;
       }

       public static int BCNN(int arrInt[]) {
              int i, temp = BCNN(arrInt[0], arrInt[1]);
              for (i = 0; i < arrInt.length - 1; i++) {
                     if (BCNN(arrInt[i], arrInt[i + 1]) <= temp) {
                           temp = BCNN(temp, arrInt[i + 1]);
                     }
              }
              return temp;
       }

       public static int BCNN1(int arrInt[]) {
              int max = 0, k = 1;
              for (int i = 0; i < arrInt.length; i++) {
                     if (max < arrInt[i]) {
                           max = arrInt[i];
                     }
              }
              int temp = max;
              for (int i = 0; i < arrInt.length; i++) {
                     while (max % arrInt[i] != 0) {
                           k++;
                           max = temp * k;
                     }
              }
              return max;
       }

       public static void main(String[] args) {
              //System.out.println("Chuong trình tính UCLN, BCNN");
              System.out.print("Bạn muốn tính UCLN, BCNN của bao nhiêu số: ");
              int n = 0;
              while (n < 2) {
                     n = nhapSoTN();
                     if (n < 2) {
                           System.out.println("Phải tối thiểu là 2 số. Hãy nhập lại!");
                     }
              }
              int arrInt[] = new int[n];
              nhapSoTN(arrInt);
              System.out.println("Uoc chung lon nhat la: " + UCLN(arrInt));
              System.out.println("Boi chung nho nhat la: " + BCNN(arrInt));
       }

}