package csv.loader

import java.io.File

import com.github.tototoshi.csv.CSVReader

class TweetLoader {
  def loadSample(filename: String): List[String] = loadRaw(filename).flatMap(_.slice(3, 4))

  private def loadRaw(filename: String): List[List[String]] = CSVReader.open(new File(filename))(TweetFormat).all()
}
