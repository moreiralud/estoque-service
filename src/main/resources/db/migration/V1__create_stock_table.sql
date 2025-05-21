CREATE TABLE IF NOT EXISTS stock_items (
  id          BIGSERIAL PRIMARY KEY,
  product_id  BIGINT   NOT NULL UNIQUE,
  quantity    INTEGER  NOT NULL
);
