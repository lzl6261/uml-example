<!DOCTYPE html>
<html>
<head>
  <title>Home page</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<form action="${base}/author/save" method="post">
  <input type="hidden" name="id" value="${author.id}">
  <input type="text" name="name" value="${author.name}" />名字

  <input  type="submit" value="提交"/>
</form>

</body>
</html>