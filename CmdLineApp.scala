import org.kohsuke.args4j.{CmdLineParser, Option}
import org.kohsuke.args4j.spi.StringArrayOptionHandler

object CmdLineApp {

  def main(args: Array[String]): Unit = {
    val cmdArgs = new CmdArgs()
    val parser = new CmdLineParser(cmdArgs)
    println(s"Args: ${args.mkString("#")}")
    parser.parseArgument(args: _*)

    println(s"subGenreTypeValue: ${cmdArgs.subGenreTypeValue}")
    println(s"cinemaProviders: ${cmdArgs.cinemaProviders.mkString(", ")}")
    println(s"cassandraHosts: ${cmdArgs.cassandraHosts.mkString(", ")}")
    println(s"cassandraPort: ${cmdArgs.cassandraPort}")
  }

}

class CmdArgs {
  @Option(name = "--subGenreTypeValue", usage = "String value used in JSON to identify a sub-genre of an asset", required = true)
  var subGenreTypeValue: String = ""

  @Option(name = "--cinemaProviders", usage = "list of partial provider ids to identify the 'movies-skycinema' content segment",
    required = true, handler = classOf[StringArrayOptionHandler])
  var cinemaProviders: Array[String] = Array.empty

  @Option(name = "--cassandraHosts", usage = "A list of Cassandra data nodes", required = true, handler = classOf[StringArrayOptionHandler])
  var cassandraHosts: Array[String] = Array.empty

  @Option(name = "--cassandraPort", usage = "Port to communicate with Cassandra", required = false)
  var cassandraPort: Int = 9042
}
