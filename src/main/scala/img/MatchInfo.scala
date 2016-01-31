package img

import scala.collection.mutable.MutableList
import scala.collection.mutable.MutableList

/*
 * MatchInfo maintains state of match as additional data items are received. 
 * It implements functionality to retrieve: 
 *    the last event (i.e. which team last scored, how many points, at what point through the
      match and what the resulting match score was)
 *    the last n events (where 0 <= n <= Total Items)
 *    all events in the match so far
 * Handles cases where an invalid data item is received or where data is inconsistent with
 *  previous data received 
 * 
 * @author Vikas Sachdeva
 */
class MatchInfo {

  var dataItems = MutableList[DataItem]()

  def addData(data: DataItem) {

    /*
     * Validate Data on following principles
     * 1) Elapsed time for every new item should be greater than the last one
     *    Similar validations for total points for team 1 & 2
     * 2) Elapsed time for every new item should less than max value predicted 
     * 
     * StdDev quantifies amount of variation observed in data till now
     * 
     */
    def isValidData: Boolean = {
      if (size > 0) {
        if (data.timeElapsed < getLastEvent.timeElapsed) {
          println("VALIDATION FAILED : Current Time : " + data.timeElapsed +
            " : Last Event Time : " + getLastEvent.timeElapsed)

          return false
        }
        if (data.team1TotPts < getLastEvent.team1TotPts) {
          println("VALIDATION FAILED : Current Team 1 points : " + data.team1TotPts +
            " : Last Event Team 1 points : " + getLastEvent.team1TotPts)

          return false
        }
        if (data.team2TotPts < getLastEvent.team2TotPts) {
          println("VALIDATION FAILED : Current Team 1 points : " + data.team2TotPts +
            " : Last Event Team 1 points : " + getLastEvent.team2TotPts)

          return false
        }
        val maxNextVal = Predictor.predictMaxForNextValue(dataItems)
        if (data.timeElapsed > maxNextVal) {
          println("VALIDATION FAILED : Current Time : " + data.timeElapsed +
            " : Max Allowed : " + maxNextVal)

          return false
        }
      }
      return true
    }

    if (isValidData) {
      dataItems += data
    } else {
      println("Rejecting addition of : " + data)
    }
  }

  def getLastEvent = dataItems.last

  def getLastNEvents(n: Int) = dataItems.takeRight(n)

  def getAllEvents = dataItems
  
  def size = dataItems.size

  def showItems = dataItems mkString "\n"

}