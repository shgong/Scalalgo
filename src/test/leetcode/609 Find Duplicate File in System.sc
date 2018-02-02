/*
Input:
["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
Output:
[["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
 */
def findDuplicate(paths: Array[String]): List[List[String]] = (
  for {
    p <- paths
    tokens = p.split(" ", -1).toList
    path = tokens.head
    file <- tokens.tail
    Array(name, content) = file.split("[()]", 2)
  } yield (content, path + "/" + name)
  ).groupBy(_._1).values.filter(_.length>=2)
  .map(_.map(_._2).toList).toList


findDuplicate(
  Array("root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)")
)