package img

import common._
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import scala.io.Source
import org.scalatest.junit.JUnitRunner

/**
 * @author Vikas Sachdeva
 */
@RunWith(classOf[JUnitRunner])
class PredictorTestSuite extends FunSuite {
  
  test("Predictor should calculate mean") {
    val mean = Predictor.avg(List(2,2,2,2))
    assert(mean == 2)
  }
  
  test("Predictor should calculate stddev") {
    val mean = Predictor.avg(List(2,2,2,2))
    
    val stddev = Predictor.stdDev(List(2,2,2,2), mean)
    assert(stddev == 0, "Std dev was : " + stddev)
  }
  
  test("Predictor should calculate stddev for sample1") {
    val src = Source.fromFile("src/main/resources/sample1.txt")
    
    val dataItems = for (line <- src.getLines; if (!isBlank(Option(line))))
      yield FileParser.createDataItem(line)
    
    val ts = for(item <- dataItems) yield item.timeElapsed
      
    val stddev = Predictor.calcStddev(ts.toList)
    assert(stddev == 176, "Std dev was : " + stddev)
  }

}