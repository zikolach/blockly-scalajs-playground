import scala.scalajs.js
import scala.scalajs.js.annotation.{JSBracketAccess, JSImport, JSName}
import scala.scalajs.js.|


@JSImport("blockly", JSImport.Default)
@js.native
object Blockly extends js.Object {
  def inject(container: String, opt_options: js.Any): Workspace = js.native

  def defineBlocksWithJsonArray(params: js.Array[BlockObj]): Unit = js.native

  var Json: js.UndefOr[Generator] = js.native

  @js.native
  class Generator(val name: String) extends js.Object {
    def workspaceToCode(workspace: js.UndefOr[Workspace] = js.undefined): String = js.native

    def statementToCode(block: Block, name: String): String = js.native

    def valueToCode(block: Block, name: String, order: Double): String = js.native

    def blockToCode(block: Block): String | js.Array[js.Any] = js.native

    @JSBracketAccess
    def apply(index: Int): js.Function1[Block, js.Array[js.Any]] = js.native

    @JSBracketAccess
    def update(index: String, v: js.Function1[Block, js.Any]): Unit = js.native
  }

  @js.native
  class Workspace extends js.Object {
    def getTopBlocks(ordered: js.UndefOr[Boolean] = js.undefined): js.Array[Block] = js.native

    def addTopBlock(block: Block): Unit = js.native

    def newBlock(prototypeName: String, opt_id: js.UndefOr[String] = js.undefined): Block = js.native

    def remainingCapacity(): Long = js.native

    /**
     * Highlight or unhighlight a block in the workspace. Block highlighting is often used to visually mark blocks currently being executed.
     *
     * @param id        ID of block to highlight/unhighlight, or null for no block (used to unhighlight all blocks). Value may be null.
     * @param opt_state If undefined, highlight specified block and automatically unhighlight all others. If true or false, manually highlight/unhighlight the specified block.
     */
    def highlightBlock(id: String, opt_state: js.UndefOr[Boolean] = js.undefined): Unit = js.native

    def updateScreenCalculationsIfScrolled(): Unit = js.native

    def cleanUp(): Unit = js.native
  }

  @js.native
  trait Connection extends js.Object {
    def targetBlock(): js.UndefOr[Block] = js.native

    def isConnected(): Boolean = js.native

    @JSName("sourceBlock_")
    val `sourceBlock_`: Block = js.native

    /**
     * Connect this connection to another connection.
     *
     * @param otherConnection Connection to connect to.
     */
    def connect(otherConnection: Connection): Unit = js.native

    def targetConnection: js.UndefOr[Connection] = js.native

    def getCheck(): js.Array[String] = js.native
  }

  @js.native
  trait Input extends js.Object {

    @JSName("type")
    val `type`: Double = js.native
    val name: js.UndefOr[String] = js.native

    @JSName("sourceBlock_")
    val `sourceBlock_`: Block = js.native
    var connection: js.UndefOr[Connection] = js.native
    var fieldRow: js.Array[js.Any] = js.native

    /**
     * Change a connection's compatibility.
     *
     * @param check Compatible value type or list of value types.  Null if all types are compatible.
     * @return [Input] The input being modified (to allow chaining).
     */
    def setCheck(check: String | js.Array[String]): Input = js.native
  }

  @js.native
  class Block(
               val workspace: Workspace = js.native,
               val prototypeName: String = js.native,
               val opt_id: js.UndefOr[String] = js.native,
               var inputCounter: Int = js.native,
               val onPendingConnection: js.UndefOr[js.ThisFunction1[Block, Connection, Unit]] = js.native,
               val finalizeConnections: js.UndefOr[js.ThisFunction0[Block, Unit]] = js.native
             ) extends js.Object {
    var inputList: js.Array[Input] = js.native

    /**
     * Returns the language-neutral value of the given field.
     *
     * @param name The name of the field.
     * @return Value of the field or null if field does not exist.
     */
    def getFieldValue(name: String): js.Any = js.native

    def setColour(color: String): js.Any = js.native

    /**
     * Sets the value of the given field for this block.
     *
     * @param newValue The value to set.
     * @param name     The name of the field to set the value of.
     */
    def setFieldValue(newValue: js.Any, name: String): Unit = js.native

    def setOnChange(func: js.Function1[js.Any, Unit]): Unit = js.native

    def getInput(name: String): js.UndefOr[Input] = js.native

    def removeInput(name: String, opt_quiet: js.UndefOr[Boolean] = js.undefined): Boolean = js.native

    def previousConnection: js.UndefOr[Connection] = js.native

    def nextConnection: js.UndefOr[Connection] = js.native

    def outputConnection: js.UndefOr[Connection] = js.native

    def getNextBlock(): js.UndefOr[Block] = js.native

    def initSvg(): Unit = js.native

    def select(): Unit = js.native

    def render(): Unit = js.native

    def appendValueInput(name: String): Input = js.native

    def moveNumberedInputBefore(inputIndex: Int, refIndex: Int): Unit = js.native

    def isInsertionMarker(): Boolean = js.native
  }

}

