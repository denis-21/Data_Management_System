import java.util.*;
import java.io.*;
public class DMS
{
    public static void dMenu(boolean z)
    {
        int ch=100; 
        Scanner s=new Scanner(System.in);
        
      	abc:
      	while(ch!=0)
       	{
           	String b[]=new String[100];
        	char pk[]=new char[100];
        	int top=-1;
        	boolean flag=false;
        	String priK="";
         	System.out.println(" --------------------------------------------------------------------");
         	System.out.println("|                                                                    |");
         	System.out.println("|                               WELCOME                              |");
         	System.out.println("|                                                                    |");
         	System.out.println("|--------------------------------------------------------------------|");
         	System.out.println("|                                                                    |");
         	System.out.println("|                                                                    |");
         	System.out.println("| PLEASE ENTER YOUR CHOICE:                                          |");
         	System.out.println("|                                                                    |");
         	System.out.println("| 1. ENTER NEW DATA                                                  |");
         	System.out.println("| 2. DELETE DATA                                                     |");
         	System.out.println("| 3. EDIT DATA                                                       |");
         	System.out.println("| 4. SEARCH FOR PARTICULAR DATA                                      |");
        	if(z)
        	{
         		System.out.println("| 5. ENTER A NEW FIELD                                               |");
         		System.out.println("| 6. DELETE AN EXISTING FIELD                                        |");
            }
         	System.out.println("| 0. EXIT DATABASE                                                   |");
         	System.out.println("|                                                                    |");
         	System.out.println("|                                                                    |");
         	System.out.println(" --------------------------------------------------------------------");
         	String d=s.nextLine();
        	if(!(d.length()==1&&Character.isDigit(d.charAt(0))))
        	{
            	System.out.println(" NO SUCH OPTION EXISTS");
            	try
            	{
                	Thread.sleep(2000);
            	}
            	catch(InterruptedException e){}
            	System.out.println('\u000C');
        	}
       
        	else
        	{
        		abcd:
            	ch=Integer.parseInt(d);
           
            	System.out.println('\u000C');
            	try
            	{  
                	FileInputStream fin=new FileInputStream("Fields.txt");  
                	Scanner sc=new Scanner(fin); 
                	while(sc.hasNextLine())
                	{  
                		b[++top]=sc.nextLine();
                 		pk[top]=b[top].charAt(b[top].length()-1);
                 
                 		if(pk[top]=='p')
                 		{
                 			flag=true;
                     		b[top]=b[top].substring(0,(b[top].length()-1));
                     		priK=b[top];
                    	}
                	}  
                	fin.close();  
            	}catch(Exception e){}
                     
	          	switch(ch)
	          	{
	            	case 1:
	             	if(top==-1)
	             		System.out.println("NO FIELD EXISTS");
	             	for(int i=0;i<=top;i++)
	             	{
	                	String fld=b[i]+".txt";
	                 	try(PrintWriter out= new PrintWriter(new BufferedWriter(new FileWriter(fld, true)))) 
	                 	{
	                    	if(!(b[i].equalsIgnoreCase(priK)))
	                     	{
	                        	System.out.println("PLEASE ENTER THE "+b[i]);
	                         	String zzz=s.nextLine();
	                         	out.println(zzz);
	                        }
	                        else
	                     	{
	                        	boolean ggg=true;
	                         	String zzz="";
	                         	while(true)
	                         	{
	                                System.out.println("PLEASE ENTER THE "+priK);
	                                zzz=s.nextLine();
	                                try
	                                {  
	                                	FileInputStream fin=new FileInputStream(priK+".txt");  
	                                	Scanner sc=new Scanner(fin); 
	                                	lkm:
	                                	while(sc.hasNextLine())
	                                	{  
	                                 
	                                 		String f=sc.nextLine();
	                                	 	if(f.equalsIgnoreCase(zzz))
	                                 		{
	                                     		System.out.println("THIS DATA ALREADY EXISTS");
	                                        	try
	                                     		{
	                                         		Thread.sleep(2000);
	                                        	}
	                                        	catch(InterruptedException e){}
	                                       		System.out.println('\u000C');
	                                       		ggg=false;
	                                    	}
	                                	}
	                              	}catch(Exception e){}
	                            	if(ggg)
	                            	{
	                                	out.println(zzz);
	                                	break;
	                            	}
	                        	}   
	                    	}
	                	}catch(Exception e){}
	                }
	                try
	                {
	                    Thread.sleep(1000);
	                }
	                catch(InterruptedException e){}
	                System.out.println('\u000C');      
	          
	             	System.out.println("NEW DATA HAS BEEN ENTERED");   
	             	break;
	             

	             	case 2:
	             	if(top==-1)
	             		System.out.println("NO FIELD EXISTS");
	             	int qqq=0;
	             	boolean flag1=false;
	              	try
	                {
	                    File inputFile = new File(priK+".txt");
	        
	                    BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	                    System.out.println("ENTER THE "+priK+" TO BE DELETED");
	                    String le =s.nextLine().toLowerCase() ;
	                    String ce;
	                    while((ce = reader.readLine()) != null) 
	                    {
	                        String trimmedLine = ce.trim().toLowerCase();
	                        qqq++;
	                        if(trimmedLine.equalsIgnoreCase(le)) 
	                        {
	                            flag1=true;
	                            break;
	                        }
	                    }
	                    reader.close(); 
	                }
	                catch(Exception e){}
	                if(flag1)
	                {
	                    System.out.println("DELETION SUCCESSFUL");
	             		for(int i=0;i<=top;i++)
	             		{
	            	     	String fld=b[i]+".txt";
	                 
	                	    try
	                    	{
	                    		File inputFile = new File(fld);
	                        	File tempFile = new File("myTempFile.txt");
	        
	       		                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	                    	    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
	                        	int qq=0;
	                        	String ce;
	                        	while((ce = reader.readLine()) != null)
	                        	{
	                            	qq++;
	                            	if(qq!=qqq) 
	          	                	{
	                            	writer.write(ce + System.getProperty("line.separator"));
	                        		}
	                        		writer.close(); 
	                        		reader.close(); 
	                        	}
	                    	}catch(Exception e){}
	                     
	                    	try
	                    	{
	                        	FileWriter fw=new FileWriter(fld);  
	                        	fw.write("");  
	                        	fw.close();
	                    	}
	                    	catch(Exception e){}
	                    	try(PrintWriter ot = new PrintWriter(new BufferedWriter(new FileWriter(fld,true))))
	                    	{  
	                        	FileInputStream fin=new FileInputStream("myTempFile.txt");  
	                        	Scanner sc3=new Scanner(fin); 
	                        	while(sc3.hasNextLine())
	                        	{  
	                            	ot.println(sc3.nextLine());                               
	                        	}  
	                        	fin.close(); 
	                    	}catch(Exception e){}
	                                              
	                	}
	                }
	                else
	                    System.out.println("NO USERNAME OF SUCH NAME EXISTS");
	             	break;
	             
	             	case 3:
	             	break;
	             
	             	case 4:
	             	break;

	            	case 5:
	            	String fld;
	            	String fld1;
	            	System.out.println("PLEASE ENTER THE FIELD TO BE ADDED");
	            	if(!flag)
	                	System.out.println("\n\nTHIS FIELD SHALL BE YOUR PRIMARY KEY\n\n");
	            	fld1 =s.nextLine().trim();
	            	fld1=fld1.toUpperCase();
	            	boolean t=false;
	            	for(int i=0;i<=top;i++)
	            	{
	                	if(fld1.equalsIgnoreCase(b[i]))
	                		t=true;
	            	}
	            	if(t)
	            	{
	                	System.out.println("THIS FIELD ALREADY EXISTS");
	                	try
	                    {
	            	        Thread.sleep(2000);
	                    }
	                    catch(InterruptedException e){}
	                	System.out.println('\u000C');
	            	}
	            	else
	            	{              
	             		fld=fld1.concat(".txt");
	                	System.out.println("NEW FIELD \""+fld1.toUpperCase()+ "\" HAS BEEN CREATED");   
	                	try(PrintWriter out= new PrintWriter(new BufferedWriter(new FileWriter(fld, true))))
	                	{
	                   		if(flag)
	                   		{
	                    
	                    		try
	                    		{  
	                        		FileInputStream fin=new FileInputStream(priK+".txt");  
	                        		Scanner sc=new Scanner(fin); 
	                        		while(sc.hasNextLine())
	                        		{
	                        			System.out.println("ENTER THE DATA FOR "+fld1);
	                         			String f=sc.nextLine();
	                         			System.out.println("ENTER THE "+fld1+" OF "+f);
	                         			String zzz=s.nextLine();
	                         			out.println(zzz);
	                        		}  
	                        		fin.close();  
	                        	}catch(Exception e){}
	                    	}
	                	}catch (IOException e) {}
	                        

	                    
	                	try(PrintWriter out= new PrintWriter(new BufferedWriter(new FileWriter("Fields.txt", true)))) 
	                	{
	                    	if(flag)
	                        	out.println(fld1);
	                    	else
	                        	out.println(fld1+"p");
	                	}catch (IOException e){}
	            	}
	            	try
	                {
	                    Thread.sleep(2000);
	                }
	                catch(InterruptedException e){}
	                System.out.println('\u000C'); 
	             	break;


	             	case 6:
	             	if(top==-1)
	             		System.out.println("NO FIELD EXISTS");
	             	int qqqq=0;
	             	boolean flag6=false;
	             	try
	                {
	                   	File inputFile = new File("Fields.txt");
	                   	BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	                   	System.out.println("ENTER THE FIELD TO BE DELETED");
	                   	String le =s.nextLine().trim().toLowerCase() ;
	                   	String ce;
	                   	while((ce = reader.readLine()) != null)
	                   	{
	                       	String trimmedLine = ce.trim().toLowerCase();
	                       	qqqq++;
	                       	if(trimmedLine.equalsIgnoreCase(le)) 
	                       	{
	                           	flag6=true;
	                           	break;
	                       	}
	                   	}
	                   	reader.close(); 
	                }catch(Exception e){}
	                if(flag6)
	                {
	                    System.out.println("DELETION SUCCESSFUL");
	             		//for(int i=0;i<=0;i++)
	             		{
	                 		try
	                 	    {
	                 	    	System.out.print(top);
	                        	File inputFile = new File("Fields.txt");
	                       		File tempFile = new File("myTempFile.txt");
	                           	BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	        	               	BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
	            	           	int qq=0;
	                	       	String ce;
	                        	while((ce = reader.readLine()) != null)
	                       		{
	                           		qq++;
	                           		if(qq!=qqqq) 
	                           		{
	                           			writer.write(ce /*+ System.getProperty("line.separator")*/);
	                           			writer.newLine();
	                       			}
	                       		}
	                    		writer.close(); 
	                       		reader.close();
	                    	}catch(Exception e){}
	                    	
	                        try
	                        {
	                            FileWriter fw=new FileWriter("Fields.txt");  
	                            fw.write("");  
	                            fw.close();
	                        }
	                        catch(Exception e){}
	                        try(PrintWriter ot = new PrintWriter(new BufferedWriter(new FileWriter("Fields.txt",true))))
	                        {  
	                            FileInputStream fin=new FileInputStream("myTempFile.txt");  
	                            Scanner sc3=new Scanner(fin); 
	                            while(sc3.hasNextLine())
	                            {  
	                                ot.println(sc3.nextLine());                               
	                            }  
	                            fin.close(); 
	                        }catch(Exception e){}
	                                             
	                    }
	                }
	                else
	                  	System.out.println("NO SUCH FIELD EXISTS");
	             	break;
	            
	            	default:
	            	break;
				}
        	}
    	}
	}
}

                        
                    
                    