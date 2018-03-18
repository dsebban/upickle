package upickle.internal

/**
  * A version of [[upickle.Js]] that keeps the index positions of the various AST
  * nodes it is constructing. Usually not necessary, but sometimes useful if you
  * want to work with an AST but still provide source-index error positions if
  * something goes wrong
  */
object IndexedJs {
  sealed trait Value{
    def index: Int
  }
  case class Str(index: Int, value0: java.lang.CharSequence) extends Value
  case class Obj(index: Int, value0: (java.lang.CharSequence, Value)*) extends Value
  case class Arr(index: Int, value: Value*) extends Value
  case class Num(index: Int, s: CharSequence, decIndex: Int, expIndex: Int) extends Value
  case class False(index: Int) extends Value{
    def value = false
  }
  case class True(index: Int) extends Value{
    def value = true
  }
  case class Null(index: Int) extends Value{
    def value = null
  }
}