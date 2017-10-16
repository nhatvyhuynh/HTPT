/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import rmi.libs.ThuatToan;

/**
 *
 * @author jacky
 */
public class GiaiQuyet  extends UnicastRemoteObject implements ThuatToan{


    public GiaiQuyet() throws RemoteException {     
   
    }
    
    @Override
    public boolean kiemTraNT(int n) throws RemoteException {
        if (n<2)    
            return false;
        else {
            if (n==2 || n==3)
                return true;
            else
            {
                for (int i=2;i<=Math.sqrt(n);i++)
                {
                    if (n%i==0){
                        return false;
                    }
                }
            }
            return true;
       }
    }   
   @Override
       public int [] ketQua(int[] array) throws RemoteException{ 
        System.out.println("");
        System.out.print( "Dãy Số Nhập vào - " );  
         for (int i=0; i < array.length; i++) System.out.print( array[i] + " " );        
             System.out.println();
             for (int g = array.length/2; g > 0; g /= 2)
                for (int i = g; i < array.length; i++)
                for (int j = i-g; j >= 0; j -= g)
                  if (array[j] > array[j+g]) {
                    int temp = array[j];
                    array[j] = array[j+g];
                    array[j+g] = temp;
                  }
            return array;
       }

    @Override
    public String snt(int[] array) throws RemoteException {  
        String result="";
        for (int i = 0; i < array.length; i++) {
                if (kiemTraNT(array[i])) {                    
                     result += " " + array[i];
                 }
                 
        }  
        return "Số Nguyên Tố:" +result+ " ";
        
    }

    @Override
    public int UCLN(int a, int b) throws RemoteException {
        while(a!= b){
             if(a>b) a= a-b;
                 else b= b-a;
         }
        return a;
    }
}
