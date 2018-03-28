package feed

case class VKUsers(items: Seq[User]) {
  def toList: List[User] = items.toList
}
