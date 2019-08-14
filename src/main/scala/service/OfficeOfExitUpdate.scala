package service

import model.Port
import persistance.DeclarationCache

class OfficeOfExitUpdate {
  def update(declarationId: String, o: Port) = {
    DeclarationCache.update(declarationId, o)
  }
}
