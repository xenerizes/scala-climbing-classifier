package classifier

import sample.{LabeledSample, Sample}

abstract class Classifier(m: Model) {
  private val model = m

  def train(sample: LabeledSample): Unit
  def classify(sample: Sample): LabeledSample
}
