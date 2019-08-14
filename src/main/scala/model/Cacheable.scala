package model

trait Cacheable[T] {
  def save(id: String, t: T): T

  def find(id: String): Either[String, T]
}
