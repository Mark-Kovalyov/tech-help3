def createPhoneNumber(numbers: Seq[Int]) = {
	"(%d%d%d) %d%d%d-%d%d%d%d".format(numbers:_*)
}
