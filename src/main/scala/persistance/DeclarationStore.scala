package persistance

import model.ExportsDeclaration

object DeclarationStore {

  var store: Map[String, ExportsDeclaration] = {
    println("New STORE...")
    Map.empty
  }

  def findInCache(id: String): Either[String, ExportsDeclaration] = store.get(id) match {
    case Some(foundItem) => Right(foundItem)
    case None => Left("Not found")
  }

  def storeInCache(i: ExportsDeclaration) = {
    store = store + (i.id -> i)
    println(s"STORE: $store")
    i
  }
}

