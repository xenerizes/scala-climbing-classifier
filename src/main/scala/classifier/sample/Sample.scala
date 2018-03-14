package classifier.sample

case class Sample(objects: List[Object] = Nil) {
  def fromStringList(raw: List[String]): Sample = Sample(raw.map(x => Object(x)))
}
