Brief Description of Solution
-----------------------------
This solution provides functionality to parse files with hexadecimal data into data-structure.
During this conversion system performs validations, considers valid data and rejects inconsistent
data items.

Main Classes:
-------------
- MatchInfo:
    Data structure which maintains the state of the match.
    Provides validation for incoming data
    Contains functionality to retrieve information related to match
- FileParser:
    Helps in parsing file
    Conversion of hexadecimal string to DataItem 
- Predictor
    Applies heuristic to validate in coming stream of data does not contain any outliers
- DataItem
    Representation of single data item.

Test Classes:
-------------
- MatchTestSuite:
    Tests related to MatchInfo, FileParser, & DataItem
- PredictorTestSuite
    Predictor test cases

Validation Errors while parsing sample2.txt:
--------------------------------------------
VALIDATION FAILED : Current Time : 168 : Last Event Time : 195
Rejecting addition of : DataItem[ hexInput=0x5404059  ptsScored=1 scoringTeam=0 team1TotPts=8 team2TotPts=11  timeElapsed=168]
VALIDATION FAILED : Current Team 1 points : 10 : Last Event Team 1 points : 14
Rejecting addition of : DataItem[ hexInput=0x7d8507e  ptsScored=2 scoringTeam=1 team1TotPts=10  team2TotPts=15  timeElapsed=251]
VALIDATION FAILED : Current Team 1 points : 12 : Last Event Team 1 points : 14
Rejecting addition of : DataItem[ hexInput=0x938608e  ptsScored=2 scoringTeam=1 team1TotPts=12  team2TotPts=17  timeElapsed=295]
VALIDATION FAILED : Current Team 1 points : 12 : Last Event Team 1 points : 14
Rejecting addition of : DataItem[ hexInput=0x8b8607a  ptsScored=2 scoringTeam=0 team1TotPts=12  team2TotPts=15  timeElapsed=279]
VALIDATION FAILED : Current Team 1 points : 12 : Last Event Team 1 points : 14
Rejecting addition of : DataItem[ hexInput=0xa10609e  ptsScored=2 scoringTeam=1 team1TotPts=12  team2TotPts=19  timeElapsed=322]
VALIDATION FAILED : Current Time : 1500 : Max Allowed : 660
Rejecting addition of : DataItem[ hexInput=0x2ee74753 ptsScored=3 scoringTeam=0 team1TotPts=232 team2TotPts=234 timeElapsed=1500]
VALIDATION FAILED : Current Team 1 points : 28 : Last Event Team 1 points : 30
Rejecting addition of : DataItem[ hexInput=0xfc8a8e2  ptsScored=2 scoringTeam=0 team1TotPts=21  team2TotPts=28  timeElapsed=505]
VALIDATION FAILED : Current Team 1 points : 29 : Last Event Team 1 points : 30
Rejecting addition of : DataItem[ hexInput=0x10a8a8ed ptsScored=1 scoringTeam=1 team1TotPts=21  team2TotPts=29  timeElapsed=533]
VALIDATION FAILED : Current Team 1 points : 29 : Last Event Team 1 points : 30
Rejecting addition of : DataItem[ hexInput=0x1180b8ea ptsScored=2 scoringTeam=0 team1TotPts=23  team2TotPts=29  timeElapsed=560]
VALIDATION FAILED : Current Team 1 points : 29 : Last Event Team 1 points : 30
Rejecting addition of : DataItem[ hexInput=0x1218c8ea ptsScored=2 scoringTeam=0 team1TotPts=25  team2TotPts=29  timeElapsed=579]
