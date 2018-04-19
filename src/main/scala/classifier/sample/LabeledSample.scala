package classifier.sample

case class LabeledSample(objects: Map[TextObject, TextObjectClass] = Map()) {
  val classList: Seq[TextObjectClass] = objects.values.toList.distinct
  val wordList: Seq[String] = objects.keys.toList.flatMap(_.words).distinct
  val classWordCount: Map[TextObjectClass, Int] = classList.map(cl => (cl, classWordList(cl).length)).toMap

  def classObjectList(cl: TextObjectClass): Seq[TextObject] = objects.filter(_.equals(cl)).keys.toList
  def classWordList(cl: TextObjectClass): Seq[String] = classObjectList(cl).flatMap(_.words).distinct

  def this(s: Sample, cl: TextObjectClass) = this(s.objects.map(x => (x, cl)).toMap)
  def this(raw: Seq[TextObject], cl: TextObjectClass) = this(Sample(raw), cl)

  def toSample = Sample(objects.keySet.toList)
}
