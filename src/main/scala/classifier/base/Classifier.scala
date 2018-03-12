package classifier.base

import classifier.sample.{LabeledSample, Sample}

abstract class Classifier {
  def train(sample: LabeledSample): Unit
  def classify(sample: Sample): LabeledSample
}
