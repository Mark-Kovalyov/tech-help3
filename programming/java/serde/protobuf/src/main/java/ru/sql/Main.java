package ru.sql;

import org.apache.commons.codec.binary.Hex;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Member member = Member.newBuilder()
                .setMid(1)
                .setName("jugde")
                .setStatus(Member.Status.ADMIN)
                .setMessages(100)
                .setRegistered("1972-01-01T10:00:20.021Z")
                .setMessagesPerDay(0.5f)
                .build();

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        member.writeTo(os);
        os.flush();
        byte[] buf = os.toByteArray();
        System.out.println("Length(bytes) : " + buf.length);
        System.out.println("Dump : " + Hex.encodeHexString(buf));

    }

}
