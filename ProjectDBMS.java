import java.lang.*;
import java.util.*;

import javax.lang.model.util.ElementScanner14;


class Project_DBMS
{
    public static void main(String arg[])
    {
        DBMS dobj = new DBMS();

        dobj.StartDBMS();

    }
}

class Student
{
    public int RID;
    public String Name;
    public int Salary;

    private static int Generator;

    static
    {
        Generator = 0;
    }

    public Student(String str, int value)
    {
        this.RID = ++Generator;
        this.Name = str;
        this.Salary = value;
    }

    public void DisplayData()
    {
        System.out.println(this.RID + "\t" + this.Name + "\t" + this.Salary);
    }
}

class DBMS
{
   public LinkedList <Student> lobj;

    public DBMS()
    {
        lobj = new LinkedList<>();
    }

   
    public void StartDBMS()
    {
        Scanner scanobj = new Scanner(System.in);

        System.out.println("Mohare customised DBMS started succesfully....");
        String Query = "";

        while(true)
        {
            System.out.print("Mohare DBMS console >");
            Query = scanobj.nextLine();

            String tokens[] = Query.split(" ");
            int QuerySize = tokens.length;

            if(QuerySize == 1)
            {
                if("Help".equals(tokens[0]))
                {
                    System.out.println("This application is used to demonstrates the customised DBMS");
                    System.out.println("Exit : Terminate DBMS");
                    System.out.println("Display all data : select * from student");
                    System.out.println("Insert data : Insert into student Name Salary");
                }
                else if("Exit".equals(tokens[0]))
                {
                    System.out.println("Thank you for using Marvellous DBMS");
                    break;
                }
            }
            else if(QuerySize == 2)
            {

            }
            else if(QuerySize == 4)
            {
                if("select".equals(tokens[0]))
                {
                    if("*".equals(tokens[1]))
                    {
                        DisplayAll();
                    }
                }
            }
            else if(QuerySize == 5)
            {
            
                if("Insert".equals(tokens[0]))
                {
                     InsertData(tokens[3],Integer.parseInt(tokens[4]));
                }
            }

        }
    }


y
    public void InsertData(String str, int value)
    {
        Student sobj = new Student(str,value);
        lobj.add(sobj);
    }

    public void DisplayAll()
    {
        for(Student sref : lobj)
        {
            sref.DisplayData();
        }
    }


    public void DisplaySpecific(int rid)
    {
         for(Student sref : lobj)
        {
            if(sref.RID == rid)
            {
                sref.DisplayData();
                break;
            }
        }
    }

  
    public void DisplaySpecific(String str)
    {
         for(Student sref : lobj)
        {
            if(str.equals(sref.Name))
            {
                sref.DisplayData();
            }
        }
    }


    public void DeleteSpecific(int rid)
    {
        int index = 0;

        for(Student sref : lobj)
        {
            if(sref.RID == rid)
            {
                lobj.remove(index);
                break;
            }
            index++;
        }
    }

  
    public void DeleteSpecific(String str)
    {
        int index = 0;

        for(Student sref : lobj)
        {
            if(str.equals(sref.Name))
            {
                lobj.remove(index);
                break;
            }
            index++;
        }
    }

    public void AggregateMax()
    {
        int iMax = 0;
        Student temp = null;

        for(Student sref : lobj)
        {
            if(sref.Salary > iMax)
            {
                iMax = sref.Salary;
                temp = sref;
            }
        }

        System.out.println("Information of student having maximum salary : ");
        temp.DisplayData();
    }

    public void AggregateMin()
    {
        int iMin = (lobj.getFirst()).Salary;
        Student temp = lobj.getFirst();

        for(Student sref : lobj)
        {
            if(sref.Salary < iMin)
            {
                iMin = sref.Salary;
                temp = sref;
            }
        }

        System.out.println("Information of student having minimum salary : ");
        temp.DisplayData();
    }

    public void AggregateSum()
    {
        long iSum = 0;

        for(Student sref : lobj)
        {
            iSum = iSum + sref.Salary;
        }

        System.out.println("Summation of salaries is : "+ iSum);
    }

    public void AggregateAvg()
    {
        long iSum = 0;

        for(Student sref : lobj)
        {
            iSum = iSum + sref.Salary;
        }

        System.out.println("Average salary is : "+ iSum / (lobj.size()));
    }

    public void AggregateCount()
    {
         System.out.println("Count is : "+lobj.size());
    }
}

