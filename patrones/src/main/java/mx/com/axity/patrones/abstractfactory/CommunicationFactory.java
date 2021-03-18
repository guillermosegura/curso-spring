package mx.com.axity.patrones.abstractfactory;

import mx.com.axity.patrones.abstractfactory.message.Type;
import mx.com.axity.patrones.abstractfactory.service.Service;
import mx.com.axity.patrones.abstractfactory.service.impl.EmailServiceImpl;
import mx.com.axity.patrones.abstractfactory.service.impl.FtpServiceImpl;
import mx.com.axity.patrones.abstractfactory.service.impl.SmsServiceImpl;

public class CommunicationFactory implements AbstractFactory
{

  @Override
  public Service create( Type type )
  {
    Service service = null;
    if( type.equals( Type.SMS ) )
    {
      service = new SmsServiceImpl();
    }
    else if( type.equals( Type.EMAIL ) )
    {
      service = new EmailServiceImpl();
    }
    else if( type.equals( Type.FTP ) )
    {
      service = new FtpServiceImpl();
    }
    service.init();
    return service;
  }

}
