object Conversions {
  def hexStr = "0x801002"                         //> hexStr: => String
  println(hexStr + "  -> " + Integer.parseInt(hexStr.substring(2), 16))
                                                  //> 0x801002  -> 8392706
  def binStr = Integer.toBinaryString(Integer.parseInt(hexStr.substring(2), 16))
                                                  //> binStr: => String
  println("Bin String" + "  -> " + Integer.toBinaryString(Integer.parseInt("781002", 16)))
                                                  //> Bin String  -> 11110000001000000000010
  
  val (x, y) = binStr splitAt (binStr.length - 2) //> x  : String = 1000000000010000000000
                                                  //| y  : String = 10
  
  val (a, b) = y splitAt (y.length -1)            //> a  : String = 1
                                                  //| b  : String = 0
               
  println(binStr + " : " + binStr.length)         //> 100000000001000000000010 : 24
  
  def binStr32 = String.format("%32s", binStr).replace(' ', '0')
                                                  //> binStr32: => String
  println(binStr32 + " : " + binStr32.length)     //> 00000000100000000001000000000010 : 32
  
  println(binStr32.substring(30))                 //> 10
  println(binStr32.substring(29,30))              //> 0
  println(binStr32.substring(21,29))              //> 00000000
  println(binStr32.substring(13,21))              //> 00000010
  println(binStr32.substring(1,13))               //> 000000010000
}