/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.libs;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


/**
 *
 * @author jacky
 */
public interface ThuatToan extends Remote{
     public int UCLN(int a,int b)throws RemoteException;
     public boolean kiemTraNT(int n ) throws RemoteException;
     public int [] ketQua( int[] array )throws RemoteException;
     public String  snt( int[] array  )throws RemoteException;

}
