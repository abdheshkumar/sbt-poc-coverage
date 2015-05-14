package com.sears

import com.sears.harvester.{HarvesterService, HarvesterType, Harvester}
import org.scalatest.FunSuite


/**
 * Created by Abdhesh.Kumar on 14-05-2015.
 */

class HarvesterServiceUnitTest extends FunSuite {

  test("Add Static booking testing harvester") {
    val harvester: Harvester = Harvester(1, "Booking Harvester", HarvesterType.STATIC)
    HarvesterService.addHarvester(harvester)
    assert(HarvesterService.harvesters.size == 1)
  }

  test("Get Static harvester") {
    val harvester: Harvester = Harvester(1, "Booking Harvester", HarvesterType.STATIC)
    HarvesterService.addHarvester(harvester)
    assert(HarvesterService.getStaticHarvester(harvester) == Some(harvester))
  }
}
