package com.sears.harvester

/**
 * Created by Abdhesh.Kumar on 14-05-2015.
 */
class HarvesterService(harvesterRepository: HarvesterRepository) {

  import HarvesterType._

  /**
   * Get Static Harvester
   * @param harvester
   * @return Option[Harvester]
   */
  def getStaticHarvester(harvester: Harvester): Option[Harvester] =
    harvesterRepository.getHarvesters.find(_.harvesterType == STATIC)

  def addHarvester(harvester: Harvester): Unit = harvesterRepository.add(harvester)

  /**
   * Return all harvesters
   * @return Set[Harvester]
   */
  def harvesters: Set[Harvester] = harvesterRepository.getHarvesters
}

object HarvesterService extends HarvesterService(new HarvesterRepositoryDAL)
