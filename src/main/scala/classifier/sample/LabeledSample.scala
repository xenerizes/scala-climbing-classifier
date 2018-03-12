package classifier.sample


// TODO: get rid of list
class LabeledSample {
  private var objects: List[(Object, ObjectClass)] = Nil

  def append(o: Object, c: ObjectClass): Unit = objects = (o, c) :: objects

  def equals(obj: LabeledSample): Boolean = objects.equals(obj.objects)
}
