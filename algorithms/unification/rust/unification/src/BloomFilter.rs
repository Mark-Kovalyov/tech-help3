pub trait BloomFilter {
    fn add(s : String) -> Boolean;
    fn check(&self) -> BloomResult;
    fn clean();
}

impl BloomFilterImpl for BloomFilter {

}

enum BloomResult {
    ProbableYes,
    No
}
