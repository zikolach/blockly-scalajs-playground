package facade

import org.scalajs.dom.raw.Element

import scala.collection.mutable
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSBracketAccess, JSImport, JSName}
import scala.scalajs.js.{ThisFunction0, |}


//noinspection ScalaUnusedSymbol
object BlocklyFacade {

  @JSImport("blockly", JSImport.Default)
  @js.native
  object Blockly extends js.Object {
    def inject(container: String, opt_options: InjectOptions): Workspace = js.native

    def defineBlocksWithJsonArray(params: js.Array[BlocklyFacade.Block]): Unit = js.native

    var Json: js.UndefOr[Generator] = js.native
    var Blocks: Blocks = js.native

    @js.native
    trait Blocks extends js.Object {

      @JSBracketAccess
      def apply(index: Int): js.UndefOr[js.Object] = js.native

      @JSBracketAccess
      def update(index: String, block: js.UndefOr[js.Object]): Unit = js.native
    }

    @js.native
    object utils extends js.Object {

      @js.native
      object xml extends js.Object {

        def createElement(tagName: String): Element = js.native
      }
    }

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
    class Connection extends js.Object {
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
    class Warning extends js.Object {
      def getText(): String = js.native
    }

    @js.native
    object Events extends js.Object {
      def disable(): Unit = js.native

      def enable(): Unit = js.native

      /**
       * Name of event that creates a block. Will be deprecated for BLOCK_CREATE.
       */
      val CREATE: String = js.native

      /**
       * Name of event that creates a block.
       */
      val BLOCK_CREATE: String = js.native

      /**
       * Name of event that deletes a block. Will be deprecated for BLOCK_DELETE.
       */
      val DELETE: String = js.native

      /**
       * Name of event that deletes a block.
       */
      val BLOCK_DELETE: String = js.native

      /**
       * Name of event that changes a block. Will be deprecated for BLOCK_CHANGE.
       */
      val CHANGE: String = js.native

      /**
       * Name of event that changes a block.
       */
      val BLOCK_CHANGE: String = js.native

      /**
       * Name of event that moves a block. Will be deprecated for BLOCK_MOVE.
       */
      val MOVE: String = js.native

      /**
       * Name of event that moves a block.
       */
      val BLOCK_MOVE: String = js.native

      /**
       * Name of event that creates a variable.
       */
      val VAR_CREATE: String = js.native

      /**
       * Name of event that deletes a variable.
       */
      val VAR_DELETE: String = js.native

      /**
       * Name of event that renames a variable.
       */
      val VAR_RENAME: String = js.native

      /**
       * Name of generic event that records a UI change.
       */
      val UI: String = js.native

      /**
       * Name of event that record a block drags a block.
       */
      val BLOCK_DRAG: String = js.native

      /**
       * Name of event that records a change in selected element.
       */
      val SELECTED: String = js.native

      /**
       * Name of event that records a click.
       */
      val CLICK: String = js.native

      /**
       * Name of event that records a marker move.
       */
      val MARKER_MOVE: String = js.native

      /**
       * Name of event that records a bubble open.
       */
      val BUBBLE_OPEN: String = js.native

      /**
       * Name of event that records a trashcan open.
       */
      val TRASHCAN_OPEN: String = js.native

      /**
       * Name of event that records a toolbox item select.
       */
      val TOOLBOX_ITEM_SELECT: String = js.native

      /**
       * Name of event that records a theme change.
       */
      val THEME_CHANGE: String = js.native

      /**
       * Name of event that records a viewport change.
       */
      val VIEWPORT_CHANGE: String = js.native

      /**
       * Name of event that creates a comment.
       */
      val COMMENT_CREATE: String = js.native

      /**
       * Name of event that deletes a comment.
       */
      val COMMENT_DELETE: String = js.native

      /**
       * Name of event that changes a comment.
       */
      val COMMENT_CHANGE: String = js.native

      /**
       * Name of event that moves a comment.
       */
      val COMMENT_MOVE: String = js.native

      /**
       * Name of event that records a workspace load.
       */
      val FINISHED_LOADING: String = js.native
    }

