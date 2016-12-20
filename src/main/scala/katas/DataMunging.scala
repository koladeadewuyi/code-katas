package katas

import katas.DataMunging._

import scala.io.Source

/**
 * Created by koladeadewuyi@gmail.com on 18/12/2016.
 */
object DataMunging {

  type Data = (String, Short, Short)

  def find(list: List[Data]): Data = {
    if (list.isEmpty) ("none", 0, 0) else quickSort(list)
  }

  private def quickSort(list: List[Data]): Data = {
    if (list.size == 1) list.head
    else {
      val midPoint = math.ceil(list.size / 2).toShort
      val pivot = list(midPoint)
      val partitionedList = compare(pivot, List(pivot), list)
      val lowerList = partitionedList.take(midPoint)
      quickSort(lowerList)
    }
  }

  private def compare(pivot: Data, partitionedList: List[Data], list: List[Data]): List[Data] = {
    if (list.isEmpty) partitionedList
    else {
      val item = list.head
      if ((item._2 - item._3) >= (pivot._2 - pivot._3)) {
        compare(pivot, partitionedList ++ List(item), list.tail)
      } else {
        compare(pivot, List(item) ++ partitionedList, list.tail)
      }
    }
  }

}

trait DataFileExtractor {
  val regexPattern = "".r

  val trimPattern = ""
  
  def extract(line: String): Data = ("none", 0, 0)

  def convertFileToList(dataFileName: String): List[Data] = {
    dataFileName match {
      case "weather.dat" => new WeatherDataExtractor().extractData(dataFileName)
      case "football.dat" => new FootballDataExtractor().extractData(dataFileName)
    }
  }

  def extractData(dataFileName: String): List[Data] = {
    val fileStream = getClass.getResourceAsStream(s"/$dataFileName")
    val file = Source.fromInputStream(fileStream)
    val list = file.getLines.toList.map { line =>
      try {
        val trimmedLine = line.trim.replaceAll(trimPattern, " ")
        val (key: String, value1: Short, value2: Short) = extract(trimmedLine)
        Some((key.toString, value1.toShort, value2.toShort))
      } catch {
        case _: Throwable => None
      }
    }.flatten
    file.close
    fileStream.close
    list
  }
}

class WeatherDataExtractor extends DataFileExtractor {
  override val regexPattern = "(^\\d{1,2}?) (\\d{2}[*]*?) (\\d{2}[*]*?) (\\d{2}) ?(\\d{1,2}?)? (\\d{1,2}?[.]\\d) (\\d[.]\\d{2}) ?([A-Z]*?)? (\\d{3}) (\\d{1,2}?[.]\\d) (\\d{3}) (\\d{1,2}?[*]?) (\\d{1,2}?[.]\\d) (\\d{2,3}?) (\\d{2}) (\\d{4}[.]\\d)$".r

  override val trimPattern = "([*]*?\\s\\s+)"
  
  override def extract(trimmedLine: String): Data = {
    val regexPattern(day, mxT, mnT, avT, Optional(hDDay), avDP, tPcpn, Optional(wxType), pDir, av, dir, mxS, skyC, mxR, mnR, avSLP) = trimmedLine
    (day, mxT.toShort, mnT.toShort)
  }
}

class FootballDataExtractor extends DataFileExtractor {
  override val regexPattern = "(^\\d{1,2}[.]?) ([A-Za-z_]{4,15}?) (\\d{2}?) (\\d{1,2}?) (\\d{1,2}?) (\\d{1,2}?) (\\d{1,2}?) (\\d{1,2}?) (\\d{1,2}?)$".r

  override val trimPattern = "(\\s+[-]*?\\s\\s+)"

  override def extract(trimmedLine: String): Data = {
    val regexPattern(num, team, played, won, lost, drew, goalsFor, goalsAgainst, points) = trimmedLine
    (team, goalsFor.toShort, goalsAgainst.toShort)
  }
}

object Optional {
  def unapply[T](a: T) = if (null == a) Some(None) else Some(Some(a))
}
