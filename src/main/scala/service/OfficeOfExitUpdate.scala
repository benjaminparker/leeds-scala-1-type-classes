package service

import model.OfficeOfExit
import persistance.DeclarationCache

class OfficeOfExitUpdate {

  def retrieve(declarationId: String) = {
    DeclarationCache.retrieve[OfficeOfExit](declarationId) match {
      case Right(office) => displayOfficeOfExit(office)
      case Left(msg) => error(msg)
    }
  }
  
  def update(declarationId: String, o: OfficeOfExit) = {
    DeclarationCache.update(declarationId, o)
  }

  private def displayOfficeOfExit(officeOfExit: OfficeOfExit) = println(s"Here is my office of exit: ${officeOfExit.officeName}")

  private def error(msg: String) = println(s"I got an error with message: $msg")
}
