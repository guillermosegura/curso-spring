package mx.com.axity.petstore.to;


public class Item
{
  private int id;
  private String sku;
  private String description;

  public int getId()
  {
    return id;
  }

  public void setId( int id )
  {
    this.id = id;
  }

  public String getSku()
  {
    return sku;
  }

  public void setSku( String sku )
  {
    this.sku = sku;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription( String description )
  {
    this.description = description;
  }

}
