FROM prom/prometheus

ARG TK_TARGET_PROMETHEUS=host.docker.internal:8081

RUN echo TK_TARGET_PROMETHEUS

RUN echo ${TK_TARGET_PROMETHEUS}

ADD prometheus.yml /
