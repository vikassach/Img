package img

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import scala.io.Source

@RunWith(classOf[JUnitRunner])
class MatchTestSuite extends FunSuite {
  
  test("DataItem equals compares all fields") {
    val hexStr = "0x801002"
    val actualDataItem = new DataItem(hexStr, 2,0,0,2,16)
    val expectedDataItem = new DataItem(hexStr, 2,0,0,2,16)
    assert(actualDataItem == expectedDataItem, 
        "Actual was: " + actualDataItem + " : Expected was: " + expectedDataItem)
  }
  
  test("Negative test 1 for DataItem equals method") {
    val hexStr = "0x801002"
    val actualDataItem = null
    val expectedDataItem = new DataItem(hexStr, 2,0,0,2,16)
    assert((actualDataItem == expectedDataItem) == false, 
        "Actual was: " + actualDataItem + " : Expected was: " + expectedDataItem)
  }
  
  test("Negative test 2 for DataItem equals method") {
    val hexStr = "0x801002"
    val actualDataItem = new DataItem(hexStr, 2,1,0,2,16)
    val expectedDataItem = new DataItem(hexStr, 2,0,0,2,16)
    assert((actualDataItem == expectedDataItem) == false, 
        "Actual was: " + actualDataItem + " : Expected was: " + expectedDataItem)
  }
  
  test("Parser should be able to parse hexadecimal string and create DataItem") {
    val hexStr = "0x801002"
    val dataItem = FileParser.createDataItem("0x801002")
    val expectedDataItem = new DataItem(hexStr, 2,0,0,2,16)
    assert(dataItem == expectedDataItem, 
        "Actual was: " + dataItem + " : Expected was: " + expectedDataItem)
  }
  
  test("MatchInfo should be able to retrieve all events in sample1 file") {
    val info = FileParser.parseData(Source.fromFile("src/main/resources/sample1.txt"))
    assert(info.getAllEvents.size == 28, "Actual file size was: " + info.size + " : Expected was: " + 28)
  }
  
  test("MatchInfo should provide match state") {
    val expectedLastEvent = new DataItem("0x12b0d8ea", 2,0,29,27,598)
    val info = FileParser.parseData(Source.fromFile("src/main/resources/sample1.txt"))
    assert(info.getLastEvent == expectedLastEvent, 
        "Actual state was: " + info.getLastEvent + " : Expected was: " + expectedLastEvent)
  }
  
  test("MatchInfo should provide last n events") {
    val expectedFifthLastEvent = new DataItem("0xf98a8e6", 2,1,28,21,499)
    val expectedLastEvent = new DataItem("0x12b0d8ea", 2,0,29,27,598)
    val info = FileParser.parseData(Source.fromFile("src/main/resources/sample1.txt"))
    val lastFiveEvents = info.getLastNEvents(5)
    assert(lastFiveEvents.head == expectedFifthLastEvent, 
        "Actual fifth last event was: " + lastFiveEvents.head + " : Expected was: " + expectedFifthLastEvent)
    assert(lastFiveEvents.last == expectedLastEvent, 
        "Actual last event was: " + lastFiveEvents.last + " : Expected was: " + expectedLastEvent)
  }
  
  test("MatchInfor should be able to filter sample2 file") {
    val info = FileParser.parseData(Source.fromFile("src/main/resources/sample2.txt"))
    assert(info.size == 20, "Actual size was: " + info.size + " : Expected was: " + 27)
  }

}