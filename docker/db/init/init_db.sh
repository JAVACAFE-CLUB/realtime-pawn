#!/bin/bash
set -e

echo "▶ 1. 스키마 생성"
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" -f /docker-entrypoint-initdb.d/seed/ddl.sql

echo "▶ 2. 초기 데이터 삽입"

echo "✅ 초기화 완료!"