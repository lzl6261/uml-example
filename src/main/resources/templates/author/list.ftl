<!DOCTYPE html>
<html>
<head>
  <title>Home page</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<form action="list" method="get" class="gs_table_form" id="formSearch">
  <input type="hidden" name="page" id="currentPage" value="${page.number}"/>
  <div class="row">
    <div class="row col-md-4 gs-min-width">
      <label class="col-md-4 gs_table_label">用户名:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" name="name" value="${param["name"]}"/>
      </div>
    </div>
    <div class="row col-md-2 gs-min-width table-btn">
      <button type="submit" class="btn btn-info">查询</button>
    </div>
  </div>
</form>
<a href="add">新建</a>
<table class="table table-bordered table-hover">
  <thead>
  <tr>
    <th class="active">名字</th>
    <th class="active">操作</th>
  </tr>
  </thead>
  <tbody>
  [#list page.content as author]
  <tr class="active">
    <td class="active">${author.name}</td>
    <td><a href="edit/${author.id}">编辑</a></td>
  </tr>
  [/#list]
  </tbody>
</table>




[#--[#if authorList.previousPageable()??]${authorList.previousPageable().getPageNumber()}[#else][/#if]--]
<label>分页</label>

[@p.mongo_page value=page form="formSearch"/]

</body>
</html>