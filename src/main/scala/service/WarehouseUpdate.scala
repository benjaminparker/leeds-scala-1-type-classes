package service

import model.WarehouseInfo
import persistance.DeclarationCache

class WarehouseUpdate {

  def retrieve(declarationId: String) = {
    DeclarationCache.retrieve[WarehouseInfo](declarationId) match {
      case Right(warehouseInfo) => displayWarehouse(warehouseInfo)
      case Left(msg) => error(msg)
    }
  }

  def update(declarationId: String, warehouseInfo: WarehouseInfo) = {
    DeclarationCache.update(declarationId, warehouseInfo)
  }

  private def displayWarehouse(warehouseInfo: WarehouseInfo) = println(s"Here is my warehouse: ${warehouseInfo.warehouseName}")

  private def error(msg: String) = println(s"I got an error with message: $msg")
}
