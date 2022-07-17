package mx.com.axity.poc.aop;

import mx.com.axity.poc.to.Alpha;
import mx.com.axity.poc.to.Operation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrackOperation
{
  private static final Logger LOG = LoggerFactory.getLogger( TrackOperation.class );

  public void beforeAdvice( JoinPoint jp )
  {
    Object[] args = jp.getArgs();
    if( args != null && args.length == 1 && args[0] instanceof Operation )
    {
      Operation operation = (Operation) args[0];
      LOG.info( "Before sin params {} operation, values: a={},  b={}", jp.getSignature().getName(), operation.getA(),
        operation.getB() );
    }
    else
    {
      LOG.info( "Before método {} de {} - {}", jp.getSignature().getName(), jp.getTarget().getClass().getCanonicalName() , args );
    }

  }

  public void beforeParamsAdvice( JoinPoint jp, Operation operation )
  {
    if( operation != null )
    {
      LOG.info( "Before {} operation, values: a={},  b={}", jp.getSignature().getName(), operation.getA(),
        operation.getB() );
    }

  }
  
  public void beforeAlpha(JoinPoint jp, Alpha alpha){
    LOG.info( "Before {} operation  {}", jp.getSignature().getName(), alpha.something() );
  }

  public void afterAdvice( JoinPoint jp )
  {
    Object[] args = jp.getArgs();
    if( args != null && args.length == 1 && args[0] instanceof Operation )
    {
      Operation operation = (Operation) args[0];
      LOG.info( "After {} operation, values: a={},  b={}, result={}", jp.getSignature().getName(), operation.getA(),
        operation.getB(), operation.getResult() );
    }

  }

  public void afterParamsAdvice( JoinPoint jp, Operation operation )
  {
    if( operation != null )
    {
      LOG.info( "After Params {} operation, values: a={},  b={}, result={}", jp.getSignature().getName(), operation.getA(),
        operation.getB(), operation.getResult() );
    }

  }

  public void afterReturnAdvice( JoinPoint jp, Operation result )
  {
    Object[] args = jp.getArgs();
    if( args != null && args.length == 1 && args[0] instanceof Operation )
    {
      Operation operation = (Operation) args[0];
      LOG.info( "After return {} operation, values: a={},  b={}, result={}", jp.getSignature().getName(), operation.getA(),
        operation.getB(), result.getResult() );
    }

  }

  public void afterReturnParamsAdvice( JoinPoint jp, Operation operation, Operation result )
  {
    if( operation != null )
    {
      LOG.info( "After return params {} operation, values: a={},  b={}, result={}", jp.getSignature().getName(), operation.getA(),
        operation.getB(), result.getResult() );
    }
  }

  private Object extractOperation( Operation operation )
  {
    Object result;
    result = new Operation();
    if( operation != null )
    {
      ((Operation) result).setA( operation.getA() );
      ((Operation) result).setB( operation.getB() );
      ((Operation) result).setType( operation.getType() );
    }
    return result;
  }

  public void afterThrowingAdvice( JoinPoint jp, Throwable error )
  {
    Object[] args = jp.getArgs();
    if( args != null && args.length == 1 && args[0] instanceof Operation )
    {
      Operation operation = (Operation) args[0];
      LOG.error( "After throwing {} operation, values: a={},  b={}", jp.getSignature().getName(), operation.getA(),
        operation.getB() );
    }
    LOG.error( error.getMessage() );
  }

  public void afterThrowingParamsAdvice( JoinPoint jp, Operation operation, Throwable error )
  {
    if( operation != null )
    {
      LOG.error( "After throwing params {} operation, values: a={},  b={}", jp.getSignature().getName(), operation.getA(),
        operation.getB() );
    }
    LOG.error( error.getMessage() );
  }

  public Object aroundAdvice( ProceedingJoinPoint pjp ) throws Throwable
  {
    Object result = null;
    Operation operation = null;
    try
    {

      Object[] args = pjp.getArgs();
      if( args != null && args.length == 1 && args[0] instanceof Operation )
      {
        operation = (Operation) args[0];
        LOG.info( "Around: Before {} operation, values: a={},  b={}", pjp.getSignature().getName(), operation.getA(),
          operation.getB() );

        if( operation.getA() == null )
        {
          String message = "Falta definir el parámetro 'a'";
          LOG.error( message );
          throw new IllegalArgumentException( message );
        }
        if( operation.getB() == null )
        {
          throw new IllegalArgumentException( "Falta definir el parámetro 'b'" );
        }
      }

      result = pjp.proceed();
      if( result != null && result instanceof Operation )
      {
        Operation operationResult = (Operation) result;
        operationResult.setCode( 9 );
        operationResult.setMessage( "OK" );
        LOG.info( "After {} operation, result={}", pjp.getSignature().getName(), operationResult.getResult() );
      }
    }
    catch( IllegalArgumentException e )
    {
      result = extractOperation( operation );
      ((Operation) result).setCode( 1 );
      ((Operation) result).setMessage( e.getMessage() );
    }
    catch( Throwable e )
    {
      LOG.error( e.getMessage()  );
      result = extractOperation( operation );
      ((Operation) result).setCode( 2 );
      ((Operation) result).setMessage( "Ocurrió una división entre cero" );
    }

    return result;
  }

  public Object aroundParamsAdvice( ProceedingJoinPoint pjp, Operation operation ) throws Throwable
  {
    Object result = null;
    try
    {
      if( operation != null )
      {
        LOG.info( "Before {} operation, values: a={},  b={}", pjp.getSignature().getName(), operation.getA(),
          operation.getB() );

        if( operation.getA() == null )
        {
          String message = "Falta definir el parámetro 'a'";
          LOG.error( message );
          throw new IllegalArgumentException( message );
        }
        if( operation.getB() == null )
        {
          throw new IllegalArgumentException( "Falta definir el parámetro 'b'" );
        }
      }

      result = pjp.proceed();
      if( result != null && result instanceof Operation )
      {
        Operation operationResult = (Operation) result;

        LOG.info( "After {} operation, result={}", pjp.getSignature().getName(), operationResult.getResult() );
      }
    }
    catch( IllegalArgumentException e )
    {
      result = extractOperation( operation );
      ((Operation) result).setCode( 1 );
      ((Operation) result).setMessage( e.getMessage() );
    }
    catch( Throwable e )
    {
      LOG.error( e.getMessage(), e );
      result = extractOperation( operation );
      ((Operation) result).setCode( 2 );
      ((Operation) result).setMessage( e.getMessage() );
    }

    return result;
  }

  public Object interceptAdvice( ProceedingJoinPoint pjp ) throws Throwable
  {
    Object result = null;
    LOG.info( "Before calling method '{}'", pjp.getSignature().getName() );
    result = pjp.proceed();
    LOG.info( "After calling method '{}'", pjp.getSignature().getName() );
    return result;
  }
}
