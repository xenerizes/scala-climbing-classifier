package classifier.sample

case class Object(str: String) {
  def words(): List[Word] = str.split(" ,;.?!").toList.map(x => Word(x))
}
