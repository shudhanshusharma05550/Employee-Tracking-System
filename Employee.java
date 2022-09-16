
import java.io.Serializable;
public class Employee implements Serializable{
   int id;
   String name;
   double salary;

   Employee(int id, String name, double salary){
      this.id = id;
      this.name = name;
      this.salary = salary;
   }
   public String toString(){
      return id+" "+name+" "+salary;
   }
}
