trait StringProcessor {
  def process(input: String): String
}

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

val s: String = "This is a Wonderful Test!"

shortener.process(tokenDeleter.process(toLowerConvertor.process(s)))
