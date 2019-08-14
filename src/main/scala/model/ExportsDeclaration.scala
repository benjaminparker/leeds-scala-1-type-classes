package model

import java.util.UUID

import persistance.DeclarationStore.{findInCache, storeInCache}

case class WarehouseInfo(warehouseName: String)

object WarehouseInfo {

  implicit object CacheableWarehouseInfo extends Cacheable[WarehouseInfo] {

    def save(id: String, warehouseInfo: WarehouseInfo): WarehouseInfo = {
      findInCache(id) match {
        case Right(declaration) => storeInCache(declaration.copy(warehouseInfo = Some(warehouseInfo)))
        case Left(_) => storeInCache(ExportsDeclaration(warehouseInfo = Some(warehouseInfo)))
      }
      warehouseInfo
    }

    def find(id: String): Either[String, WarehouseInfo] = {
      findInCache(id) match {
        case Right(ExportsDeclaration(_, Some(warehouseInfo), _)) => Right(warehouseInfo)
        case _ => Left("Warehouse Info Not found")
      }
    }
  }
}

case class OfficeOfExit(officeName: String)

object OfficeOfExit {

  implicit object CacheableOfficeOfExit extends Cacheable[OfficeOfExit] {
    def save(id: String, o: OfficeOfExit): OfficeOfExit = {
      findInCache(id) match {
        case Right(declaration) => storeInCache(declaration.copy(officeOfExit = Some(o)))
        case Left(_) => storeInCache(ExportsDeclaration(officeOfExit = Some(o)))
      }
      o
    }

    def find(id: String): Either[String, OfficeOfExit] = {
      findInCache(id) match {
        case Right(ExportsDeclaration(_, _, Some(officeOfExit))) => Right(officeOfExit)
        case _ => Left("Office of Exit Not found")
      }
    }
  }

}

case class ExportsDeclaration(id: String = UUID.randomUUID().toString, warehouseInfo: Option[WarehouseInfo] = None, officeOfExit: Option[OfficeOfExit] = None)

object ExportsDeclaration {
  implicit object CacheableDeclaration extends Cacheable[ExportsDeclaration] {
  
      def save(id: String, declaration: ExportsDeclaration): ExportsDeclaration = {
        storeInCache(declaration)
        declaration
      }
  
      def find(id: String): Either[String, ExportsDeclaration] = findInCache(id)
    }
}

