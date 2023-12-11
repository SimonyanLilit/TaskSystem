FROM postgres:13
ARG PLATFORM_BUILD_TAG=latest
COPY ./init.sql /docker-entrypoint-initdb.d

# Perform healthchecks every 10s, allowing 3s for each to timeout.  Retry for up to 5 minutes
HEALTHCHECK --interval=10s --timeout=3s --start-period=10s --retries=30 CMD pg_isready -U postgres -d platform_system || exit 1
