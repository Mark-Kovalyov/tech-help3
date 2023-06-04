class BTree(val v : Int,
            var left : Option[BTree],
            var right : Option[BTree])

val root = BTree(1,None,None)

root.left = Some(new BTree(2,None,None))
