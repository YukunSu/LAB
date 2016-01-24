package com.broadsoft;

import java.io.*;
import java.math.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The following program reads a file containing large integer numbers.
 * The filename is provided as the first command line argument.
 * For each number, it dispatches a task into a thread pool to factorize the number.
 * After the factorization is complete, it calls the method Output.output(String result).
 * The goal is to implement the class Output to:
 * 1) Print the value of 'result' in the order that the number were provided in the input file.
 * 2) Results must be displayed as soon as available, subject to the "in order" rule #1.
 * 3) Threads in the thread pool must be busy at least 99% of the time
 *    (they must not sleep or block for extended periods).
 * 4) You may modify the class Output as desired and create any additional class or object as needed.
 * 5) Classes Task and Interview01 must not be modified.
 * The program can be invoked as 'java com.broadsoft.Interview01 test.txt'.
 */

class Output
{
  private final int lineNumber;
  /**
   * Use ConcurrentHashMap instead of HashMap for thread-safe
   */
  private static Map<Integer, String> map = new ConcurrentHashMap<Integer, String>();
  /**
   * Use AtomicInteger instead of int for thread-safe
   */
  private static AtomicInteger order = new AtomicInteger(1);

  public Output(int lineNumber)
  {
    this.lineNumber = lineNumber;
  }

  public void output(String result)
  {
    // TODO replace by logic to display results in order and non-blocking.
    synchronized(this.map){
      map.put(lineNumber, result);
      while(map.get(order.get())!=null && map.containsKey(order.get()))
      {
        System.out.println(order.get() + ": " + map.remove(order.get()));
        order.incrementAndGet();
      }
    }
  }
}

class Task implements Runnable
{
  private BigInteger x;
  private Output     output;

  public Task(BigInteger x, Output output)
  {
    this.x      = x;
    this.output = output;
  }

  @Override
  public void run()
  {
    List<BigInteger> factors = factor(x);
    if (factors.size() > 1) Collections.sort(factors);
    output.output(x + " -> " + factors);
  }

  private List<BigInteger> factor(BigInteger x)
  {
    if (BigInteger.ONE.equals(x)) return Collections.emptyList();
    if (x.isProbablePrime(100)) return Collections.singletonList(x);
    if (!x.testBit(0))
    {
      // Even number.
      List<BigInteger> result = new ArrayList<BigInteger>();
      result.add(BigInteger.valueOf(2));
      result.addAll(factor(x.shiftRight(1)));
      return result;
    }
    for (long i = 1;; ++i)
    {
      BigInteger a = BigInteger.valueOf(2);
      BigInteger b = a;
      BigInteger c = BigInteger.valueOf(i);
      for (;;)
      {
        a = a.multiply(a).add(c).mod(x);
        b = b.multiply(b).add(c).mod(x);
        b = b.multiply(b).add(c).mod(x);
        BigInteger d = a.subtract(b).abs().gcd(x);
        if (d.equals(x)) break;
        if (BigInteger.ONE.equals(d)) continue;
        List<BigInteger> result = new ArrayList<BigInteger>();
        result.addAll(factor(d));
        result.addAll(factor(x.divide(d)));
        return result;
      }
    }
  }
}

public class Interview01
{
  private String filename;

  public Interview01(String filename)
  {
    this.filename = filename;
  }

  public void run() throws Exception
  {
    ExecutorService threadPool = Executors.newFixedThreadPool(4);
    BufferedReader  reader     = new BufferedReader(new FileReader(filename));
    try
    {
      for (int lineNumber = 1;; ++lineNumber)
      {
        String line = reader.readLine();
        if (line == null) break;
        BigInteger x = new BigInteger(line);
        threadPool.submit(new Task(x, new Output(lineNumber)));
      }
    }
    finally
    {
      reader.close();
    }
    threadPool.shutdown();
  }

  public static void main(String[] args)
  {
    try
    {
      new Interview01(args[0]).run();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