    @js.native
    trait AbstractEvent extends js.Object {

      @JSName("type")
      val `type`: String = js.native
      // specific to all block event types
      val blockId: js.UndefOr[String] = js.native
      val workspaceId: js.UndefOr[String] = js.native
      // specific to block change event type
      val element: js.UndefOr[String] = js.native // One of 'field', 'comment', 'disabled', etc.
      val name: js.UndefOr[String] = js.native // Name of input or field affected, or null.
      val oldValue: js.UndefOr[String] = js.native // Previous value of element.
      val newValue: js.UndefOr[String] = js.native // New value of element.
      // specific to block delete event type
      val ids: js.UndefOr[js.Array[String]] = js.native
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
      val id: String = js.native

      @JSName("type")
      val `type`: String = js.native
      var inputList: js.Array[Input] = js.native
      var contextMenu: Boolean = js.native

      var warning: Blockly.Warning = js.native

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

      def setOnChange(func: js.Function1[Blockly.AbstractEvent, Unit]): Unit = js.native

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

      def setCommentText(text: String): Unit = js.native

      def getCommentText(): String = js.native

      def setWarningText(text: String, opt_id: js.UndefOr[String] = js.undefined): Unit = js.native

      def toDevString(): String = js.native

      /**
       * Set whether the block is collapsed or not.
       *
       * @param collapsed True if collapsed.
       */
      def setCollapsed(collapsed: Boolean): Unit = js.native

      /**
       * Get whether the block is collapsed or not.
       *
       * @return True if collapsed.
       */
      def isCollapsed(): Boolean = js.native

      /**
       * Set whether the block is highlighted or not.  Block highlighting is
       * often used to visually mark blocks currently being executed.
       *
       * @param highlighted True if highlighted.
       */
      def setHighlighted(highlighted: Boolean): Unit = js.native

      /**
       * Return the top-most block in this block's tree.
       * This will return itself if this block is at the top level.
       *
       * @return The root block.
       */
      def getRootBlock(): Block = js.native

      /**
       * Move a block by a relative offset.
       *
       * @param dx Horizontal offset in workspace units.
       * @param dy Vertical offset in workspace units.
       */
      def moveBy(dx: Double, dy: Double): Unit = js.native
    }

    @js.native
    class Workspace extends js.Object {

      /**
       * When something in this workspace changes, call a function.
       * Note that there may be a few recent events already on the stack.  Thus the
       * new change listener might be called with events that occurred a few
       * milliseconds before the change listener was added.
       *
       * @param func Function to call.
       */
      def addChangeListener(func: js.Function1[AbstractEvent, Unit]): Unit = js.native

      /**
       * Stop listening for this workspace's changes.
       *
       * @param func Function to stop calling.
       */
      def removeChangeListener(func: js.Function1[AbstractEvent, Unit]): Unit = js.native

      /**
       * Finds the top-level blocks and returns them.  Blocks are optionally sorted by position; top to bottom (with slight LTR or RTL bias).
       *
       * @param ordered Sort the list if true.
       * @return The top-level block objects.
       */
      def getTopBlocks(ordered: js.UndefOr[Boolean] = js.undefined): js.Array[Block] = js.native

      /**
       * Find all blocks in workspace.  Blocks are optionally sorted
       * by position; top to bottom (with slight LTR or RTL bias).
       *
       * @param ordered Sort the list if true.
       * @return Array of blocks.
       */
      def getAllBlocks(ordered: js.UndefOr[Boolean] = js.undefined): js.Array[Block] = js.native

      /**
       * Find the block on this workspace with the specified ID.
       *
       * @param id ID of block to find.
       * @return The sought after block, or null if not found.
       */
      def getBlockById(id: String): Block = js.native

      /**
       * Adds a block to the list of top blocks.
       *
       * @param block Block to add.
       */
      def addTopBlock(block: Block): Unit = js.native

      /**
       * Obtain a newly created block.
       *
       * @param prototypeName Name of the language object containing type-specific functions for this block.
       * @param opt_id        Optional ID.  Use this ID if provided, otherwise create a new ID.
       * @return The created block.
       */
      def newBlock(prototypeName: String, opt_id: js.UndefOr[String] = js.undefined): Block = js.native

