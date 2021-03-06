import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;

/**
   An appointment marked with a description and the date it is 
   scheduled to hold. 
*/
public abstract class Appointment
{
   private String description;
   private Date date;
       
   /**
      The default constructor without a description and date
   */
   public Appointment()
   {
      description = "";
   }
   
   /**
      Set the description for this appointment.
      @param text sentence describing this appointment.
   */
   public void setDescription(String text)
   {
      description = text;
   }
   
   /**
      Sets the date for this appointment.
      @param year year of this appointment
      @param month month for this appointment
      @param day the date of this appointment
   */
   public void schedule(int year, int month, int day)
   {
      date = new Date(year, month, day);
   } 
       
   /**
      Gets the date this appointment is scheduled to hold
      @return date for this appointment
   */
   public Date getAppointmentDate()
   {
      return date; 
   }
   
   /**
      Checks if this appointment is scheduled to hold on this given date
      @param year the year 
      @param month the month 
      @param day day within the month
      @return true if the appointment is scheduled to hold within the
      given date, false otherwise 
   */
   public abstract boolean occursOn(int year, int month, int day);
   
   /**
      Saves this appointment entry to a file.
      @param filename file name where this appointment is saved
   */
   public void save(String filename) throws FileNotFoundException
   {
      ArrayList<String> lines = new ArrayList<String>();
      
      File file = new File(filename);
      if (file.exists())
      {
         Scanner in = new Scanner(file);
         while (in.hasNextLine()) 
         {
            lines.add(in.nextLine());
         }
         in.close();
      }
      
      PrintStream out = new PrintStream(file);
      for (String line : lines)
      {
         out.println(line);
      }
      String dateString = String.format("%02d-%02d-%4d", date.getDate(), 
         date.getMonth(), date.getYear());
      out.println(String.format("%s %s %s", getClass().getName(),
         description, dateString));
      out.close();
      
   }
   
   public String toString()
   {
      return getClass().getName() + "[description=" + description 
                                    + ", date=" + date + "]";
   }
}