package classifier.naiveBayes

import classifier.base.Classifier
import classifier.sample._

import scala.math.log

class NaiveBayesClassifier extends Classifier {
  private var fit: Fit = new Fit

  override def train(sample: LabeledSample): Unit = fit = Fit(sample)

  override def classify(sample: Sample): LabeledSample = {
    val labeled = sample.objects.map(x => (x, classifyObject(x))).toMap
    LabeledSample(labeled)
  }

  private def classifyObject(o: TextObject): TextObjectClass = {
    val probas = fit.classList.map(cl => (cl, logProba(o, cl))).toMap
    probas.maxBy(_._2)._1
  }

  private def logProba(o: TextObject, cl: TextObjectClass): Double = {
    def wordProba(w: String): Double =
      (fit.classSpecificWordCount(w, cl) + 1) / (fit.uniqueWordCount + fit.classWordCount(cl))

    log(fit.classProba(cl)) + o.words.foldLeft(0d)((_, x) => log(wordProba(x)))
  }
}
