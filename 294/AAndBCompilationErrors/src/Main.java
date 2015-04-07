import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
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
    	int[] a = new int[n];
    	int[] b = new int[n - 1];
    	int[] c = new int[n - 2];
    	for(int i = 0; i < n; i++) a[i] = sc.nextInt();
    	Arrays.sort(a);
    	for(int i = 0; i < (n - 1); i++) b[i] = sc.nextInt();
    	Arrays.sort(b);
    	for(int i = 0; i < (n - 2); i++) c[i] = sc.nextInt();
    	Arrays.sort(c);
    	int first = -1;
    	int second = -1;
    	int i = 0;
    	int j = 0;
    	while(i < (n - 1) && j < (n - 1) && i <= j)
    	{
    		if(a[i] == b[j])
    		{
    			i++;
    			j++;
    		}
    		else
    		{
    			first = a[i];
    			break;
    		}
    	}
    	if(i == n - 1) first = a[n - 1];
    	
    	i = 0;
    	j = 0;
    	while(i < (n - 2) && j < (n - 2) && i <= j)
    	{
    		if(b[i] == c[j])
    		{
    			i++;
    			j++;
    		}
    		
    		else
    		{
    			second = b[i];
    			break;
    		}
    		  		
    	}
    	if(i == n - 2) second = b[n - 2];
    	out.println(first);
    	out.println(second);
    	
    	
        out.close();
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