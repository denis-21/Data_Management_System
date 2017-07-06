import java.util.*;
import java.io.*;
public class Welcome
{
    public static void main(String[] args)throws IOException
        {
               InputStreamReader read=new InputStreamReader(System.in);
               BufferedReader buf=new BufferedReader(read);
               String username,password;
       while(true)
        {
            System.out.println('\u000C');
            System.out.println(" --------------------------------------------------------------------");
            System.out.println("|                                                                    |");
            System.out.println("|                            LOGIN  PAGE                             |");
            System.out.println("|                                                                    |");
            System.out.println("|--------------------------------------------------------------------|");
            System.out.println("|                                                                    |");
            System.out.println("|                                                                    |");
            System.out.println("| PLEASE ENTER YOUR USERNAME:                                        |");
            System.out.print("| ");  
             username = buf.readLine();
            System.out.println("|                                                                    |");
            System.out.println("| PLEASE ENTER YOUR PASSWORD:                                        |");
            System.out.print("| ");
             password = buf.readLine();
            System.out.println("|                                                                    |");
            System.out.println("|                                                                    |");
            System.out.println(" --------------------------------------------------------------------"); 
            try
             {
                 Thread.sleep(1000);
                }
                catch(InterruptedException e){}
               System.out.println('\u000C');
            
            if(username.equals("admin")&&password.equals("admin"))
            {
                Admin.mMenu();
            }
             else
            {
                boolean flag=true;
           try
           {  
               int m=0;
                FileInputStream fin=new FileInputStream("AccountDetails.txt");  
                Scanner sc=new Scanner(fin);
                while(sc.hasNext()){ 
                    m++;
                 String s=sc.next();
                 String s2=sc.next();
                 if(username.equals(s)&&password.equals(s2))
                 {
                     flag=false;
                     User.uMenu(s,m);
                     break;
                } 
            }
                fin.close();  
              }
              catch(Exception e) {} 
              
            if (flag)
             {
                 System.out.println("WRONG USERNAME OR PASSWORD ENTERED");
                   try
             {
                 Thread.sleep(1000);
                }
                catch(InterruptedException e){}
               System.out.println('\u000C');
            }
        
          }
        }
    }
}



