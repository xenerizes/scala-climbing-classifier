package loader.json

import feed.{Post, User, VKFeed, VKUsers}
import play.api.libs.json._
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

object VKParser {
  implicit val readsPost: Reads[Post] = (
    (__ \ "post_id").read[Int] and
      (__ \ "source_id").read[Int] and
      (__ \ "text").read[String] and
      (__ \ "likes" \ "count").read[Int]
    )(Post.apply _)

  implicit val readsUser: Reads[User] = (
    (__ \ "id").read[Int] and
      (__ \ "first_name").read[String] and
      (__ \ "last_name").read[String] and
      (__ \ "photo_100").read[String]
    )(User.apply _)

  implicit val readsVKFeed: Reads[VKFeed] = (__ \ "response" \ "items").read[Seq[Post]].map(VKFeed(_))
  implicit val readsVKUsers: Reads[VKUsers] = (__ \ "response").read[Seq[User]].map(VKUsers(_))

  def parseFeed(str: String): VKFeed = Json.parse(str).as[VKFeed]
  def parseUser(str: String): VKUsers = Json.parse(str).as[VKUsers]
}
