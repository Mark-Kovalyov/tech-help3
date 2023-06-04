use std::cmp::Ordering;

impl Ord for Mmax {
    fn mmax(&self, other: &Self) -> Ordering {
        self.height.cmp(&other.height)
    }
}