      /**
       * Scroll the workspace to center on the given block.
       *
       * @param id ID of block center on.
       */
      def centerOnBlock(id: String): Unit = js.native

      /**
       * The number of blocks that may be added to the workspace before reaching the maxBlocks.
       *
       * @return Number of blocks left.
       */
      def remainingCapacity(): Long = js.native

      /**
       * Highlight or unhighlight a block in the workspace. Block highlighting is often used to visually mark blocks currently being executed.
       *
       * @param id        ID of block to highlight/unhighlight, or null for no block (used to unhighlight all blocks). Value may be null.
       * @param opt_state If undefined, highlight specified block and automatically unhighlight all others. If true or false, manually highlight/unhighlight the specified block.
       */
      def highlightBlock(id: String, opt_state: js.UndefOr[Boolean] = js.undefined): Unit = js.native

      /**
       * Resizes and repositions workspace chrome if the page has a new scroll position.
       */
      def updateScreenCalculationsIfScrolled(): Unit = js.native

      /**
       * Clean up the workspace by ordering all the blocks in a column.
       */
      def cleanUp(): Unit = js.native

      /**
       * Dispose of this workspace.
       * Unlink from all DOM elements to prevent memory leaks.
       */
      def dispose(): Unit = js.native

      /**
       * Delete a block off this workspace with the specified ID.
       *
       * @param id ID of block to delete.
       */
      def removeBlockById(id: String): Unit = js.native

      /**
       * Dispose of all blocks and comments in workspace.
       */
      def clear(): Unit = js.native

      var scrollX: Double = js.native
      var scrollY: Double = js.native
    }

    @js.native
    object Extensions extends js.Object {

      /**
       * Registers a new extension function. Extensions are functions that help
       * initialize blocks, usually adding dynamic behavior such as onchange
       * handlers and mutators. These are applied using Block.applyExtension(), or
       * the JSON "extensions" array attribute.
       *
       * @param name   The name of this extension.
       * @param initFn The function to initialize an extended block.
       */
      def register(name: String, initFn: ThisFunction0[Block, Unit]): Unit = js.native

      /**
       * Unregisters the extension registered with the given name.
       *
       * @param name The name of the extension to unregister.
       */
      def unregister(name: String): Unit = js.native

      /**
       * Registers a new extension function that adds a mutator to the block.
       * At register time this performs some basic sanity checks on the mutator.
       * The wrapper may also add a mutator dialog to the block, if both compose and
       * decompose are defined on the mixin.
       *
       * @param name          The name of this mutator extension.
       * @param mixinObj      The values to mix in.
       * @param opt_helperFn  An optional function to apply after mixing in the object.
       * @param opt_blockList A list of blocks to appear in the flyout of the mutator dialog.
       */
      def registerMutator(name: String, mixinObj: js.Object, opt_helperFn: js.UndefOr[ThisFunction0[Block, Unit]] = js.undefined, opt_blockList: js.UndefOr[js.Array[String]] = js.undefined): Unit = js.native
    }

    @js.native
    class Comment(val block: Block) extends js.Object {
      def setVisible(visible: Boolean): Unit = js.native

      def dispose(): Unit = js.native
    }

    @js.native
    object ContextMenuItems extends js.Object {
      def registerHelp(): Unit = js.native
    }

    @js.native
    object ContextMenuRegistry extends js.Object {

      @js.native
      object registry extends js.Object {
        def register(item: js.Any): Unit = js.native

        def unregister(id: String): Unit = js.native
      }
    }

    @js.native
    class InsertionMarkerManager extends js.Object {

      @js.native
      trait Candidate extends js.Object {
        val closest: js.UndefOr[Connection] = js.native
        val local: js.Any = js.native
        val radius: js.Any = js.native
      }

      @JSName("wouldDeleteBlock_")
      var `wouldDeleteBlock_`: Boolean = js.native

      def getCandidate_(dxy: js.Any): Candidate = js.native

