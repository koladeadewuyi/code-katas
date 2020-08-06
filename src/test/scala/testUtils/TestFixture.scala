package testUtils

import org.scalatest.funspec.AnyFunSpecLike
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks

trait TestFixture extends AnyFunSpecLike with Matchers with TableDrivenPropertyChecks
