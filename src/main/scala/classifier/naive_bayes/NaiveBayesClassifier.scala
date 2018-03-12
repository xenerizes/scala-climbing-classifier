package classifier.naive_bayes

import classifier.base.Classifier
import classifier.sample.{LabeledSample, Sample}

class NaiveBayesClassifier extends Classifier {
  private var fit = TrainingResults()

  override def train(sample: LabeledSample): Unit = {

  }

}
