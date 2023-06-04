FROM azul/zulu-openjdk-alpine:11.0.12

ARG HADOOP_VER=3.3.1

RUN apk upgrade --no-cache
RUN apk --update add --no-cache bash tini libstdc++ wget curl

RUN wget -O /hadoop-${HADOOP_VER}.tar.gz \
    https://archive

COPY entrypoint.sh /opt/

ENTRYPOINT [ "/opt/entrypoint.sh" ]
