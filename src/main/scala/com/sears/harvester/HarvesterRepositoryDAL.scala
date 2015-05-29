package com.sears.harvester

/**
 * Created by Abdhesh.Kumar on 14-05-2015.
 */
trait HarvesterRepository {
  /**
   * We should not use mutable variable. Right now we have used for testing purpose
   */
  var harvesters: Set[Harvester] = Set.empty

  /**
   * Get All harvesters
   * @return Set[Harvester]
   */
  def getHarvesters: Set[Harvester] = harvesters

  def add(harvester: Harvester): Unit
}

class HarvesterRepositoryDAL extends HarvesterRepository {
  /**
   * Add Harvester to existing harvesters list
   * @param harvester: Harvester
   * @return Unit
   */
  override def add(harvester: Harvester): Unit = harvesters += harvester
}
