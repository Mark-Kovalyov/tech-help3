import socket

# Create a UDP socket
udp_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

# Enable SO_REUSEPORT option
udp_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEPORT, 1)

# Bind the socket to a specific port
udp_socket.bind(('0.0.0.0', 12345))

# Receive and process incoming packets
while True:
    data, addr = udp_socket.recvfrom(1024)
    # Process the received data
