namespace java puma.thrift.pdp

/**
 * You can define enums, which are just 32 bit integers. Values are optional
 * and start at 1 if not supplied, C style again.
 */
enum DataTypeP {
  STRING = 0;
  INTEGER = 1;
  DATETIME = 2;
  BOOLEAN = 3;
}

enum ResponseTypeP {
  PERMIT = 0;
  DENY = 1;
  NOT_APPLICABLE = 2;
  INDETERMINATE = 3;
}

struct AttributeValueP {
  1: DataTypeP dataType,
  2: string id,
  3: optional list<string> stringValues,
  4: optional list<i32> intValues,
  5: optional list<i64> datetimeValues,
  6: optional list<bool> booleanValues,
}

service RemotePDPService {
  ResponseTypeP evaluateP(1:list<AttributeValueP> attributes)
}
