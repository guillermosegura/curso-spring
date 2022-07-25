package mx.com.axity.poc.aop;

import mx.com.axity.poc.to.Operation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TrackOperation
{
  private static final Logger LOG = LoggerFactory.getLogger( TrackOperation.class );

  @Before("execution(* mx.com.axity.poc.service.*.*(..))")
  public void beforeAdvice( JoinPoint jp )
  {
    Object[] args = jp.getArgs();
    if( args != null && args.length == 1 && args[0] instanceof Operation )
    {
      Operation operation = (Operation) args[0];
      LOG.info( "beforeAdvice {} operation, values: a={},  b={}", jp.getSignature().getName(), operation.getA(),
        operation.getB() );
    }

  }

  @Before("execution(* mx.com.axity.poc.service.*.*(..)) and args(operation)")
  public void beforeParamsAdvice( JoinPoint jp, Operation operation )
  {
    if( operation != null )
    {
      LOG.info( "Before params {} operation, values: a={},  b={}", jp.getSignature().getName(), operation.getA(),
        operation.getB() );
    }

  }

  @After("execution(* mx.com.axity.poc.service.*.*(..))")
  public void afterAdvice( JoinPoint jp )
  {
    Object[] args = jp.getArgs();
    if( args != null && args.length == 1 && args[0] instanceof Operation )
    {
      Operation operation = (Operation) args[0];
      LOG.info( "After {} operation, values: a={},  b={}", jp.getSignature().getName(), operation.getA(),
        operation.getB() );
    }

  }

  @After("execution(* mx.com.axity.poc.service.*.*(..)) and args(operation)")
  public void afterParamsAdvice( JoinPoint jp, Operation operation )
  {
    if( operation != null )
    {
      LOG.info( "After params {} operation, values: a={},  b={}", jp.getSignature().getName(), operation.getA(),
        operation.getB() );
    }

  }

  @AfterReturning(pointcut = "execution(* mx.com.axity.poc.service.*.*(..))", returning = "result")
  public void afterReturnAdvice( JoinPoint jp, Operation result )
  {
    Object[] args = jp.getArgs();
    if( args != null && args.length == 1 && args[0] instanceof Operation )
    {
      Operation operation = (Operation) args[0];
      LOG.info( "After return {} operation, values: a={},  b={}, result={}", jp.getSignature().getName(),
        operation.getA(), operation.getB(), result.getResult() );
    }

  }

  @AfterReturning(pointcut = "execution(* mx.com.axity.poc.service.*.*(..))"
      + " and args(operation)", returning = "result")
  public void afterReturnParamsAdvice( JoinPoint jp, Operation operation, Operation result )
  {
    if( operation != null )
    {
      LOG.info( "After return params {} operation, values: a={},  b={}, result={}", jp.getSignature().getName(),
        operation.getA(), operation.getB(), result.getResult() );
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

  @AfterThrowing(pointcut = "execution(* mx.com.axity.poc.service.*.*(..))", throwing = "error")
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

  @AfterThrowing(pointcut = "execution(* mx.com.axity.poc.service.*.*(..))"
      + " and args(operation)", throwing = "error")
  public void afterThrowingParamsAdvice( JoinPoint jp, Operation operation, Throwable error )
  {
    if( operation != null )
    {
      LOG.error( "After throwing params {} operation, values: a={},  b={}", jp.getSignature().getName(),
        operation.getA(), operation.getB() );
    }
    LOG.error( error.getMessage() );
  }

  @Around("execution(* mx.com.axity.poc.service.*.*(..))")
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
        LOG.info( "Before aroundAdvice {} operation, values: a={},  b={}", pjp.getSignature().getName(),
          operation.getA(), operation.getB() );

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

  @Around("execution(* mx.com.axity.poc.service.*.*(..)) and args(operation)")
  public Object aroundParamsAdvice( ProceedingJoinPoint pjp, Operation operation ) throws Throwable
  {
    Object result = null;
    try
    {
      if( operation != null )
      {
        LOG.info( "Before aroundParamsAdvice {} operation, values: a={},  b={}", pjp.getSignature().getName(),
          operation.getA(), operation.getB() );

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
      LOG.error( "aroundParamsAdvice excepcion: ", e.getMessage() );
      result = extractOperation( operation );
      ((Operation) result).setCode( 2 );
      ((Operation) result).setMessage( e.getMessage() );
    }

    return result;
  }

  @Around("within (@mx.com.axity.poc.aop.Intercept *)")
  public Object interceptClassAdvice( ProceedingJoinPoint pjp ) throws Throwable
  {
    Object result = null;
    LOG.info( "interceptClass.Before calling method '{}'", pjp.getSignature().getName() );
    result = pjp.proceed();
    LOG.info( "interceptClass.After calling method '{}'", pjp.getSignature().getName() );
    return result;
  }

  @Around("execution (* mx.com.axity.poc.service.*.*(..))" + " and @annotation(mx.com.axity.poc.aop.Intercept)")
  public Object interceptMethodAdvice( ProceedingJoinPoint pjp ) throws Throwable
  {
    Object result = null;
    LOG.info( "interceptMethod.Before calling method '{}'", pjp.getSignature().getName() );
    result = pjp.proceed();
    LOG.info( "interceptMethod.After calling method '{}'", pjp.getSignature().getName() );
    return result;
  }

}