      def shouldDelete_(candidate: Candidate, deleteArea: js.Any): Boolean = js.native

      def shouldUpdatePreviews_(candidate: Candidate, dxy: js.Any): Boolean = js.native

      def maybeHidePreview_(candidate: Candidate): Boolean = js.native

      def maybeShowPreview_(candidate: Candidate): Boolean = js.native

      // see details in PendingConnectionsPlugin$
      var pendingBlocks: js.UndefOr[mutable.Set[Block]] = js.native
    }

    @js.native
    object InsertionMarkerManager extends InsertionMarkerManager

    trait BlockStyle extends js.Object {
      val colourPrimary: String
      val colourSecondary: String
      val colourTertiary: String
      val hat: String
    }

    trait CategoryStyle extends js.Object {
      val colour: String
    }

    trait ComponentStyle extends js.Object {
      val workspaceBackgroundColour: String
      val toolboxBackgroundColour: String
      val toolboxForegroundColour: String
      val flyoutBackgroundColour: String
      val flyoutForegroundColour: String
      val flyoutOpacity: Double
      val scrollbarColour: String
      val scrollbarOpacity: Double
      val insertionMarkerColour: String
      val insertionMarkerOpacity: Double
      val markerColour: String
      val cursorColour: String
      val selectedGlowColour: String
      val selectedGlowOpacity: Double
      val replacementGlowColour: String
      val replacementGlowOpacity: Double
    }

    trait FontStyle extends js.Object {
      val family: String
      val weight: String
      val size: Double
    }

    @js.native
    class Theme(
                 name: String,
                 opt_blockStyles: Map[String, BlockStyle],
                 opt_categoryStyles: Map[String, CategoryStyle],
                 opt_componentStyles: ComponentStyle
               ) extends js.Object {
      def fontStyle: FontStyle = js.native

      val startHats: Boolean = js.native
    }

    @js.native
    object Theme extends js.Object {
      def defineTheme(themeName: String, options: js.Object): Theme = js.native
    }

  }

  trait MoveOptions extends js.Object {
    val scrollbars: js.UndefOr[Boolean] = js.undefined
    val drag: js.UndefOr[Boolean] = js.undefined
    val wheel: js.UndefOr[Boolean] = js.undefined
  }

  object MoveOptions {

    def apply(
               scrollbars: js.UndefOr[Boolean] = js.undefined,
               drag: js.UndefOr[Boolean] = js.undefined,
               wheel: js.UndefOr[Boolean] = js.undefined
             ): MoveOptions = js.Dynamic.literal(scrollbars = scrollbars, drag = drag, wheel = wheel).asInstanceOf[MoveOptions]
  }

  @js.native
  trait InjectOptions extends js.Object {
    val toolbox: js.UndefOr[Toolbox] = js.native
    val readOnly: js.UndefOr[Boolean] = js.native
    val trashcan: js.UndefOr[Boolean] = js.native
    val maxInstances: js.UndefOr[js.Map[String, Int]] = js.native
    val maxTrashcanContents: js.UndefOr[Int] = js.native
    val collapse: js.UndefOr[Boolean] = js.native
    val comments: js.UndefOr[Boolean] = js.native
    val disable: js.UndefOr[Boolean] = js.native
    val sounds: js.UndefOr[Boolean] = js.native
    // ...
    val move: js.UndefOr[MoveOptions] = js.native
    //    val theme: js.UndefOr[Blockly.Theme] = js.undefined,
  }

  object InjectOptions {

    def apply(
               toolbox: js.UndefOr[Toolbox] = js.undefined,
               readOnly: js.UndefOr[Boolean] = js.undefined,
               trashcan: js.UndefOr[Boolean] = js.undefined,
               maxInstances: js.UndefOr[js.Map[String, Int]] = js.undefined,
               maxTrashcanContents: js.UndefOr[Int] = js.undefined,
               collapse: js.UndefOr[Boolean] = js.undefined,
               comments: js.UndefOr[Boolean] = js.undefined,
               disable: js.UndefOr[Boolean] = js.undefined,
               sounds: js.UndefOr[Boolean] = js.undefined,
               move: js.UndefOr[MoveOptions] = js.undefined
             ): InjectOptions =
      js.Dynamic
        .literal(
          toolbox = toolbox,
          readOnly = readOnly,
          trashcan = trashcan,
          maxInstances = maxInstances,
          maxTrashcanContents = maxTrashcanContents,
          collapse = collapse,
          comments = comments,
          disable = disable,
          sounds = sounds,
          move = move
        )
        .asInstanceOf[InjectOptions]
  }

