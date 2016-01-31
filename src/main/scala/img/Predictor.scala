package img

import scala.math._
import Numeric.Implicits._

/* 
 * Predictor predicts what max value can be for next item in the series
 * It uses heuristic that new item should not be more than last event + 2 StdDev 
 * This logic is dependent on type of data that is being filtered.
 * 
 * StdDev quantifies amount of variation observed in data till now
 * 
 * Stddev will be calculated on if size of list is more than 5
 * Otherwise a default value calculated from sample1 will be used
 * 
 * Logic for calculation of StdDev is taken from:
 * http://rosettacode.org/wiki/Standard_deviation#Scala
 *
 * @author Vikas Sachdeva
 */
object Predictor extends App {

  def avg(ts: Iterable[Int])(implicit num: Integral[Int]) = ts.sum / num.fromInt(ts.size)
  def stdDev(ts: Iterable[Int], mean: Double)(implicit num: Fractional[Double]) =
    sqrt(num.toDouble(ts.foldLeft(num.zero)((b, a) => num.plus(b, num.times(num.minus(a, mean), num.minus(a, mean))))) / ts.size)

  def calcStddev(ts: Iterable[Int]): Int = {

    val DEFAULT_STD_DEV = 176

    if (ts.size <= 5) {
      return DEFAULT_STD_DEV
    }
    val mean = avg(ts)
    val stdDv = stdDev(ts, mean)
    BigDecimal(stdDv).setScale(0, BigDecimal.RoundingMode.UP).toInt
  }

  def predictMaxForNextValue(dataItems: Iterable[DataItem]): Int = {
    val ts = for (item <- dataItems) yield item.timeElapsed

    dataItems.last.timeElapsed + 2 * calcStddev(ts)
  }

}