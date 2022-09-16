import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        int choice = -1;
        
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        File file = new File("Employee.txt");
        boolean result;  
         try   
         {  
            result = file.createNewFile();  //creates a new file  
            if(result)      // test if successfully created a newfi
            {  
                System.out.println("file created "); //returns the path string  
            }  
            else  
            {  
                System.out.println("File already exist at location: ");  
            }  
            
         }
         catch (IOException e)   
         {  
            e.printStackTrace();    //prints exception if any  
         }
         ArrayList<Employee> al = new ArrayList<Employee>();
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;
        if(file.isFile()){
         ois = new ObjectInputStream(new FileInputStream(file));
         al = (ArrayList<Employee>)ois.readObject();
         ois.close();
      }
        do{
           System.out.println("1.Add Employee");
           System.out.println("2.View All Employee");
           System.out.println("3.View Employee");
           System.out.println("4.Delete Employee");
           System.out.println("5.Update Employee");
           System.out.print("Enter Your Choice : ");
           choice = s.nextInt();
  
           switch(choice){
              case 1:
                 System.out.println("Enter how many employees you want : ");
                 int n = s.nextInt();
                 for(int i=0;i<n;i++){
                    System.out.print("Enter Employee No: ");
                    int id = s.nextInt();
  
                    System.out.print("Enter Employee Name: ");
                    String name = s1.next();
                    
                    System.out.print("Enter Employee Salary : ");
                    double salary = s1.nextDouble();  
                    
                    al.add(new Employee(id,name,salary));
                            
                 }
  
                 oos = new ObjectOutputStream(new FileOutputStream(file));
                 oos.writeObject(al);
                 oos.close();
              break;
              case 2:
                 if(file.isFile()){
                    ois = new ObjectInputStream(new FileInputStream(file));
                    al = (ArrayList<Employee>)ois.readObject();
                    ois.close();
  
                    System.out.println("-------------------------------------");
                    li = al.listIterator();
                    while(li.hasNext())
                       System.out.println(li.next());
                    System.out.println("-------------------------------------");
                 }else{
                    System.out.println("File not Exists....!");
                 }
              break;
              case 3:
                 if(file.isFile()){
                    ois = new ObjectInputStream(new FileInputStream(file));
                    al = (ArrayList<Employee>)ois.readObject();
                    ois.close();
  
                    boolean found = false;
                    System.out.println("Enter ID to Search : ");
                    int id = s.nextInt();
                    System.out.println("-------------------------------------");
                    li = al.listIterator();
                    while(li.hasNext()){
                       Employee e = (Employee)li.next();
                       if(e.id == id){
                          System.out.println(e);
                          found = true;
                       }
                    }
                    if(!found)
                       System.out.println("Record Not Found...!");
                    System.out.println("-------------------------------------");
                 }else{
                    System.out.println("File not Exists....!");
                 }
              break;          
              case 4:
                 if(file.isFile()){
                    ois = new ObjectInputStream(new FileInputStream(file));
                    al = (ArrayList<Employee>)ois.readObject();
                    ois.close();
  
                    boolean found = false;
                    System.out.print("Enter ID to Delete : ");
                    int id = s.nextInt();
                    System.out.println("-------------------------------------");
                    li = al.listIterator();
                    while(li.hasNext()){
                       Employee e = (Employee)li.next();
                       if(e.id == id){
                          li.remove();
                          found = true;
                       }
                    }
                    if(found){
                       oos = new ObjectOutputStream(new FileOutputStream(file));
                       oos.writeObject(al);
                       oos.close();
                       System.out.println("Record Deleted Successfully....!");
                    }
                    else{
                       System.out.println("Record Not Found...!");                      
                    }
                    System.out.println("-------------------------------------");
                 }else{
                    System.out.println("File not Exists....!");
                 }
              break;          
              case 5:
                 if(file.isFile()){
                    ois = new ObjectInputStream(new FileInputStream(file));
                    al = (ArrayList<Employee>)ois.readObject();
                    ois.close();
  
                    boolean found = false;
                    System.out.print("Enter ID to Update : ");
                    int id = s.nextInt();
                    System.out.println("-------------------------------------");
                    li = al.listIterator();
                    while(li.hasNext()){
                       Employee e = (Employee)li.next();
                       if(e.id == id){
                          System.out.print("Enter New EmpName : ");
                          String name = s1.next();
                          System.out.print("Enter Employee Salary : ");
                          double salary = s.nextDouble();  
                          li.set(new Employee(id,name,salary));
                          found = true;
                       }
                    }
                    if(found){
                       oos = new ObjectOutputStream(new FileOutputStream(file));
                       oos.writeObject(al);
                       oos.close();
                       System.out.println("Record Updated Successfully....!");
                    }
                    else{
                       System.out.println("Record Not Found...!");                      
                    }
                    System.out.println("-------------------------------------");
                 }else{
                    System.out.println("File not Exists....!");
                 }
              break; 
           }
        }while(choice!=0); 
              
      }
  
}
