package model

trait Cacheable[T] {
  def upsert(id: String, t: T): T
}

