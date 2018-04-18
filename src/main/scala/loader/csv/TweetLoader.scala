package loader.csv

import java.io.File

import classifier.sample.{Sample, TextObject}
import com.github.tototoshi.csv.CSVReader

class TweetLoader(filename: String) {
  def loadRaw: Seq[Seq[String]] = CSVReader.open(new File(filename))(TweetFormat).all()
  def loadStringSeq: Seq[String] = loadRaw.flatMap(_.slice(3, 4))
  def loadObjectSeq: Seq[TextObject] = loadStringSeq.map(new TextObject(_))
  def loadSample = Sample(loadObjectSeq)
}
