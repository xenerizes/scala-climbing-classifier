package feed

case class VKFeed(items: Seq[Post]) {
  def toList: List[Post] = items.toList
}
