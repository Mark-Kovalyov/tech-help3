const std = @import("std");

const MAX_UDP_PACKET_SIZE = 65507;

pub fn main() !void {
    //////////////////// Command line
    var gpa = std.heap.GeneralPurposeAllocator(.{}){};
    defer _ = gpa.deinit();
    const allocator = gpa.allocator();

    const args = try std.process.argsAlloc(allocator);
    defer std.process.argsFree(allocator, args);

    std.debug.print("Arguments: {s}\n", .{args});

    /////////////// STOUT / STDERR
    const stdout = std.io.getStdOut().writer();
    const stderr = std.io.getStdErr().writer();
    if (argc == 1) {
      stderr.print("Usage :\n    listen-udp [udp-port]");
      return 1;
    }

    /////////// UDP
    const address = std.net.Address.initIp4([4]u8{ 127, 0, 0, 1 }, 8080);
    var server = std.net.StreamServer.init(.{ .reuse_address = true });
    try server.listen(address);

    while(true) {

    }
    stdout.print("OK");
}
