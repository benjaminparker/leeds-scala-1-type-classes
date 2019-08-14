package persistance

import model.Cacheable

object DeclarationCache {
  def update[T: Cacheable](id: String, t: T): T = {
    implicitly[Cacheable[T]].upsert(id, t)
  }
}