@js.native
trait ArgObj extends js.Object {
  @JSName("type") val `type`: String
  val name: js.UndefOr[String] = js.undefined
  val check: js.UndefOr[String] = js.undefined
  val align: js.UndefOr[String] = js.undefined
  val options: js.UndefOr[js.Array[js.Array[String]]] = js.undefined
}

object ArgObj {
  def apply(
             `type`: String,
             name: js.UndefOr[String] = js.undefined,
             check: js.UndefOr[String] = js.undefined,
             align: js.UndefOr[String] = js.undefined,
             options: js.UndefOr[js.Array[js.Array[String]]] = js.undefined
           ): ArgObj = js.Dynamic.literal(
    `type` = `type`,
    name = name,
    check = check,
    align = align,
    options = options
  ).asInstanceOf[ArgObj]

  object Type {
    val field_input = "field_input"
    val field_dropdown = "field_dropdown"
    val field_checkbox = "field_checkbox"
    val field_colour = "field_colour"
    val field_number = "field_number"
    val field_angle = "field_angle"
    val field_variable = "field_variable"
    val field_date = "field_date"
    val field_label = "field_label"
    val field_image = "field_image"
    val input_value = "input_value"
    val input_statement = "input_statement"
    val input_dummy = "input_dummy"
  }
}

@js.native
trait BlockObj extends js.Object {
  @JSName("type") val `type`: String = js.native
  val message0: js.UndefOr[String] = js.native
  val args0: js.UndefOr[js.Array[ArgObj]] = js.native
  val message1: js.UndefOr[String] = js.native
  val args1: js.UndefOr[js.Array[ArgObj]] = js.native
  val message2: js.UndefOr[String] = js.native
  val args2: js.UndefOr[js.Array[ArgObj]] = js.native
  val previousStatement: js.UndefOr[String] = js.native
  val nextStatement: js.UndefOr[String] = js.native
  val output: js.UndefOr[String] = js.native
  val colour: js.UndefOr[String] = js.native
  val helpUrl: js.UndefOr[String] = js.native
  val style: js.UndefOr[String] = js.native
  val inputsInline: js.UndefOr[Boolean] = js.native
  val tooltip: String = js.native
  val extensions: js.UndefOr[js.Array[String]] = js.native
  val mutator: js.UndefOr[String] = js.undefined
}

object BlockObj {

  def apply(
             `type`: String,
             message0: js.UndefOr[String] = js.undefined,
             args0: js.UndefOr[js.Array[ArgObj]] = js.undefined,
             message1: js.UndefOr[String] = js.undefined,
             args1: js.UndefOr[js.Array[ArgObj]] = js.undefined,
             message2: js.UndefOr[String] = js.undefined,
             args2: js.UndefOr[js.Array[ArgObj]] = js.undefined,
             previousStatement: js.UndefOr[String] = js.undefined,
             nextStatement: js.UndefOr[String] = js.undefined,
             output: js.UndefOr[String] = js.undefined,
             colour: js.UndefOr[String] = js.undefined,
             helpUrl: js.UndefOr[String] = js.undefined,
             style: js.UndefOr[String] = js.undefined,
             inputsInline: js.UndefOr[Boolean] = js.undefined,
             tooltip: String = "",
             extensions: js.UndefOr[js.Array[String]] = js.undefined,
             mutator: js.UndefOr[String] = js.undefined
           ): BlockObj =
    js.Dynamic
      .literal(
        `type` = `type`,
        message0 = message0,
        args0 = args0,
        message1 = message1,
        args1 = args1,
        message2 = message2,
        args2 = args2,
        previousStatement = previousStatement,
        nextStatement = nextStatement,
        output = output,
        colour = colour,
        helpUrl = helpUrl,
        style = style,
        inputsInline = inputsInline,
        tooltip = tooltip,
        extensions = extensions,
        mutator = mutator
      )
      .asInstanceOf[BlockObj]
}
