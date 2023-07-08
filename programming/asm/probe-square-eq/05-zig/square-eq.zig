const std = @import("std");

fn discr(a:f64,b:f64,c:f64) {
    return b*b - 4*a*c;
}

fn solve() {
    val d = discr(a,b,c);
    if (d >= 0.0) {
       val x1 = (-b - sqrt(d)) / (2 * a);
       val x2 = (-b + sqrt(d)) / (2 * a);
    } else {
       std.debug.print("Complex roots!\n");
    }
}

pub fn main() void {
    x1,x2 = solve(a, b, c)
    std.debug.print("Hello, {s}!\n", .{"World"});
}
