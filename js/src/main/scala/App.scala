import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExport, JSExportAll, JSExportTopLevel}

object App {

  var workspaceOpt: Option[Blockly.Workspace] = None

  def main(args: Array[String]): Unit = {
    Blockly.defineBlocksWithJsonArray(
      js.Array(
        BlockObj(
          `type` = "test",
          message0 = "test %1",
          args0 = js.Array(
            ArgObj(`type` = ArgObj.Type.field_input, name = "ARG0", check = "number")
          ),
          colour = "123"
        )
      )
    )
    workspaceOpt = Some(Blockly.inject("blocklyContainer", js.Dynamic.literal(
      toolbox = js.Dynamic.literal(
        kind = "flyoutToolbox",
        contents = js.Array(
          js.Dynamic.literal(kind = "block", `type` = "test")
        )
      )
    )))
    val gen = new Blockly.Generator("Json")
    gen.update(
      "test",
      block => {
        val arg0 = block.getFieldValue("ARG0")
        //        val arg0 = gen.valueToCode(block, "ARG0", 0.0)
        val code =
          s"""{
             |  "arg0" : $arg0
             |}""".stripMargin
        code
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
        println(code)
      }
    }
  }
}