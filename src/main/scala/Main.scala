import scala.io.StdIn

object Main {
  trait StringProcessor {
    def process(input: String): String
  }

  def main(args: Array[String]) {
    val tokenDeleter = new StringProcessor {
      def process(input: String): String = {
        input.replace(",", "")
          .replace("!", "")
          .replace(".", "")
          .replace("?", "")
          .replace(";", "")
          .replace(":", "")
      }
    }

    val shortener = new StringProcessor {
      def process(input: String): String = input match {
        case input if input.length <= 20 => input
        case input => input.take(20) + "..."
      }
    }

    val toLowerConvertor = new StringProcessor {
      def process(input: String): String = {
        input.toLowerCase()
      }
    }

    println(shortener.process(tokenDeleter.process(toLowerConvertor.process(scala.io.StdIn.readLine()))))
  }}