package classifier

import classifier.naiveBayes.NaiveBayesClassifier
import classifier.sample.{LabeledSample, Object, ObjectClass, Sample}
import csv.loader.TweetLoader
import org.scalatest.{FunSuite, GivenWhenThen}

class NaiveBayesSpec extends FunSuite with GivenWhenThen {
  val positiveClass = ObjectClass("Positive")
  val negativeClass = ObjectClass("Negative")

  val positive: Sample = new TweetLoader("positive.csv").loadSample
  val negative: Sample = new TweetLoader("negative.csv").loadSample

  val classifier = new NaiveBayesClassifier

  test("Medium split") {
    Given("trained with 3/4 of sample")
    val (trainSample, testSample) = splitToTrainTest(0.75)
    classifier.train(trainSample)

    When("test part is classified")
    val results = classifier.classify(testSample.toSample)

    Then("classification should be accurate")
    assert(results.equals(testSample)) // they surely wouldn't
  }

  def toMap(s: Sample, cl: ObjectClass): Map[Object, ObjectClass] = LabeledSample().fromSample(s, cl).objects
  def toMap(pos: Sample, neg: Sample): Map[Object, ObjectClass] = toMap(pos, positiveClass) ++ toMap(neg, negativeClass)

  def splitToTrainTest(n: Double): (LabeledSample, LabeledSample) = {
    val (trainP, testP) = splitSample(positive, n)
    val (trainN, testN) = splitSample(negative, n)
    (LabeledSample(toMap(trainP, trainN)), LabeledSample(toMap(testP, testN)))
  }

  def splitSample(origin: Sample, pos: Double): (Sample, Sample) = {
    val (train, test) = origin.objects.splitAt((origin.objects.length * pos).toInt)
    (Sample(train), Sample(test))
  }
}
