import java.util.*;
import java.io.*;
public class User
{
    public static void uMenu(String us,int z)
    {
        int ch=0; 
        Scanner sc=new Scanner(System.in);
        abc:
        while(ch!=5)
        {
           System.out.println(" --------------------------------------------------------------------");
           System.out.println("|                                                                    |");
           System.out.print("|                        WELCOME  "+us.toUpperCase());
           System.out.println("                           |");
           System.out.println("|                                                                    |");
           System.out.println("|--------------------------------------------------------------------|");
           System.out.println("|                                                                    |");
           System.out.println("|                                                                    |");
           System.out.println("| PLEASE ENTER YOUR CHOICE:                                          |");
           System.out.println("|                                                                    |");
           System.out.println("| 1. CHANGE USERNAME                                                 |");
           System.out.println("| 2. CHANGE PASSWORD                                                 |");
           System.out.println("| 3. MANAGE DATABASE                                                 |");
           System.out.println("| 4. LOG OFF                                                         |");
           System.out.println("|                                                                    |");
           System.out.println("|                                                                    |");
           System.out.println(" --------------------------------------------------------------------");
           String d=sc.nextLine();
           if(!(d.length()==1&&Character.isDigit(d.charAt(0))))
          {
               System.out.println(" NO SUCH OPTION EXISTS");
               try
                {
                 Thread.sleep(1000);
                }
                catch(InterruptedException e){}
               System.out.println('\u000C');
          }
       
          else
          abcd:
          {
            ch=Integer.parseInt(d);
           
            System.out.println('\u000C');
         
            switch(ch)
            {
             case 1:
                 while(true)
                {
                    System.out.println("ENTER THE NEW USERNAME");
                    us =sc.nextLine().trim();
                    if(us.length()==8)
                    break;
                    else 
                    System.out.println("THE USERNAME HAS TO HAVE 8 CHARACTERS");
                      try
                    {
                    Thread.sleep(1996);
                    }
                  catch(InterruptedException e){}
                  System.out.println('\u000C');
                }
                  try{
                      FileWriter fw=new FileWriter("myTempFile.txt");  
                        fw.write("");  
                        fw.close();
                      }
                  catch(Exception e){}
                  try(PrintWriter ot = new PrintWriter(new BufferedWriter(new FileWriter("myTempFile.txt",true)))){  
                      FileInputStream fin=new FileInputStream("AccountDetails.txt");  
                      Scanner sc3=new Scanner(fin);
                      int n=0;
                      while(sc3.hasNextLine())
                      {  n++;
                         if(n!=z)
                         ot.println(sc3.nextLine());
                         else
                         {
                         String u=sc3.next();
                         ot.print(us+" "+sc3.next()+System.getProperty("line.separator"));
                         }
                      }  
                      fin.close(); 
                    }catch(Exception e){}
                    try{
                        FileWriter fw=new FileWriter("AccountDetails.txt");  
                          fw.write("");  
                          fw.close();
                        }
                        catch(Exception e){}
                    try(PrintWriter ot = new PrintWriter(new BufferedWriter(new FileWriter("AccountDetails.txt",true)))){  
                        FileInputStream fin=new FileInputStream("myTempFile.txt");  
                        Scanner sc3=new Scanner(fin); 
                        while(sc3.hasNextLine())
                        {  
                          ot.println(sc3.nextLine());                               
                        }  
                        fin.close(); 
                      }catch(Exception e){}
                System.out.println("USERNAME HAS BEEN UPDATED TO "+us);
          break;
             

          
          case 2:
          
          String p1;
            while(true)
            {
              System.out.println("ENTER THE NEW PASSWORD");
              p1=sc.nextLine().trim();
              System.out.println("PLEASE RE-ENTER THE PASSWORD TO CONFIRM");
              String p2=sc.nextLine().trim();
              if(!(p1.equals(p2)))
                 System.out.println("THE RE-ENTERED PASSWORD DOES NOT MATCH");
              else 
                 break;
              try
              {
                 Thread.sleep(1996);
              }
              catch(InterruptedException e){}
              System.out.println('\u000C');
            }
            
            try{
                FileWriter fw=new FileWriter("myTempFile.txt");  
                fw.write("");  
                fw.close();
                }
            catch(Exception e){}
            try(PrintWriter ot = new PrintWriter(new BufferedWriter(new FileWriter("myTempFile.txt",true)))){  
              FileInputStream fin=new FileInputStream("AccountDetails.txt");  
              Scanner sc3=new Scanner(fin);
              int n=0;
              while(sc3.hasNextLine())
              {  n++;
                if(n!=z)
                  ot.println(sc3.nextLine());
                else
                {
                  ot.print(sc3.next()+" "+p1+System.getProperty("line.separator"));
                  String u=sc3.next();
                }
              }  
              fin.close(); 
            }catch(Exception e){}
            try{
              FileWriter fw=new FileWriter("AccountDetails.txt");  
              fw.write("");  
              fw.close();
            }
            catch(Exception e){}
            try(PrintWriter ot = new PrintWriter(new BufferedWriter(new FileWriter("AccountDetails.txt",true)))){  
               FileInputStream fin=new FileInputStream("myTempFile.txt");  
               Scanner sc3=new Scanner(fin); 
               while(sc3.hasNextLine())
               {  
                  ot.println(sc3.nextLine());                               
               }  
                fin.close(); 
              }catch(Exception e){}
              System.out.println("PASSWORD HAS BEEN UPDATED");
            break;
  
             

          case 3:
             DMS.dMenu(false);
             break;
          


          case 4:
            System.out.println(" LOGGING OFF");
            try
            {
              Thread.sleep(2000);
            }
            catch(InterruptedException e){}
            break abc;
            
          default:
            System.out.println(" NO SUCH OPTION EXISTS");
            try
            {
              Thread.sleep(1000);
            }
            catch(InterruptedException e){}
            System.out.println('\u000C');
            break abcd;
            }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\nPLEASE PRESS ENTER TO CONTINUE");
        d=sc.nextLine();
        System.out.println('\u000C');
        }
            
      }
    }
   
}
