package classifier.naiveBayes

import classifier.sample.{LabeledSample, TextObjectClass}

private[naiveBayes] case class Fit(sample: LabeledSample = new LabeledSample) {
  val classList: List[TextObjectClass] = sample.classList
  val uniqueWordCount: Int = sample.wordList.size

  def classProba(cl: TextObjectClass): Double = classObjectCount(cl).toDouble / sample.objects.size
  def classSpecificWordCount(w: String, cl: TextObjectClass): Int = sample.classWordList(cl).count(_.equals(w))
  def classWordCount(cl: TextObjectClass): Int = sample.classWordList(cl).length

  private def classObjectCount(cl: TextObjectClass): Int = sample.objects.count(_._2.equals(cl))
}
