package csv.loader

import java.io.File

import classifier.sample.{ObjectClass, Sample}
import com.github.tototoshi.csv.CSVReader

class TweetLoader(filename: String) {
  def loadSample: Sample = Sample().fromStringList(loadStringList)
  def loadStringList: List[String] = loadRaw.flatMap(_.slice(3, 4))
  def loadRaw: List[List[String]] = CSVReader.open(new File(filename))(TweetFormat).all()
}
