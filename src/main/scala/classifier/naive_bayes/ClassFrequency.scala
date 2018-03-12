package classifier.naive_bayes

// TODO: get rid of list
class ClassFrequency {
  private var classes: List[ObjectCount] = Nil

  def append(o: ObjectCount): Unit = classes = o :: classes
}
