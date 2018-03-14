package classifier.naiveBayes

import classifier.sample.{LabeledSample, ObjectClass, Word}

private[naiveBayes] case class Fit(sample: LabeledSample = new LabeledSample) {
  val classList: List[ObjectClass] = sample.classList
  val uniqueWordCount: Int = sample.wordList.size

  def classProba(cl: ObjectClass): Double = classObjectCount(cl).toDouble / sample.objects.size
  def classSpecificWordCount(w: Word, cl: ObjectClass): Int = sample.classWordList(cl).count(_.equals(w))
  def classWordCount(cl: ObjectClass): Int = sample.classWordList(cl).length

  private def classObjectCount(cl: ObjectClass): Int = sample.objects.count(_._2.equals(cl))
}
