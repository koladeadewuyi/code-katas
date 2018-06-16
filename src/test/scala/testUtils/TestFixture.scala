package testUtils

import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{FunSpec, Matchers}

trait TestFixture extends FunSpec with Matchers with TableDrivenPropertyChecks
