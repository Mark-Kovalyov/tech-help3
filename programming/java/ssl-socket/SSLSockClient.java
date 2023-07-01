

String host  = "google.com";
Integer port = 80;

SSLSocketFactory sslsocketfactory = SSLSocketFactory.getDefault();
SSLSocket sslsocket               = (SSLSocket) sslsocketfactory.createSocket(host, port);

InputStream in   = sslsocket.getInputStream();
OutputStream out = sslsocket.getOutputStream();

out.write("GET /");

while (in.available() > 0) {
    System.out.print(in.read());
}

sslsocket.close();