  trait Toolbox extends js.Object {
    val kind: Toolbox.Kind
    val contents: js.Array[Toolbox.ToolboxItem]
  }

  object Toolbox {

    def apply(
               kind: Toolbox.Kind,
               contents: js.Array[Toolbox.ToolboxItem]
             ): Toolbox = {
      println(s"====   ${kind.getClass.getSimpleName.stripSuffix("$")}")
      js.Dynamic.literal(kind = kind.!, contents = contents).asInstanceOf[Toolbox]
    }

    //noinspection TypeAnnotation
    sealed trait Kind extends Enum

    object Kind {
      object flyoutToolbox extends Kind

      object categoryToolbox extends Kind
    }

    trait ToolboxItem extends js.Any {
      def kind: String
    }

    class Block(@JSName("type") val `type`: String) extends js.Object with ToolboxItem {
      val kind: String = "block"
    }

    class Category(val name: String, val contents: js.Array[Block]) extends js.Object with ToolboxItem {
      val kind: String = "category"
    }
  }

  @js.native
  trait Block extends js.Object {
    @JSName("type") val `type`: String = js.native
    val message0: js.UndefOr[String] = js.native
    val args0: js.UndefOr[js.Array[Arg]] = js.native
    val message1: js.UndefOr[String] = js.native
    val args1: js.UndefOr[js.Array[Arg]] = js.native
    val message2: js.UndefOr[String] = js.native
    val args2: js.UndefOr[js.Array[Arg]] = js.native
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

  object Block {

    def apply(
               `type`: String,
               message0: js.UndefOr[String] = js.undefined,
               args0: js.UndefOr[js.Array[Arg]] = js.undefined,
               message1: js.UndefOr[String] = js.undefined,
               args1: js.UndefOr[js.Array[Arg]] = js.undefined,
               message2: js.UndefOr[String] = js.undefined,
               args2: js.UndefOr[js.Array[Arg]] = js.undefined,
               message3: js.UndefOr[String] = js.undefined,
               args3: js.UndefOr[js.Array[Arg]] = js.undefined,
               message4: js.UndefOr[String] = js.undefined,
               args4: js.UndefOr[js.Array[Arg]] = js.undefined,
               message5: js.UndefOr[String] = js.undefined,
               args5: js.UndefOr[js.Array[Arg]] = js.undefined,
               message6: js.UndefOr[String] = js.undefined,
               args6: js.UndefOr[js.Array[Arg]] = js.undefined,
               message7: js.UndefOr[String] = js.undefined,
               args7: js.UndefOr[js.Array[Arg]] = js.undefined,
               previousStatement: js.UndefOr[String] = js.undefined,
               nextStatement: js.UndefOr[String] = js.undefined,
               output: js.UndefOr[String] = js.undefined,
               colour: js.UndefOr[String] = js.undefined,
               helpUrl: js.UndefOr[String] = js.undefined,
               style: js.UndefOr[String] = js.undefined,
               inputsInline: js.UndefOr[Boolean] = js.undefined,
               tooltip: String = "",
               extensions: js.UndefOr[js.Array[String]] = js.undefined,
               mutator: js.UndefOr[String] = js.undefined,
               enableContextMenu: js.UndefOr[Boolean] = js.undefined // TODO: this option doesn't seem to make an effect on the block
             ): Block =
      js.Dynamic
        .literal(
          `type` = `type`,
          message0 = message0,
          args0 = args0,
          message1 = message1,
          args1 = args1,
          message2 = message2,
          args2 = args2,
          message3 = message3,
          args3 = args3,
          message4 = message4,
          args4 = args4,
          message5 = message5,
          args5 = args5,
          message6 = message6,
          args6 = args6,
          message7 = message7,
          args7 = args7,
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
        .asInstanceOf[Block]
  }

