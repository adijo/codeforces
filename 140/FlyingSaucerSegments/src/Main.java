
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 *
 * @author Aditya Joshi
 */
public class Main 
{
    
    public static void main(String[] args)
    {
    
        MyScanner sc = new MyScanner();
        long n = sc.nextLong();
        long m = sc.nextLong();
        
        long answer = modexp(3, n, m);
        if(answer == 0) System.out.println(m - 1);
        else System.out.println(answer - 1);
    
    }
    
     public static int modexp(int a, long b, long n) {
        if (b == 0) return 1;
        long t = modexp(a, b/2, n);  // use long for intermediate computations to eliminate overflow
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
