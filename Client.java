1/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.libs.ThuatToan;

/**
 *
 * @author jacky
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        // TODO code application logic here
        new Client().run();
        
    }
  
    private void run(){
       int port= 6394;
         // nhập dãy số random. 
            int[] array = new int[15];
            java.util.Random rn = new java.util.Random();

            for (int i=0; i < array.length; i++) array[i] = rn.nextInt(20) + 1;
            for (int i=0; i < array.length; i++) System.out.print( array[i] + " " );
            System.out.println();  
            // nhập ước chung lớn nhất nhỏ nhất
            int a, b;
                Scanner nhap = new Scanner (System.in);
                System.out.println("Nhap so thu nhat: ");
                a = nhap.nextInt();
                System.out.println("Nhap so thu hai: ");
                b = nhap.nextInt();
            
           
            try {
                /*System.out.println("======Dãy số tăng dần là  =======");                 
                ThuatToan nguyenTo = (ThuatToan) Naming.lookup("rmi://localhost:"+port+"/ThuatToan");
                array=nguyenTo.ketQua(array);
                
                for (int i=0; i < array.length; i++) System.out.print( array[i] + " " ); 
                System.out.println();
                //
                String result=nguyenTo.snt(array);
                System.out.println("======Dãy Số Nguyên Tố Là =======");                 
                System.out.println(result);
                System.out.println(); */
                // 
                int ucln=nguyenTo.UCLN(a,b);
                System.out.println("======UCLN-BCNN =======");                 
                System.out.println("Uoc chung lon nhat cua a va b la : "+ucln);
                System.out.println("Boi chung nho nhat cua a va b la : "+(a*b)/ucln);
                System.out.println();
                } catch (NotBoundException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RemoteException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
           
        } 
    
    
}
