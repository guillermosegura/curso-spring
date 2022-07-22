package mx.com.axity.poc.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.axity.poc.entity.OfficeDO;

/**
 * @author guillermo.segura@axity.com
 *
 */
@Repository
public interface OfficeRepository extends JpaRepository<OfficeDO, String>
{

  /**
   * @param territory
   * @return
   */
  List<OfficeDO> findByTerritory( String territory );

}
