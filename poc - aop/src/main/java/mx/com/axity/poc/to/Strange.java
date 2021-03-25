package mx.com.axity.poc.to;

public class Strange
{

  private int id;

  public Strange()
  {
  }

  public Strange( int id )
  {
    this.id = id;
  }

  /**
   * @return the id
   */
  public int getId()
  {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId( int id )
  {
    this.id = id;
  }

  @Override
  public String toString()
  {
    return "<<Strange: " + this.id + " >>";
  }
}
