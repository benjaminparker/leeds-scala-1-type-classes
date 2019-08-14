package persistance

import model.Cacheable

object DeclarationCache {
  def retrieve[T: Cacheable](id: String): Either[String, T] = {
    implicitly[Cacheable[T]].find(id)
  }

  def update[T: Cacheable](id: String, t: T): T = {
    implicitly[Cacheable[T]].save(id, t)
  }
}
