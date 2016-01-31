

package object common {
  
  def isBlank(input: Option[String]): Boolean =
    input.filter(_.trim.length > 0).isEmpty

}
