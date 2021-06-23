import scala.scalajs.js

object App {

  def main(args: Array[String]): Unit = {
    println("Hello")
    Blockly.inject("blocklyContainer", js.Dynamic.literal())
  }
}
