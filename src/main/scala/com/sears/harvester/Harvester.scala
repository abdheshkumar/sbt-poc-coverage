package com.sears.harvester

/**
 * Created by Abdhesh.Kumar on 14-05-2015.
 */

/**
 * Harvester basic information
 */
case class Harvester(id: Int, name: String, harvesterType: HarvesterType.Value)

/**
 * Define type of harvester
 */
object HarvesterType extends Enumeration {
  type HarvesterType = Value
  val STATIC, DYNAMIC = Value
}

