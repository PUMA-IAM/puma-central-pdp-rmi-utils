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
  DOUBLE = 4;
}

enum ResponseTypeP {
  PERMIT = 0;
  DENY = 1;
  NOT_APPLICABLE = 2;
  INDETERMINATE = 3;
}

enum ObjectTypeP {
  SUBJECT = 0;
  ACTION = 1;
  RESOURCE = 2;
  ENVIRONMENT = 3;
}

enum MultiplicityP {
  GROUPED = 0;
  ATOMIC = 1;
}

struct AttributeValueP {
  1: DataTypeP dataType,
  2: ObjectTypeP objectType,
  3: MultiplicityP multiplicity,
  4: string id,
  5: optional list<string> stringValues,
  6: optional list<i32> intValues,
  7: optional list<i64> datetimeValues,
  8: optional list<bool> booleanValues,
  9: optional list<double> doubleValues,
}

service RemotePDPService {
  ResponseTypeP evaluateP(1:list<AttributeValueP> attributes)
}
