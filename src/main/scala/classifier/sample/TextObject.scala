package classifier.sample

case class TextObject(words: List[String]) {
  def this(in: String) = this(in.split(" ,;.?!@").toList)
}
