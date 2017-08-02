package org.change.v2.runners.experiments

import java.io.{FileOutputStream, PrintStream, File}

import org.change.v2.analysis.expression.concrete.nonprimitive._
import org.change.v2.analysis.expression.concrete.{ConstantValue, SymbolicValue, ConstantBitVector, SymbolicBitVector}
import org.change.v2.analysis.memory.State
import org.change.v2.analysis.processingmodels.instructions._
import org.change.v2.executor.clickabstractnetwork.ClickExecutionContext
import org.change.v2.analysis.memory.TagExp._
import org.change.v2.analysis.memory.Tag
import org.change.v2.util.conversion.RepresentationConversion._

object SEFLRunner {

  lazy val output = new PrintStream(new FileOutputStream(new File("sefl.output")))

  def main (args: Array[String]){

    val (successful, failed) = p4model

    output.println(
      successful.map(_.jsonString).mkString("Successful: {\n", "\n", "}\n") +
      failed.map(_.jsonString).mkString("Failed: {\n", "\n", "}\n")
    )

    output.close()
    
    println("Check output @ sefl.output")
  }

  def p4model: (List[State], List[State]) = {

    main(State.clean, true)
  }
}


