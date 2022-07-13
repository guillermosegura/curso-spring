package poc;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class SImpleTest
{

  @Test
  public void test() throws InterruptedException
  {
    System.out.println( "Hola" );

    List<String> list = new ArrayList<String>();
    Hilo h1 = new Hilo( "Hilo 1", list );
    Hilo h2 = new Hilo( "Hilo 2", list );
    Hilo h3 = new Hilo( "Hilo 3", list );

    h1.start();
    h2.start();
    h3.start();

    Thread.sleep( 1000L );
    // for( String s : list )
    // {
    // System.out.println( s );
    // }
  }

  @Test
  public void test2() throws InterruptedException
  {
    System.out.println( "Hola" );

    List<Integer> list =   new ArrayList<Integer>()  ;
    
   
    HiloRunnable h1 = new HiloRunnable( "Hilo 1", list, true );
    HiloRunnable h2 = new HiloRunnable( "Hilo 2", list, true );
    HiloRunnable h3 = new HiloRunnable( "Hilo 3", list, false );
    HiloRunnable h4 = new HiloRunnable( "Hilo 4", list, false );
    HiloRunnable h5 = new HiloRunnable( "Hilo 5", list, false );
    HiloRunnable h6 = new HiloRunnable( "Hilo 6", list, false );
    HiloRunnable h7 = new HiloRunnable( "Hilo 7", list, false );

    Thread t1 = new Thread( h1 );
    Thread t2 = new Thread( h2 );
    Thread t3 = new Thread( h3 );
    Thread t4 = new Thread( h4 );
    Thread t5 = new Thread( h5 );
    Thread t6 = new Thread( h6 );
    Thread t7 = new Thread( h7 );

    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();
    t6.start();
    t7.start();

    Thread.sleep( 1000L );

    // for( String s : list )
    // {
    // System.out.println( s );
    // }
  }

  @Test
  public void test3() throws InterruptedException
  {
    SynchronizedCounter sc = new SynchronizedCounter();

    HiloCounter h1 = new HiloCounter( "HiloCounter 1", sc, true );
    HiloCounter h2 = new HiloCounter( "HiloCounter 2", sc, false );
    HiloCounter h3 = new HiloCounter( "HiloCounter 3", sc, true );

    h1.start();
    h2.start();
    h3.start();

    Thread.sleep( 1000L );
    
    
    Object o = new Object();
    
    synchronized( o )
    {
      //
      
      
      //
    }
    
  }

  private static class Hilo extends Thread
  {
    private String name;
    private List<String> list;

    public Hilo( String name, List<String> list )
    {
      this.name = name;
      this.list = list;
    }

    public void run()
    {
      int n = 0;
      while( true )
      {
        String msg = "This code is running in a thread [" + name + "] " + n;
        System.out.println( msg );

        list.add( msg );
        n++;
        try
        {
          long sleep = 100L + (long) (Math.random() * 200.0);
          Thread.sleep( sleep );
          System.out.println( "\tHay " + list.size() + " valores  [" + name + "]  " );
        }
        catch( InterruptedException e )
        {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }
  }

  private static class HiloRunnable implements Runnable
  {

    private String name;
    private List<Integer> list;
    private boolean producer;
    private boolean flag;

    public HiloRunnable( String name, List<Integer> list, boolean producer )
    {
      this.name = name;
      this.list = list;
      this.producer = producer;
    }

    @Override
    public void run()
    {
      System.out.println( "Hola [" + name + "]" );

      while( true )
      {
        if( producer )
        {
          int n = (int) (Math.random() * 100.0);
          this.list.add( n );
          System.out.println( "Se agregó " + n + "[" + name + "]" );
          for( int v : this.list )
          {
            System.out.print( v + "," );
          }
        }
        else
        {
          if( !this.list.isEmpty() )
          {
            int n = this.list.remove( 0 );
            System.out.println( "Se quitó " + n + "[" + name + "]" );
          }
          else
          {
            System.out.println( "No hay elementos " + "[" + name + "]" );
          }
        }

        long sleep = 100L + (long) (Math.random() * 200.0);
        try
        {
          Thread.sleep( sleep );
        }
        catch( InterruptedException e )
        {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }

    private void metodoSync()
    {
      synchronized( list )
      {

      }
    }

  }

  private static class SynchronizedCounter
  {
    private int c = 0;

    public synchronized void increment()
    {
      c++;
    }

    public synchronized void decrement()
    {
      c--;
    }

    public synchronized int value()
    {
      return c;
    }
  }

  private static class HiloCounter extends Thread
  {
    private String name;
    private SynchronizedCounter sc;
    private boolean increment;

    public HiloCounter( String name, SynchronizedCounter sc, boolean increment )
    {
      this.name = name;
      this.sc = sc;
      this.increment = increment;
    }

    public void run()
    {
      while( true )
      {
        if( this.increment )
        {
          System.out.println("Incrementa " + " [" + name + "]  ");
          this.sc.increment();
        }
        else
        {
          System.out.println("Decrementa " + " [" + name + "]  ");
          this.sc.decrement();
        }

        try
        {
          long sleep = 100L + (long) (Math.random() * 200.0);
          Thread.sleep( sleep );
          System.out.println( "SC=" + sc.value() + " [" + name + "]  " );
        }
        catch( InterruptedException e )
        {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

      }

    }
  }
}
