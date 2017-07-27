<#--
分页查询
-->
[#macro mongo_page value form]
[#if value.totalElements!=0]
<ul class="pagination">
  <li class="first"><a href="javascript:goPage('0');">首页</a></li>
  [#if value.number!=0]
  <li class="prev"><a href="javascript:goPage('${value.number-1}');"><i class="arrow arrow2"></i>上一页</a></li>
  [/#if]
  [#list 1..value.totalPages as item]
  [#if value.number==item-1]
  <li class="page active"><a>${item}</a></li>
  [#else]
  <li class="page"><a href="javascript:goPage('${item-1}');">${item}</a></li>
  [/#if]
  [/#list]
  [#if value.number!=value.totalPages-1]
  <li class="next"><a href="javascript:goPage('${value.number+1}');">下一页<i class="arrow arrow3"></i></a></li>
  [/#if]

  <li class="last"><a href="javascript:goPage('${value.totalPages-1}');">末页</a></li>
  <li><span>共${value.totalElements}条</span></li>
</ul>

<script type="text/javascript">
  function goPage(pageNo) {
    try{
      var tableForm = document.getElementById('${form}');
      document.getElementById("currentPage").value=pageNo;
      tableForm.onsubmit=null;
      tableForm.submit();
    } catch(e) {
      alert('goPage(pageNo)方法出错');
    }
  }
</script>
[/#if]
[/#macro]