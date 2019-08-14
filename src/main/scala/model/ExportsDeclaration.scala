package model

import java.util.UUID

import persistance.DeclarationStore.{findInCache, storeInCache}

case class Warehouse(name: String)

object Warehouse {

  implicit object CacheableWarehouseInfo extends Cacheable[Warehouse] {

    def upsert(id: String, warehouse: Warehouse): Warehouse = {
      findInCache(id) match {
        case Right(declaration) => storeInCache(declaration.copy(warehouse = Some(warehouse)))
        case Left(_) => storeInCache(ExportsDeclaration(warehouse = Some(warehouse)))
      }
      warehouse
    }
  }

}

case class Port(name: String)

object Port {

  implicit object CacheablePort extends Cacheable[Port] {
    def upsert(id: String, port: Port): Port = {
      findInCache(id) match {
        case Right(declaration) => storeInCache(declaration.copy(port = Some(port)))
        case Left(_) => storeInCache(ExportsDeclaration(port = Some(port)))
      }
      port
    }
  }

}

case class ExportsDeclaration(id: String = UUID.randomUUID().toString, warehouse: Option[Warehouse] = None, port: Option[Port] = None)

object ExportsDeclaration {

  implicit object CacheableDeclaration extends Cacheable[ExportsDeclaration] {
    def upsert(id: String, declaration: ExportsDeclaration): ExportsDeclaration = {
      storeInCache(declaration)
      declaration
    }
  }

}

