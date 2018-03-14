package classifier.sample

class LabeledSample {
  private var objects: List[(Object, ObjectClass)] = Nil

  def size(): Int = objects.length // FIXME: change to words
  def freq(): List[ClassProperty] = sizes().map(x => x.modify(x.property / size()))
  def sizes(): List[ClassProperty] = Nil // TODO
  def unique(): Int = objects.distinct.length // FIXME: change to words

  def append(o: Object, c: ObjectClass): Unit = objects = (o, c) :: objects
}
