package classifier.sample

case class TextObject(words: Seq[String]) {
  def this(in: String) = this(in.split(" ,;.?!@").toSeq)
}
