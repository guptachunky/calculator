import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Date;
import java.sql.PreparedStatement;
public class Calculator {


    public static double add(int left,int right)
    {
        System.out.println(left+right);
        return left+right;
    }

   public static double subtract(int left,int right)
   {
       System.out.println(left-right);
       return left-right;
   }
public static double multiply(int left,int right)
{
    System.out.println(left*right);
    return left*right;
}

public static double divide(int left,int right)
{

    if(right==0)
    {
        return 0;
    }
    System.out.println(left/right);
    return left/right;
}

public static double power(double left,double right)
{
    System.out.println( Math.pow(left,right) );
    return Math.pow(left,right);
}

public static double absolute(double num)
{
    System.out.println(Math.abs(num));
    return Math.abs(num);
}

public static double modulus(int left,int right)
{
    System.out.println(left%right);
    return left%right;
}

public static double max(int left,int right)
{
    if(left>right)
    {
        System.out.println(left);
        return left;
    }
    else {
        System.out.println(right);
return right;
    }
    }

public static double min(int left,int right)
{
    if(left<right)
    {
        System.out.println(left);
        return left;
    }
    else
        System.out.println(right);
    return right;

}

    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
        int num=0,n=0,n1=0;
        double result=0;
         int id=0;
        String op="";
        while(true)
        {
            System.out.println("Enter Operations \n 1. For Addition \n 2. For Subtraction \n 3. For Multiply \n 4. For Division \n 5. For Power \n 6. For Absolute \n 7. For Modulas \n 8.For Maximum Of Two Numbers \n 9.For Minimun Of Two Numbers \n 10.Exit");
            num=sc.nextInt();

            if(num==1)
            {
                System.out.println("Enter First Number");
                n=sc.nextInt();
                System.out.println("Enter 2nd Number");
                n1=sc.nextInt();
                op="addition";
                result=add(n,n1);
            }
            else if(num==2)
            {

                System.out.println("Enter First Number");
                n=sc.nextInt();
                System.out.println("Enter 2nd Number");
                n1=sc.nextInt();
                op="Subtraction";
                result=subtract(n,n1);
            }
            else if(num==3)
            {

                System.out.println("Enter First Number");
                n=sc.nextInt();
                System.out.println("Enter 2nd Number");
                n1=sc.nextInt();
                op="multiply";
                result=multiply(n,n1);
            }
            else if(num==4)
            {

                System.out.println("Enter First Number");
                n=sc.nextInt();
                System.out.println("Enter 2nd Number");
                n1=sc.nextInt();
                op="division";
                result=divide(n,n1);
            }
            else if(num==5)
            {

                System.out.println("Enter First Number");
                n=sc.nextInt();
                System.out.println("Enter 2nd Number");
                n1=sc.nextInt();
                op="power";
                result=power(n,n1);
            }
            else if(num==6)
            {

                System.out.println("Enter First Number");
                n=sc.nextInt();
                System.out.println("Enter 2nd Number");
                n1=sc.nextInt();
                op="absolute";
                result=absolute(n1);
            }
            else if(num==7)
            {

                System.out.println("Enter First Number");
                n=sc.nextInt();
                System.out.println("Enter 2nd Number");
                n1=sc.nextInt();
                op="modulas";
                result=modulus(n,n1);
            }
            else if(num==8)
            {

                System.out.println("Enter First Number");
                n=sc.nextInt();
                System.out.println("Enter 2nd Number");
                n1=sc.nextInt();
                op="max";
                result=max(n,n1);
            }
            else if(num==9)
            {

                System.out.println("Enter First Number");
                n=sc.nextInt();
                System.out.println("Enter 2nd Number");
                n1=sc.nextInt();
                op="min";
                result=min(n,n1);
            }
            else
            {
                break;
            }
            id++;
            String timestamp ="12-15-2018";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/calc", "root", "tiger");

                PreparedStatement pst = con.prepareStatement("insert into calculator values(?,?,?,?,?,?)");
                pst.setInt(1, id);
                pst.setString(2, timestamp);
                pst.setString(3, n + "");
                pst.setString(4, n1 + "");
                pst.setString(5,op );
                pst.setString(6,result+"");
                pst.execute();
//            ResultSet rs=st.executeQuery("select * from test");
//            while(rs.next())
//            {
//                System.out.println("id="+rs.getString("id"));
//                System.out.println("name="+rs.getString("name"));
//
//
//            }
                con.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }








  }

  while(true)
  {
      int inp=0;
      System.out.println("1.for Reading All operations \n 2. for Sepecific operand operations \n Exit");
      inp=sc.nextInt();
      if(inp==1)
      {
                       try{
                         Class.forName("com.mysql.jdbc.Driver");
                         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/calc", "root", "tiger");
                          Statement st = con.createStatement();
                          ResultSet rs=st.executeQuery("Select * from calculator");
                          while(rs.next())
                          {
                              System.out.println("id="+rs.getInt(1));
                              System.out.println("timestamp="+rs.getString(2));
                              System.out.println("Left_operator="+rs.getString(3));
                              System.out.println("right_operator="+rs.getString(4));
                              System.out.println("opearand="+rs.getString(5));
                              System.out.println("result="+rs.getString(6));
                          }
                          con.close();
                       }
                       catch(Exception e)
                       {
                           e.printStackTrace();
                       }

      }
      else if(inp==2)
      {
          System.out.println("Enter Operations \n additon. For Addition \n Subtraction. For Subtraction \n multiply. For Multiply \n division. For Division \n power. For Power \n absolute. For Absolute \n modulas. For Modulas \n min.For Maximum Of Two Numbers \n max.For Minimun Of Two Numbers \n 10.Exit");
          String s=sc.next();
          try{
              Class.forName("com.mysql.jdbc.Driver");
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/calc", "root", "tiger");
              Statement st = con.createStatement();
              ResultSet rs=st.executeQuery("Select * from calculator where operand='"+s+"'");
              while(rs.next())
              {System.out.println("id="+rs.getInt(1));
                  System.out.println("timestamp="+rs.getString(2));
                  System.out.println("Left_operator="+rs.getString(3));
                  System.out.println("right_operator="+rs.getString(4));
                  System.out.println("opearand="+rs.getString(5));
                  System.out.println("result="+rs.getString(6));
              }
              con.close();
          }
          catch(Exception e)
          {
              e.printStackTrace();
          }

      }
      else
      {
          break;
      }
  }







    }
}
