FROM prom/prometheus

ARG environment=acceptance



ADD ./prometheus/prometheus-${environment}.yml /etc/prometheus/prometheus.yml

RUN echo ========

RUN cat /etc/prometheus/prometheus.yml