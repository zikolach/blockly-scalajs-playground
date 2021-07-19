import blocks.{Block, ConstructableBlock, Statement}
import facade.BlocklyFacade.{Blockly, Toolbox}
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExportAll, JSExportTopLevel}
import facade.{BlocklyFacade => BF}

object App {

  object Test extends Block with Statement with ConstructableBlock[String] {
    override def id: String = "test"

    override def definition: BF.Block =
      BF.Block( //                                                                          <--- here we define custom blocks we can use in our workspace
        `type` = id, //                                                                     <--- starting from unique name
        message0 = "test %1", //                                                            <--- text shown on the block, must contain all the arguments as %1
        args0 = js.Array(
          BF.Arg(`type` = BF.Arg.Type.field_input, name = "ARG0", check = "number") //      <--- all block child connections are defined as arguments, fields or inputs (or dummy), see ArgObj.Type
        ),
        colour = "123", //                                                                  <--- block color, (0 - 360) - hue component of the color, or RGB color as HEX
      )

    override def generator(gen: Blockly.Generator): js.Function1[Blockly.Block, js.Any] = block => {
      val arg0 = (block.getFieldValue("ARG0"): Any) match { //                       <--- here we just get field value
        case str: String if str.nonEmpty => str //                                               might be combination of generator's statementToCode/valueToCode/blockToCode calls
        case _ => "null" //                                                                      note this trick with `: Any` to use pattern matching on js.Any type, same with pseudo-union types
      }
      s"""{"arg0" : $arg0}""".stripMargin //                                                <--- and combine it all together into the code string, depending on block output type might need to return a tuple of code and precedence (js.Array("code", 0.0))
    }

    override def construct(inputName: Option[String], parent: Option[Blockly.Block])(implicit workspace: Blockly.Workspace): PartialFunction[String, Seq[Blockly.Block]] = ???
  }

  var workspaceOpt: Option[BF.Blockly.Workspace] = None

  def main(args: Array[String]): Unit = {
    val blocks = js.Array(Test)
    BF.Blockly.defineBlocksWithJsonArray(blocks.map(_.definition))
    workspaceOpt = Some(BF.Blockly.inject("blocklyContainer", BF.InjectOptions(
      toolbox = BF.Toolbox(
        kind = BF.Toolbox.Kind.flyoutToolbox, //                                            <--- optionally define workspace toolbar, might include categories
        contents = js.Array(
          new Toolbox.Block(`type` = "test") //                                             <--- and blocks to be shown
        )
      ),
      trashcan = true
    )))
    val gen = new BF.Blockly.Generator("Json") //                                    <--- define a generator, name doesn't matter
    blocks.foreach(block => gen.update(block.id, block.generator(gen)))
    BF.Blockly.Json = gen
  }

}

@JSExportTopLevel("Foo")
@JSExportAll
object Foo {

  def onClick(): Unit = {
    BF.Blockly.Json.foreach { gen =>
      App.workspaceOpt.foreach { workspace =>
        val code = gen.workspaceToCode(workspace)
        dom.document.getElementById("code").innerText = code
      }
    }
  }
}