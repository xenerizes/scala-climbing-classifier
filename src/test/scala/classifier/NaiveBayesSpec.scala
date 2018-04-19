package classifier

import classifier.naiveBayes.NaiveBayesClassifier
import classifier.sample._
import loader.csv.TweetLoader
import org.scalatest.{FunSuite, GivenWhenThen}

class NaiveBayesSpec extends FunSuite with GivenWhenThen {
  val positiveClass = TextObjectClass("Positive")
  val negativeClass = TextObjectClass("Negative")

  val positive: Sample = new TweetLoader("positive.csv").loadSample
  val negative: Sample = new TweetLoader("negative.csv").loadSample

  val classifier = new NaiveBayesClassifier

  test("Medium split") {
    Given("trained")
    val (trainSample, testSample) = splitToTrainTest(0.999)
    classifier.train(trainSample)

    When("test part is classified")
    println(trainSample.objects.size, testSample.objects.size)
    val results = classifier.classify(testSample.toSample)

    Then("classification should be accurate")
    val failCount = results.objects.toSet.diff(testSample.objects.toSet).size / 2
    val accuracy = 100 - failCount * 100d / testSample.objects.size
    println(accuracy) // no assertions, just print accuracy
  }

  def toMap(s: Sample, cl: TextObjectClass): Map[TextObject, TextObjectClass] = new LabeledSample(s, cl).objects
  def toMap(pos: Sample, neg: Sample): Map[TextObject, TextObjectClass] = toMap(pos, positiveClass) ++ toMap(neg, negativeClass)

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
