package blocks

import facade.{BlocklyFacade => BF}

import scala.scalajs.js

trait Block {
  def id: String

  def definition: BF.Block

  def generator(gen: BF.Blockly.Generator): js.Function1[BF.Blockly.Block, js.Any]
}

object Block {

  //noinspection TypeAnnotation
  sealed trait Check extends BF.Enum

  object Check extends {
    object Number extends Check

    object Boolean extends Check

    object String extends Check

    object Array extends Check

    object Colour extends Check
  }
}

/**
 * Implement this trait for block with output
 */
trait Output {
  /**
   * Generate code string out of the block
   */
  def generator(gen: BF.Blockly.Generator): js.Function1[BF.Blockly.Block, js.Any]
}

/**
 * Implement this trait for block without output
 */
trait Statement {
  /**
   * Generate code string out of the block
   */
  def generator(gen: BF.Blockly.Generator): js.Function1[BF.Blockly.Block, js.Any]
}

trait ConstructableBlock[T] {
  /**
   * Method to construct block from given type
   */
  def construct(inputName: Option[String], parent: Option[BF.Blockly.Block])(implicit workspace: BF.Blockly.Workspace): PartialFunction[T, Seq[BF.Blockly.Block]]
}

