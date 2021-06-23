import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExportAll, JSExportTopLevel}

object App {

  var workspaceOpt: Option[Blockly.Workspace] = None

  def main(args: Array[String]): Unit = {
    Blockly.defineBlocksWithJsonArray(
      js.Array(
        BlockObj( //                                                                        <--- here we define custom blocks we can use in our workspace
          `type` = "test", //                                                               <--- starting from unique name
          message0 = "test %1", //                                                          <--- text shown on the block, must contain all the arguments as %1
          args0 = js.Array(
            ArgObj(`type` = ArgObj.Type.field_input, name = "ARG0", check = "number") //    <--- all block child connections are defined as arguments, fields or inputs (or dummy), see ArgObj.Type
          ),
          colour = "123", //                                                                <--- block color, (0 - 360) - hue component of the color, or RGB color as HEX
        )
      )
    )
    workspaceOpt = Some(Blockly.inject("blocklyContainer", js.Dynamic.literal(
      toolbox = js.Dynamic.literal(
        kind = "flyoutToolbox", //                                                          <--- optionally define workspace toolbar, might include categories
        contents = js.Array(
          js.Dynamic.literal(kind = "block", `type` = "test") //                            <--- and blocks to be shown
        )
      ),
      trashcan = true
    )))
    val gen = new Blockly.Generator("Json") //                                       <--- define a generator, name doesn't matter
    gen.update( //                                                                          <--- and a function for each block type we defined or want to use (if standard)
      "test",
      block => {
        val arg0 = (block.getFieldValue("ARG0"): Any) match { //                     <--- here we just get field value
          case str: String if str.nonEmpty => str //                                             might be combination of generator's statementToCode/valueToCode/blockToCode calls
          case _ => "null" //                                                                    note this trick with `: Any` to use pattern matching on js.Any type, same with pseudo-union types
        }
        s"""{"arg0" : $arg0}""".stripMargin //                                              <--- and combine it all together into the code string, depending on block output type might need to return a tuple of code and precedence (js.Array("code", 0.0))
      }
    )
    Blockly.Json = gen
  }

}

@JSExportTopLevel("Foo")
@JSExportAll
object Foo {

  def onClick(): Unit = {
    Blockly.Json.foreach { gen =>
      App.workspaceOpt.foreach { workspace =>
        val code = gen.workspaceToCode(workspace)
        dom.document.getElementById("code").innerText = code
      }
    }
  }
}