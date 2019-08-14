package service

import model.Warehouse
import persistance.DeclarationCache

class WarehouseUpdate {
  def update(declarationId: String, warehouseInfo: Warehouse) = {
    DeclarationCache.update(declarationId, warehouseInfo)
  }
}
