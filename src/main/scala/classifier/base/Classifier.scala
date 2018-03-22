package classifier.base

import classifier.sample.{LabeledSample, Sample}

trait Classifier {
  def train(sample: LabeledSample): Unit
  def classify(sample: Sample): LabeledSample
}
