val str =
  """
    | {
    |   "rules": [{
    |     "name": "col1_null",
    |     "rule": {
    |       "$isnull": true
    |     },
    |     "columns": ["col1"]
    |   }, {
    |     "name": "col1_notnull",
    |     "rule": {
    |       "$isnull": false
    |     },
    |     "columns": ["col1"]
    |   }, {
    |     "name": "col1_type",
    |     "rule": {
    |       "$type": "string"
    |     },
    |     "columns": ["col1"]
    |   }, {
    |     "name": "col1_minlen",
    |     "rule": {
    |       "$strlen": {
    |         "$gte": 1
    |       }
    |     },
    |     "columns": ["col1"]
    |   }]
    | }
  """.stripMargin


def escape(str:String):String = str
  .replace("\\","\\\\")
  .replace("\"","\\\"")
  .replace("\f","\\f")
  .replace("\r","\\r")
  .replace("\t","\\t")
  .replace("\n","\\n")
  .replace("\b","\\b")

escape(str)