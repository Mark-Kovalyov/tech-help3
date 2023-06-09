// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto3/member.proto

package ru.sql;

public interface MemberOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ru.sql.Member)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 mid = 1;</code>
   */
  int getMid();

  /**
   * <pre>
   * // Имя
   * </pre>
   *
   * <code>string name = 2;</code>
   */
  java.lang.String getName();
  /**
   * <pre>
   * // Имя
   * </pre>
   *
   * <code>string name = 2;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>.ru.sql.Member.Status status = 3;</code>
   */
  int getStatusValue();
  /**
   * <code>.ru.sql.Member.Status status = 3;</code>
   */
  ru.sql.Member.Status getStatus();

  /**
   * <pre>
   * E-Mail:
   * </pre>
   *
   * <code>string email = 4;</code>
   */
  java.lang.String getEmail();
  /**
   * <pre>
   * E-Mail:
   * </pre>
   *
   * <code>string email = 4;</code>
   */
  com.google.protobuf.ByteString
      getEmailBytes();

  /**
   * <code>string url = 5;</code>
   */
  java.lang.String getUrl();
  /**
   * <code>string url = 5;</code>
   */
  com.google.protobuf.ByteString
      getUrlBytes();

  /**
   * <code>string icq = 6 [deprecated = true];</code>
   */
  @java.lang.Deprecated java.lang.String getIcq();
  /**
   * <code>string icq = 6 [deprecated = true];</code>
   */
  @java.lang.Deprecated com.google.protobuf.ByteString
      getIcqBytes();

  /**
   * <pre>
   * Откуда:
   * </pre>
   *
   * <code>string from_where = 7;</code>
   */
  java.lang.String getFromWhere();
  /**
   * <pre>
   * Откуда:
   * </pre>
   *
   * <code>string from_where = 7;</code>
   */
  com.google.protobuf.ByteString
      getFromWhereBytes();

  /**
   * <pre>
   * Интересы:
   * </pre>
   *
   * <code>string interests = 8;</code>
   */
  java.lang.String getInterests();
  /**
   * <pre>
   * Интересы:
   * </pre>
   *
   * <code>string interests = 8;</code>
   */
  com.google.protobuf.ByteString
      getInterestsBytes();

  /**
   * <pre>
   * Работа:
   * </pre>
   *
   * <code>string job = 9;</code>
   */
  java.lang.String getJob();
  /**
   * <pre>
   * Работа:
   * </pre>
   *
   * <code>string job = 9;</code>
   */
  com.google.protobuf.ByteString
      getJobBytes();

  /**
   * <pre>
   * Информация:
   * </pre>
   *
   * <code>string info = 10;</code>
   */
  java.lang.String getInfo();
  /**
   * <pre>
   * Информация:
   * </pre>
   *
   * <code>string info = 10;</code>
   */
  com.google.protobuf.ByteString
      getInfoBytes();

  /**
   * <pre>
   * Сообщений:
   * </pre>
   *
   * <code>int32 messages = 11;</code>
   */
  int getMessages();

  /**
   * <pre>
   * Зарегистрирован:  (date)
   * </pre>
   *
   * <code>string registered = 12;</code>
   */
  java.lang.String getRegistered();
  /**
   * <pre>
   * Зарегистрирован:  (date)
   * </pre>
   *
   * <code>string registered = 12;</code>
   */
  com.google.protobuf.ByteString
      getRegisteredBytes();

  /**
   * <pre>
   * Последнее сообщение:  (date)
   * </pre>
   *
   * <code>string last_message = 13;</code>
   */
  java.lang.String getLastMessage();
  /**
   * <pre>
   * Последнее сообщение:  (date)
   * </pre>
   *
   * <code>string last_message = 13;</code>
   */
  com.google.protobuf.ByteString
      getLastMessageBytes();

  /**
   * <pre>
   * Сообщений в день: ex: 0,021
   * </pre>
   *
   * <code>float messages_per_day = 14;</code>
   */
  float getMessagesPerDay();
}
