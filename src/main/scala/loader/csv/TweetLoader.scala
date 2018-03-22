package loader.csv

import java.io.File

import classifier.sample.{Sample, TextObject}
import com.github.tototoshi.csv.CSVReader

class TweetLoader(filename: String) {
  def loadRaw: List[List[String]] = CSVReader.open(new File(filename))(TweetFormat).all()
  def loadStringList: List[String] = loadRaw.flatMap(_.slice(3, 4))
  def loadObjectList: List[TextObject] = loadStringList.map(new TextObject(_))
  def loadSample = Sample(loadObjectList)
}
