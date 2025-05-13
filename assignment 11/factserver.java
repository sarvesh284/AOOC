import java.util.*;
import java.net.*;
import java.io.*;

class factserver
{
public static void main(String args[])
{
try
{
ServerSocket s1 = new ServerSocket(1520);
Socket s2 = s1.accept();

DataInputStream dis;
DataOutputStream dos;

InputStream is;
OutputStream os;

is = s2.getInputStream();
os = s2.getOutputStream();

dis = new DataInputStream(is);
dos = new DataOutputStream(os);

Scanner sc = new Scanner(System.in);

String str;
do {
    System.out.println("data received:");
    
    str = dis.readUTF(); 
    
    if (str.equals("STOP")) break;
    
    int number = Integer.parseInt(str);
    long factorial = 1;
    
    for (int i = 1; i <= number; i++) {
        factorial *= i;
    }

    dos.writeUTF("Factorial of " + number + " is " + factorial);
    
} while (true);
}
catch(Exception e)
{
e.printStackTrace();
}
}
}
