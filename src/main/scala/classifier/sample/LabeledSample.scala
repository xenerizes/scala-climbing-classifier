package classifier.sample

case class LabeledSample(objects: Map[Object, ObjectClass] = Map()) {
  def size(): Int = 0
  def freq(): List[ClassProperty] = sizes().map(x => x.modify(x.property / size()))
  def sizes(): List[ClassProperty] = Nil
  def unique(): Int = 0
}
