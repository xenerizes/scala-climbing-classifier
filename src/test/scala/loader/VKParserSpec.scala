package loader

import org.scalatest.{FunSuite, GivenWhenThen}

import json.VKParser
import feed.{User, Post}
import scala.io.Source

class VKParserSpec extends FunSuite with GivenWhenThen {
  test("Test feed") {
    Given("feed")
    val feed = Source.fromFile("feed.json").mkString

    val expected = List(
      Post(32860, -106879986, "Корнелл был известен по группам Soundgarden и Audioslave.", 0),
      Post(244688, -30022666, "", 13),
      Post(33703, -90074084, "Пусть все на западе увидят, как у нас хорошо!", 4)
    )

    When("parsing posts")
    val posts = VKParser.parseFeed(feed)

    Then("list of Post")
  }

  test("Test users") {
    Given("user list")
    val users = Source.fromFile("users.json").mkString

    val expected = List(
      User(210700286, "Lindsey", "Stirling", "https://sun9-8.us...20f/W8Uv-hC7Bvo.jpg"),
      User(56739221, "Nika", "Lapulka", "https://vk.com/images/camera_100.png"),
      User(87283495, "Mr.", "Podlets", "https://pp.userap...3495/d_556537b8.jpg")
    )

    When("parsing users")
    val userList = VKParser.parseUser(users)

    Then("list of User")
    assert(userList.equals(expected))
  }

}