  @js.native
  trait Arg extends js.Object {
    @JSName("type") val `type`: Arg.Type
    val name: js.UndefOr[String] = js.undefined
    val check: js.UndefOr[String] = js.undefined
    val align: js.UndefOr[Arg.Align] = js.undefined
    val options: js.UndefOr[js.Array[js.Array[String]]] = js.undefined
  }

  object Arg {

    def apply(
               `type`: Arg.Type,
               name: js.UndefOr[String] = js.undefined,
               check: js.UndefOr[String] = js.undefined, // TODO: replace type with IdDef
               align: js.UndefOr[Arg.Align] = js.undefined,
               options: js.UndefOr[js.Array[js.Array[String]]] = js.undefined
             ): Arg =
      js.Dynamic
        .literal(
          `type` = `type`.!,
          name = name,
          check = check,
          align = align.map(_.!),
          options = options
        )
        .asInstanceOf[Arg]

    def fieldInput(name: String, check: blocks.Block.Check): Arg = apply(`type` = Type.field_input, name = name, check = check.toString) // TODO toString

    def fieldLabel(name: String, check: blocks.Block.Check = blocks.Block.Check.String): Arg = apply(`type` = Type.field_label, name = name, check = check.toString)

    //noinspection TypeAnnotation
    sealed trait Type extends Enum

    object Type {
      object field_input extends Type

      object field_dropdown extends Type

      object field_checkbox extends Type

      object field_colour extends Type

      object field_number extends Type

      object field_angle extends Type

      object field_variable extends Type

      object field_date extends Type

      object field_label extends Type

      object field_label_serializable extends Type

      object field_image extends Type

      object field_multilinetext extends Type

      object input_value extends Type

      object input_statement extends Type

      object input_dummy extends Type

    }

    //noinspection TypeAnnotation
    sealed trait Align extends Enum

    object Align extends {
      object LEFT extends Align

      object CENTRE extends Align

      object RIGHT extends Align
    }
  }

  // TODO: remove
  val connections = mutable.ArrayBuffer[(BlocklyFacade.Blockly.Connection, BlocklyFacade.Blockly.Connection)]()

  object Implicits {
    implicit class ConnectibleOption(parentOpt: Option[Blockly.Block]) {

      def connectTo(input: Option[String], child: Blockly.Block): Unit =
        for {
          parent <- parentOpt
          inputName <- input
          input <- parent.getInput(inputName)
          parentConn <- input.connection
          childConn <- child.outputConnection
        } connections.append(parentConn -> childConn)
    }

    implicit class Connectible(parent: Blockly.Block) {

      def connectTo(input: String, child: Blockly.Block): Unit =
        for {
          input <- parent.getInput(input)
          parentConn <- input.connection
          childConn <- child.outputConnection
        } connections.append(parentConn -> childConn)

      def connectNext(input: String, child: Blockly.Block): Unit =
        for {
          input <- parent.getInput(input)
          parentConn <- input.connection
          childConn <- child.previousConnection
        } connections.append(parentConn -> childConn)

      def connectSibling(child: Blockly.Block): Unit =
        for {
          parentConn <- parent.nextConnection
          childConn <- child.previousConnection
        } connections.append(parentConn -> childConn)
    }

    //    implicit val encoder: Encoder[js.Any] = (a: js.Any) =>
    //      (a: Any) match {
    //        case null                           => Json.Null
    //        case str: String                    => Json.fromString(str)
    //        case dbl: Double                    => Json.fromDouble(dbl).getOrElse(Json.Null)
    //        case other if other == js.undefined => Json.Null
    //        case _ =>
    //          println(s"Cannot encode [$a] to JSON")
    //          Json.fromString("???")
    //      }
  }

  trait Enum {
    def ! : String = getClass.getSimpleName.stripSuffix("$")
  }
}
