package img

class DataItem(val hexInput: String, val ptsScored: Int, val scoringTeam: Int,
  val team2TotPts: Int, val team1TotPts: Int, val timeElapsed: Int) {

  
  override def toString = "DataItem[" +
  		"\thexInput=" + hexInput +
  		"\tptsScored=" + ptsScored +
  		"\tscoringTeam=" + scoringTeam + 
  		"\tteam1TotPts=" + team1TotPts +
  		"\tteam2TotPts=" + team2TotPts +
  		"\ttimeElapsed=" + timeElapsed +
  		"]"
      
  override def equals(o: Any) = o match {
    case that: DataItem => that.hexInput.equalsIgnoreCase(this.hexInput) && 
            that.ptsScored.equals(this.ptsScored) &&
            that.scoringTeam.equals(this.scoringTeam)&&
            that.team1TotPts.equals(this.team1TotPts)&&
            that.team2TotPts.equals(this.team2TotPts)&&
            that.timeElapsed.equals(this.timeElapsed) 
    case _ => false
  }

}