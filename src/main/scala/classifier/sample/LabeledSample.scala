package classifier.sample

case class LabeledSample(objects: Map[Object, ObjectClass] = Map()) {
  val classList: List[ObjectClass] = objects.values.toList.distinct
  val wordList: List[Word] = objects.keys.toList.flatMap(_.words()).distinct

  def classObjectList(cl: ObjectClass): List[Object] = objects.filter(_.equals(cl)).keys.toList
  def classWordList(cl: ObjectClass): List[Word] = classObjectList(cl).flatMap(_.words()).distinct

  def fromStringList(raw: List[String], cl: ObjectClass): LabeledSample = fromSample(Sample().fromStringList(raw), cl)
  def fromSample(s: Sample, cl: ObjectClass): LabeledSample = LabeledSample(s.objects.map(x => (x, cl)).toMap)

  def toSample: Sample = Sample(objects.keySet.toList)
}
