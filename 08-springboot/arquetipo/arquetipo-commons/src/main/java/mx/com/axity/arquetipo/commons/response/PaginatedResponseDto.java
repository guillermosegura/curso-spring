package mx.com.axity.arquetipo.commons.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase DTO de respuesta paginada
 * 
 * @author guillermo.segura@axity.com
 */
@Getter
@Setter
public class PaginatedResponseDto<T extends Serializable> implements Serializable
{
  private static final long serialVersionUID = -7923049268047269630L;

  private HeaderDto header;

  private long page;
  private long size;
  private long pages;
  private long registries;
  private List<T> data;

  /**
   * Constructor default
   */
  public PaginatedResponseDto()
  {
  }

  /**
   * Constructor por página, tamaño y número de registros
   * 
   * @param page
   * @param size
   * @param registries
   */
  public PaginatedResponseDto( long page, long size, long registries )
  {
    this.page = page;
    this.size = size;
    this.registries = registries;

    if( registries % size == 0 )
    {
      this.pages = registries / size;
    }
    else
    {
      this.pages = registries / size + 1;
    }
    this.data = new ArrayList<>();
  }

  /**
   * Constructor por página, tamaño, número de registros y lista de elementos
   * 
   * @param page
   * @param size
   * @param registries
   * @param data
   */
  public PaginatedResponseDto( long page, long size, long registries, List<T> data )
  {
    this( page, size, registries );
    this.data = data;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString()
  {
    Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    return gson.toJson( this );
  }
}
