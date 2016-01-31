package img

import common._
import scala.io.Source
import scala.io.BufferedSource

object FileParser {
  

  def parseData(src: BufferedSource): MatchInfo = {

    val info = new MatchInfo()

    for (line <- src.getLines; if (!isBlank(Option(line))))
      info.addData(createDataItem(line))

//    println("Unsorted data\n" + info.showItems)
    return info
  }


  def createDataItem(hexStr: String): DataItem = {
//    println("Input Hex String" + "  -> " + hexStr)

    val strToParse = hexStr.substring(2)
//    println("After removing 0x" + "  -> " + strToParse)

    val binStr = Integer.toBinaryString(Integer.parseInt(strToParse, 16))
//    println("Binary Representation" + "  -> " + binStr)

    def binStr32 = String.format("%32s", binStr).replace(' ', '0')

    new DataItem(hexStr,
      Integer.parseInt(binStr32.substring(30), 2),
      Integer.parseInt(binStr32.substring(29, 30), 2),
      Integer.parseInt(binStr32.substring(21, 29), 2),
      Integer.parseInt(binStr32.substring(13, 21), 2),
      Integer.parseInt(binStr32.substring(1, 13), 2))
  }
}