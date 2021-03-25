package mx.com.axity.poc.to;

public final class OperationFactory
{
  private OperationFactory()
  {
  }

  public static Operation add( int a, int b )
  {
    Operation operation = new Operation();
    operation.setA( a );
    operation.setB( b );
    operation.setType( Operation.Type.ADD );
    return operation;
  }

  public static Operation substract( int a, int b )
  {
    Operation operation = new Operation();
    operation.setA( a );
    operation.setB( b );
    operation.setType( Operation.Type.SUBSTRACT );
    return operation;
  }

  public static Operation multiply( int a, int b )
  {
    Operation operation = new Operation();
    operation.setA( a );
    operation.setB( b );
    operation.setType( Operation.Type.MULTIPLY );
    return operation;
  }

  public static Operation divide( int a, int b )
  {
    Operation operation = new Operation();
    operation.setA( a );
    operation.setB( b );
    operation.setType( Operation.Type.DIVIDE );
    return operation;
  }
}
