use std::fs::File;
use std::io::{self, BufRead};
use std::path::Path;
use std::collections::BTreeSet;
// use std::collections::HashSet;



fn read_lines<P>(filename: P) -> io::Result<io::Lines<io::BufReader<File>>>
where P: AsRef<Path>, {
    let file = File::open(filename)?;
    Ok(io::BufReader::new(file).lines())
}


// enum Result<T, E> {
//   Ok(T),
//   Err(E),
// }
//


fn main() {
    if let Ok(lines) = read_lines("/bigdata/billion/40m.csv") {
        let mut words: BTreeSet<& str> = BTreeSet::new();
        for line_result in lines {
            if let Ok(line) = line_result {
                let res = words.insert(&line);
                                   //  ^^^^^ borrowed value does not live long enough
            }
            // - `line` dropped here while still borrowed
        }
        words.clear();
    }
    println!("Hello, world!");
}
