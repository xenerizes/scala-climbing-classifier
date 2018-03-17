package classifier.sample

case class Object(str: String) {
  def words(): List[Property] = str.split(" ,;.?!@").toList.map(x => Property(x))
}
