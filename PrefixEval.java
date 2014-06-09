/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prefixeval;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 *
 * @author chintan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        if(args.length==0)
            System.out.println("Please specify the file name");
        else readFile(args[0]);
    }
    private static void readFile(String filepath)
    {
        int count=0;
        try{
  // Open the file that is the first
  // command line parameter
  FileInputStream fstream = new FileInputStream(filepath);
  // Get the object of DataInputStream
  DataInputStream in = new DataInputStream(fstream);
  BufferedReader br = new BufferedReader(new InputStreamReader(in));
  String strLine;
  //Read File Line By Line with maximum of 40 cases
  while ((strLine = br.readLine()) != null && count<=40)   {
  
  count++;
  double x=prefixeval(strLine);
  if(x==-1)
       System.out.println("Prefix expression is not properly formatted");
  else
       System.out.println(x);


  }
  //Close the input stream
  in.close();
    }
 
  catch(IOException e){
              System.out.println("Problem encountered while reading the file");
           }
       
    }


    public static double prefixeval(String input)
    {
       //Using Stack to hold the operands
       Stack<Double> operands = new Stack<Double>();
       double op1=0,op2=0;
       //Getting individula tokens with regular expression
       String result[]=input.split("\\s");
       //Scanning the string from right to left
       for(int i=result.length-1;i>=0;i--)
       {
          if(result[i].charAt(0)=='+' || result[i].charAt(0)=='*' || result[i].charAt(0)=='/' || result[i].charAt(0)=='-')
          {
           try{
              op1=operands.pop();
              op2=operands.pop();
              }
           //In case expression is wrong e.g * 4
           catch(EmptyStackException e)
           {
            return -1;
           }
            double res=process(result[i].charAt(0),op1,op2);
            operands.push(res);
          }
          else{
              try{
              operands.push(new Double(result[i]));
              }
             //In case expression is invalid e.g + a b
              catch(NumberFormatException e)
              {
               return -1;
              }
       }}

       //return the top element of stack as final result
        return operands.peek();
    }

    public static double process(char operator, double a1, double a2)
    {
        switch(operator)
        {
            case '+':return a1+a2;

            case '*':return a1*a2;

            case '/':return a1/a2;

            case '-':return a1-a2;
            
            default:return -1;
        }

        
        

    }

}
