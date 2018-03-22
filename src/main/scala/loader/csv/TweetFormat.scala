package loader.csv

import com.github.tototoshi.csv.DefaultCSVFormat

private[loader] object TweetFormat extends DefaultCSVFormat {
  override val delimiter = ';'
}
