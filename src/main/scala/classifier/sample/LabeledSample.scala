package classifier.sample

case class LabeledSample(objects: Map[Object, ObjectClass] = Map()) {
  val classList: List[ObjectClass] = objects.values.toList.distinct
  val wordList: List[Word] = objects.keys.toList.flatMap(_.words()).distinct

  def classObjectList(cl: ObjectClass): List[Object] = objects.filter(_.equals(cl)).keys.toList
  def classWordList(cl: ObjectClass): List[Word] = classObjectList(cl).flatMap(_.words()).distinct
}
