package classifier.sample

case class ClassProperty(cl: ObjectClass, property: Double) {
  // TODO: better func name
  def modify(np: Double = property) = ClassProperty(cl, np)
}
