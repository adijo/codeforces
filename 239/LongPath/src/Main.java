
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Main 
{
    
    public static void main(String[] args)
    {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        
        long[] DP = new long[n + 1];
        DP[1] = 2;
        for(int i = 2; i < n + 1; i++)
        {
         long acc = 0;
         for(int j = arr[i - 1]; j < i; j++) acc += DP[j];
         DP[i] = (acc + 2)%1000000007;
            
        
        }
        
        long total_sum = 0;
        for(int i = 1; i < n + 1; i++) total_sum += DP[i];
        System.out.println(total_sum%1000000007);
    }
    public static class MyScanner {
      BufferedReader br;
      StringTokenizer st;
 
      public MyScanner() {
         br = new BufferedReader(new InputStreamReader(System.in));
      }
 
      String next() {
          while (st == null || !st.hasMoreElements()) {
              try {
                  st = new StringTokenizer(br.readLine());
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
          return st.nextToken();
      }
 
      int nextInt() {
          return Integer.parseInt(next());
      }
 
      long nextLong() {
          return Long.parseLong(next());
      }
 
      double nextDouble() {
          return Double.parseDouble(next());
      }
 
      String nextLine(){
          String str = "";
	  try {
	     str = br.readLine();
	  } catch (IOException e) {
	     e.printStackTrace();
	  }
	  return str;
      }

   } 
}
