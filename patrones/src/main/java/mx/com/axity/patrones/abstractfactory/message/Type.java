package mx.com.axity.patrones.abstractfactory.message;

public enum Type
{
  EMAIL(ServiceType.COMMUNICATION), 
  SMS(ServiceType.COMMUNICATION), 
  FTP(ServiceType.COMMUNICATION), 
  LOGGING( ServiceType.EVENT), 
  MONITOR(ServiceType.EVENT), 
  SAVING(ServiceType.EVENT);

  private ServiceType serviceType;

  private Type( ServiceType serviceType )
  {
    this.serviceType = serviceType;
  }

  public ServiceType getServiceType()
  {
    return serviceType;
  }

}
