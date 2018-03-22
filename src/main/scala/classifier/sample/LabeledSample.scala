package classifier.sample

case class LabeledSample(objects: Map[TextObject, TextObjectClass] = Map()) {
  val classList: List[TextObjectClass] = objects.values.toList.distinct
  val wordList: List[String] = objects.keys.toList.flatMap(_.words).distinct

  def classObjectList(cl: TextObjectClass): List[TextObject] = objects.filter(_.equals(cl)).keys.toList
  def classWordList(cl: TextObjectClass): List[String] = classObjectList(cl).flatMap(_.words).distinct

  def this(s: Sample, cl: TextObjectClass) = this(s.objects.map(x => (x, cl)).toMap)
  def this(raw: List[TextObject], cl: TextObjectClass) = this(Sample(raw), cl)

  def toSample = Sample(objects.keySet.toList)
}
