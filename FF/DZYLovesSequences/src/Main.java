import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main 
{
    private static MyScanner sc;
    private static PrintWriter out;
    
    public static void main(String[] args)
    {
    	sc = new MyScanner();
    	out = new PrintWriter(System.out);
    	int n = sc.nextInt();
    	int[] arr = new int[n];
    	for(int i = 0; i < n; i++)
    		arr[i] = sc.nextInt();
    	
    	int[] ldecr = new int[n];
    	for(int i = 1; i < n; i++)
    	{
    		if(arr[i - 1] < arr[i])
    			ldecr[i] = ldecr[i - 1] + 1;
    	}
    	int answer = 1;
    	for(int i = 1; i < n; i++)
    	{
    			
    			if(ldecr[i] == 0)
    			{
    				answer = max(answer, i - (i - 1 - ldecr[i - 1]) + 1);
    			}
    			
    			else
    			{
    				int maxIndex = i - ldecr[i];
        			if(maxIndex > 0) answer = max(answer, i - maxIndex + 2);
        			
            		if((maxIndex - 1) >= 0 && canFit(arr, maxIndex))
            		{
            			int prevIndex = (maxIndex - 1) - ldecr[maxIndex - 1];
            			answer = max(answer, i - prevIndex + 1);
            		}
            		
            		else
            		{
            		
            			answer = max(answer, i - maxIndex + 1);
            		}
    				
    			}
    			
    		
    		
    	}
    	out.println(answer);
    	out.close();
    }
    
    private static boolean canFit(int[] arr, int index)
    {
    	if(index - 1 == 0)
    	{
    		return true;
    	}
    	
    	if(index + 1 >= arr.length) return true;
    	if(index - 1 < 0)
    	{
    		if(arr[index] >= 1) return true;
    		else return false;
    	}
    	if(index - 2 < 0)
    	{
    		return arr[index + 1] - arr[index - 1] > 1;
    	}
    	return arr[index + 1] - arr[index - 1] > 1 || (arr[index] - arr[index - 2] > 1);
    }
    
    private static int max(int a, int b)
    {
        if(a > b) return a;
        else return b;
    }

    private static int min(int a, int b)
    {
        if(a < b) return a;
        else return b;

    }

 private static int abs(int a, int b)
    {
        return (int) Math.abs(a - b);
    }
    
     public static int modexp(int a, int b, int n) 
     {
        if (b == 0) return 1;
        long t = modexp(a, b/2, n);  
        long c = (t * t) % n;
        if (b % 2 == 1)
           c = (c * a) % n;
        return (int) c;
    }
    
 public static class MyScanner 
    {
      BufferedReader br;
      StringTokenizer st;
 
      public MyScanner() 
      {
         br = new BufferedReader(new InputStreamReader(System.in));
      }
 
      String next() 
      {
          while (st == null || !st.hasMoreElements()) 
          {
              try 
              {
                  st = new StringTokenizer(br.readLine());
              } catch (IOException e) 
              {
                  e.printStackTrace();
              }
          }
          return st.nextToken();
      }
 
      int nextInt() 
      {
          return Integer.parseInt(next());
      }
 
      long nextLong() 
      {
          return Long.parseLong(next());
      }
 
      double nextDouble() 
      {
          return Double.parseDouble(next());
      }
 
      String nextLine()
      {
          String str = "";
	  try 
          {
	     str = br.readLine();
	  } catch (IOException e) 
          {
	     e.printStackTrace();
	  }
	  return str;
      }

   }
}