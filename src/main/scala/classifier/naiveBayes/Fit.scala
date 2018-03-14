package classifier.naiveBayes

import classifier.sample.{LabeledSample, ObjectClass, Word}

private[naiveBayes] class Fit(sample: LabeledSample = new LabeledSample) {
  val classProba: Map[ObjectClass, Double] = Map()
  val words: Map[ObjectClass, Int] = Map()
  val wordsFreq: Map[(Word, ObjectClass), Float] = Map()
  val uniqueWords: Int = 0
  val classList: List[ObjectClass] = Nil
}
